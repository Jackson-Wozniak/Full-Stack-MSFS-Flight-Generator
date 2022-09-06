package MSFSFlightGenerator.service;

import MSFSFlightGenerator.model.entity.Airport;
import MSFSFlightGenerator.utils.GenerateFlightUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class AirportServiceTest {

    @Autowired
    private AirportService airportService;

    @Test
    void emptyIcaoCodeMakesAirportNull(){
        assertNull(airportService.findAirportById(""));
    }

    @Test
    void flightNotOverTenHours(){
        List<Airport> airports =
                airportService.getAirportsWithMaxHours("10", 200);
        double distanceInMiles = GenerateFlightUtils.calculateFlightDistanceInMiles(
                airports.get(0), airports.get(1));
        assert(GenerateFlightUtils.calculateFlightHours(200, distanceInMiles) <= 10);
    }

    @Test
    void timeOfAnyDoesNotThrowNumberFormatException(){
        assertDoesNotThrow(
                () -> airportService.getAirportsWithMaxHours(
                        "any", 100));
    }

}