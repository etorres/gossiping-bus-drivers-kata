package es.eriktorr.katas.gossiping;

import lombok.Value;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Value
class Gossip {

    private final String content;

    static Set<Gossip> initialsGossipFor(String driverName) {
        return new HashSet<>(Collections.singletonList(new Gossip(driverName + "'s gossip")));
    }

}
