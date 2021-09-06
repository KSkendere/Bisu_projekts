import java.sql.*;
import java.util.Scanner;

public class Bee_project {


    private static DbConnection dbConnection;

    public static void main(String[] args) {


        dbConnection = new DbConnection();
// CREATE OBJECT FROM CLASS COLONY
        Colony colony = new Colony();
// CREATE OBJECT FROM CLASS LOCATION
        Location location = new Location();
// CREATE OBJECT FROM CLASS HIVE
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
                    countHive(hive);
                    honeyAndPollenSum(colony);
                    break;
                case 2:
                    int menu1;
                    do {
                        System.out.println("Please choose what information about bee hive locations you want to know!");
                        System.out.println("");
                        System.out.println("Please select 1 if you want to see information about number of bee hives in each location");
                        System.out.println("Please select 2 if you want to see information about total amount of honey in each location");
                        System.out.println("Please select 3 if you want to see information about total amount of pollen in each location");
                        System.out.println("Please select 0 to exit locations section");
//                        need to add 0 plus need to add default
                        menu1=scanner.nextInt();
                        switch (menu1) {
                            case 1:
                                System.out.println("Information about number of bee hives in each location:");
                                System.out.println("");
                                hivesLocation(colony, location);
                                System.out.println("");
                                break;
                            case 2:
                                System.out.println("Information about total amount of honey in each location:");
                                System.out.println("");
                                honeyInLocation(colony, location);
                                System.out.println("");
                                break;
                            case 3:
                                System.out.println("Information about total amount of pollen in each location:");
                                System.out.println("");
                                pollenInLocation(colony, location);
                                System.out.println("");
                                break;
                            default:
                                if (menu1 == 0) {
                                    System.out.println("Going back to main menu.");
                                    System.out.println();
                                } else {
                                    System.out.println("No such option!");
                                }
                        }
                    } while (menu1 != 0);
                    break;
                case 3:

                    break;
                case 4:
            switch (menu){
//           see information or edit information
//                printout
//                edit all data base choose which to edit?
}
                    break;
                case 5:
//RUN METHOD ADD NEW HIVE
                    addNewHive(scanner, hive);
                    break;
                case 6:
//RUN METHOD DELETE NEW HIVE
                    deleteHive(scanner, hive);
                    break;
                case 7:
//RUN METHOD ADD NEW LOCATION
                    addNewLocation(scanner, location);
                    break;
                case 8:
//PRINT OUT ALL LOCATIONS
                    printLocation1(location);
//RUN METHOD DELETE LOCATION
                    deleteLocation(scanner, location);
//                   If you delete location also delete hives and colonies in it
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
        location.setLocationAddress(scanner.nextLine());
        System.out.println("Please enter location note");
        location.setLocationNote(scanner.nextLine());
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
        hive.setHiveNotes(scanner.next());
//        System.out.println("Please choose location Id");
//        hive.setLocationIdForHive(scanner.nextInt());
        dbConnection.createHive(hive);


    }

    // PRINT METHOD DELETE LOCATION

    public static void printLocation1(Location location){
        dbConnection.printLocation(location);
    }

    // CREATE METHOD DELETE LOCATION

    public static void deleteLocation(Scanner scanner, Location location) {
        System.out.println("Please enter location you want to delete");
        location.setLocationName(scanner.next());
        dbConnection.deleteLocation(location);

    }

    // CREATE METHOD DELETE HIVE
    public static void deleteHive(Scanner scanner, Hive hive) {
        System.out.println("Please enter hive id you want to delete");
        hive.setHiveId(scanner.nextInt());
        dbConnection.deleteHive(hive);

    }
    // COUNTING HIVES
    public static void countHive (Hive hive){
        dbConnection.countHives(hive);
    }
//    SUM OF HONEY AND POLLEN
    public static void honeyAndPollenSum (Colony colony){
        dbConnection.sumOfHoneyAndPollen(colony);
    }

//    Hives in location
    public static void  hivesLocation (Colony colony, Location location){dbConnection.hivesInLocation(colony,location);}
//    Honey in each location
    public static void honeyInLocation (Colony colony, Location location) {dbConnection.honeyInLocation(colony,location);}
//    Pollen in each location
    public static void pollenInLocation (Colony colony, Location location) {dbConnection.pollenInLocation(colony,location);}


}
