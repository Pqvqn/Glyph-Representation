package pqvqntort.glyphs.model;

public sealed class Arrow permits StraightArrow, CurvedArrow, CircleArrow {
}

final class StraightArrow extends Arrow {}

final class CurvedArrow extends Arrow {}

final class CircleArrow extends Arrow {}
