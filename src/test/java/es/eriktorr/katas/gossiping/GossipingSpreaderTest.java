package es.eriktorr.katas.gossiping;

import es.eriktorr.katas.gossiping.GossipingSpreader;
import lombok.val;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GossipingSpreaderTest {

    @Test public void
    find_the_number_of_stops_it_takes_to_have_all_drivers_on_board_with_the_latest_gossips() {
        val gossipingCollector = new GossipingSpreader(
                Collections.unmodifiableMap(new HashMap<String, List<Integer>>() {{
                    put("D1", Arrays.asList(3, 1, 2, 3));
                    put("D2", Arrays.asList(3, 2, 3, 1));
                    put("D3", Arrays.asList(4, 2, 3, 4, 5));
                }})
        );
        assertThat(gossipingCollector.stopsNeededToSpreadAllTheGossips()).isEqualTo("5");
    }

    @Test public void
    return_never_when_at_least_one_driver_does_not_have_all_the_gossips_by_the_end_of_the_day() {
        val gossipingCollector = new GossipingSpreader(
                Collections.unmodifiableMap(new HashMap<String, List<Integer>>() {{
                    put("D1", Arrays.asList(2, 1, 2));
                    put("D2", Arrays.asList(5, 2, 8));
                }})
        );
        assertThat(gossipingCollector.stopsNeededToSpreadAllTheGossips()).isEqualTo("never");
    }

}
