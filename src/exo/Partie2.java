package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie2 {

    private static final Function<Trip, String> toCity =
            Trip::city;

    private static final Function<Trip, String> toDriver =
            Trip::driverId;

    private static final ToDoubleFunction<Trip> toPrice =
            Trip::price;

    private static final ToDoubleFunction<Trip> toDuration =
            Trip::durationMin;

    public Map<String, Long> countByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        toCity,
                        Collectors.counting()
                ));
    }

    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        toDriver,
                        Collectors.summingDouble(toPrice)
                ));
    }

    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        toCity,
                        Collectors.averagingDouble(toDuration)
                ));
    }
}
