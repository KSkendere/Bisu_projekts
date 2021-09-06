// CREATE CLASS LOCATION
public class Hive {
    private int id;
    private int hiveId;
    private String hiveStatus;
    private String hiveType;
    private String hiveNotes;
    private int locationId;


    // CREATE NON ARGUMENT CONSTRUCTOR

    public Hive() {
    }


    // CREATE CONSTRUCTOR WITH ARGUMENTS

    public Hive(int id, int hiveId, String hiveStatus, String hiveType, String hiveNotes, int locationId) {
        this.id = id;
        this.hiveId = hiveId;
        this.hiveStatus = hiveStatus;
        this.hiveType = hiveType;
        this.hiveNotes = hiveNotes;
        this.locationId = locationId;
    }

    // CREATE TO STRING METHOD

    @Override
    public String toString() {
        return "Hive{" +
                "id=" + id +
                ", hiveId=" + hiveId +
                ", hiveStatus='" + hiveStatus + '\'' +
                ", hiveType='" + hiveType + '\'' +
                ", hiveNotes='" + hiveNotes + '\'' +
                ", locationId=" + locationId +
                '}';
    }


//        CREATE GETTERS AND SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}

