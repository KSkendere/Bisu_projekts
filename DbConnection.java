import java.sql.*;
import java.util.ArrayList;

public class DbConnection {

    private Connection conn;

    private Statement statement;

    private String sqlStatement;

    public DbConnection() {

        try {

            String dbUrl = "jdbc:sqlite:bee_project.db";
            conn = DriverManager.getConnection(dbUrl);

            if (conn != null) {
                DatabaseMetaData databaseMetaData = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Connection to" + databaseMetaData.getDatabaseProductName() + " " + databaseMetaData.getDatabaseProductVersion());


                statement = conn.createStatement();

                //          Create table colony
                statement = conn.createStatement();
                sqlStatement = "CREATE TABLE IF NOT EXISTS colonies" +
                        " (colony_id INTEGER PRIMARY KEY NOT NULL, " +
                        "hive_id INTEGER NOT NULL, " +
                        "colony_origin TEXT NOT NULL, " +
                        "queen_breed TEXT NOT NULL, " +
                        "queen_year INTEGER NOT NULL, " +
                        "supers INTEGER NOT NULL, " +
                        "frames INTEGER NOT NULL, " +
                        "bees INTEGER NOT NULL, " +
                        "brood INTEGER NOT NULL, " +
                        "honey INTEGER NOT NULL, " +
                        "pollen INTEGER NOT NULL, " +
                        "varroa_treatment TEXT NOT NULL, " +
                        "food_added TEXT NOT NULL, " +
                        "next_visit TEXT NOT NULL, " +
                        "location_name TEXT NOT NULL)";
//                sqlStatement = "ALTER TABLE hives ADD COLUMN location_name TEXT";
                statement.execute(sqlStatement);
//                CREATE TABLE LOCATIONS

                sqlStatement = "CREATE TABlE IF NOT EXISTS locations" +
                        "(location_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "location_name TEXT," +
                        "location_address TEXT," +
                        "location_notes TEXT )";
                statement.execute(sqlStatement);

//                CREATE TABLE HIVES
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS hives" +
                                "(hive_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "hive_status TEXT," +
                                "hive_type TEXT," +
                                "hive_notes TEXT )";
//                                "location_id_for_hive INTEGER FOREIGN KEY REFERENCES locations(location_id))";
//                                "FOREIGN KEY (location_id_for_hive) REFERENCES locations(location_id))";

                statement.execute(sqlStatement);


            }

        } catch (SQLException exception) {
            System.out.println("Database error" + exception);
        }
    }
//    CREATE METHOD CREATE LOCATION

    public void createLocation(Location location) {

        try {

            sqlStatement = "INSERT INTO locations (location_name,location_address, location_notes) " +
                    "VALUES (" +
                    "'" + location.getLocationName() + "'," +
                    "'" + location.getLocationAddress() + "'," +
                    "'" + location.getLocationNote() + "')";
            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error inserting into  locations table " + exception);
        }
    }

    //    CREATE METHOD CREATE HIVE
    public void createHive(Hive hive) {
        try {
            sqlStatement = "INSERT INTO hives" +
                    " (hive_status, hive_type, hive_notes)" +
                    " VALUES (" +
                    "'" + hive.getHiveStatus() + "'," +
                    "'" + hive.getHiveType() + "'," +
                    "'" + hive.getHiveNotes() + "')";
//                    "'" + hive.getLocationIdForHive()+ "')"  ;

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error inserting into hives table " + exception);
        }

    }

    //    CREATE METHOD DELETE LOCATION
    public void deleteLocation(Location location) {

        try {

            sqlStatement = "DELETE FROM locations WHERE location_name = '" + location.getLocationName() + "'";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error inserting into  locations table " + exception);
        }
    }

    //    CREATE METHOD DELETE HIVE
    public void deleteHive(Hive hive) {

        try {

            sqlStatement = "DELETE FROM hives WHERE hive_id = '" + hive.getHiveId() + "'";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error inserting into  locations table " + exception);
        }
    }
    // PRINT OUT LOCATIONS

//    public ArrayList<Location> printLocation() {
//        ArrayList<Location> locationList = new ArrayList<Location>();

    public void printLocation(Location location) {
        try {
            sqlStatement = "SELECT location_name FROM locations";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                String locationName = resultSet.getString("location_name");
                System.out.println(" Locations: " + locationName);
            }
        } catch (SQLException exception) {
            System.out.println("Error when printing locations " + exception);
        }

    }

    //    HOW MANY HIVES THERE ARE
    public void countHives(Hive hive) {
        try {

            sqlStatement = "SELECT COUNT (hive_id) FROM hives";
            ResultSet resultSet = statement.executeQuery(sqlStatement);

            int hiveCount = resultSet.getInt("COUNT (hive_id)");

            System.out.println("There are " + hiveCount + " bee hives in total.");

        } catch (SQLException exception) {
            System.out.println("Error counting hives" + exception);
        }
    }

    //    TOTAL HONEY AND POLLEN (KG)
    public void sumOfHoneyAndPollen(Colony colony) {
        try {
            sqlStatement = "SELECT SUM (honey), SUM (pollen) FROM colonies";
            ResultSet resultSet = statement.executeQuery(sqlStatement);

            int honeySum = resultSet.getInt("SUM (honey)");
            int pollenSum = resultSet.getInt("SUM (pollen)");
            System.out.println("There is " + honeySum + " kg of honey and there are " + pollenSum + " pollen frames in hives in total.");

        } catch (Exception exception) {
            System.out.println("Error in sum of honey " + exception);
        }

    }
    //THREE STRONGEST COLONIES BY HONEY

    public void strongestColoniesByHoney(Colony colony) {
        try {
            sqlStatement = "SELECT*FROM colonies ORDER BY honey DESC LIMIT 3";
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            System.out.println("The strongest 3 hives by honey are: ");
            while (resultSet.next()) {
                int hiveID = resultSet.getInt("hive_id");
                int kgHoney = resultSet.getInt("honey");

                System.out.println("Hive nr. " + hiveID + " , where is " + kgHoney + " kg of honey");

            }

        } catch (Exception exception) {
            System.out.println("Error in strongest colonies by honey " + exception);
        }
    }

    //HOW MANY COLONIES AR TREATED WITH VARROA TREATMENT,SORT BY COUNT

    public void varroaTreatmentCount(Colony colony) {

        try {
            sqlStatement = "SELECT COUNT(colony_id), varroa_treatment FROM colonies GROUP BY varroa_treatment  ORDER BY COUNT(colony_id) DESC";

            ResultSet resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                int varCount = resultSet.getInt("Count(colony_id)");
                String varroaTreatment = resultSet.getString("varroa_treatment");
                System.out.println("There are " + varCount + " hives treated with treatment " + varroaTreatment);

            }

        } catch (Exception exception) {
            System.out.println("There is error in varroa treatment count: " + exception);
        }
    }

    public void hivesInLocation(Colony colony, Location location) {
        try {
            sqlStatement = "SELECT location_name, (SELECT count(colony_id) FROM colonies WHERE locations.location_name=colonies.location_name)\n" +
                    "FROM locations;";
            ResultSet resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String locationName = resultSet.getString("location_name");
                Integer colonyId = resultSet.getInt("(SELECT count(colony_id) FROM colonies WHERE locations.location_name=colonies.location_name)");
                System.out.println("In location " + locationName + " there are " + colonyId + " bee hives.");
            }
        } catch (SQLException exception) {
            System.out.println("Error counting hives" + exception);
        }
    }

    public void honeyInLocation(Colony colony, Location location) {
        try {
            sqlStatement = "SELECT location_name, (SELECT sum(honey) FROM colonies WHERE" +
                    " locations.location_name=colonies.location_name) FROM locations;";
            ResultSet resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String locationName = resultSet.getString("location_name");
                Integer locationHoney = resultSet.getInt("(SELECT sum(honey) FROM colonies WHERE locations.location_name=colonies.location_name)");
                System.out.println("In location " + locationName + " there are " + locationHoney + " kg of honey in total.");
            }
        } catch (SQLException exception) {
            System.out.println("Error counting honey" + exception);
        }
    }

    public void pollenInLocation(Colony colony, Location location) {
        try {
            sqlStatement = "SELECT location_name, (SELECT sum(pollen) FROM colonies WHERE" +
                    " locations.location_name=colonies.location_name) FROM locations;";
            ResultSet resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String locationName = resultSet.getString("location_name");
                Integer locationPollen = resultSet.getInt("(SELECT sum(pollen) FROM colonies WHERE locations.location_name=colonies.location_name)");
                System.out.println("In location " + locationName + " there are " + locationPollen + " kg of pollen in total.");
            }
        } catch (SQLException exception) {
            System.out.println("Error counting pollen" + exception);
        }
    }
}


