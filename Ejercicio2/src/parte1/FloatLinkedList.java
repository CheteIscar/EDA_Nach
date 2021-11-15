package parte1;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayte
 */
public class FloatLinkedList implements FloatList {
    private class Node{
        Node next;
        float element;

        public Node(float e){
            this.element=e;
        }

        public Node(float e, Node nxt){
            this.element=e;
            this.next=nxt;
        }

        public void setElement(float element) {
            this.element = element;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public float getElement() {
            return element;
        }
        public Node getNext() {
            return next;
        }
    }

    Node head;
    int size;

    public FloatLinkedList (){size=0;}

    @Override
    public int size() {return size; }

    @Override
    public boolean isempty() {return (size==0);}

    @Override
    public void add(Float value) {
        head = new Node(value, head);
        size++;
    }

    @Override
    public void add(int index, Float value) {
        if (index == 1) {
            add(value);
        } else {
            Node node = this.head;
            for (int i = 1; i < index; i++) {
                node = node.getNext();
            }
            node.setNext(new Node(value, node.next));
            size++;
        }
    }

    @Override
    public Float remove() {
        float elem = head.getElement();
        this.head=head.getNext();
        size--;
        return elem;
    }

    @Override
    public Float remove(int index) {
        if (index==1){
            return remove();
        }
        else{
            Node aux = this.head;
            for(int i=1; i<index-1;i++){
                aux=aux.getNext();
            }
            Float out = aux.getNext().getElement();
            aux.setNext(aux.getNext().getNext());
            size --;
            return out;
        }
    }

    @Override
    public Float get() {
        return head.getElement();
    }

    @Override
    public Float get(int index) {
        Node aux=head;
        for (int i=1;i<index;i++){
            aux=aux.getNext();
        }
        return aux.getElement();
    }

    @Override
    public int search(Float value) {
        Node aux=head;
        for(int i=1;i<=size;i++){
            if(aux.getElement()==value){
                return i;
            }
            else{
                aux=aux.getNext();
            }
        }
        return 0;
    }

    @Override
    public boolean contains(Float value) {
        return (search(value)!=0);
    }
    
}
