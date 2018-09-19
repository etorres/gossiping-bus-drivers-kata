package es.eriktorr.katas.gossiping;

import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class BusRouteTest {

    @Parameters(name = "case {index}: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "initial stop of the route", 0, 1 },
                { "stop in the middle of the route", 3, 4 },
                { "final stop of the route", 4, 5 },
                { "stop after a complete round", 7, 3 },
                { "stop after a few rounds", 13, 4 },
        });
    }

    @Parameter public
    String message;

    @Parameter(1) public
    int minute;

    @Parameter(2) public
    int stop;

    private BusRoute busRoute;

    @Before
    public void setUp() {
        val busDriver = new BusDriver("Dave");
        busRoute = new BusRoute(busDriver, Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test public void
    compute_stop_from_minute() {
        assertThat(busRoute.stopAt(minute)).as(message).isEqualTo(stop);
    }

}
