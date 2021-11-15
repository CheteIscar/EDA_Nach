
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import material.Position;

/**
 *
 * @author mayte
 * @param <E>
 */
public class LCRSTree<E> implements NAryTree<E> {
    
    private class LCRSnode<T> implements Position<T>{

        private T element;
        private LCRSnode<T> parent,child,sibling;

        @Override
        public T getElement() {return element;}

        public LCRSnode(T element){
            this.element=element;
            this.child=null;
            this.parent=null;
            this.sibling=null;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setChild(LCRSnode<T> child) {
            this.child = child;
        }

        public void setParent(LCRSnode<T> parent) {
            this.parent = parent;
        }

        public void setSibling(LCRSnode<T> sibling) {
            this.sibling = sibling;
        }

        public LCRSnode<T> getChild() {
            return child;
        }

        public LCRSnode<T> getParent() {
            return parent;
        }

        public LCRSnode<T> getSibling() {
            return sibling;
        }
    }
    private LCRSnode<E> root;

    public LCRSTree(){
        root=null;
    }

    @Override
    public Position<E> addRoot(E e) {
       return root = new LCRSnode<>(e);
    }

    @Override
    public Position<E> add(E element, Position<E> p){
        LCRSnode<E> parent=null;
        try {
            parent = checkPosition(p);
        }catch(InvalidPositionException e){
            e.printStackTrace();
        }
        LCRSnode<E> newChild = new LCRSnode<>(element);
        LCRSnode<E> prevChild = parent.getChild();
        newChild.setParent(parent);
        if (prevChild==null){
            parent.setChild(newChild);
        }
        else{
            while(prevChild.getSibling()!=null){
                prevChild=prevChild.getSibling();
            }
            prevChild.setSibling(newChild);
        }
        return newChild;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        LCRSnode<E> parent = null ;
        try{
            parent = checkPosition(p);
        }catch(InvalidPositionException e){
            e.printStackTrace();
        }
        LCRSnode<E> newChild = new LCRSnode<>(element);
        LCRSnode<E> prevChild = parent.getChild();
        newChild.setParent(parent);
        if (prevChild==null||(n==0)){
            if (n==0){
                newChild.setSibling(prevChild);}
            parent.setChild(newChild);
        }
        else{
            int i=0;
            while(prevChild.getSibling()!=null&&i<n-1){
                prevChild = prevChild.getSibling();
            }
            newChild.setSibling(prevChild.getSibling());
            prevChild.setSibling(newChild);
        }
        return newChild;
    }


    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        LCRSnode<E> n2 = null;
        LCRSnode<E> n1 = null;
        try{
            n1 = checkPosition(p1);
            n2 = checkPosition(p2);
        }catch(InvalidPositionException e){
            e.printStackTrace();
        }
        E aux = n1.getElement();
        n1.setElement(n2.getElement());
        n2.setElement(aux);
    }

    @Override
    public E replace(Position<E> p, E e) {
        LCRSnode<E> node=null;
        try{
            node=checkPosition(p);
        }catch(InvalidPositionException ex){
            ex.printStackTrace();
        }
        E aux = node.getElement();
        node.setElement(e);
        return aux;
    }

    @Override
    public void remove(Position<E> p) {
        if (isRoot(p)) {
            root = null;
        }
        else{
            LCRSnode<E> node=null;
            try{
                node=checkPosition(p);
            }catch(InvalidPositionException ex){
                ex.printStackTrace();
            }
            LCRSnode<E> parent = node.getParent();
            LCRSnode<E> prevChild = parent.getChild();
            if (prevChild == node) {
                parent.setChild(node.getSibling());
            } else {
                while (prevChild.getSibling() != node) {
                    prevChild = prevChild.getSibling();
                }
                prevChild.setSibling(node.getSibling());
                node = null;
            }
        }
    }

    @Override
    /**una copia o un puntero no entiendooooooooooooooo*/
    public NAryTree<E> subTree(Position<E> v) {
        LCRSnode<E> node=null;
        try{
            node=checkPosition(v);
        }catch(InvalidPositionException ex){
            ex.printStackTrace();
        }
        LCRSTree<E> tree = new LCRSTree<>();
        LCRSnode<E> parent = node.getParent();
        LCRSnode<E> prev = parent.getChild();
        if(prev==node){
            node.setParent(null);
            node.setSibling(null);
        }
        else{
            while(prev.getSibling()!=node){
                prev.getSibling();
            }
            prev.setSibling(null);
            node.setSibling(null);
            node.setParent(null);
        }
        tree.root=node;
        return tree;
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
        LCRSnode<E> node=null;
        try{
            node=checkPosition(p);
        }catch(InvalidPositionException ex){
            ex.printStackTrace();
        }
        LCRSnode<E> treeRoot = (LCRSnode<E>) t;
        treeRoot.setParent(node);
        treeRoot.setSibling(node.getChild());
        node.setChild(treeRoot);
    }

    @Override
    public boolean isEmpty() {
        return (root==null);
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        LCRSnode<E> node=null;
        try{
            node=checkPosition(v);
        }catch(InvalidPositionException ex){
            ex.printStackTrace();
        }
        return node.getParent();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        LCRSnode<E> node=null;
        try{
            node=checkPosition(v);
        }catch(InvalidPositionException ex){
            ex.printStackTrace();
        }
        LinkedList<Position<E>> list = new LinkedList<>();
        LCRSnode<E> child = node.getChild();
        while(child!=null){
            list.add(child);
            child = child.getSibling();
        }
        return list;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);}

    @Override
    public boolean isLeaf(Position<E> v) {
        LCRSnode<E> node=null;
        try{
            node=checkPosition(v);
        }catch(InvalidPositionException ex){
            ex.printStackTrace();
        }
        return(node.getChild()==null);
    }

    @Override
    public boolean isRoot(Position<E> v) {
        LCRSnode<E> node=null;
        try{
            node=checkPosition(v);
        }catch(InvalidPositionException ex){
            ex.printStackTrace();
        }
        return (root==node);
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new PreorderIterator<E>(this);
    }

    public int size() {
        int size=0;
        for(Position<E> pos: this){
            size++;
        }
        return size;
    }


    protected LCRSnode<E> checkPosition(Position<E> p) throws InvalidPositionException{
        if((p==null)||(!(p instanceof LCRSnode<E>))){
            throw new InvalidPositionException("The position is Invalid");
        }
        return (LCRSnode<E>) p;
    }
}
