package pqvqntort.glyphs.model;

import java.util.*;

public sealed abstract class Segment permits Line, Curve, Loop {

    abstract Arrow startDirection();

    abstract Arrow endDirection();

    List<Point> points = new ArrayList<>();

    public void insertPoint(Point p, int index){
        int sz = points.size();
        index %= sz;

        if (index < 0)
            index += sz;

        if(index!=0)
            points.add(index, p);

    }

    public void insertAllPoints(Collection<? extends Point> c)
    {
        points.addAll(1, c);
    }

}

final class Line extends Segment {
    Align alignment;

    public Line() {
        points.add(new Point(this));
        points.add(new Point(this));
    }

    @Override
    public Arrow startDirection(){
        return alignment;
    }
    @Override
    public Arrow endDirection(){
        return alignment;
    }

}

final class Curve extends Segment {
    Radial start;
    Radial end;
    int loops;

    public Curve(){
        points.add(new Point());
        points.add(new Point());
    }

    @Override
    public Arrow startDirection(){
        return start;
    }
    @Override
    public Arrow endDirection(){
        return end;
    }
    public int loopCount(){
        return loops;
    }
}

final class Loop extends Segment {
    Fill fill;

    public Loop() {
        Point p = new Point();
        points.add(p);
        points.add(p);
    }

    @Override
    public Arrow startDirection(){
        return fill;
    }
    @Override
    public Arrow endDirection(){
        return fill;
    }
}
