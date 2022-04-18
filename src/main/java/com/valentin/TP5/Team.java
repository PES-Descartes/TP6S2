package com.valentin.TP5;

import java.util.Random;

public class Team {
    private static final Random generator = new Random();

    private String name;
    private long uuid;

    public Team(String name) {
        this.name = name;
        this.uuid = generator.nextLong();
    }

    public String getName() {
        return name;
    }

    public long getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", uid=" + uuid +
                '}';
    }
}
