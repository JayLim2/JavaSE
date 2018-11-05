package com.jaylim.ch07.task10;

import com.sun.istack.internal.NotNull;

import java.util.Set;
import java.util.TreeSet;

public class Graph {
    private Set<City> graph;

    public Graph() {
        graph = new TreeSet<>();
    }

    public boolean put(@NotNull City city) {
        return graph.add(city);
    }

    public City[] getShortestDistance(City city1) {
        City[] path = null;

        City current = city1;
        while (!graph.isEmpty()) {
            Set<Neighbor> neighbors = current.getNeighbors();
            for (Neighbor neighbor : neighbors) {

            }
        }

        return path;
    }

    public static void connect(@NotNull City city1, @NotNull City city2, int distance) {
        city1.addNeighbor(city2, distance);
        city2.addNeighbor(city1, distance);
    }
}
