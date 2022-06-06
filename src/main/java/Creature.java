package main.java;

import java.util.HashMap;

/**
 * Класс "Существо". Содержит затраты на перемещение для
 * указанных типов поверхностей
 */
public class Creature {
    public HashMap<String, Integer> transportCosts;

    public Creature() {
        this.transportCosts = new HashMap<>();
    }
}
