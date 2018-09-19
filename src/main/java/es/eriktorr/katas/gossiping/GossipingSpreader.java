package es.eriktorr.katas.gossiping;

import lombok.val;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static es.eriktorr.katas.gossiping.Gossip.initialsGossipFor;

class GossipingSpreader {

    private static final int MINUTES_MAXIMUM = 480;

    private final List<BusRoute> routes;
    private final Map<BusDriver, Set<Gossip>> gossips;

    GossipingSpreader(List<BusRoute> routes) {
        this.routes = routes;
        this.gossips = initialGossips(routes);
    }

    String stopsNeededToSpreadAllTheGossips() {
        val stops = IntStream.rangeClosed(0, MINUTES_MAXIMUM).sorted()
                .filter(this::areAllGossipsSpreadAt)
                .mapToObj(Integer::toString)
                .findFirst();
        return stops.orElse("never");
    }

    private boolean areAllGossipsSpreadAt(int minute) {
        val driversGroupedByStop = groupDriversByStopAt(minute);
        exchangeGossips(driversGroupedByStop);
        return areAllDriversOnBoardWithTheLatestsGossips();
    }

    private Map<Integer, List<BusRoute>> groupDriversByStopAt(int minute) {
        return routes.stream()
                .collect(Collectors.groupingBy(route -> route.stopAt(minute)));
    }

    private void exchangeGossips(Map<Integer, List<BusRoute>> sameStopGroups) {
        sameStopGroups.forEach((stop, busRoutes) -> {
            if (busRoutes.size() > 1) {
                exchangeGossipsWith(busRoutes);
            }
        });
    }

    private void exchangeGossipsWith(List<BusRoute> busRoutes) {
        val combinedGossips = busRoutes.stream()
                .map(busRoute -> gossips.get(busRoute.getDriver()))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        busRoutes.forEach(busRoute -> gossips.put(busRoute.getDriver(), combinedGossips));
    }

    private boolean areAllDriversOnBoardWithTheLatestsGossips() {
        val driverWhoDoesNotHaveAllTheGossips = gossips.values().stream()
                .filter(currentGossips -> currentGossips.size() != routes.size())
                .findFirst();
        return !driverWhoDoesNotHaveAllTheGossips.isPresent();
    }

    private Map<BusDriver, Set<Gossip>> initialGossips(List<BusRoute> routes) {
        return routes.stream()
                .map(route -> new SimpleEntry<>(route.getDriver(), initialsGossipFor(route.getDriverName())))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
    }

}
