import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

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
scanner.nextLine();

            switch (menu) {
                case 1:
//RUN METHOD COUNT HIVE
                    countHive(hive);
//RUN METHOD SUM OF HONEY AND POLLEN
                    honeyAndPollenSum(colony);
//RUN METHOD PRINT OUT 3 STRONGEST HIVES
                    strongestHivesByHoney(colony, location, hive);
//RUN METHOD VARROA TREATMENT COUNT
                    varroaTreatmentCount(colony);
                    getPercentsOfVarroaTreatement(colony);

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
                        menu1 = scanner.nextInt();
                        scanner.nextLine();

                        switch (menu1) {
                            case 1:
                                System.out.println("Information about number of bee hives in each location:");
                                System.out.println("");
                                hivesInLocations(hive,location);
                                System.out.println("");
                                break;
                            case 2:
                                System.out.println("Information about total amount of honey in each location:");
                                System.out.println("");
                                countHoneyInLocation(location,hive,colony);
                                System.out.println("");
                                break;
                            case 3:
                                System.out.println("Information about total amount of pollen in each location:");
                                System.out.println("");
// Insert method
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
                    getInfoFromHistoryTableAboutData(history, scanner);
                    break;
                case 4:
//PRINT INFORMATION ABOUT SELECTED COLONY
                    printInfoAboutColony(scanner, colony);
////                    Help for Livija
//                    System.out.println("Please enter next visits date: ");
//                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
//                   String dateOne = "";
//                      dateOne = scanner.nextLine();
//                     Date date = simpleDateFormat.parse(dateOne);

                    break;
                case 5:
//RUN METHOD ADD NEW HIVE
                    addNewHive(scanner, hive, history, location, localDateTime, dateTimeFormatter);
                    break;
                case 6:
//RUN METHOD DELETE NEW HIVE
                    deleteHive(scanner, hive, location, history, localDateTime, dateTimeFormatter);
                    break;
                case 7:
//RUN METHOD ADD NEW LOCATION
                    addNewLocation(scanner, location, history, localDateTime, dateTimeFormatter);
                    break;
                case 8:
//RUN METHOD TO PRINT OUT ALL LOCATIONS
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
        location.setLocationName(scanner.nextLine());

        System.out.println("Please enter location address");
        location.setLocationAddress(scanner.nextLine());

        System.out.println("Please enter location note");
        location.setLocationNote(scanner.nextLine());

//        CREATE LOCATION
        dbConnection.createLocation(location);
//        ADD RECORD TO HISTORY TABLE
        history.setActionDone("Added new location " + location.getLocationName());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);

    }
// CREATE METHOD ADD NEW HIVE
    public static void addNewHive(Scanner scanner, Hive hive, History history, Location location, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {

        System.out.println("Please enter hive id");
        hive.setHiveId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Please enter hive status");
        hive.setHiveStatus(scanner.nextLine());

        System.out.println("Please enter hive type");
        hive.setHiveType(scanner.nextLine());

        System.out.println("Please enter  hive notes");
        hive.setHiveNotes(scanner.nextLine());

        System.out.println("Please enter location Id");
        hive.setLocationId(scanner.nextInt());
        scanner.nextLine();
        dbConnection.createHive(hive);
//   ADD INFORMATION TO HISTORY TABLE
        history.setActionDone("Added new hive: nr: " + hive.getHiveId() + " ,in location: " + dbConnection.findLocationForAddedHive(location, hive));
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }
    // METHOD PRINT OUT LOCATIONS

    public static void printLocation1(Location location) {
        dbConnection.printLocation(location);
    }

    // CREATE METHOD DELETE LOCATION
    public static void deleteLocation(Scanner scanner, Location location, Hive hive, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Please enter location you want to delete");
        location.setLocationName(scanner.nextLine());

        //        DELETE HIVES TOGETHER WITH LOCATION WITH FOREACH LOOP
        for (int eatchvariable : dbConnection.findHivesToDelete(location)
        ) {
            hive.setHiveId(eatchvariable);
            dbConnection.deleteHive(hive);
//      ADD INFORMATION ABOUT DELETED HIVES IN HISTORY TABLE IN LOOP
            history.setActionDone("Hive nr. deleted together with location " + location.getLocationName() + " is: " + eatchvariable);
            history.setDataAndTime(localDateTime.format(dateTimeFormatter));
            dbConnection.addRecordToHistory(history);
        }
// ADD INFORMATION ABOUT DELETED LOCATION IN HISTORY TABLE
        history.setActionDone("Location deleted " + location.getLocationName());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
//        DELETE LOCATION
        dbConnection.deleteLocation(location);
    }

    // CREATE METHOD DELETE HIVE
    public static void deleteHive(Scanner scanner, Hive hive, Location location, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Please enter hive id you want to delete");
        hive.setHiveId(scanner.nextInt());
        scanner.nextLine();
//        ADD INFORMATION IN HISTORY DATA BASE
        history.setActionDone("Deleted hive nr:" + hive.getHiveId() + " from location " + dbConnection.findLocationForHive(location, hive));
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
//        DELETING HIVE
        dbConnection.deleteHive(hive);
    }

    // COUNTING HIVES
    public static void countHive(Hive hive) {
        dbConnection.countHives(hive);
    }

    //    SUM OF HONEY AND POLLEN
    public static void honeyAndPollenSum(Colony colony) {
        dbConnection.sumOfHoneyAndPollen(colony);
    }
//  3 STRONGEST HIVES BY HONEY

    public static void strongestHivesByHoney(Colony colony, Location location, Hive hive) {
        dbConnection.strongestColoniesByHoney(colony, hive, location);
    }

    //HOW MANY COLONIES ARE TREATED WITH VARROA TREATMENT,SORT BY COUNT
    public static void varroaTreatmentCount(Colony colony) {
        dbConnection.varroaTreatmentCount(colony);
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
        scanner.nextLine();
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

    //    GET INFORMATION FROM HISTORY TABLE ABOUT SPECIFIC DATA
    public static void getInfoFromHistoryTableAboutData(History history, Scanner scanner) {
        System.out.println("Please enter data you would like see information about in format: dd-mm-yyyy");
        history.setDataAndTime(scanner.nextLine());

        dbConnection.getInformationFromHistoryTable(history);
    }


}


