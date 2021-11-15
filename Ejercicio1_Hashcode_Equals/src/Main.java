import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Map<Alumno,Double> map = new HashMap<>();
        Alumno sergio = new Alumno("Sergio", 2312312);
        map.put(sergio, 8.2);
        map.put(new Alumno("Alvaro", 23124312), 2.3);
        map.put(new Alumno("Rodri", 12849312), 5.7);
        map.put(new Alumno("Javi", 210231242), 9.5);
        map.put(new Alumno("Pax", 2312314), 1.3);
        System.out.println("la nota de sergio es "+map.get(sergio));
    }
}
