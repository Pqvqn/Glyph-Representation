package pqvqntort.glyphs.model;

import java.util.*;

public sealed abstract class Segment permits Line, Curve, Loop {

    abstract Arrow startDirection();

    abstract Arrow endDirection();

    protected List<Point> points = new ArrayList<>();

    public Segment() {
        points = new ArrayList<>();
    }

    public int convertIndex(int index){
        int idx = index;
        int sz = points.size();
        if (idx < 0)
            idx += sz - 1;
        return idx;
    }

    public Point getPoint(int index){
        int idx = convertIndex(index);
        if (idx == 0 || idx == points.size() - 1)
            throw new IndexOutOfBoundsException("Cannot access first or last point");
        return points.get(idx);
    }

    public Point startPoint() {
        return points.get(0);
    }

    public Point endPoint() {
        return points.get(points.size()-1);
    }

    public void insertPoint(Point p, int index){
        int idx = convertIndex(index);
        if (idx == 0 || idx == points.size())
            throw new IndexOutOfBoundsException("Cannot access first or last point");

        points.add(idx, p);

        Point prev = points.get(index-1);
        Point next = points.get(index+1);
        p.updateLowerBound(prev);
        p.updateUpperBound(next);
        if(prev!=startPoint())
            prev.updateUpperBound(p);
        if(next!=endPoint())
            next.updateLowerBound(p);
    }

    public void insertAllPoints(Collection<Point> c)
    {
        Iterator<Point> it = c.iterator();
        while(it.hasNext()){
            insertPoint(it.next(), 1);
        }
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
        points.add(new Point(this));
        points.add(new Point(this));
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
        Point p = new Point(this);
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

    @Override
    public int convertIndex(int index){
        int idx = index;
        if(idx > 0)
        {
            idx--;
        }
        int sz = points.size();
        if (idx < 0)
            idx += sz;
        return idx;
    }

    @Override
    public Point getPoint(int index){
        int idx = convertIndex(index);
        return points.get(idx);
    }

    @Override
    public Point startPoint() {
        return null;
    }

    @Override
    public Point endPoint() {
        return null;
    }

    @Override
    public void insertPoint(Point p, int index){
        int idx = convertIndex(index);

        points.add(idx, p);

        Point prev = getPoint(idx-1);
        Point next = getPoint((idx+1)%points.size());
        p.updateLowerBound(prev);
        p.updateUpperBound(next);
        prev.updateUpperBound(p);
        next.updateLowerBound(p);
    }

    @Override
    public void insertAllPoints(Collection<Point> c)
    {
        Iterator<Point> it = c.iterator();
        while(it.hasNext()){
            insertPoint(it.next(), 0);
        }
    }
}
