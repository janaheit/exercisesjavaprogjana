package be.abis.coffee.model;

public class Cup {
    private Liquid liquid;

    public Cup() {
    }

    public void fill(Liquid liquid) {
        if (this.liquid == null) this.liquid = liquid;
        else System.out.println("...This cup was still full. You made a mess.");
    }

    public void empty() {
        this.liquid = null;
    }

    public Liquid getLiquid() {
        return liquid;
    }
}
