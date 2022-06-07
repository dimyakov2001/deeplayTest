package main.java.movementCosts;

import java.util.HashMap;

/**
 * Класс "Существо". Содержит имя расы и затраты на перемещение для
 * указанных типов поверхностей
 */
public class Creature {
    public String species;
    public HashMap<String, Integer> transportCosts;

    public Creature() {
        this.transportCosts = new HashMap<>();
    }
}
