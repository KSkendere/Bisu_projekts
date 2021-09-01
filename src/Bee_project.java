import java.sql.*;
import java.util.Scanner;

public class Bee_project {


    private static DbConnection dbConnection;

    public static void main(String[] args) {


        dbConnection = new DbConnection();

        Location location = new Location();
        Hive hive = new Hive();
//ADD SCANNER
        Scanner scanner = new Scanner(System.in);


        // Creating a MENU
        int menu;

        do {
            System.out.println("Welcome to BeeMaster!");
            System.out.println("Please select what you would like to do:");
            System.out.println("Select 1 to show a general information about my bee hives");
            System.out.println("Select 2 to show information about specific location");
            System.out.println("Select 3 to show a list of tasks for this week");
            System.out.println("Select 4 to show and edit the information about the bee hive");
            System.out.println("Select 5 to add a new bee hive to the location");
            System.out.println("Select 6 to delete an existing bee hive");
            System.out.println("Select 7 to add a new location");
            System.out.println("Select 8 to delete a location");
            System.out.println("Select 0 to exit the application");
            menu = scanner.nextInt();


            switch (menu) {
                case 1:
                    dbConnection.toString();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
//RUN METHOD ADD NEW LOCATION
                    addNewHive(scanner, hive);
                    break;
                case 6:

                    break;
                case 7:
                    //RUN METHOD ADD NEW LOCATION
                    addNewLocation(scanner, location);
                    break;
                case 8:

                    break;
                default:
                    System.out.println("This menu item does not exist");
                    System.out.println("Please double check the number you have entered!");
            }

        } while (menu != 0);


    }

    // CREATE METHOD ADD NEW LOCATION
    public static void addNewLocation(Scanner scanner, Location location) {
        System.out.println("Please enter location name");
        location.setLocationName(scanner.next());
        System.out.println("Please enter location address");
        location.setLocationAddress(scanner.next());
        System.out.println("Please enter location note");
        location.setLocationNote(scanner.next());
//        CREATE LOCATION
        dbConnection.createLocation(location);

    }
// CREATE METHOD ADD NEW HIVE

    public static void addNewHive(Scanner scanner, Hive hive) {

        System.out.println("Please enter hive status");
        hive.setHiveStatus(scanner.next());
        System.out.println("Please enter hive type");
        hive.setHiveType(scanner.next());
        System.out.println("Please enter  hive notes");
        hive.setHiveNotes (scanner.next());
//    System.out.println("Please choose location Id");
//    hive.setLocationIdForHive(location.getLocationId());
        dbConnection.createHive(hive);


    }
}
