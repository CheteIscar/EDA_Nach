
import java.util.Iterator;
import material.Position;
import java.util.LinkedList;

/**
 *
 * @author mayte
 * @param <E>
 */
public class LinkedTree<E> implements NAryTree<E> {

    private class TreeNode<T> implements Position<T> {

        private LinkedList<Position<E>> children;
        private T element;
        private TreeNode<T> parent;

        public TreeNode(T elem) {
            children = new LinkedList<>();
            element = elem;
            parent = null;
        }

        @Override
        public T getElement() {
            return this.element;
        }

        public TreeNode<T> getParent() {
            return this.parent;
        }

        public LinkedList<Position<E>> getChildren() {
            return this.children;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }

        public void setChild(Position<E> child, int n) {
            children.add(n, child);
        }

        public void setChild(Position<E> child){
            children.add(child);
        }

        public void removeChild(Position<E> p){
            children.remove(p);
        }


    }

    private TreeNode<E> root;


    public LinkedTree(){
        root=null;
    }

    public LinkedTree(Position<E> p){
        TreeNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        root=node;
    }

    @Override
    public Position<E> addRoot(E e) {
        if (this.isEmpty()) {
            TreeNode<E> node = new TreeNode(e);
            this.root = node;
        }
        return root;
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
        TreeNode<E> parent = null;
        try {
            parent = checkPosition(p);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        TreeNode<E> node = new TreeNode<>(element);
        node.setParent(parent);
        if (parent != null)
            parent.setChild(node);
        return node;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        TreeNode<E> parent = null;
        try {
            parent = checkPosition(p);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        TreeNode<E> node = new TreeNode<>(element);
        node.setParent(parent);
        if (parent != null)
            parent.setChild(node, n);
        return node;
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        TreeNode<E> n1 = null;
        TreeNode<E> n2 = null;
        try {
            n1 = checkPosition(p1);
            n2 = checkPosition(p2);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        if ((n1 != null) && (n2 != null)) {
            E aux = n1.getElement();
            n1.setElement(n2.getElement());
            n2.setElement(aux);
        }
    }

    @Override
    public E replace(Position<E> p, E e) {
        TreeNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException ex) {
            ex.printStackTrace();
        }
        node.setElement(e);
        return e;
    }

    @Override
    public void remove(Position<E> p) {
        TreeNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        if (node!=null) {
            TreeNode<E> parent = node.getParent();
            if (!isRoot(p)){
                parent.removeChild(node);
            }
            else{
                this.root=null;
            }
        }
        node=null;
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
        TreeNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        if(node!=null) {
            node.setParent(null);
        }
        return new LinkedTree<E>(v);
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
        TreeNode<E> node = null;
        try {
            node = checkPosition(p);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        if (node!=null){
            node.setChild(t.root(), 0);
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Position<E> root() {
        return this.root;
    }


    @Override
    public Position<E> parent(Position<E> v) {
        TreeNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        TreeNode<E> out=null;
        if (node!=null)
            out = node.getParent();
        return out;
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        TreeNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        return node.getChildren();
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        TreeNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        return (node.getChildren().isEmpty());
    }

    @Override
    public boolean isRoot(Position<E> v) {
        TreeNode<E> node = null;
        try {
            node = checkPosition(v);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        }
        return (root==node);
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new PreorderIterator<E>(this);
    }

    public int size(){
        int size=0;
        for(Position<E> pos:this){
            size++;
        }
        return size;
    }

    public TreeNode<E> checkPosition(Position<E> pos) throws InvalidPositionException {
        if(pos==null||!(pos instanceof TreeNode<E>)){
            throw new InvalidPositionException("Position_is_Invalid");
        }
        return (TreeNode<E>) pos;
    }
}
