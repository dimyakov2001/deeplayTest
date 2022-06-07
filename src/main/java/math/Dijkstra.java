package main.java.math;

import main.java.InvalidParamsException;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Алгоритм Дейкстры для нахождения кратчайшего пути в графе
 */
public class Dijkstra {

    /**
     * Алгоритм нахождение кратчайшего пути в графе с помощью метода Дейкстры
     * @param incidenceMatrix – матрица инцидентности графа (квадратная матрица)
     * @param startVertex – индекс вершины-старта (начинается с 0)
     * @param finVertex – индекс вершины-финиша (начинается с 0)
     * @return – длина пути из startVertex в finVertex
     */
    public static float solve(final float[][] incidenceMatrix, int startVertex, int finVertex) {
        if (!Utils.isSquareMatrix(incidenceMatrix)) {
            throw new InvalidShapeException("Incidence matrix is not square matrix.");
        }

        final int matrixShape = incidenceMatrix.length;

        if (startVertex < 0 || startVertex >= matrixShape) {
            throw new InvalidParamsException("Invalid start vertex.");
        }
        if (finVertex < 0 || finVertex >= matrixShape) {
            throw new InvalidParamsException("Invalid finish vertex.");
        }

        // инициализируем рабочую матрицу
        float[][] matrix = Utils.initFilledMatrix(matrixShape, matrixShape, Float.POSITIVE_INFINITY);

        // инициализируем множество посещённых вершин
        HashSet<Integer> visitedVertices = new HashSet<>();

        // текущая вершина и длина пути до неё
        int currentVertex = startVertex;
        float currentVertexPathLen = 0;

        while (currentVertex != finVertex) {
            // "вычёркиваем" столбец с номером вершины, равным currentVertex
            Utils.fillMatrixColumn(matrix, currentVertex, Float.POSITIVE_INFINITY);
            visitedVertices.add(currentVertex);

            // пробегаем через все вершины и вычисляем, будет ли эффективней проходить через currentVertex
            for (int vertexIdx = 0; vertexIdx < matrixShape; vertexIdx++) {
                if (!visitedVertices.contains(vertexIdx)) {
                    float pathLenFromThisVertex = incidenceMatrix[currentVertex][vertexIdx] + currentVertexPathLen;
                    float pathLenFromOtherVertices = Dijkstra.minInColumnFromVisitedVertices(
                            matrix, vertexIdx, visitedVertices);

                    matrix[currentVertex][vertexIdx] = Math.min(pathLenFromThisVertex, pathLenFromOtherVertices);
                }
            }

            // находим ближайшую вершину
            int nearestVertex = Utils.argmin(matrix[currentVertex]);

            // переходим в ближайшую вершину
            currentVertexPathLen = matrix[currentVertex][nearestVertex];
            currentVertex = nearestVertex;
        }

        return currentVertexPathLen;
    }

    /**
     * Вычисляет минимальное значение в столбце из тех вершин, которые были посещены
     * @param matrix – рабочая матрица
     * @param columnIdx – индекс столбца, в котором выбираем
     * @param visited – вершины, среди которых ищем
     * @return минимальное значение в столбце
     */
    private static float minInColumnFromVisitedVertices(float[][] matrix, int columnIdx, HashSet<Integer> visited) {
        float min = Float.POSITIVE_INFINITY;

        for (int iteratorIdx : visited) {
            if (matrix[iteratorIdx][columnIdx] < min) {
                min = matrix[iteratorIdx][columnIdx];
            }
        }

        return min;
    }
}
