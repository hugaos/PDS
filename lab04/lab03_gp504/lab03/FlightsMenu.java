package lab03;

public class FlightsMenu {
    public static void mainMenu() {
        System.out.println("Choose an option: (H for help)");
    }

    public static void helpMenu() {
        System.out.println("I <FileName> - Reads the given file and with flight content.\n");
        System.out.println("M <flight_code> - Shows the map of the reservations in the plane.\n");
        System.out.println(
                "F <flight_code> <num_seats_executive> <num_seats_tourist> - Increments a new flight with flight code, executive seats and tourists seats.\n");
        System.out.println(
                "R <flight_code> <class> <number_seats> - Increments a reservation to the flight with indication of hte flight code, class (T / E) and number of seats.\n");
        System.out.println("C <reservation_code> - Cancels a reservation\n");
        System.out.println("Q - Quit");
    }
}
