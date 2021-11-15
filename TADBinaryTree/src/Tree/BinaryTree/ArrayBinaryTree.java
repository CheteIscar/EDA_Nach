
package Tree.BinaryTree;

import java.util.Iterator;
import material.Position;

/**
 *
 * @author mayte
 */
public class ArrayBinaryTree<E> implements BinaryTree<E> {


    public class BTPos<E> implements Position<E>{
        private int pos;
        private E value;

        public BTPos(int pos, E value) {
            this.pos = pos;
            this.value = value;
        }

        public int getPos() {
            return pos;
        }

        public E getElement() {
            return value;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

    private Position<E> tree[];


    public ArrayBinaryTree(){
    }

    @Override
    public Position<E> left(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> right(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasRight(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternal(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRoot(Position<E> p) {
        return (tree[0]==p);
    }

    @Override
    public Position<E> root() {
        return tree[0];
    }

    @Override
    public E replace(Position<E> p, E e) {
        try{
            BTPos<E> node = checkPosition(p);
            node.setValue(e);
            /*
            int pos = node.getPos();
            tree[pos]=node;
            */

        }catch(InvalidPositionException ex){
            ex.printStackTrace();
        }
        return e;
    }

    @Override
    public Position<E> sibling(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> addRoot(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> parent(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachLeft(Position<String> h, BinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachRight(Position<String> h, BinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BinaryTree<String> subTree(Position<E> h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BTPos<E> checkPosition(Position<E> p) throws InvalidPositionException{
        if((p==null)||!(p instanceof BTPos<E>)){
            throw new InvalidPositionException("Position_is_Invalid");
        }
        return (BTPos<E>) p;
    }
    
}
