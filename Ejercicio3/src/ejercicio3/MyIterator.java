package ejercicio3;

import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {
    private LinkedNode<E> node;
    private LinkedPositionList<E> list;

    public MyIterator(LinkedPositionList<E> lst) throws InvalidPositionException{
        this.list=lst;
        this.node=(LinkedNode<E>) lst.get();
    }

    @Override
    public boolean hasNext() {
        return (this.node!=null);
    }

    @Override
    public E next() {
        E out = this.node.getElement();
        this.node = this.node.getNext();
        return out;
    }
}
