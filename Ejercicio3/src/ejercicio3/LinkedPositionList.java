package ejercicio3;

import java.util.Iterator;

public class LinkedPositionList<E> implements MyListBetter<E>{
    private Position<E> head;
    private int size;

    public LinkedPositionList(){
        this.head=null;
        this.size=0;
    }

    @Override
    public boolean contains(E value) {
        Position<E> aux = search(value);
        if (aux==null){ return false;}
        else{ return true;}
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isempty() {
        return (size==0);
    }

    @Override
    public Position<E> add(E elem) {
        LinkedNode<E> nextNode = (LinkedNode<E>) head;
        LinkedNode<E> newNode = new LinkedNode<E>(nextNode, null, elem);
        if (nextNode!=null) {
            nextNode.setPrev(newNode);
        }
        this.head=newNode;
        size++;
        return head;
    }

    @Override
    public Position<E> addAfter(Position<E> pos, E value) throws InvalidPositionException{
        LinkedNode<E> prevNode = checkposition(pos);
        LinkedNode<E> newNode = new LinkedNode<E>(prevNode.getNext(),prevNode, value);
        prevNode.getNext().setPrev(newNode);
        prevNode.setNext(newNode);
        size++;
        return newNode; //aqui pasa algoooooo
    }

    @Override
    public Position<E> addBefore(Position<E> pos, E value) throws InvalidPositionException {
        LinkedNode<E> nextNode = checkposition(pos);
        LinkedNode<E> newNode = new LinkedNode<E>(nextNode,nextNode.getPrev(),value);
        nextNode.getPrev().setNext(newNode);
        nextNode.setPrev(newNode);
        size++
        return newNode;
    }

    @Override
    public E remove(Position<E> pos) throws InvalidPositionException{
        LinkedNode<E> nodeRemove = checkposition(pos);
        if (nodeRemove.getPrev()==head){
            this.head = nodeRemove.getNext();
        }
        else{
            nodeRemove.getPrev().setNext(nodeRemove.getNext());
        }
        if (nodeRemove.getNext()!=null){
            nodeRemove.getNext().setPrev(nodeRemove.getPrev());
        }
        size--;
        return nodeRemove.getElement();
    }

    @Override
    public Position<E> get() {
        return head;
    }

    @Override
    public Position<E> set(Position<E> pos, E value) throws InvalidPositionException{
        LinkedNode<E> node = checkposition(pos);
        node.setElement(value);
        return node;
    }

    @Override
    public Position<E> search(E value) {
        LinkedNode<E> aux = (LinkedNode<E>)  head;
        Position <E> out = null;
        boolean encontrado =false;
        while(aux!=null&&(!encontrado)){
            if (aux.getElement()==value){
                out = (Position<E>) aux;
                encontrado=true;
            }
            aux=aux.getNext();
        }
        return out;
    }

    @Override
    public Iterator<E> iterator() throws InvalidPositionException{
        try {
            return new MyIterator<E>(this);
        }catch (InvalidPositionException e){
            e.printStackTrace();
        }
        return null
    }

    protected LinkedNode<E> checkposition(Position<E> pos) throws InvalidPositionException{
        if(pos==null || !(pos instanceof LinkedNode<E>)){
            throw new InvalidPositionException("The position is invalid");
        }
        else{
            return (LinkedNode<E>) pos;
        }
    }
}
