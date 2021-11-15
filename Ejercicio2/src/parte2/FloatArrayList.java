package parte2;

import java.util.Objects;



/**
 *
 * @author mayte
 */
public class FloatArrayList implements FloatList{
    
    private final Float[] vector;
    private int pos;
    private final int MAX;
    
    public FloatArrayList(int tam){
        MAX = tam;
        vector = new Float[MAX];
        pos = 0;
    }
    
    @Override
    public int size() {
        return pos;
    }

    @Override
    public boolean isempty() {
        return (pos == 0);
    }

    @Override
    public void add(Float value) {
        vector[pos] = value;
        pos++;
    }

    private void limits(int index){
        if ((index < 1) || (index > pos +1 ))
            throw new RuntimeException("The index is out of limits.");
    }
    
    @Override
    public void add(int index, Float value) {
        limits(index);
        int mov = pos;
        for(int i = 1; i < index; i++){
            vector[mov] = vector[mov-1];
            mov--;
        }
        vector[mov] = value;
        pos++;
    }

    @Override
    public Float remove() {
        if (isempty())
            throw new RuntimeException("It is not allowed remove elements froma empty list.");
        pos--;
        Float value = vector[pos];        
        return value;
    }

    @Override
    public Float remove(int index) {
        if ((isempty())||(index > pos))
            throw new RuntimeException("This operation can not do it.");
        Float value = vector[pos-index];
        for (int i = pos-index; i < (pos-1); i++){
            vector[i] = vector[i+1];
        }
        pos--;
        return value;
    }

    @Override
    public Float get() {
        if (isempty())
            throw new RuntimeException("There is not element in the list.");
        return vector[pos-1];
    }

    @Override
    public Float get(int index) {
        if ((isempty())||(index > pos))
            throw new RuntimeException("There is not element in the list.");
        return vector[pos-index];
    }

    @Override
    public int search(Float value) {
        if (isempty())
            return 0;
        int cont = 1;
        int i = pos-1;
        while ((i > 0) && (!value.equals(vector[i]))){
            i--;
            cont++;
        }
        if (!value.equals(vector[i]))
            return 0;
        else
            return cont;
    }

    @Override
    public boolean contains(Float value) {
        return (search(value) != 0);
    }
    
}
