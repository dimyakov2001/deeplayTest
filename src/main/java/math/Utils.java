package main.java.math;

public class Utils {
    /**
     * Проверка квадратности матрицы
     * @param matrix – входная матрица
     * @return – boolean, является ли данная матрица квадратной
     */
    public static boolean isSquareMatrix(float[][] matrix) {
        final int shape = matrix.length;
        for (float[] row : matrix) {
            if (row.length != shape) {
                return false;
            }
        }
        return true;
    }


    /**
     * Инициализация матрицы, заполненной одним значением
     * @param rows – количество строк в матрице
     * @param cols – количество столбцов в матрице
     * @param fillValue – значение для заполнения
     * @return – матрица, состоящая из rows строк, cols столбцов. Её каждый элемент равен fillValue
     */
    public static float[][] initFilledMatrix(int rows, int cols, float fillValue) {
        float[][] matrix = new float[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = fillValue;
            }
        }

        return matrix;
    }

    /**
     * Нахождение индекса минимального элемента массива
     * @param array – входной массив
     * @return индекс минимального элемента массива
     */
    public static int argmin(float[] array) {
        if (array.length == 0) {
            throw new Error("Empty array");
        }

        float minVal = array[0];
        int minArg = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
                minArg = i;
            }
        }

        return minArg;
    }

    /**
     * Получение столбца матрицы
     * @param matrix – матрица
     * @param columnIndex – индекс столбца
     * @return столбец матрицы
     */
    public static float[] getMatrixColumn(float[][] matrix, int columnIndex) {
        final int shape = matrix.length;
        float[] col = new float[shape];

        for (int i = 0; i < shape; i++) {
            col[i] = matrix[i][columnIndex];
        }

        return col;
    }

    /**
     * Заполнение столбца матрицы заданным значением
     * @param matrix – входная матрица
     * @param columnIndex – индекс столбца
     * @param value – значение
     * @return новая матрица
     */
    public static float[][] fillMatrixColumn(float[][] matrix, int columnIndex, float value) {
        final int shape = matrix.length;

        for (int i = 0; i < shape; i++) {
            matrix[i][columnIndex] = value;
        }

        return matrix;
    }

    /**
     * Заменяет все вхождения findValue в матрице matrix на setValue
     * @param matrix – исходная матрица
     * @param findValue – значение, которое нужно заменить
     * @param setValue – значение, на которое нужно заменить
     * @return – исходная матрица
     */
    public static float[][] matrixReplace(float[][] matrix, float findValue, float setValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == findValue) {
                    matrix[i][j] = setValue;
                }
            }
        }

        return matrix;
    }
}
