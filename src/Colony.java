    public class Colony {
    private Integer id;
        private Integer hiveId;
        private String colonyOrigin;
        private String queenBreed;
        private String queenYear;
        private Integer numberOfSupers;
        private Integer numberOfFrames;
        private Integer numberOfBees;
        private Integer numberOfBrood;
        private Integer kgHoney;
        private Integer pollen;
        private String varroaTreatment;
        private Integer foodAdded;
        private Integer nextVisit;

        public Colony() {
        }
//    ARGUMENT CONSTRUCTOR

        public Colony(Integer id, Integer hiveId, String colonyOrigin, String queenBreed, String queenYear, Integer numberOfSupers, Integer numberOfFrames, Integer numberOfBees, Integer numberOfBrood, Integer kgHoney, Integer pollen, String varroaTreatment, Integer foodAdded, Integer nextVisit) {
            this.id = id;
            this.hiveId = hiveId;
            this.colonyOrigin = colonyOrigin;
            this.queenBreed = queenBreed;
            this.queenYear = queenYear;
            this.numberOfSupers = numberOfSupers;
            this.numberOfFrames = numberOfFrames;
            this.numberOfBees = numberOfBees;
            this.numberOfBrood = numberOfBrood;
            this.kgHoney = kgHoney;
            this.pollen = pollen;
            this.varroaTreatment = varroaTreatment;
            this.foodAdded = foodAdded;
            this.nextVisit = nextVisit;
        }

//    TO STRING METHOD

        @Override
        public String toString() {
            return "Colony{" +
                    "id=" + id +
                    ", hiveId=" + hiveId +
                    ", colonyOrigin='" + colonyOrigin + '\'' +
                    ", queenBreed='" + queenBreed + '\'' +
                    ", queenYear='" + queenYear + '\'' +
                    ", numberOfSupers=" + numberOfSupers +
                    ", numberOfFrames=" + numberOfFrames +
                    ", numberOfBees=" + numberOfBees +
                    ", numberOfBrood=" + numberOfBrood +
                    ", kgHoney=" + kgHoney +
                    ", pollen=" + pollen +
                    ", varroaTreatment='" + varroaTreatment + '\'' +
                    ", foodAdded=" + foodAdded +
                    ", nextVisit=" + nextVisit +
                    '}';
        }

//    GETTERS & SETTERS


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getHiveId() {
            return hiveId;
        }

        public void setHiveId(Integer hiveId) {
            this.hiveId = hiveId;
        }

        public String getColonyOrigin() {
            return colonyOrigin;
        }

        public void setColonyOrigin(String colonyOrigin) {
            this.colonyOrigin = colonyOrigin;
        }

        public String getQueenBreed() {
            return queenBreed;
        }

        public void setQueenBreed(String queenBreed) {
            this.queenBreed = queenBreed;
        }

        public String getQueenYear() {
            return queenYear;
        }

        public void setQueenYear(String queenYear) {
            this.queenYear = queenYear;
        }

        public Integer getNumberOfSupers() {
            return numberOfSupers;
        }

        public void setNumberOfSupers(Integer numberOfSupers) {
            this.numberOfSupers = numberOfSupers;
        }

        public Integer getNumberOfFrames() {
            return numberOfFrames;
        }

        public void setNumberOfFrames(Integer numberOfFrames) {
            this.numberOfFrames = numberOfFrames;
        }

        public Integer getNumberOfBees() {
            return numberOfBees;
        }

        public void setNumberOfBees(Integer numberOfBees) {
            this.numberOfBees = numberOfBees;
        }

        public Integer getNumberOfBrood() {
            return numberOfBrood;
        }

        public void setNumberOfBrood(Integer numberOfBrood) {
            this.numberOfBrood = numberOfBrood;
        }

        public Integer getKgHoney() {
            return kgHoney;
        }

        public void setKgHoney(Integer kgHoney) {
            this.kgHoney = kgHoney;
        }

        public Integer getPollen() {
            return pollen;
        }

        public void setPollen(Integer pollen) {
            this.pollen = pollen;
        }

        public String getVarroaTreatment() {
            return varroaTreatment;
        }

        public void setVarroaTreatment(String varroaTreatment) {
            this.varroaTreatment = varroaTreatment;
        }

        public Integer getFoodAdded() {
            return foodAdded;
        }

        public void setFoodAdded(Integer foodAdded) {
            this.foodAdded = foodAdded;
        }

        public Integer getNextVisit() {
            return nextVisit;
        }

        public void setNextVisit(Integer nextVisit) {
            this.nextVisit = nextVisit;
        }
    }
