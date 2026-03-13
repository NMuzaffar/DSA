package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// --- Provided Classes (with 'implements Run' added) ---

interface Run {}

/**
 * Run-Length Encoded Run.
 * Stores a 'count' of identical 'value's.
 */
class RLERun implements Run {
    int count;
    int value;

    public RLERun(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public String toString() {
        return "RLERun[value=" + value + ", count=" + count + "]";
    }
}

/**
 * Bit-Packed (Blocked) Run.
 * Stores exactly 8 integer values.
 * MODIFIED: This class now only contains the data array.
 */
class BitPackingRun implements Run {
    int[] data = new int[8];

    @Override
    public String toString() {
        // Updated toString to remove 'value'
        return "BitPackingRun[data=" + Arrays.toString(data) + "]";
    }
}

// --- Encoder Implementation ---

public class IntegerEncoder {

    // The current mode of the encoder
    private enum Mode {
        RLE,
        BITPACKING
    }

    private final List<Run> runs;
    private Mode currentMode;

    // State for RLE mode
    private int rleValue;
    private int rleCount;

    // State for BITPACKING mode
    private final List<Integer> bitpackBuffer;

    public IntegerEncoder() {
        this.runs = new ArrayList<>();
        this.currentMode = Mode.RLE; // Rule #3: RLE is default
        this.rleCount = 0;
        this.bitpackBuffer = new ArrayList<>(8);
    }

    /**
     * Writes a single integer value to the encoder.
     *
     * @param val The integer to encode.
     */
    public void writeData(int val) {
        if (currentMode == Mode.RLE) {
            handleRLE(val);
        } else {
            handleBitPacking(val);
        }
    }

    /**
     * Handles a new value while in RLE mode.
     */
    private void handleRLE(int val) {
        if (rleCount == 0) {
            // This is the first value in a new potential RLE run
            rleValue = val;
            rleCount = 1;
        } else if (val == rleValue) {
            // Value matches, continue the RLE run
            rleCount++;
        } else {
            // Mismatch! The RLE run is broken.
            if (rleCount >= 8) {
                // Rule #1: RLE run is valid (>= 8). Flush it.
                flushRLE();
                // Start a new RLE run with the new value.
                rleValue = val;
                rleCount = 1;
            } else {
                // RLE run failed (count < 8). Switch to BitPacking.
                switchToBitPacking(val);
            }
        }
    }

    /**
     * Handles a new value while in BitPacking mode.
     */
    private void handleBitPacking(int val) {
        bitpackBuffer.add(val);
        // Rule #2: BLE should be exactly 8
        if (bitpackBuffer.size() == 8) {
            flushBitPacking();
        }
    }

    /**
     * Switches state from a failed RLE to BitPacking.
     */
    private void switchToBitPacking(int newVal) {
        currentMode = Mode.BITPACKING;

        // Add all the values from the failed RLE run to the buffer
        for (int i = 0; i < rleCount; i++) {
            bitpackBuffer.add(rleValue);
        }
        // Clear the RLE state
        rleCount = 0;

        // Add the new, mismatching value
        handleBitPacking(newVal);
    }

    /**
     * Finalizes and adds a full BitPackingRun.
     */
    private void flushBitPacking() {
        BitPackingRun run = new BitPackingRun();

        // MODIFIED: The 'run.value' line is removed.

        for (int i = 0; i < 8; i++) {
            run.data[i] = bitpackBuffer.get(i);
        }
        runs.add(run);

        // Clear buffer and switch back to default RLE mode
        bitpackBuffer.clear();
        currentMode = Mode.RLE; // Rule #3
    }

    /**
     * Finalizes and adds the current RLE run.
     */
    private void flushRLE() {
        if (rleCount > 0) {
            runs.add(new RLERun(rleValue, rleCount));
            rleCount = 0;
        }
    }

    /**
     * Flushes a partial bitpack buffer *as RLE runs*.
     * This handles the end-of-stream case to satisfy all rules.
     */
    private void flushPartialBitpackAsRLE() {
        if (bitpackBuffer.isEmpty()) {
            return;
        }

        // Use RLE logic on the remaining buffer items
        int currentVal = bitpackBuffer.get(0);
        int currentCount = 0;

        for (int val : bitpackBuffer) {
            if (val == currentVal) {
                currentCount++;
            } else {
                // Mismatch, flush previous RLE run
                runs.add(new RLERun(currentVal, currentCount));
                // Start new run
                currentVal = val;
                currentCount = 1;
            }
        }
        // Flush the very last run
        runs.add(new RLERun(currentVal, currentCount));

        bitpackBuffer.clear();
    }


    /**
     * Flushes any pending data and returns the complete list of runs.
     *
     * @return The list of encoded runs.
     */
    public List<Run> getRuns() {
        // Check what state we are in when 'getRuns' is called
        if (currentMode == Mode.RLE) {
            // We have a pending RLE run. Flush it.
            // Rule #1a: This is allowed to be < 8.
            flushRLE();
        } else {
            // We have a pending BitPacking run.
            // Rule #2 says it MUST be 8. We can't pad it.
            // The only valid way to flush a partial buffer
            // is to convert it back to RLE runs.
            flushPartialBitpackAsRLE();
        }

        // Return a copy to prevent modification
        return new ArrayList<>(runs);
    }

    // --- Main method for Demonstration (no changes) ---

    public static void main(String[] args) {
        System.out.println("--- Test Case 1: Long RLE ---");
        IntegerEncoder encoder1 = new IntegerEncoder();
        int[] data1 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}; // 11 items
        for (int val : data1) {
            encoder1.writeData(val);
        }
        encoder1.getRuns().forEach(System.out::println);
        // Expected: RLERun[value=5, count=11]

        System.out.println("\n--- Test Case 2: Short RLE (at end) ---");
        IntegerEncoder encoder2 = new IntegerEncoder();
        int[] data2 = {7, 7, 7}; // 3 items
        for (int val : data2) {
            encoder2.writeData(val);
        }
        encoder2.getRuns().forEach(System.out::println);
        // Expected: RLERun[value=7, count=3] (Allowed by Rule #1a)

        System.out.println("\n--- Test Case 3: Failed RLE -> Full BitPacking ---");
        IntegerEncoder encoder3 = new IntegerEncoder();
        // 3 '1's (fails RLE), then 5 more different values
        int[] data3 = {1, 1, 1, 2, 3, 4, 5, 6};
        for (int val : data3) {
            encoder3.writeData(val);
        }
        encoder3.getRuns().forEach(System.out::println);
        // Expected: BitPackingRun[data=[1, 1, 1, 2, 3, 4, 5, 6]]

        System.out.println("\n--- Test Case 4: Failed RLE -> Partial BitPacking (at end) ---");
        IntegerEncoder encoder4 = new IntegerEncoder();
        int[] data4 = {1, 1, 1, 2, 3, 3}; // Fails RLE, buffer has 6 items
        for (int val : data4) {
            encoder4.writeData(val);
        }
        encoder4.getRuns().forEach(System.out::println);
        // Expected:
        // RLERun[value=1, count=3]
        // RLERun[value=2, count=1]
        // RLERun[value=3, count=2]

        System.out.println("\n--- Test Case 5: Valid RLE -> Failed RLE -> Full BitPacking -> RLE ---");
        IntegerEncoder encoder5 = new IntegerEncoder();
        int[] data5 = {
                8, 8, 8, 8, 8, 8, 8, 8, 8, // Valid RLE (9)
                1, 1,                       // Failed RLE (2)
                2, 3, 4, 5, 6, 7,           // Fills BitPacking buffer
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9 // Valid RLE (10)
        };
        for (int val : data5) {
            encoder5.writeData(val);
        }
        encoder5.getRuns().forEach(System.out::println);
        // Expected:
        // RLERun[value=8, count=9]
        // BitPackingRun[data=[1, 1, 2, 3, 4, 5, 6, 7]]
        // RLERun[value=9, count=10]
    }
}