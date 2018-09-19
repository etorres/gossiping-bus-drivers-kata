package es.eriktorr.katas.gossiping;

import lombok.val;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GossipingSpreaderTest {

    private static final BusDriver BUS_DRIVER_DAVE = new BusDriver("Dave");
    private static final BusDriver BUS_DRIVER_ANNA = new BusDriver("Anna");
    private static final BusDriver BUS_DRIVER_JOHN = new BusDriver("John");

    @Test public void
    find_the_number_of_stops_it_takes_to_have_all_drivers_on_board_with_the_latest_gossips() {
        val gossipingSpreader = new GossipingSpreader(
                Arrays.asList(
                        new BusRoute(BUS_DRIVER_DAVE, Arrays.asList(3, 1, 2, 3)),
                        new BusRoute(BUS_DRIVER_ANNA, Arrays.asList(3, 2, 3, 1)),
                        new BusRoute(BUS_DRIVER_JOHN, Arrays.asList(4, 2, 3, 4, 5))
                )
        );
        assertThat(gossipingSpreader.stopsNeededToSpreadAllTheGossips()).isEqualTo("4");
    }

    @Test public void
    return_never_when_at_least_one_driver_does_not_have_all_the_gossips_by_the_end_of_the_day() {
        val gossipingSpreader = new GossipingSpreader(
                Arrays.asList(
                        new BusRoute(BUS_DRIVER_DAVE, Arrays.asList(2, 1, 2)),
                        new BusRoute(BUS_DRIVER_ANNA, Arrays.asList(5, 2, 8))
                )
        );
        assertThat(gossipingSpreader.stopsNeededToSpreadAllTheGossips()).isEqualTo("never");
    }

}
