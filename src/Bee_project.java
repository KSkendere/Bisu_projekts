import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;
import java.util.Date;

public class Bee_project {
    private static DbConnection dbConnection;

    public static void main(String[] args) throws ParseException {


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
        Methods methods = new Methods();
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
            menu = validatorForIntegers(scanner);


            switch (menu) {
                case 1:
                    int menu2;
                    do {
                        System.out.println("Please choose what you want to see from general section! ");
                        System.out.println("");
                        System.out.println("Please select 1 if you want to see how many bee hives you have");
                        System.out.println("Please select 2 if you want to see total amount of honey and pollen in kg for all bee hives");
                        System.out.println("Please select 3 if you want to see 3 strongest bee hives");
                        System.out.println("Please select 4 if you want to see information about varroa treatment in your bee hives");
                        System.out.println("Please select 0 to exit locations section");
                        menu2 = validatorForIntegers(scanner);

                        switch (menu2) {
                            case 1:
                                System.out.println("Information about how many bee hives you have");
                                System.out.println("");
                                //RUN METHOD COUNT HIVE
                                countHive(hive);
                                break;
                            case 2:
                                System.out.println("Information about total amount of honey and pollen in kg for all bee hives");
                                System.out.println("");
                                //RUN METHOD SUM OF HONEY AND POLLEN
                                honeyAndPollenSum(colony);
                                break;
                            case 3:
                                System.out.println("Information about 3 strongest bee hives");
                                System.out.println("");
                                //RUN METHOD PRINT OUT 3 STRONGEST HIVES
                                strongestHivesByHoney(colony, location, hive);
                                break;
                            case 4:
                                System.out.println("Information about varroa treatment in your bee hives");
                                System.out.println("");
                                //RUN METHOD VARROA TREATMENT COUNT
                                varroaTreatmentCount(colony);
                                getPercentsOfVarroaTreatement(colony);
                                break;
                            default:
                                if (menu2 == 0) {
                                    System.out.println("Going back to main menu.");
                                    System.out.println();
                                } else {
                                    System.out.println("No such option!");
                                }
                        }
                    } while (menu2 != 0);
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
                        menu1 = validatorForIntegers(scanner);


                        switch (menu1) {
                            case 1:
                                System.out.println("Information about number of bee hives in each location:");
                                System.out.println("");
                                hivesInLocations(hive, location);
                                System.out.println("");
                                break;
                            case 2:
                                System.out.println("Information about total amount of honey in each location:");
                                System.out.println("");
                                countHoneyInLocation(location, hive, colony);
                                System.out.println("");
                                break;
                            case 3:
                                System.out.println("Information about total amount of pollen in each location:");
                                System.out.println("");
                                countPollenInLocation(location, hive, colony);
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
                    actionsInLastVisit(history);

                case 4:
//               Help for Livija
//                    System.out.println("Please enter next visits date: ");
//                    colony.setNextVisit(scanner.nextLine());
//
//                    Date date = new SimpleDateFormat("dd/MM/YYY)").parse(colony.getNextVisit());
//                    System.out.println(date);

                    int hiveMenu;
                    do {
                        System.out.println("");
                        System.out.println("Select 1 to show info of colony in specific hive");
                        System.out.println("Select 2 to add new colony");
                        System.out.println("Select 3 to add colony origin in specific hive");
                        System.out.println("Select 4 to add queen's breed in specific hive");
                        System.out.println("Select 5 to add queen's year in specific hive");
                        System.out.println("Select 6 to add number of supers in specific hive");
                        System.out.println("Select 7 to add number of frames in specific hive");
                        System.out.println("Select 8 to add number of bees in specific hive");
                        System.out.println("Select 9 to add number of brood in specific hive");
                        System.out.println("Select 10 to add kg of honey in specific hive");
                        System.out.println("Select 11 to add pollen in specific hive");
                        System.out.println("Select 12 to add varroa treatment in specific hive");
                        System.out.println("Select 13 to add food in specific hive");
                        System.out.println("Select 0 to exit back to main menu");

                        hiveMenu = validatorForIntegers(scanner);

                        switch (hiveMenu) {
                            case 1:
//PRINT INFORMATION ABOUT SELECTED COLONY
                                printInfoAboutColony(scanner, colony);
                                System.out.println();
                                break;
                            case 2:
// ADD COLONY
                                addColony(colony, scanner, hive, history, location, localDateTime, dateTimeFormatter);
                                System.out.println();
                                break;
                            case 3:
                                //ADD COLONY ORIGIN
                                System.out.println("Adding colony origin: ");
                                addColonyOrigin(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachColonyOrigin(colony);
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Adding queen breed: ");
                                addQueenBreed(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachQueenBreed(colony);
                                System.out.println();
                                break;
                            case 5:
                                System.out.println("Adding queen year: ");
                                addQueenYear(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachQueenYear(colony);
                                System.out.println();
                                break;
                            case 6:
                                System.out.println("Adding number of supers: ");
                                addNumOfSupers(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachNumOfSupers(colony);
                                System.out.println();
                                break;
                            case 7:
                                System.out.println("Adding number of frames: ");
                                addNumOfFrames(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachNumOfFrames(colony);
                                System.out.println();
                                break;
                            case 8:
                                System.out.println("Adding number of bees: ");
                                addNumOfBees(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachNumOfBees(colony);
                                System.out.println();
                                break;
                            case 9:
                                System.out.println("Adding number of brood: ");
                                addNumOfBrood(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachNumOfBrood(colony);
                                System.out.println();
                                break;
                            case 10:
                                System.out.println("Adding kg of honey: ");
                                addKgHoney(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachKgHoney(colony);
                                System.out.println();
                                break;
                            case 11:
                                System.out.println("Adding pollen: ");
                                addPollen(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachPollen(colony);
                                System.out.println();
                                break;
                            case 12:
                                System.out.println("Adding varroa treatment: ");
                                addVarroaTreatment(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachVarroaTreatment(colony);
                                System.out.println();
                                break;
                            case 13:
                                System.out.println("Adding food: ");
                                addFoodAdded(scanner, colony, history,localDateTime,dateTimeFormatter);
                                dbConnection.attachFoodAdded(colony);
                                System.out.println();
                                break;
//                            case 14:
//                                System.out.println("Please enter next visits date: ");
//                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
//                                String dateOne = "";
//                                dateOne = scanner.nextLine();
//                                Date date = simpleDateFormat.parse(dateOne);
//                                break;
                            default:
                                if (hiveMenu == 0) {
                                    System.out.println("Going back to main menu.");
                                    System.out.println();
                                } else {
                                    System.out.println("No such option!");
                                }
                        }

                    }
                    while (hiveMenu != 0);
                    break;

                case 5:

//RUN METHOD ADD NEW HIVE
                    addNewHive(scanner, hive, history, location, localDateTime, dateTimeFormatter);
                    break;
                case 6:
//RUN METHOD DELETE NEW HIVE
                    deleteHive(scanner, hive, location, colony, history, localDateTime, dateTimeFormatter);
                    break;
                case 7:
//RUN METHOD ADD NEW LOCATION
                    addNewLocation(scanner, location, history, localDateTime, dateTimeFormatter);
                    break;
                case 8:
//RUN METHOD TO PRINT OUT ALL LOCATIONS
                    printLocation1(location);
//RUN METHOD DELETE LOCATION
                    deleteLocation(scanner, location, hive, colony, history, localDateTime, dateTimeFormatter);
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

        do {
            System.out.println("Please enter hive id");
            hive.setHiveId(validatorForIntegers(scanner));

            if (hive.getHiveId() == dbConnection.checkHivesNr(hive)) {
                System.out.println("There is hive with nr. " + hive.getHiveId() + "already, please enter another one");
            }
        } while (hive.getHiveId() == dbConnection.checkHivesNr(hive));

        System.out.println("Please enter hive status");
        hive.setHiveStatus(scanner.nextLine());

        System.out.println("Please enter hive type");
        hive.setHiveType(scanner.nextLine());

        System.out.println("Please enter  hive notes");
        hive.setHiveNotes(scanner.nextLine());
// PRINT LOCATION NAME AND LOCATION ID
        printLocationNameAndLocationId(location);
        System.out.println("Please enter location Id");
        hive.setLocationId(validatorForIntegers(scanner));
        dbConnection.createHive(hive);
//   ADD INFORMATION TO HISTORY TABLE
        history.setActionDone("Added new hive: nr: " + hive.getHiveId() + ", in location: " + dbConnection.findLocationForAddedHive(location, hive));
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
        System.out.println("Added new hive: nr: " + hive.getHiveId() + " ,in location: " + dbConnection.findLocationForAddedHive(location, hive));
    }


// CREATE METHOD TO ADD NEW COLONY

    public static void addColony(Colony colony, Scanner scanner, Hive hive, History history, Location location, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {

        do {
            System.out.println("Please enter hive id: ");
            colony.setHiveId(validatorForIntegers(scanner));

            if (colony.getHiveId() == dbConnection.thereIsColonyWithThisHiveNr(colony)) {
                System.out.println("There is colony in this hive already, please choose another one");
            }
            if (colony.getHiveId() != dbConnection.isThereHiveWithThisNr(hive, colony)) {
                System.out.println("There is no hive with this nr, please choose what would you like to do: ");
                int menu3;
                do {
                    System.out.println("to create new hive enter 1");
                    System.out.println("to chose another hive enter 0");
                    menu3 = validatorForIntegers(scanner);

                    switch (menu3) {
                        default:
                            System.out.println("This menu item does not exist");
                            System.out.println("Please double check the number you have entered!");
                            break;
                        case 1:
                            addNewHive(scanner, hive, history, location, localDateTime, dateTimeFormatter);
                    }
                    if (menu3==1) {break;}

                } while (menu3 != 0);

            }
        }
        while (colony.getHiveId() == dbConnection.thereIsColonyWithThisHiveNr(colony)
                || colony.getHiveId() != dbConnection.isThereHiveWithThisNr(hive, colony));

        System.out.println("Please enter colony origin: ");
        colony.setColonyOrigin(scanner.nextLine());
        System.out.println("Please enter queen breed: ");
        colony.setQueenBreed(scanner.nextLine());
        System.out.println("Please enter queen year: ");
        colony.setQueenYear(validatorForIntegers(scanner));
        System.out.println("Please enter the number of supers: ");
        colony.setNumberOfSupers(validatorForIntegers(scanner));
        System.out.println("Please enter the number of frames: ");
        colony.setNumberOfFrames(validatorForIntegers(scanner));
        System.out.println("Please enter the number of bees: ");
        colony.setNumberOfBees(validatorForIntegers(scanner));
        System.out.println("Please enter the number of brood: ");
        colony.setNumberOfBrood(validatorForIntegers(scanner));
        System.out.println("Please enter the amount of honey: ");
        colony.setKgHoney(validatorForIntegers(scanner));
        System.out.println("Please enter the number of pollen frames: ");
        colony.setKgHoney(validatorForIntegers(scanner));
        System.out.println("Please enter the varroa treatment: ");
        colony.setVarroaTreatment(scanner.nextLine());
        System.out.println("Please enter the amount of added food");
        colony.setFoodAdded(validatorForIntegers(scanner));
        System.out.println("Please enter the date of the next visit");
        colony.setNextVisit(scanner.nextLine());
        dbConnection.createColony(colony);
        history.setActionDone("Added new colony to hive nr.: " + colony.getHiveId() + " in location: " + dbConnection.findLocationForAddedHive(location, hive));
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }


    // METHOD PRINT OUT LOCATIONS

    public static void printLocation1(Location location) {
        dbConnection.printLocation(location);
    }

    // CREATE METHOD DELETE LOCATION
    public static void deleteLocation(Scanner scanner, Location location, Hive hive, Colony colony, History
            history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Please enter location you want to delete");
        location.setLocationName(scanner.nextLine());

        //        DELETE HIVES TOGETHER WITH LOCATION WITH FOREACH LOOP
        for (int eatchvariable : dbConnection.findHivesToDelete(location)
        ) {
            hive.setHiveId(eatchvariable);
            colony.setHiveId(eatchvariable);
            dbConnection.deleteHive(hive);
            dbConnection.deleteColony(colony);
//      ADD INFORMATION ABOUT DELETED HIVES IN HISTORY TABLE IN LOOP
            history.setActionDone("Hive and colony deleted together with location " + location.getLocationName() + " is: " + eatchvariable);
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
    public static void deleteHive(Scanner scanner, Hive hive, Location location, Colony colony, History
            history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Please enter hive id you want to delete");
        hive.setHiveId(validatorForIntegers(scanner));
        colony.setHiveId(hive.getHiveId());
//        ADD INFORMATION IN HISTORY DATA BASE
        history.setActionDone("Deleted hive and colony nr:" + hive.getHiveId() + " from location " + dbConnection.findLocationForHive(location, hive));
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
//        DELETING HIVE
        dbConnection.deleteHive(hive);
        dbConnection.deleteColony(colony);
        System.out.println("Deleted hive and colony nr:" + hive.getHiveId() + " from location " + dbConnection.findLocationForHive(location, hive));
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
        colony.setHiveId(validatorForIntegers(scanner));
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
        System.out.println((float) counterForL * 100 / dbConnection.getvarroaTreatment().size() + " % of colonies treated with treatment l");
        System.out.println((float) counterForM * 100 / dbConnection.getvarroaTreatment().size() + " % of colonies treated with treatment m");
        System.out.println((float) counterForA * 100 / dbConnection.getvarroaTreatment().size() + " % of colonies treated with treatment a");
    }

    //    GET INFORMATION FROM HISTORY TABLE ABOUT SPECIFIC DATA
    public static void getInfoFromHistoryTableAboutData(History history, Scanner scanner) {
        System.out.println("Please enter data you would like see information about in format: dd-mm-yyyy");
        history.setDataAndTime(scanner.nextLine());

        dbConnection.getInformationFromHistoryTable(history);

    }

    //    GET  INFORMATION ABOUT ACTIONS DONE ON LAST VISIT
    public static void actionsInLastVisit(History history) {
        dbConnection.allActionsInLastVisit(history);
    }

    //   FIND OUT IF THERE IS HIVE WITH SUCH NUMBER ALREADY
//    COUNT POLLEN IN LOCATIONS
    public static void countPollenInLocation(Location location, Hive hive, Colony colony) {
        dbConnection.countPollenInLocations(location, hive, colony);

    }

    //    PRINT LOCATION NAME AND LOCATION ID FOR ADDING HIVE
    public static void printLocationNameAndLocationId(Location location) {
        dbConnection.printLocationNameAndLocationId(location);
    }

    //    VALIDATOR FOR VARIABLES
    public static int validatorForIntegers(Scanner scanner) {
        int userInput = 0, notInt = 0, newInput = 0;
        while (notInt == 0) {
            try {
                newInput = Integer.parseInt(scanner.nextLine());
                userInput = newInput;
                notInt = 1;
                return userInput;

            } catch (NumberFormatException e) {
                System.out.println("That is not an integer, please try again.");

            }

        }
        return 0;
    }
    /////////case 4 methods for ADD
    //ADD COLONY ORIGIN
    public static void addColonyOrigin(Scanner scanner, Colony colony, History history,LocalDateTime localDateTime,DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add colony's origin ");
        colony.setColonyOrigin(scanner.nextLine());
        dbConnection.attachColonyOrigin(colony);
        // ADD TO HISTORY
        history.setActionDone("Added colony origin " + colony.getColonyOrigin() + " in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    // ADD QUEEN BREED
    public static void addQueenBreed(Scanner scanner, Colony colony, History history,LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add queen breed ");
        colony.setQueenBreed(scanner.nextLine());
        dbConnection.attachQueenBreed(colony);
        // ADD TO HISTORY
        history.setActionDone("Added queen breed " + colony.getQueenBreed()+" in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    //ADD QUEEN YEAR
    public static void addQueenYear(Scanner scanner, Colony colony, History history,LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add queen's year ");
        colony.setQueenYear(validatorForIntegers(scanner));
        dbConnection.attachQueenYear(colony);
        // ADD TO HISTORY
        history.setActionDone("Added queen's year " + colony.getQueenYear() +" in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    //ADD NUMBER OF SUPERS
    public static void addNumOfSupers(Scanner scanner, Colony colony, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add number of supers ");
        colony.setNumberOfSupers(validatorForIntegers(scanner));
        dbConnection.attachNumOfSupers(colony);
        // ADD TO HISTORY
        history.setActionDone("Added number of supers " + colony.getNumberOfSupers()+ " in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    //ADD NUMBER OF FRAMES
    public static void addNumOfFrames(Scanner scanner, Colony colony, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add number of frames ");
        colony.setNumberOfFrames(validatorForIntegers(scanner));
        dbConnection.attachNumOfFrames(colony);
        // ADD TO HISTORY
        history.setActionDone("Added number of frames " + colony.getNumberOfFrames()+" in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    //ADD NUMBER OF BEES
    public static void addNumOfBees(Scanner scanner, Colony colony, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add number of bees ");
        colony.setNumberOfBees(validatorForIntegers(scanner));
        dbConnection.attachNumOfBees(colony);
        // ADD TO HISTORY
        history.setActionDone("Added number of bees " + colony.getNumberOfBees()+" in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    //ADD NUMBER OF BROOD
    public static void addNumOfBrood(Scanner scanner, Colony colony, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add number of brood ");
        colony.setNumberOfBrood(validatorForIntegers(scanner));
        dbConnection.attachNumOfBrood(colony);
        // ADD TO HISTORY
        history.setActionDone("Added number of brood " + colony.getNumberOfBrood()+ " in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    //ADD KG OF HONEY
    public static void addKgHoney(Scanner scanner, Colony colony, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add kg of honey ");
        colony.setKgHoney(validatorForIntegers(scanner));
        dbConnection.attachKgHoney(colony);
        // ADD TO HISTORY
        history.setActionDone("Added kg of honey " + colony.getKgHoney()+ " in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    //ADD POLLEN
    public static void addPollen(Scanner scanner, Colony colony, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add pollen ");
        colony.setPollen(validatorForIntegers(scanner));
        dbConnection.attachPollen(colony);
        // ADD TO HISTORY
        history.setActionDone("Added pollen " + colony.getPollen()+" in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    //ADD VARROA TREATMENT
    public static void addVarroaTreatment(Scanner scanner, Colony colony, History history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add varroa treatment ");
        colony.setVarroaTreatment(scanner.nextLine());
        dbConnection.attachVarroaTreatment(colony);
        // ADD TO HISTORY
        history.setActionDone("Added varroa treatment " + colony.getVarroaTreatment()+" in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }

    //ADD FOOD
    public static void addFoodAdded(Scanner scanner, Colony colony, History history,LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        System.out.println("Enter hive id ");
        colony.setHiveId(validatorForIntegers(scanner));
        System.out.println("Add food ");
        colony.setFoodAdded(validatorForIntegers(scanner));
         dbConnection.attachFoodAdded(colony);
        // ADD TO HISTORY
        history.setActionDone("Added food " + colony.getFoodAdded()+" in hive nr. " + colony.getHiveId());
        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
        dbConnection.addRecordToHistory(history);
    }



}









