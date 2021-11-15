
package Tree.BinaryTree;

import java.util.Iterator;
import java.util.LinkedList;

import material.Position;

/**
 *
 * @author mayte
 */
public class LinkedBinaryTree<E> implements BinaryTree<E>{

    public class BTNode<E> implements Position<E>{

        private E elem;
        private BTNode<E> parent, left, right;


        public BTNode(E elem) {
            this.elem = elem;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public BTNode<E> getLeft() {
            return left;
        }

        public BTNode<E> getParent() {
            return parent;
        }

        public BTNode<E> getRight() {
            return right;
        }

        public E getElement() {
            return elem;
        }

        public void setElem(E elem) {
            this.elem = elem;
        }

        public void setParent(BTNode<E> parent) {
            this.parent = parent;
        }

        public void setLeft(BTNode<E> left) {
            this.left = left;
        }

        public void setRight(BTNode<E> right) {
            this.right = right;
        }
    }


    private BTNode<E> root;


    public LinkedBinaryTree(){
        root=null;
    }

    @Override
    public Position<E> left(Position<E> v) {
        BTNode<E> node = null;
        try{
            node = checkPosition(v);
        }catch(InvalidPositionException e){
            e.printStackTrace();
        }
        if (node!=null) {
            return node.getLeft();
        }
        else{
            return null;
        }
    }

    @Override
    public Position<E> right(Position<E> v) {
        BTNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        if (node != null) {
            return node.getRight();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        return (node != null) && (node.getLeft() != null);
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        //Es posible que hagas un get de un null;
        return (node != null) && (node.getRight() != null);
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        BTNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        //Es posible que hagas un get de un null;
        return ((node != null) && (node.getRight() == null) && (node.getLeft()==null));
    }

    @Override
    public boolean isRoot(Position<E> p) {
        BTNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        return (node==this.root());
    }

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public E replace(Position<E> p, E e) {
        BTNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        if(node!=null){
            node.setElem(e);
        }
        return e;
    }

    @Override
    public Position<E> sibling(Position<E> p) {
        BTNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        BTNode<E> sibling=null;
        if(node!=null&&!isRoot(p)){
            BTNode<E> parent= node.getParent();
            if(node.getParent().getLeft()==node){
                sibling=parent.getRight();
            }
            else{
                sibling=parent.getLeft();
            }
        }
        return sibling;
    }

    @Override
    public Position<E> addRoot(E e) {
        return this.root= new BTNode<>(e);
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
        BTNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        BTNode<E> newNode = new BTNode<>(e);
        if(node!=null&&node.getLeft()==null){
            newNode.setParent(node);
            node.setLeft(newNode);
        }
        return newNode;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        BTNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        BTNode<E> newNode = new BTNode<>(e);
        if(node!=null&&node.getRight()==null){
            newNode.setParent(node);
            node.setRight(newNode);
        }
        return newNode;}

    @Override
    public E remove(Position<E> p) {
        BTNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        E out = node.getElement();
        p = null;
        return out;
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        BTNode<E> node1 = null;
        BTNode<E> node2 = null;
        try {
            node1 = checkPosition(p1);
            node2 = checkPosition(p2);

        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        if(node1!=null&&node2!=null){
            E aux =node1.getElement();
            node1.setElem(node2.getElement());
            node2.setElem(aux);
        }
    }

    @Override
    public void attachLeft(Position<String> h, BinaryTree<String> t1) {
        BTNode<E> node = null;
        try {
            node = checkPosition((Position<E>) h);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        if(node!=null&&node.getLeft()==null){
            BTNode<E> newNode = (BTNode<E>) t1;
            newNode.setParent(node);
            node.setLeft(newNode);
        }
    }

    @Override
    public void attachRight(Position<String> h, BinaryTree<String> t1) {
        BTNode<E> node = null;
        try {
            node = checkPosition((Position<E>) h);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        if(node!=null&&node.getRight()==null){
            BTNode<E> newNode = (BTNode<E>) t1;
            newNode.setParent(node);
            node.setRight(newNode);
        }
    }

    @Override
    public boolean isEmpty() {
        return (root==null);
    }

    @Override
    public Position<E> parent(Position<E> v) {
        BTNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        Position<E> out =null;
        if(!isRoot(v)){
            out = node.parent;
        }
        return out;
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        BTNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        LinkedList<Position<E>> lst= new LinkedList<>();
        if(node.getLeft()!=null) {
            lst.add(node.getLeft());
        }
        if(node.getRight()!=null) {
            lst.add(node.getRight());
        }
        return lst;
    }

    private class LinkedBinaryTreeInOrderIterator<E> implements Iterator<Position<E>>{
        private BTNode<E> node;

        /**NO SE SI DESENCAPSULO FATAAAAAAL, aunque creo que no, xq es una private class dentro de la main class*/
     /**   public LinkedBinaryTreeInOrderIterator(LinkedBinaryTree<Position<E>> tree){
            node = (Positon<E>) tree.root();
            while(hasLeft(node)){

            }
        }
*/
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Position<E> next() {
            return null;
        }
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  //  @Override
 /**   void attachLeft(Position<String> h, LinkedBinaryTree<String> t1) {
        BTNode<E> node = null;
        try {
            node = checkPosition((Position<E>) h);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        if(node!=null&&node.getLeft()==null){
            BTNode<E> newNode = (BTNode<E>) t1.root;
            newNode.setParent(node);
            node.setLeft(newNode);
        }
    }*/
    
   /** @Override
    void attachRight(Position<String> h, LinkedBinaryTree<String> t1) {
        BTNode<E> node = null;
        try {
            node = checkPosition((Position<E>) h);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        if(node!=null&&node.getRight()==null){
            BTNode<E> newNode = (BTNode<E>) t1.root;
            newNode.setParent(node);
            node.setRight(newNode);
        }
    }*/

    @Override
    public LinkedBinaryTree<String> subTree(Position<E> h) {
        BTNode<E> node = null;
        try {
            node = checkPosition(h);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        this.root=node;
        return (LinkedBinaryTree<String>) this;
    }

    public BTNode<E> checkPosition(Position<E> p) throws InvalidPositionException{
        if((p==null)||!(p instanceof BTNode<E>)){
            throw new InvalidPositionException("Position_is_Invalid");
        }
        return (BTNode<E>) p;
    }
   
}
