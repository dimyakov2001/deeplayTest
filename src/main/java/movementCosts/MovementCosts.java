package main.java.movementCosts;

import main.java.Constants;

/**
 * Класс, отвечающий за получение таблицы стоимости перемещения
 */
public class MovementCosts {

    /**
     * Получение таблицы стоимости перемещения
     * @return массив Creature
     */
    public static Creature[] getCosts() {
        return new Creature[] {
                MovementCosts.makeHuman(),
                MovementCosts.makeSwamper(),
                MovementCosts.makeLeshiy()
        };
    }

    /**
     * @return затраты на перемещение для человека
     */
    private static Creature makeHuman() {
        final Creature human = new Creature();
        human.species = Constants.human;
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
        swamper.species = Constants.swamper;
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
        leshiy.species = Constants.leshiy;
        leshiy.transportCosts.put(Constants.swamp, 3);
        leshiy.transportCosts.put(Constants.water, 3);
        leshiy.transportCosts.put(Constants.bushes, 2);
        leshiy.transportCosts.put(Constants.plain, 2);

        return leshiy;
    }
}
