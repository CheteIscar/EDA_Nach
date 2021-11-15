package ejercicio3;

public class LinkedNode<E> implements Position<E>{
    private LinkedNode<E> next, prev;
    private E element;

    public LinkedNode(LinkedNode<E> next, LinkedNode<E> prev, E elem){
        this.element=elem;
        this.next=next;
        this.prev=prev;
    }

    public void setElement(E element) {this.element = element;}

    public void setNext(LinkedNode<E> next) {this.next = next;}

    public void setPrev(LinkedNode<E> prev) {this.prev = prev;}

    @Override
    public E getElement() {return element;}

    public LinkedNode<E> getNext() {return next;}

    public LinkedNode<E> getPrev() {return prev;}

}
