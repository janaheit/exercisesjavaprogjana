package be.abis.coffee.model;

public enum MilkType {
    NONE("no"),
    DAIRY("dairy"),
    OAT("oat"),
    SOY("soy");

    private String description;

    MilkType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
