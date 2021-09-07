public class History {
    private int id;
    private String actionDone;
    private String dataAndTime;
    private String units;

    public History() {
    }

    public History(int id, String actionDone, String dataAndTime, String units) {
        this.id = id;
        this.actionDone = actionDone;
        this.dataAndTime = dataAndTime;
        this.units = units;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", actionDone='" + actionDone + '\'' +
                ", dataAndTime='" + dataAndTime + '\'' +
                ", units='" + units + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActionDone() {
        return actionDone;
    }

    public void setActionDone(String actionDone) {
        this.actionDone = actionDone;
    }

    public String getDataAndTime() {
        return dataAndTime;
    }

    public void setDataAndTime(String dataAndTime) {
        this.dataAndTime = dataAndTime;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
