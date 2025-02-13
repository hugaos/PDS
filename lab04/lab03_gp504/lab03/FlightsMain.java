package lab03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FlightsMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Plane> stored_planes = new HashMap<String, Plane>();

        FlightsMenu mn = new FlightsMenu();
        if (args.length == 0) {
            while (true) {
                FlightsMenu.mainMenu();
                String userInput = sc.nextLine();
                usrInputHandler(userInput, mn, stored_planes);
            }
        } else {
            for (String string : args) {
                String[] arr = readFile(string);
                for (String string2 : arr) {
                    usrInputHandler(string2, mn, stored_planes);
                }
            }
        }
        sc.close();
    }

    public static void usrInputHandler(String userInput, FlightsMenu mn, HashMap<String, Plane> stored_planes) {
        String[] inputSplitted = userInput.split(" ");
        char usrOption = Character.toUpperCase(userInput.charAt(0));

        if (userInput == "" || userInput.toUpperCase().equals("H")) {

        }

        // switch case to check user input
        switch (usrOption) {
            case 'H': {
                FlightsMenu.helpMenu();
                break;
            }

            case 'I': {
                if (inputSplitted.length == 1) {
                    System.out.println("Insira o nome do ficheiro");
                    break;
                }

                String[] arr = readFile(inputSplitted[1]);
                Plane plane = createPlane(arr);

                if (plane == null)
                    break;
                if (stored_planes.keySet().contains(plane.getFlightCode())) {
                    System.out.println("Plane already exists.");
                    break;
                }
                System.out.println(plane.planeCharacteristics());

                for (int i = 1; i < arr.length; i++) {
                    String[] reserves = arr[i].split(" ");
                    plane.ocupySeat(reserves[0], Integer.parseInt(reserves[1]));
                }

                // save plane in hashmap
                stored_planes.put(plane.getFlightCode(), plane);
                break;
            }

            case 'M': {
                if (inputSplitted.length == 1) {
                    System.out.println("Insert plane code: ");
                    break;
                }

                String flight_code = inputSplitted[1];
                if (stored_planes.keySet().contains(flight_code)) {
                    System.out.println(stored_planes.get(flight_code));
                } else {
                    System.out.println("Flight code does not exist.");
                }
                break;
            }

            case 'F': {
                String[] arr = { "" };
                if (!(inputSplitted[1].matches(".*[0-9].*") && inputSplitted[1].matches(".*[a-zA-Z].*"))) {
                    System.out.println("Flight code must have at least 1 number and 1 letter");
                    break;
                }

                if (inputSplitted.length == 3) {
                    arr = new String[] { String.format(">%s %s", inputSplitted[1], inputSplitted[2]) };
                } else if (inputSplitted.length == 4) {
                    arr = new String[] {
                            String.format(">%s %s %s", inputSplitted[1], inputSplitted[2], inputSplitted[3]) };
                } else {
                    System.out
                            .println("Formato: flight_code [Opcional]num_seats_executive(4x3) num_seats_tourist(20x4)");
                    break;
                }

                Plane plane = createPlane(arr);

                if (plane == null)
                    break;
                if (stored_planes.keySet().contains(plane.getFlightCode())) {
                    System.out.println("Plane already exists.");
                    break;
                }
                stored_planes.put(plane.getFlightCode(), plane);

                break;
            }

            case 'R': {
                if (inputSplitted.length != 4) {
                    System.out.println("Formato: R flight_code class num_seats");
                    return;
                }
                System.out.println(inputSplitted[2] + " " + inputSplitted[3]);
                Plane plane = stored_planes.get(inputSplitted[1]);
                plane.ocupySeat(inputSplitted[2], Integer.parseInt(inputSplitted[3]));
                int planeRessize = plane.getReservations().size();
                System.out.println(plane.getReservations().get(planeRessize - 1));
                break;
            }

            case 'C': {
                if (inputSplitted.length != 2) {
                    System.out.println("Formato: C flight_code:sequencial_reservation_number");
                    break;
                }

                String[] code = inputSplitted[1].split(":");
                stored_planes.get(code[0]).removeReservation(code[1]);
                break;
            }

            case 'Q': {
                System.out.println("Closing Program..");
                System.exit(0);
                break;
            }

            default: {
                FlightsMenu.helpMenu();
                break;
            }
        }
        System.out.println();
        return;
    }

    private static String[] readFile(String filename) {
        ArrayList<String> lst = new ArrayList<String>();
        String file_path = "lab03/" + filename;
        try {
            Scanner sc = new Scanner(new FileReader(file_path));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lst.add(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        String[] arr = lst.toArray(new String[0]);

        return arr;
    }

    private static Plane createPlane(String[] arr) {
        String[] planeInfo = arr[0].split(" ");
        String flight_code = planeInfo[0].substring(1, planeInfo[0].length());
        int[] num_seats_executive = { 0, 0 };
        int[] num_seats_tourist = { 0, 0 };

        if (planeInfo.length == 2) {
            String[] seats = planeInfo[1].split("x");
            num_seats_tourist = new int[] { Integer.parseInt(seats[0]), Integer.parseInt(seats[1]) };
        } else if (planeInfo.length == 3) {
            String[] seats = planeInfo[1].split("x");
            num_seats_executive = new int[] { Integer.parseInt(seats[0]), Integer.parseInt(seats[1]) };
            seats = planeInfo[2].split("x");
            num_seats_tourist = new int[] { Integer.parseInt(seats[0]), Integer.parseInt(seats[1]) };
        } else {
            System.out.println("Formato: flight_code [Opcional]num_seats_executive(4x3) num_seats_tourist(20x4)");
            return null;
        }

        Plane plane = new Plane(flight_code, num_seats_executive, num_seats_tourist);
        return plane;
    }
}
