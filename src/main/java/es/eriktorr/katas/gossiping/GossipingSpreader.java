package es.eriktorr.katas.gossiping;

import java.util.List;
import java.util.stream.Collectors;

class GossipingSpreader {

    private static final int MINUTES_MAXIMUM = 480;

    private final List<DailyBusRoute> dailyRoutes;

    GossipingSpreader(List<BusRoute> routes) {
        this.dailyRoutes = routes.stream()
                .map(DailyBusRoute::new)
                .collect(Collectors.toList());
    }

    String stopsNeededToSpreadAllTheGossips() {
        return null;
    }

}
