package pqvqntort.glyphs.model;

import java.util.*;

public class Intersection {
    Set<Point> points;
    Set<ParallelGroup> groups;
    Set<List<Point>> stackedOrder;

    public Intersection(){
        points = new HashSet<>();
        groups = new HashSet<>();
        stackedOrder = new HashSet<>();
    }

    public class ParallelGroup {
        Set<Set<Point>> points;

        public ParallelGroup() {
            points = new HashSet<>();
        }

        //TODO : direction constraints
        //TODO : bigger set is maximum size 2
    }

    //TODO : figure out stackedOrder checking
}
