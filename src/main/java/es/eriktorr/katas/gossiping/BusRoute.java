package es.eriktorr.katas.gossiping;

import lombok.Value;

import java.util.List;

@Value
class BusRoute {

    private final BusDriver driver;
    private final List<Integer> stops;

    String getDriverName() {
        return driver.getName();
    }

}
