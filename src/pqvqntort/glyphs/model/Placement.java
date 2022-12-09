package pqvqntort.glyphs.model;

public class Placement {

    Place arrow;
    Symbol before;
    Symbol after;

    public Placement(Symbol before, Symbol after, Place arrow){
        this.arrow = arrow;
        this.before = before;
        this.after = after;
    }
}
