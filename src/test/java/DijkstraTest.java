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
        float[][] incidenceMatrix = {
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

        Utils.matrixReplace(incidenceMatrix, 0, Float.POSITIVE_INFINITY);

        float ans = Dijkstra.solve(incidenceMatrix, 0, 9);
        Assert.assertEquals(185, ans, 0.000001);
    }

    @Test
    public void testReal() {
        float[][] incidenceMatrix = {
                {0, 3, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 3, 0, 5, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {5, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 3, 0, 0, 2, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 3, 0, 1, 0, 0, 3, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 3, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 3, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 2, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1, 0}
        };

        Utils.matrixReplace(incidenceMatrix, 0, Float.POSITIVE_INFINITY);

        float ans = Dijkstra.solve(incidenceMatrix, 0, 15);
        Assert.assertEquals(10, ans, 0.000001);
    }

    /**
     * Проверка случая некорректной матрицы
     */
    @Test
    public void testInvalidIncidenceMatrixShape() {
        float[][] incidenceMatrix = {
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

        Utils.matrixReplace(incidenceMatrix, 0, Float.POSITIVE_INFINITY);

        thrown.expect(InvalidShapeException.class);
        Dijkstra.solve(incidenceMatrix, 0, 9);
    }

    /**
     * Проверка случая неквадратной матрицы матрицы
     */
    @Test
    public void testNonSquareIncidenceMatrix() {
        float[][] incidenceMatrix = {
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

        Utils.matrixReplace(incidenceMatrix, 0, Float.POSITIVE_INFINITY);

        thrown.expect(InvalidShapeException.class);
        Dijkstra.solve(incidenceMatrix, 0, 9);
    }

    @Test
    public void testInvalidVertex() {
        float[][] incidenceMatrix = {
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

        Utils.matrixReplace(incidenceMatrix, 0, Float.POSITIVE_INFINITY);

        thrown.expect(InvalidShapeException.class);
        Dijkstra.solve(incidenceMatrix, 0, 10);
        Dijkstra.solve(incidenceMatrix, 0, -1);
        Dijkstra.solve(incidenceMatrix, -1, 9);
        Dijkstra.solve(incidenceMatrix, 12, 9);
    }




}
