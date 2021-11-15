import java.util.Iterator;
import java.util.LinkedList;
import material.Position;

public class PreorderIterator<E> implements Iterator<Position<E>> {
    Tree<E> tree;
    LinkedList<Position<E>> list = new LinkedList<>();

    public PreorderIterator(Tree<E> tree){
        this.tree=tree;
        if(tree.root()!=null) {
            list.add(tree.root());
        }
    }

    @Override
    public boolean hasNext() {
        return (!list.isEmpty());
    }

    @Override
    public Position<E> next() {
        Position<E> out = list.remove(0);
        for (Position<E> child: tree.children(out)){
            list.add(child);
        }
        return out;
    }


}
