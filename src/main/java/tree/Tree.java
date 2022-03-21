package tree;

abstract class Tree {
    Double height;
    Integer treeRings;
    Integer branches;

    abstract void growHeight(Integer height);
    abstract void age();
    abstract void growBranch();
    abstract void die();
}
