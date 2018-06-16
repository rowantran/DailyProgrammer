/*
Challenge #344 [Easy]

In mathematics, the Baum–Sweet sequence is an infinite automatic sequence of 0s and 1s defined by the rule:

b_n = 1 if the binary representation of n contains no block of consecutive 0s of odd length;
b_n = 0 otherwise;
for n >= 0.
 */

public class BaumSweetSequence {
    public static void main(String[] args) {
        byte[] result = baumSweetSequence(200);

        for (int i = 0; i < result.length; i++) {
            byte b_n = result[i];
            System.out.print(b_n);
            if (i != result.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    private static byte[] baumSweetSequence(int nMax) {
        byte[] sequence = new byte[nMax+1];
        sequence[0] = 1;

        for (int n = 1; n <= nMax; n++) {
            byte hasOddRunOfZeroes = 1; // assume no odd runs of zeroes by default
            byte[] binaryRep = convertToBinary(n);

            int counter = 0;
            for (byte b : binaryRep) {
                if (b == 0) {
                    counter++;
                } else {
                    if (counter % 2 == 1) {
                        hasOddRunOfZeroes = 0;
                        counter = 0;
                    }
                }
            }

            // If binary representation ends in 0
            if (counter % 2 == 1) {
                hasOddRunOfZeroes = 0;
            }

            sequence[n] = hasOddRunOfZeroes;
        }

        return sequence;
    }

    private static byte[] convertToBinary(int n) {
        int currentProduct = n;

        int binaryLength = getLengthInBinary(n);
        byte[] binaryRepresentation = new byte[binaryLength];

        int index = binaryLength - 1;
        while (currentProduct > 0) {
            binaryRepresentation[index] = (byte) (currentProduct % 2);
            currentProduct /= 2;
            index--;
        }

        return binaryRepresentation;
    }

    private static int getLengthInBinary(int n) {
        int binaryLength;
        if (n <= 1) {
            binaryLength = 1;
        } else {
            binaryLength = (int) (Math.log(n) / Math.log(2)) + 1;
        }

        return binaryLength;
    }
}
