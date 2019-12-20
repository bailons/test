package suanfa.iterator;


public interface Selector {
    boolean end();
    Object current();
    void next();
}
