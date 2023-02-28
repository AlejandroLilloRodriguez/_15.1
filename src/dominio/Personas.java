package dominio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Comparator;

public class Personas {
    public static void main(String[] args) {
        ArrayList<Persona> lista = new ArrayList<Persona>();
        Persona p1 = new Persona("Juan", LocalDate.of(1990, 1, 1));
        Persona p2 = new Persona("Pedro", LocalDate.of(1995, 1, 1));
        Persona p3 = new Persona("Maria", LocalDate.of(1998, 1, 1));
        Persona p4 = new Persona("Ana", LocalDate.of(2000, 1, 1));
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        System.out.println("La persona mas joven es: " + elMasJoven(lista).getNombre());
        System.out.println("La suma de las edades es: " + calcularSumaEdades(lista));
        System.out.println("La edad minima es: " + calcularEdadMinima(lista));
        System.out.println("La media de edad es: " + calcularMediaDeEdad(lista));

    }
    public void annadirPersona(Persona persona, ArrayList<Persona> lista){

        lista.add(persona);
    }
    public static Persona elMasJoven(ArrayList<Persona> lista){
        return Stream.iterate(0, x -> x + 1).limit(lista.size()).map(x -> lista.get(x)).min(Comparator.comparing(Persona::calcularEdad)).get();
    }
    public static long calcularSumaEdades(ArrayList<Persona>lista){
        return Stream.iterate(0,x->x+1).limit(lista.size()).map(x->lista.get(x)).mapToLong(Persona::calcularEdad).sum();
    }
    public static long calcularEdadMinima(ArrayList<Persona>lista){
        return Stream.iterate(0,x->x+1).limit(lista.size()).map(x->lista.get(x)).mapToLong(Persona::calcularEdad).min().getAsLong();
    }
    public static double calcularMediaDeEdad(ArrayList<Persona>lista){
        return Stream.iterate(0,x->x+1).limit(lista.size()).map(x->lista.get(x)).mapToLong(Persona::calcularEdad).reduce(0,(x,y)->(x+y))/lista.size();
    }


}
