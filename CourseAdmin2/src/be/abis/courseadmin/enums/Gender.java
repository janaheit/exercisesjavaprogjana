package be.abis.courseadmin.enums;

public enum Gender {
    FEMALE("f", "she", "her", "her"),
    MALE("m", "he", "him", "his"),
    OTHER("d", "they", "them", "their");

    private String abbreviation;
    private String personalPronoun;
    private String reflexivePronoun;
    private String posessivePronoun;

    Gender(String abbreviation, String personalPronoun, String reflexivePronoun, String posessivePronoun){
        this.abbreviation = abbreviation;
        this.personalPronoun = personalPronoun;
        this.reflexivePronoun = reflexivePronoun;
        this.posessivePronoun = posessivePronoun;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public  String  getPersonalPronoun(){
        return personalPronoun;
    }
    public String getReflexivePronoun(){
        return reflexivePronoun;
    }

    public String  getPosessivePronoun(){
        return posessivePronoun;
    }
}
