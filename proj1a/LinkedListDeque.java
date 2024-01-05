public class LinkedListDeque<T>{

    public class IntNode{
        public T item;
        public IntNode next;
        public IntNode prev;
        public IntNode (T i, IntNode n, IntNode p){
            item=i;
            next=n;
            prev=p;
        }
    }
    public IntNode sentinel;
    public int size;
    public LinkedListDeque(){
        size=0;
        sentinel = new IntNode(null, null, null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
    }
    public void addFirst(T item){
        sentinel.next=new IntNode(item, sentinel.next, sentinel);
        if(size>0){
            sentinel.next.next.prev=sentinel.next;
        }
        size++;
    }
    public void addLast(T item){
        IntNode temp=sentinel;
        while (temp.next!=sentinel){
            temp=temp.next;
        }
        temp.next=new IntNode(item, sentinel, temp);
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
        IntNode temp = sentinel.next;
        sentinel.next=sentinel.next.next;
        temp.next=null;
        temp.prev=null;
        size--;
        return temp.item;
    }
    public T removeLast(){
        if (sentinel.next==null){
            return null;
        }
        IntNode temp=sentinel;
        while (temp.next!=sentinel){
            temp=temp.next;
        }
        temp.prev.next=sentinel;
        size--;
        return temp.item;
    }
    public T get(int index){
        IntNode temp = sentinel;
        while(index>=0){
            temp=temp.next;
            index--;
        }
        return temp.item;
    }
}