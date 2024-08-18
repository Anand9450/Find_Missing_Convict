package com;

public class FindConvict {

    public int findMissingConvictId(int[] convicts) {
        int endRange = convicts.length;

        // the swap method definition
        for (int i = 0; i < convicts.length; i++) {
            while (convicts[i] > 0 && convicts[i] <= endRange && convicts[convicts[i] - 1] != convicts[i]) {
                swap(convicts, i, convicts[i] - 1);
            }
        }

        for (int i = 0; i < convicts.length; i++) {
            if (convicts[i] != i + 1) {
                return i + 1;
            }
        }
        return endRange + 1;
    }

    //swap method
    private void swap(int[] convicts, int i, int j) {
        int temp = convicts[i];
        convicts[i] = convicts[j];
        convicts[j] = temp;
    }

    public static void main(String[] args) {
        FindConvict findConvict = new FindConvict();

        int[] convictSet1 = {2, 3, 1, 5}; // should return 4
        int[] convictSet2 = {2, 5, 4, 3, 6}; // should return 1
        int[] convictSet3 = {5, 3, 2, 1, 4}; // should return 6
        int[] convictSet4 = {}; // should return 1

        System.out.println("Convict missing from set 1: " + findConvict.findMissingConvictId(convictSet1));
        System.out.println("Convict missing from set 2: " + findConvict.findMissingConvictId(convictSet2));
        System.out.println("Convict missing from set 3: " + findConvict.findMissingConvictId(convictSet3));
        System.out.println("Convict missing from set 4: " + findConvict.findMissingConvictId(convictSet4));
    }
}
