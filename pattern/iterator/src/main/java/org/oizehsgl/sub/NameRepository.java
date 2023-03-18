package org.oizehsgl.sub;

/**
 * nameRepository
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class NameRepository implements Container {
    public String[] names = {"one", "two", "three"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    public class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
