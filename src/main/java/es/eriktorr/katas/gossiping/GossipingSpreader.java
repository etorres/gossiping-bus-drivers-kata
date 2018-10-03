package es.eriktorr.katas.gossiping;

import lombok.val;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static es.eriktorr.katas.gossiping.Gossip.initialGossipsFor;

class GossipingSpreader {

    private final List<BusRoute> routes;
    private final Map<BusDriver, Set<Gossip>> gossips;

    GossipingSpreader(List<BusRoute> routes) {
        this.routes = routes;
        this.gossips = initialGossipsFrom(routes);
    }

    String stopsNeededToSpreadAllTheGossips() {
        /* TODO step 1: step sequentially through the stops of the routes, until all the gossips are spread or
           until the end of the day, whatever comes first */
        throw new IllegalStateException("Feature under construction");
    }

    private boolean areAllGossipsSpreadAt(int minute) {
        val driversGroupedByStop = groupDriversByStopAt(minute);
        exchangeGossips(driversGroupedByStop);
        return areAllDriversOnBoardWithTheLatestGossips();
    }

    private Map<Integer, List<BusRoute>> groupDriversByStopAt(int minute) {
        /* TODO step 2: group drivers by stop */
        throw new IllegalStateException("Feature under construction");
    }

    private void exchangeGossips(Map<Integer, List<BusRoute>> sameStopGroups) {
        /* TODO step 3: exchange gossips with the drivers who meet at the same stop */
        throw new IllegalStateException("Feature under construction");
    }

    private boolean areAllDriversOnBoardWithTheLatestGossips() {
        /* TODO step 4: check that all drivers are on board with the latest gossips */
        throw new IllegalStateException("Feature under construction");
    }

    private Map<BusDriver, Set<Gossip>> initialGossipsFrom(List<BusRoute> routes) {
        return routes.stream()
                .map(route -> new SimpleEntry<>(route.getDriver(), initialGossipsFor(route.getDriverName())))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
    }

}
