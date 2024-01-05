public class ArrayDeque<Item>{

    public Item[] items;
    public int size;
    public int nextFirst;
    public int nextLast;
    public int first;
    public ArrayDeque(){
        size=0;
        items= (Item[]) new Object[8];
        nextFirst = (items.length - size) / 2;
        nextLast = nextFirst + 1;
        first = nextFirst;
    }
    private void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        int tempLength = items.length - first;
        System.arraycopy(items, first, a, a.length / 2 - 1, tempLength);
        if (tempLength != items.length) {
            System.arraycopy(items, 0, a, a.length / 2 - 1 + tempLength, first);
        }
        items = a;
        nextFirst = (items.length / 2 - 1 - 1 + items.length) % items.length;
        first = (nextFirst + 1) % items.length;
        nextLast = (nextFirst + size + 1) % items.length;
    }
    private void resizeDown(int capacity) {
        if (capacity < 8) {
            return;
        }
        Item[] a = (Item[]) new Object[capacity];
        int tempLength = items.length - first;
        if (tempLength < size) {
            System.arraycopy(items, first, a, a.length / 2 - 1, tempLength);
            int left = size - tempLength;
            System.arraycopy(items, nextLast - 1, a, a.length / 2 - 1 + tempLength, left);
        } else {
            System.arraycopy(items, first, a, a.length / 2 - 1, size);
        }
        items = a;
        nextFirst = (items.length / 2 - 1 - 1 + items.length) % items.length;
        first = (nextFirst + 1) % items.length;
        nextLast = (nextFirst + size + 1) % items.length;
    }
    public void addFirst(Item item){
        if(size==items.length){
            resize(2*items.length);
        }
        size++;
        first=nextFirst;
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
    }
    public void addLast(Item item){
        if(size==items.length){
            resize(2*items.length);
        }
        size++;
        items[nextLast]=item;
        if(items[first]==null){
            first=nextLast;
        }
        nextLast=(nextLast+1)%items.length;
    }
    public boolean isEmpty(){
        return (size==0);
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
    public Item removeFirst(){
        if (size == 0) {
            return null;
        }
        Item x = items[first];
        items[first] = null;
        first = (first + 1) % items.length;
        nextFirst = (nextFirst + 1) % items.length;
        size--;
        if ((double) size / items.length < 0.25) {
            resizeDown(items.length / 2);
        }
        return x;
    }
    public Item removeLast(){
        if (size == 0) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        Item x = items[nextLast];
        items[nextLast] = null;
        size --;
        if ((double) size / items.length < 0.25) {
            resizeDown(items.length / 2);
        }
        return x;
    }
    public Item get(int index){
        if (index < 0 || index > size - 1) {
            return null;
        }
        index += first;
        return items[index % items.length];
    }
}