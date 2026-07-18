import factory.TripFactory;
import models.Trip;
import exo.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Trip> trips = TripFactory.generateTrips(10);

        Partie1 p1 = new Partie1();
        Partie2 p2 = new Partie2();
        Partie3 p3 = new Partie3();
        Partie4 p4 = new Partie4();

        System.out.println("Trajets longs et chers : " + p1.longAndExpensiveTrips(trips));
        System.out.println("Mauvais trajets : " + p1.badTrips(trips));
        System.out.println("Trajets récents : " + p1.recentTrips(trips));

        System.out.println("Nombre par ville : " + p2.countByCity(trips));
        System.out.println("Revenus par chauffeur : " + p2.revenueByDriver(trips));
        System.out.println("Durée moyenne par ville : " + p2.avgDurationByCity(trips));

        System.out.println("Top 10 trajets chers : " + p3.top10ExpensiveTrips(trips));
        System.out.println("Meilleur trajet : " + p3.bestTrip(trips));

        System.out.println("Revenu total séquentiel : " + p4.totalRevenueSequential(trips));
        System.out.println("Revenu total parallèle : " + p4.totalRevenueParallel(trips));
        System.out.println("Nombre par ville parallèle : " + p4.countByCityParallel(trips));
        System.out.println("Trajets premium : " + p4.premiumTripsParallel(trips));
    }
}