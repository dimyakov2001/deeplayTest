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
        human.setSpecies(Constants.human);
        human.setTransportCosts(Constants.swamp, 5);
        human.setTransportCosts(Constants.water, 2);
        human.setTransportCosts(Constants.bushes, 3);
        human.setTransportCosts(Constants.plain, 1);

        return human;
    }

    /**
     * @return затраты на перемещение для болотника
     */
    private static Creature makeSwamper() {
        final Creature swamper = new Creature();
        swamper.setSpecies(Constants.swamper);
        swamper.setTransportCosts(Constants.swamp, 2);
        swamper.setTransportCosts(Constants.water, 2);
        swamper.setTransportCosts(Constants.bushes, 5);
        swamper.setTransportCosts(Constants.plain, 2);

        return swamper;
    }

    /**
     * @return затраты на перемещение для лешего
     */
    private static Creature makeLeshiy() {
        final Creature leshiy = new Creature();
        leshiy.setSpecies(Constants.leshiy);
        leshiy.setTransportCosts(Constants.swamp, 3);
        leshiy.setTransportCosts(Constants.water, 3);
        leshiy.setTransportCosts(Constants.bushes, 2);
        leshiy.setTransportCosts(Constants.plain, 2);

        return leshiy;
    }
}
