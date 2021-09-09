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
    }

