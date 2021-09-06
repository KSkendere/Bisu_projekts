// CREATE CLASS LOCATION
public class Location {
    private int locationId;
    private String locationName;
    private String locationAddress;
    private String locationNote;

    // CREATE NON ARGUMENT CONSTRUCTOR
    public Location() {
    }

    // CREATE CONSTRUCTOR WITH ARGUMENTS
    public Location(int locationId, String locationName, String locationAddress, String locationNote) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationAddress = locationAddress;
        this.locationName = locationName;
    }

    //CREATE TO STRING METHOD
    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", locationAddress='" + locationAddress + '\'' +
                ", locationNote='" + locationNote + '\'' +
                '}';
    }

    // CREATE SETTERS AND GETTERS
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationNote() {
        return locationNote;
    }

    public void setLocationNote(String locationNote) {
        this.locationNote = locationNote;
    }
}


