package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Partie1 {

    private static final Predicate<Trip> longTrip =
            trip -> trip.distanceKm() > 10;

    private static final Predicate<Trip> expensiveTrip =
            trip -> trip.price() > 20;

    private static final Predicate<Trip> badTrip =
            trip -> trip.rating() < 3;

    private static final Predicate<Trip> recentTrip =
            trip -> {
                LocalDate today = LocalDate.now();
                LocalDate yesterday = today.minusDays(1);
                LocalDate tripDate = trip.startTime().toLocalDate();
                return tripDate.equals(today) || tripDate.equals(yesterday);
            };

    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .filter(longTrip.and(expensiveTrip))
                .toList();
    }

    public List<Trip> badTrips(List<Trip> trips) {
        return trips.stream()
                .filter(badTrip)
                .toList();
    }

    public List<Trip> recentTrips(List<Trip> trips) {
        return trips.stream()
                .filter(recentTrip)
                .toList();
    }
}