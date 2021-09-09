import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Methods {
    private static DbConnection dbConnection;


//    //    PRINT LOCATION NAME AND LOCATION ID FOR ADDING HIVE
//    public static void printLocationNameAndLocationId(Location location) {
//        dbConnection.printLocationNameAndLocationId(location);
//    }
//    // CREATE METHOD DELETE HIVE
//    public static void deleteHive(Scanner scanner, Hive hive, Location location, Colony colony, History
//            history, LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
//        System.out.println("Please enter hive id you want to delete");
//        hive.setHiveId(scanner.nextInt());
//        scanner.nextLine();
//        colony.setHiveId(hive.getHiveId());
////        ADD INFORMATION IN HISTORY DATA BASE
////        history.setActionDone("Deleted hive and colony nr:" + hive.getHiveId() + " from location " + dbConnection.findLocationForHive(location, hive));
////        history.setDataAndTime(localDateTime.format(dateTimeFormatter));
////        dbConnection.addRecordToHistory(history);
////        DELETING HIVE
//        dbConnection.deleteHive(hive);
//        dbConnection.deleteColony(colony);

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
    //    GET  INFORMATION ABOUT ACTIONS DONE ON LAST VISIT
    public static void actionsInLastVisit(History history, DbConnection dbConnection) {
        dbConnection.allActionsInLastVisit(history);
    }
    //    GET INFORMATION FROM HISTORY TABLE ABOUT SPECIFIC DATA
    public static void getInfoFromHistoryTableAboutData(History history, Scanner scanner, DbConnection dbConnection) {
        System.out.println("Please enter data you would like see information about in format: dd-mm-yyyy");
        history.setDataAndTime(scanner.nextLine());
        dbConnection.getInformationFromHistoryTable(history);
    }
    public static void getPercentsOfVarroaTreatement(Colony colony, DbConnection dbConnection) {
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
    // PRINT OUT INFORMATION ABOUT COLONIES
    public static void printInfoAboutColony(Scanner scanner, Colony colony, Methods methods, DbConnection dbConnection) {
        System.out.println("Select hive id whose colony you want information about");
        colony.setHiveId(methods.validatorForIntegers(scanner));
        dbConnection.coloniesInfo(colony);
    }
    // METHOD PRINT OUT LOCATIONS
    public static void printLocation1(Location location, DbConnection dbConnection) {
        dbConnection.printLocation(location);
    }

}
