package pqvqntort.glyphs.model;

public class Subsegment {

    Point start;

    Point end;

    public Subsegment(Point start, Point end) {
        this.start = start;
        this.end = end;

        if(start.segment != end.segment)
            throw new IllegalArgumentException("Points must be on the same segment");
    }

    public Segment segment() {
        return start.segment;
    }

}
