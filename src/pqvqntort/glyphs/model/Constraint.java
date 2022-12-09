package pqvqntort.glyphs.model;

public abstract sealed class Constraint permits
    DirectionConstraint,
    IntersectionConstraint,
    LoopConstraint,
    OrderConstraint {

    enum Relation {
        GREATER,
        LESSER,
        EQUAL,
        UNEQUAL
    }

    Relation relation;

    public Constraint(Relation relation) {
        this.relation = relation;
    }

}

final class DirectionConstraint extends Constraint {

    Radial direction;

    public DirectionConstraint(Relation relation, Radial direction){
        super(relation);
        this.direction = direction;
    }
}

final class IntersectionConstraint extends Constraint {

    enum ContactType{
        TANGENT_WITH,
        TANGENT_AGAINST,
        NORMAL_IN,
        NORMAL_OUT
    }

    ContactType type;

    public IntersectionConstraint(Relation relation, ContactType type){
        super(relation);
        this.type = type;
    }
}

final class LoopConstraint extends Constraint {

    int loopNumber;

    public LoopConstraint(Relation relation, int loopNumber) {
        super(relation);
        this.loopNumber = loopNumber;
    }
}

final class OrderConstraint extends Constraint {

    Point point;

    public OrderConstraint(Relation relation, Point point){
        super(relation);
        this.point = point;
    }

}


