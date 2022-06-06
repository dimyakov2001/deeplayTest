package test.java;


import main.java.math.Dijkstra;

import main.java.math.InvalidShapeException;
import main.java.math.Utils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

/**
 * Тесты алгоритма Дейкстры
 */
public class DijkstraTest {
    @Rule public ExpectedException thrown = ExpectedException.none();

    /**
     * Проверка корректной работы алгоритма Дейкстры
     */
    @Test
    public void testCorrect() {
        final float[][] zeroIncidenceMatrix = {
                {0  , 50 , 0  , 0  , 50 , 60 , 0  , 150, 140, 0  },
                {50 , 0  , 50 , 0  , 0  , 0  , 0  , 0  , 0  , 0  },
                {0  , 50 , 0  , 45 , 0  , 0  , 0  , 0  , 60 , 0  },
                {0  , 0  , 45 , 0  , 0  , 0  , 0  , 0  , 60 , 55 },
                {50 , 0  , 0  , 0  , 0  , 35 , 0  , 0  , 0  , 0  },
                {60 , 0  , 0  , 0  , 35 , 0  , 50 , 60 , 0  , 0  },
                {0  , 0  , 0  , 0  , 0  , 50 , 0  , 40 , 0  , 0  },
                {150, 0  , 0  , 0  , 0  , 60 , 40 , 0  , 40 , 0  },
                {140, 0  , 60 , 60 , 0  , 0  , 0  , 40 , 0  , 45 },
                {0  , 0  , 0  , 55 , 0  , 0  , 0  , 0  , 45 , 0  }
        };

        final float[][] incidenceMatrix = Utils.matrixReplace(zeroIncidenceMatrix, 0, Float.POSITIVE_INFINITY);

        final float ans = Dijkstra.solve(incidenceMatrix, 0, 9);
        Assert.assertEquals(185, ans, 0.000001);
    }

    /**
     * Проверка случая некорректной матрицы
     */
    @Test
    public void testInvalidIncidenceMatrixShape() {
        float[][] zeroIncidenceMatrix = {
                {0  , 50 , 0  , 0  , 50 , 60 , 0  , 150, 140, 0  },
                {50 , 0  , 50 , 0  , 0  , 0  , 0  , 0  , 0},
                {0  , 50 , 0  , 45 , 0  , 0  , 0  , 0  , 60 , 0  },
                {0  , 0  , 45 , 0  , 0  , 0  , 0  , 0  , 60 , 55 },
                {50 , 0  , 0  , 0  , 0  , 35 , 0  , 0  , 0  , 0  },
                {60 , 0  , 0  , 0  , 35 , 0  , 50 , 60 , 0  , 0  },
                {0  , 0  , 0  , 0  , 0  , 50 , 0  , 40 , 0  , 0  },
                {150, 0  , 0  , 0  , 0  , 60 , 40 , 0  , 40 , 0  },
                {140, 0  , 60 , 60 , 0  , 0  , 0  , 40 , 0  , 45 },
                {0  , 0  , 0  , 55 , 0  , 0  , 0  , 0  , 45 , 0  }
        };

        final float[][] incidenceMatrix = Utils.matrixReplace(zeroIncidenceMatrix, 0, Float.POSITIVE_INFINITY);

        thrown.expect(InvalidShapeException.class);
        Dijkstra.solve(incidenceMatrix, 0, 9);
    }

    /**
     * Проверка случая неквадратной матрицы матрицы
     */
    @Test
    public void testNonSquareIncidenceMatrix() {
        float[][] zeroIncidenceMatrix = {
                {0  , 50 , 0  , 0  , 50 , 60 , 0  , 150, 140, 0  },
                {50 , 0  , 50 , 0  , 0  , 0  , 0  , 0  , 0  , 0  },
                {0  , 50 , 0  , 45 , 0  , 0  , 0  , 0  , 60 , 0  },
                {0  , 0  , 45 , 0  , 0  , 0  , 0  , 0  , 60 , 55 },
                {50 , 0  , 0  , 0  , 0  , 35 , 0  , 0  , 0  , 0  },
                {60 , 0  , 0  , 0  , 35 , 0  , 50 , 60 , 0  , 0  },
                {0  , 0  , 0  , 0  , 0  , 50 , 0  , 40 , 0  , 0  },
                {150, 0  , 0  , 0  , 0  , 60 , 40 , 0  , 40 , 0  },
                {140, 0  , 60 , 60 , 0  , 0  , 0  , 40 , 0  , 45 },
                {0  , 0  , 0  , 55 , 0  , 0  , 0  , 0  , 45 , 0  },
                {0  , 0  , 0  , 55 , 0  , 0  , 0  , 0  , 45 , 0  }
        };

        final float[][] incidenceMatrix = Utils.matrixReplace(zeroIncidenceMatrix, 0, Float.POSITIVE_INFINITY);

        thrown.expect(InvalidShapeException.class);
        Dijkstra.solve(incidenceMatrix, 0, 9);
    }




}
