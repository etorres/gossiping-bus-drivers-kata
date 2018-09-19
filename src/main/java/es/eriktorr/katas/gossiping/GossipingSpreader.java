package es.eriktorr.katas.gossiping;

import lombok.val;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class GossipingSpreader {

    private static final int MINUTES_MAXIMUM = 480;

    private final List<BusRoute> routes;
    private final Map<BusDriver, List<Gossip>> gossips;

    GossipingSpreader(List<BusRoute> routes) {
        this.routes = routes;
        this.gossips = routes.stream()
                .map(route -> new SimpleEntry<>(route.getDriver(), initialGossipFrom(route.getDriverName())))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
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

    private List<Gossip> initialGossipFrom(String driverName) {
        return Collections.singletonList(new Gossip(driverName + "' gossip"));
    }

}
