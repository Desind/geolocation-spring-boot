package tree;

abstract class Conifer extends Tree {
    Integer needles;
    Integer cones;

    abstract void growNeedle();
    abstract void produceCone();
    abstract void dropCone();
}
