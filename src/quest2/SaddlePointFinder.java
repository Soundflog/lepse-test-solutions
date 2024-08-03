package quest2;

import java.util.Arrays;

public class SaddlePointFinder {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Для матрицы");
        System.out.println(Arrays.deepToString(matrix));
        findSaddlePoint(matrix);

        System.out.println("\nДля матрицы");
        int[][] matrix2 = {
                {3, 8, 4},
                {2, 7, 5},
                {9, 6, 1}
        };
        System.out.println(Arrays.deepToString(matrix2));
        findSaddlePoint(matrix2);

        System.out.println("\nДля матрицы");
        int[][] matrix3 = {
                {1, 2, 3},
                {3, 4, 5},
                {5, 6, 7}
        };
        System.out.println(Arrays.deepToString(matrix3));
        findSaddlePoint(matrix3);
    }

    private static void findSaddlePoint(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int[] ints : matrix) {
            int minRow = ints[0];
            int colIndex = 0;
            for (int j = 1; j < cols; j++) {
                if (ints[j] < minRow) {
                    minRow = ints[j];
                    colIndex = j;
                }
            }

            int maxCol = matrix[0][colIndex];
            int rowIndex = 0;
            for (int k = 1; k < rows; k++) {
                if (matrix[k][colIndex] > maxCol) {
                    maxCol = matrix[k][colIndex];
                    rowIndex = k;
                }
            }

            if (minRow == maxCol) {
                System.out.println("Седловая точка: (" + rowIndex + ", " + colIndex + ") = " + matrix[rowIndex][colIndex]);
                return;
            }
        }

        System.out.println("Седловой точки не найдено");
    }
}

