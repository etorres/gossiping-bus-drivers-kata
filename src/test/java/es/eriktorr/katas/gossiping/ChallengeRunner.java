package es.eriktorr.katas.gossiping;

import lombok.Value;
import lombok.val;

import java.util.Arrays;
import java.util.stream.Stream;

public class ChallengeRunner {

    public static void main(String[] args) {
        Stream.of(challenge1(), challenge2()).forEach(challenge -> {
                    val challengeName = challenge.getName();
                    val gossipingSpreader = challenge.getGossipingSpreader();
                    val stopsOrNever = gossipingSpreader.stopsNeededToSpreadAllTheGossips();
                    System.out.println(String.format("In challenge \"%s\" gossips are spread at %s", challengeName, stopsOrNever));
                }
        );
    }

    private static Challenge challenge1() {
        return new Challenge("Small city", new GossipingSpreader(
                Arrays.asList(
                        new BusRoute(new BusDriver("Olivia"), Arrays.asList(7, 11, 2, 2, 4, 8, 2, 2)),
                        new BusRoute(new BusDriver("Sophia"), Arrays.asList(3, 0, 11, 8)),
                        new BusRoute(new BusDriver("Amelia"), Arrays.asList(5, 11, 8, 10, 3, 11)),
                        new BusRoute(new BusDriver("Muhammad"), Arrays.asList(5, 9, 2, 5, 0, 3)),
                        new BusRoute(new BusDriver("Oliver"), Arrays.asList(7, 4, 8, 2, 8, 1, 0, 5)),
                        new BusRoute(new BusDriver("Emily"), Arrays.asList(3, 6, 8, 9)),
                        new BusRoute(new BusDriver("Isabella"), Arrays.asList(4, 2, 11, 3, 3))
                )
        ));
    }

    private static Challenge challenge2() {
        return new Challenge("Large city", new GossipingSpreader(
                Arrays.asList(
                        new BusRoute(new BusDriver("Noah"), Arrays.asList(12, 23, 15, 2, 8, 20, 21, 3, 23, 3, 27, 20, 0)),
                        new BusRoute(new BusDriver("Leo"), Arrays.asList(21, 14, 8, 20, 10, 0, 23, 3, 24, 23, 0, 19, 14, 12, 10, 9, 12, 12, 11, 6, 27, 5)),
                        new BusRoute(new BusDriver("Jack"), Arrays.asList(8, 18, 27, 10, 11, 22, 29, 23, 14)),
                        new BusRoute(new BusDriver("Freddie"), Arrays.asList(13, 7, 14, 1, 9, 14, 16, 12, 0, 10, 13, 19, 16, 17)),
                        new BusRoute(new BusDriver("Grace"), Arrays.asList(24, 25, 21, 4, 6, 19, 1, 3, 26, 11, 22, 28, 14, 14, 27, 7, 20, 8, 7, 4, 1, 8, 10, 18, 21)),
                        new BusRoute(new BusDriver("Aria"), Arrays.asList(13, 20, 26, 22, 6, 5, 6, 23, 26, 2, 21, 16, 26, 24)),
                        new BusRoute(new BusDriver("Harry"), Arrays.asList(6, 7, 17, 2, 22, 23, 21)),
                        new BusRoute(new BusDriver("George"), Arrays.asList(23, 14, 22, 28, 10, 23, 7, 21, 3, 20, 24, 23, 8, 8, 21, 13, 15, 6, 9, 17, 27, 17, 13, 14)),
                        new BusRoute(new BusDriver("Lily"), Arrays.asList(23, 13, 1, 15, 5, 16, 7, 26, 22, 29, 17, 3, 14, 16, 16, 18, 6, 10, 3, 14, 10, 17, 27, 25)),
                        new BusRoute(new BusDriver("Mia"), Arrays.asList(25, 28, 5, 21, 8, 10, 27, 21, 23, 28, 7, 20, 6, 6, 9, 29, 27, 26, 24, 3, 12, 10, 21, 10, 12, 17)),
                        new BusRoute(new BusDriver("Charlie"), Arrays.asList(26, 22, 26, 13, 10, 19, 3, 15, 2, 3, 25, 29, 25, 19, 19, 24, 1, 26, 22, 10, 17, 19, 28, 11, 22, 2, 13)),
                        new BusRoute(new BusDriver("Ava"), Arrays.asList(8, 4, 25, 15, 20, 9, 11, 3, 19)),
                        new BusRoute(new BusDriver("Ethan"), Arrays.asList(24, 29, 4, 17, 2, 0, 8, 19, 11, 28, 13, 4, 16, 5, 15, 25, 16, 5, 6, 1, 0, 19, 7, 4, 6)),
                        new BusRoute(new BusDriver("Freya"), Arrays.asList(16, 25, 15, 17, 20, 27, 1, 11, 1, 18, 14, 23, 27, 25, 26, 17, 1))
                )
        ));
    }

    @Value
    private static class Challenge {
        private final String name;
        private final GossipingSpreader gossipingSpreader;
    }

}
