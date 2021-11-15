import java.util.Objects;


public class Alumno {
    private String nombre;
    private double dni;


    public Alumno(String name, double dni){
        nombre=name;
        this.dni=dni;
    }

    @Override
    public boolean equals(Object o){
        if (this==o){
            return true;
        }
        if ((o==null) || getClass()!=o.getClass()){
            return false;
        }
        Alumno aux = (Alumno) o;
        return Objects.equals(dni,aux.dni);
    }

    @Override
    public int hashCode(){return Objects.hash(dni);}
}
