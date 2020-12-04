package fr.mirabeau.demo.entity;

import javax.annotation.Resource;

public enum SecurityPictogram {
    FLAMMABLE("Flammable"),
    TOXIC("Toxic"),
    IRRITANT("Irritant"),
    ENV_DAMAGE("Environmentally damaging"),
    OXIDIZING("Oxidizing"),
    COMPRESSED_GAS("Compressed gas"),
    HEALTH_HAZARD("Health hazard");

    private final String name;

    SecurityPictogram(String name) {
        this.name = name;
    }
}
