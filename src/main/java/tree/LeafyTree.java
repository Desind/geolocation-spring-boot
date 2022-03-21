package tree;

abstract class LeafyTree extends Tree{
    boolean isHibernating;
    Integer leafs;
    Integer flowers;
    Integer fruits;

    abstract void hibernate();
    abstract void unHibernate();
    abstract void growLeaf();
    abstract void produceFlower();
    abstract void dropFlower();
    abstract void pollinateFlower();
    abstract void dropFruit();
}
