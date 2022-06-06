package main.java;

import java.util.HashMap;


/**
 * Класс, отвечающий за получение таблицы стоимости перемещения
 */
public class MovementCosts {

    /**
     * Получение таблицы стоимости перемещения
     * @return соответствие строка - объект Creature. Строка здесь – имя расы.
     */
    public static HashMap<String, Creature> getCosts() {
        final HashMap<String, Creature> creatures = new HashMap<>();
        creatures.put(Constants.human, MovementCosts.makeHuman());
        creatures.put(Constants.swamper, MovementCosts.makeSwamper());
        creatures.put(Constants.leshiy, MovementCosts.makeLeshiy());

        return creatures;
    }

    /**
     * @return затраты на перемещение для человека
     */
    private static Creature makeHuman() {
        final Creature human = new Creature();
        human.transportCosts.put(Constants.swamp, 5);
        human.transportCosts.put(Constants.water, 2);
        human.transportCosts.put(Constants.bushes, 3);
        human.transportCosts.put(Constants.plain, 1);

        return human;
    }

    /**
     * @return затраты на перемещение для болотника
     */
    private static Creature makeSwamper() {
        final Creature swamper = new Creature();
        swamper.transportCosts.put(Constants.swamp, 2);
        swamper.transportCosts.put(Constants.water, 2);
        swamper.transportCosts.put(Constants.bushes, 5);
        swamper.transportCosts.put(Constants.plain, 2);

        return swamper;
    }

    /**
     * @return затраты на перемещение для лешего
     */
    private static Creature makeLeshiy() {
        final Creature leshiy = new Creature();
        leshiy.transportCosts.put(Constants.swamp, 3);
        leshiy.transportCosts.put(Constants.water, 3);
        leshiy.transportCosts.put(Constants.bushes, 2);
        leshiy.transportCosts.put(Constants.plain, 2);

        return leshiy;
    }
}
