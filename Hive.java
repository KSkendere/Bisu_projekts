// CREATE CLASS LOCATION
public class Hive {
    private int hiveId;
    private String hiveStatus;
    private String hiveType;
    private String hiveNotes;
    private int locationIdForHive;
    // CREATE NON ARGUMENT CONSTRUCTOR

    public Hive() {
    }

    // CREATE CONSTRUCTOR WITH ARGUMENTS
    public Hive(int hiveId, String hiveStatus, String hiveType, String hiveNotes, int locationIdForHive) {
        this.hiveId = hiveId;
        this.hiveStatus = hiveStatus;
        this.hiveType = hiveType;
        this.hiveNotes = hiveNotes;
        this.locationIdForHive = locationIdForHive;
    }
        // CREATE TO STRING METHOD

        @Override
        public String toString () {
            return "Hive{" +
                    "hiveId=" + hiveId +
                    ", hiveStatus='" + hiveStatus + '\'' +
                    ", hiveType='" + hiveType + '\'' +
                    ", hiveNotes='" + hiveNotes + '\'' +
                    ", locationIdForHive=" + locationIdForHive +
                    '}';
        }
//        CREATE GETTERS AND SETTERS


    public int getHiveId() {
        return hiveId;
    }

    public void setHiveId(int hiveId) {
        this.hiveId = hiveId;
    }

    public String getHiveStatus() {
        return hiveStatus;
    }

    public void setHiveStatus(String hiveStatus) {
        this.hiveStatus = hiveStatus;
    }

    public String getHiveType() {
        return hiveType;
    }

    public void setHiveType(String hiveType) {
        this.hiveType = hiveType;
    }

    public String getHiveNotes() {
        return hiveNotes;
    }

    public void setHiveNotes(String hiveNotes) {
        this.hiveNotes = hiveNotes;
    }

    public int getLocationIdForHive() {
        return locationIdForHive;
    }

    public void setLocationIdForHive(int locationIdForHive) {
        this.locationIdForHive = locationIdForHive;
    }
}

