package test.java;

import main.java.math.InvalidShapeException;
import main.java.math.Utils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

/**
 * Тесты математических утилит
 */
public class MathUtilsTest {

    @Test
    public void testSquarePositive() {
        float[][] matrix = {
                {1, 2},
                {3, 4}
        };

        boolean ans = Utils.isSquareMatrix(matrix);
        Assert.assertTrue(ans);
    }

    @Test
    public void testSquareNegative() {
        float[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        boolean ans = Utils.isSquareMatrix(matrix);
        Assert.assertFalse(ans);
    }

    @Test
    public void testFilledMatrix() {
        float[][] expectedMatrix = {
                {1, 1, 1},
                {1, 1, 1}
        };

        float[][] ans = Utils.initFilledMatrix(2, 3, 1);

        Assert.assertArrayEquals(expectedMatrix, ans);
    }
    
    @Test
    public void testArgmin() {
        float[] array = {1, 2, 3, -1, -3, 10};

        int ans = Utils.argmin(array);

        Assert.assertEquals(4, ans);
    }

    @Test
    public void testGetMatrixColumn() {
        float[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        float[] expectedCol = {3, 6, 9};
        float[] ans = Utils.getMatrixColumn(matrix, 2);

        Assert.assertArrayEquals(expectedCol, ans, (float) 0.000001);
    }

    @Test
    public void testFillMatrixColumn() {
        float[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        float[][] expectedMatrix = {
                {1, 0, 3},
                {4, 0, 6},
                {7, 0, 9}
        };

        Utils.fillMatrixColumn(matrix, 1, 0);

        for (int i = 0; i < expectedMatrix.length; i++) {
            Assert.assertArrayEquals(expectedMatrix[i], matrix[i], (float) 0.000001);
        }
    }

    @Test
    public void testReplaceMatrix() {
        float[][] matrix = {
                {1, 0, 3},
                {4, 5, 0},
                {0, 8, 9}
        };

        float[][] expectedMatrix = {
                { 1, -1,  3},
                { 4,  5, -1},
                {-1,  8,  9}
        };

        Utils.matrixReplace(matrix, 0, -1);

        for (int i = 0; i < expectedMatrix.length; i++) {
            Assert.assertArrayEquals(expectedMatrix[i], matrix[i], (float) 0.000001);
        }
    }

}
