package es.eriktorr.katas.gossiping;

import lombok.val;

import java.util.List;
import java.util.stream.IntStream;

class GossipingSpreader {

    private static final int MINUTES_MAXIMUM = 480;

    private final List<BusRoute> routes;

    GossipingSpreader(List<BusRoute> routes) {
        this.routes = routes;
    }

    String stopsNeededToSpreadAllTheGossips() {
        val stops = IntStream.rangeClosed(0, MINUTES_MAXIMUM).sorted()
                .filter(this::areAllGossipsSpreadAt)
                .mapToObj(Integer::toString)
                .findFirst();
        return stops.orElse("never");
    }

    private boolean areAllGossipsSpreadAt(int minute) {

        // TODO

        return false;
    }

}
