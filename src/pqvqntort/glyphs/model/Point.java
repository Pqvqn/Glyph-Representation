package pqvqntort.glyphs.model;
import java.util.*;

public class Point {

    Segment segment;
    Set<Constraint> constraints;
    OrderConstraint prevBound;
    OrderConstraint nextBound;

    public Point(Segment segment) {
        this(segment, null, null);
    }

    public Point(Segment segment, Point prev, Point next) {
        this.segment = segment;
        constraints = new HashSet<>();
        updateLowerBound(prev);
        updateUpperBound(next);
    }

    public void updateLowerBound(Point prev){
        if(prev==null){
            prevBound = null;
        }else if(prevBound!=null){
            prevBound = new OrderConstraint(Constraint.Relation.GREATER, prev);
        }else{
            prevBound.point = prev;
        }
    }

    public void updateUpperBound(Point next){
        if(next==null){
            nextBound = null;
        }else if(nextBound!=null){
            nextBound = new OrderConstraint(Constraint.Relation.LESSER, next);
        }else{
            nextBound.point = next;
        }
    }

}
