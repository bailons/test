package suanfa.iterator;

public class Iterator {
    private int next;
    private Object[] objects;

    private Iterator(int size) {
        objects = new Object[size];
    }

    public void add(int x) {
        if (next < objects.length) {
            objects[next++] = x;
        }
    }


    private class SelectorImpl implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i == objects.length;
        }

        @Override
        public Object current() {
            return objects[i];
        }

        @Override
        public void next() {
            if (i < objects.length) {
                i++;
            }
        }
    }

    private Selector getSelect() {
        return new SelectorImpl();
    }

    public static void main(String[] args) {
        Iterator iterator = new Iterator(10);
        for (int x = 0; x < 10; x++) {
            iterator.add(x);
        }
        Selector selector = iterator.getSelect();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }

    }

}
