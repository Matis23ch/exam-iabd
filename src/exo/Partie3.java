package exo;

import models.Trip;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Partie3 {

    private static final Comparator<Trip> byPriceDesc =
            Comparator.comparingDouble(Trip::price).reversed();

    private static final Comparator<Trip> byRatingDesc =
            Comparator.comparingDouble(Trip::rating).reversed();

    public List<Trip> top10ExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .sorted(byPriceDesc)
                .limit(10)
                .toList();
    }

    public Optional<Trip> bestTrip(List<Trip> trips) {
        return trips.stream()
                .max(byRatingDesc);
    }
}