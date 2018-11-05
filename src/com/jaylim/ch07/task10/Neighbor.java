package com.jaylim.ch07.task10;

import java.util.Objects;

class Neighbor {
    private City neighborCity;
    private int distance;

    public Neighbor(City neighborCity, int distance) {
        this.neighborCity = neighborCity;
        this.distance = distance;
    }

    public City getNeighborCity() {
        return neighborCity;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbor neighbor = (Neighbor) o;
        return distance == neighbor.distance &&
                Objects.equals(neighborCity, neighbor.neighborCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(neighborCity, distance);
    }
}
