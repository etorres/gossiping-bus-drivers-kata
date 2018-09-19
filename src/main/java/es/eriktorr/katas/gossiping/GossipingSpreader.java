package es.eriktorr.katas.gossiping;

import lombok.val;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class GossipingSpreader {

    private static final int MINUTES_MAXIMUM = 480;

    private final List<BusRoute> routes;
    private final Map<BusDriver, Set<Gossip>> gossips;

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
        val sameStopGroups = routes.stream()
                .collect(Collectors.groupingBy(route -> route.stopAt(minute)));
        sameStopGroups.forEach((stop, busRoutes) -> {
            if (busRoutes.size() > 1) {
                val combinedGossips = busRoutes.stream()
                        .map(busRoute -> gossips.get(busRoute.getDriver()))
                        .flatMap(Collection::stream)
                        .collect(Collectors.toSet());
                busRoutes.forEach(busRoute -> gossips.put(busRoute.getDriver(), combinedGossips));
            }
        });
        val driverWhoDoesNotHaveAllTheGossips = gossips.values().stream()
                .filter(currentGossips -> currentGossips.size() != routes.size())
                .findFirst();
        return !driverWhoDoesNotHaveAllTheGossips.isPresent();
    }

    private Set<Gossip> initialGossipFrom(String driverName) {
        return new HashSet<>(Collections.singletonList(new Gossip(driverName + "' gossip")));
    }

}
