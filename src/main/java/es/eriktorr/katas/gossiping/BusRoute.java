package es.eriktorr.katas.gossiping;

import lombok.Value;

import java.util.List;

@Value
class BusRoute {

    private final String driver;
    private final List<Integer> stops;

}
