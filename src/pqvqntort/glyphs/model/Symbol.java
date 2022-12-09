package pqvqntort.glyphs.model;
import java.util.*;

public class Symbol {

    Set<Segment> segments;
    Set<Intersection> intersections;
    Set<Curl> curls;

    public Symbol() {
        segments = new HashSet<>();
        intersections = new HashSet<>();
        curls = new HashSet<>();
    }

    //TODO : check that this is a valid symbol

}
