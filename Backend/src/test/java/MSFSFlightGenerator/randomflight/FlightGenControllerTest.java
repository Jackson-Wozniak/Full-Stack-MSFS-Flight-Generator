package MSFSFlightGenerator.randomflight;

import MSFSFlightGenerator.randomflight.airport.AirportService;
import MSFSFlightGenerator.randomflight.plane.PlaneService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class FlightGenControllerTest {

    @Autowired
    private AirportService airportService;

    @Autowired
    private PlaneService planeService;


    @Test
    //make sure that flight constructor auto calls setDistance and setTime method
    void makeSureFlightDistanceExists(){
        Flight flight = new Flight(
                airportService.findRandomAirport(),
                airportService.findRandomAirport(),
                planeService.findRandomPlane());
        assertNotEquals(0.0d, flight.getFlightDistance());
    }

}