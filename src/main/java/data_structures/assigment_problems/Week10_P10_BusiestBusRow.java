package data_structures.assigment_problems;

public class Week10_P10_BusiestBusRow {
    static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;
        for (int row = 0; row < grid.length; row++) {
            int total = 0;
            for (int value : grid[row]) total += value;
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = row;
            }
        }
        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 0, 1}, {3, 3, 1}, {1, 1, 1}};
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
