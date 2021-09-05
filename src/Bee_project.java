import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        History history = new History();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
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
//RUN METHOD TO COUNT HIVES ARE IN EACH LOCATION
                    hivesInLocations(hive, location);
//RUN METHOD TO COUNT HONEY IN EACH LOCATION
                    countHoneyInLocation(location, hive, colony);
                    break;
                case 3:

                    break;
                case 4:
//PRINT INFORMATION ABOUT SELECTED COLONY
                    printInfoAboutColony(scanner, colony);
                    break;
                case 5:
//RUN METHOD ADD NEW HIVE
                    addNewHive(scanner, hive, history, localDateTime, dateTimeFormatter);
                    break;
                case 6:
//RUN METHOD DELETE NEW HIVE
                    deleteHive(scanner, hive);
                    break;
                case 7:
//RUN METHOD ADD NEW LOCATION
                    addNewLocation(scanner, location, history, localDateTime, dateTimeFormatter);
                    break;
                case 8:
//PRINT OUT ALL LOCATIONS
                    printLocation1(location);
//RUN METHOD DELETE LOCATION
                    deleteLocation(scanner, location, hive, history, localDateTime, dateTimeFormatter);
                    break;
                default:
                    System.out.println("This menu item does not exist");
                    System.out.println("Please double check the number you have entered!");
            }

        } while (menu != 0);


    }

    // CREATE METHOD ADD NEW LOCATION
    public static void addNewLocation(Scanner scanner, Location location, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Please enter location name");
        location.setLocationName(scanner.next());
        System.out.println("Please enter location address");
        location.setLocationAddress(scanner.next());
        System.out.println("Please enter location note");
        location.setLocationNote(scanner.next());
//        CREATE LOCATION
        dbConnection.createLocation(location);
//        ADD RECORD TO HISTORY TABLE
        history.setActionDone("Added new location " + location.getLocationName());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);

    }
// CREATE METHOD ADD NEW HIVE

    public static void addNewHive(Scanner scanner, Hive hive, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {

        System.out.println("Please enter hive id");
        hive.setHiveId(scanner.nextInt());
        System.out.println("Please enter hive status");
        hive.setHiveStatus(scanner.next());
        System.out.println("Please enter hive type");
        hive.setHiveType(scanner.next());
        System.out.println("Please enter  hive notes");
        hive.setHiveNotes(scanner.next());
        System.out.println("Please enter location Id");
        hive.setLocationId(scanner.nextInt());
        dbConnection.createHive(hive);
//
        history.setActionDone("Added new hive: nr: " + hive.getHiveId() + " ,in location: " + hive.getLocationId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    // METHOD PRINT OUT LOCATIONS

    public static void printLocation1(Location location){
        dbConnection.printLocation(location);

    }

    // CREATE METHOD DELETE LOCATION

    public static void deleteLocation(Scanner scanner, Location location, Hive hive, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Please enter location you want to delete");
        location.setLocationName(scanner.next());
        System.out.println(dbConnection.findHivesToDelete(location).toString());
        for (int eatchvariable : dbConnection.findHivesToDelete(location)
        ) {
            hive.setHiveId(eatchvariable);
            dbConnection.deleteHive(hive);
            history.setActionDone("Hive nr. deleted together with location " + location.getLocationName() + " is: " + eatchvariable);
            history.setDataAndTime(localDateTime.format(dateTimeFormatter));
            dbConnection.addRecordToHistory(history);
        }
        history.setActionDone("Location deleted " + location.getLocationName());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
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

    //HOW MANY HIVES IN LOCATIONS
    public static void hivesInLocations(Hive hive, Location location) {
        dbConnection.hivesInLocations(hive, location);
    }

    //    COUNT HONEY IN LOCATIONS
    public static void countHoneyInLocation(Location location, Hive hive, Colony colony) {
        dbConnection.countHoneyInLocations(location, hive, colony);
    }

    // PRINT OUT INFORMATION ABOUT COLONIES
    public static void printInfoAboutColony(Scanner scanner, Colony colony) {
        System.out.println("Select hive id whose colony you want information about");
        colony.setHiveId(scanner.nextInt());
        dbConnection.coloniesInfo(colony);
    }

    public static void getPercentsOfVarroaTreatement(Colony colony) {
        int counterForL = 0;
        int counterForM = 0;
        int counterForA = 0;

        for (int i = 0; i < dbConnection.getvarroaTreatment().size(); i++) {
            if (dbConnection.getvarroaTreatment().get(i).equals("l")) {
                counterForL++;
            } else if (dbConnection.getvarroaTreatment().get(i).equals("m")) {
                counterForM++;
            } else if (dbConnection.getvarroaTreatment().get(i).equals("a")) {
                counterForA++;
            }
        }
        System.out.println((double) counterForL * 100 / dbConnection.getvarroaTreatment().size() + " % of colonies treated with treatment l");
        System.out.println((double) counterForM * 100 / dbConnection.getvarroaTreatment().size() + " % of colonies treated with treatment m");
        System.out.println((double) counterForA * 100 / dbConnection.getvarroaTreatment().size() + " % of colonies treated with treatment a");
    }
}

