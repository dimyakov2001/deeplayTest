package main.java.movementCosts;

import java.util.HashMap;

/**
 * Класс "Существо". Содержит имя расы и затраты на перемещение для
 * указанных типов поверхностей
 */
public class Creature {
    private String species;
    private final HashMap<String, Float> transportCosts;

    public Creature() {
        this.species = "";
        this.transportCosts = new HashMap<>();
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public float getTransportCosts(String localityType) {
        return this.transportCosts.getOrDefault(localityType, Float.MAX_VALUE);
    }

    public void setTransportCosts(String localityType, float transportCosts) {
        this.transportCosts.put(localityType, transportCosts);
    }
}
