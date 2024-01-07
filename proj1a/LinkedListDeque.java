public class LinkedListDeque<T>{

    private class IntNode{
        private T item;
        private IntNode next;
        private IntNode prev;
        private IntNode (T i, IntNode n, IntNode p){
            item=i;
            next=n;
            prev=p;
        }
    }
    private IntNode sentinel;
    private int size;
    public LinkedListDeque(){
        size=0;
        sentinel = new IntNode(null, null, null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
    }
    public void addFirst(T item){
        sentinel.next=new IntNode(item, sentinel.next, sentinel);
        if(size==0){
            sentinel.prev=sentinel.next;
        }
        if(size>0){
            sentinel.next.next.prev=sentinel.next;
        }
        size++;
    }
    public void addLast(T item){
        IntNode secondLast= sentinel.prev;
        sentinel.prev.next= new IntNode(item, sentinel, secondLast);
        sentinel.prev=sentinel.prev.next;
        size++;
    }
    public boolean isEmpty(){
        return (size==0);
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        IntNode temp=sentinel;
        while (temp.next!=sentinel){
            System.out.print(temp.next.item+ " ");
            temp=temp.next;
        }
    }
    public T removeFirst(){
        if (sentinel.next==null){
            return null;
        }
        IntNode first = sentinel.next;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        if (sentinel.prev==first){
            sentinel.prev=sentinel;
        }
        if (size>0){
            size--;
        }
        first.next=null;
        first.prev=null;
        return first.item;
    }
    public T removeLast(){
        if (sentinel.next==null){
            return null;
        }
        T tempItem = sentinel.prev.item;
        IntNode secondLast= sentinel.prev.prev;
        secondLast.next=sentinel;
        sentinel.prev = secondLast;
        if (size>0){
            size--;
        }
        return tempItem;
    }
    public T get(int index){
        IntNode temp = sentinel;
        while(index>=0){
            temp=temp.next;
            index--;
        }
        return temp.item;
    }
    public T getRecursive(int index) {
        if(index<0||index>size-1){
            return null;
        }
        return getRecursiveHelper(sentinel.next,index);
    }
    private T getRecursiveHelper(IntNode temp, int index){
        if(index == 0){
            return temp.item;
        }
        return getRecursiveHelper(temp.next, index-1);
    }

}