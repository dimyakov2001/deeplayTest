package main.java;

import java.util.HashMap;


public class Settings {

    public static HashMap<String, Creature> getSettings() {
        final HashMap<String, Creature> creatures = new HashMap<>();
        creatures.put(Constants.human, Settings.makeHuman());
        creatures.put(Constants.swamper, Settings.makeSwamper());
        creatures.put(Constants.leshiy, Settings.makeLeshiy());

        return creatures;
    }

    private static Creature makeHuman() {
        final Creature human = new Creature();
        human.transportCosts.put(Constants.swamp, 5);
        human.transportCosts.put(Constants.water, 2);
        human.transportCosts.put(Constants.bushes, 3);
        human.transportCosts.put(Constants.plain, 1);

        return human;
    }

    private static Creature makeSwamper() {
        final Creature swamper = new Creature();
        swamper.transportCosts.put(Constants.swamp, 2);
        swamper.transportCosts.put(Constants.water, 2);
        swamper.transportCosts.put(Constants.bushes, 5);
        swamper.transportCosts.put(Constants.plain, 2);

        return swamper;
    }

    private static Creature makeLeshiy() {
        final Creature leshiy = new Creature();
        leshiy.transportCosts.put(Constants.swamp, 3);
        leshiy.transportCosts.put(Constants.water, 3);
        leshiy.transportCosts.put(Constants.bushes, 2);
        leshiy.transportCosts.put(Constants.plain, 2);

        return leshiy;
    }
}
