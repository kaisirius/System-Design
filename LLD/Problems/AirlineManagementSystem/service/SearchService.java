package LLD.Problems.AirlineManagementSystem.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import LLD.Problems.AirlineManagementSystem.models.Flight;

public class SearchService {
  private List<Flight> flights;

  public SearchService() {
    flights = new ArrayList<>();
  }

  public void addFlight(Flight flight) {
    flights.add(flight);
  }

  public List<Flight> searchFlightsBeforeDate(String source, String destination, LocalDateTime date) {
    List<Flight> res = new ArrayList<>();

    for(Flight flight: flights) {
      if(flight.getSource() == source && flight.getDestination() == destination && flight.getDepartureTime().isBefore(date)) {
        res.add(flight);
      }
    }
    return res;
  }
}
