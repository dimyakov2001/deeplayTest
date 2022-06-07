package main.java;

import main.java.math.Dijkstra;
import main.java.math.Utils;
import main.java.movementCosts.Creature;
import main.java.movementCosts.MovementCosts;


public class Solution {
    private static final int[] fieldSize = {4, 4};

    private static final int startPos = 0;
    private static final int finPos = 15;

    /**
     * Возвращает длину оптимального пути для расы и конкретного поля
     * @param field – строка, описывающая поле
     * @param species – раса существа, пересекающего поле
     * @return – длина наиболее короткого пути
     */
    public static int getResult(String field, String species) {
        // получаем затраты на перемещение для данной расы
        Creature[] races = MovementCosts.getCosts();

        // находим нужную расу
        Creature race = Solution.findCreature(races, species);

        // создаём матрицу инцидентности графа, построенного по
        // данным о поле и затратах на перемещение
        float[][] matrix = Solution.createIncidenceMatrix(field, race);

        // находим минимальный путь в графе
        return (int) Dijkstra.solve(matrix, Solution.startPos, Solution.finPos);
    }

    /**
     * Поиск подходящей расы в массиве
     * @param creatures – список рас
     * @param species – раса, которую нужно найти
     * @return нужный объект Creature
     */
    private static Creature findCreature(Creature[] creatures, String species) {
        int i = 0;
        while (i < creatures.length) {
            if (creatures[i].getSpecies().equals(species)) {
                return creatures[i];
            }
            i++;
        }

        throw new InvalidParamsException(String.format("Can't find species: %s", species));
    }

    /**
     * Создание матрицы инцидентности графа по полю и затратам на передвижение
     * конкретной расы
     * @param field – поле
     * @param creature – затраты на передвижение расы
     * @return – матрица инцидентности графа
     */
    private static float[][] createIncidenceMatrix(String field, Creature creature) {
        int vertexNum = Solution.fieldSize[0] * Solution.fieldSize[1];

        float[][] matrix = Utils.initFilledMatrix(vertexNum, vertexNum, Float.POSITIVE_INFINITY);

        // проходим каждую вершину
        for (int i = 0; i < vertexNum; i++) {
            // клетка поля над текущей
            if (i >= Solution.fieldSize[1]) {
                Solution.addVertex(matrix, field, creature, i,i - Solution.fieldSize[1]);
            }

            // клетка поля под текущей
            if ((i / Solution.fieldSize[1]) < Solution.fieldSize[0] - 1) {
                Solution.addVertex(matrix, field, creature, i,i + Solution.fieldSize[1]);
            }

            // клетка слева от текущей
            if (i % Solution.fieldSize[1] != 0) {
                Solution.addVertex(matrix, field, creature, i,i - 1);
            }

            // клетка справа от текущей
            if ((i + 1) % Solution.fieldSize[1] != 0) {
                Solution.addVertex(matrix, field, creature, i,i + 1);
            }
        }

        return matrix;
    }

    /**
     * Добавление вершины в матрицу инцидентности графа
     * @param matrix – матрица инцидентности
     * @param field – строка поля
     * @param creature – объект расы существа
     * @param currVertexIdx – вершина, из которой выходи существо
     * @param vertexIdx – вершина, в которую существо входит
     */
    private static void addVertex(float[][] matrix, String field, Creature creature, int currVertexIdx, int vertexIdx) {
        String vertexType = Character.toString(field.charAt(vertexIdx));
        float vertexCost = creature.getTransportCosts(vertexType);

        matrix[currVertexIdx][vertexIdx] = vertexCost;
    }
}
