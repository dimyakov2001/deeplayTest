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


}
