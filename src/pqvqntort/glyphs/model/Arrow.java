package pqvqntort.glyphs.model;

public sealed interface Arrow permits Align, Radial, Fill, Place {}

enum Align implements Arrow {
    VERTICAL,
    HORIZONTAL,
    ASCEND,
    DESCEND;
}
enum Radial implements Arrow {
    UP, UP_RIGHT,
    RIGHT, DOWN_RIGHT,
    DOWN, DOWN_LEFT,
    LEFT, UP_LEFT;

    /*Radial opposite() {
        return Radial.values()[(this.ordinal() + 4) % 8];
    }*/
}
enum Fill implements Arrow {
    DOT, RING;
}

enum Place implements Arrow {
    RIGHT,
    DOWN,
    DOWN_RIGHT,
    DOWN_LEFT,
    INSIDE,
    COVER
}