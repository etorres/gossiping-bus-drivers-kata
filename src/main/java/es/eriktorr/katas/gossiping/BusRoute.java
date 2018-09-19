package es.eriktorr.katas.gossiping;

import lombok.Value;
import lombok.val;

import java.util.List;

@Value
class BusRoute {

    private final BusDriver driver;
    private final List<Integer> stops;

    String getDriverName() {
        return driver.getName();
    }

    int stopAt(int minute) {
        val size = stops.size();
        return stops.get(minute < size ? minute : minute % size);
    }

}
