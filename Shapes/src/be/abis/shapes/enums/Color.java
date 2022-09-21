package be.abis.shapes.enums;

public enum Color {
    RED("red"),
    BLUE("blue"),
    ORANGE("orange"),
    GREEN("green"),
    YELLOW("yellow"),
    BROWN("brown"),
    BLACK("black"),
    PURPLE("purple");

    private String description;

    Color(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

