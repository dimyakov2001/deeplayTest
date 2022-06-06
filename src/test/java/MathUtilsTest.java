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
    /**
     * Тест на проверку квадратности матрицы
     */
    @Test
    public void testSquarePositive() {
        final float[][] matrix = {
                {1, 2},
                {3, 4}
        };

        final boolean ans = Utils.isSquareMatrix(matrix);
        Assert.assertTrue(ans);
    }

    /**
     * Тест на проверку квадратности матрицы
     */
    @Test
    public void testSquareNegative() {
        final float[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        final boolean ans = Utils.isSquareMatrix(matrix);
        Assert.assertFalse(ans);
    }

    /**
     * Проверка работы инициализатора матриц
     */
    @Test
    public void testFilledMatrix() {
        final float[][] expectedMatrix = {
                {1, 1, 1},
                {1, 1, 1}
        };

        final float[][] ans = Utils.initFilledMatrix(2, 3, 1);

        Assert.assertArrayEquals(expectedMatrix, ans);
    }


}
