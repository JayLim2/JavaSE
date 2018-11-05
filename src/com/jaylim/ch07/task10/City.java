package com.jaylim.ch07.task10;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class City {
    private Integer label;
    private String name;
    private Set<Neighbor> neighbors;

    public City(String name) {
        label = null;
        this.name = name;
        neighbors = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public boolean addNeighbor(City city, int distance) {
        return neighbors.add(new Neighbor(city, distance));
    }

    public Set<Neighbor> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) &&
                Objects.equals(neighbors, city.neighbors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, neighbors);
    }
}

