package dominio;
import java.time.LocalDate;
public class Persona {
    private String nombre;
    private LocalDate fechaDeNacimiento;
    public Persona(String nombre, LocalDate fechaDeNacimiento){
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public String getNombre(){
        return nombre;
    }

    public long calcularEdad(){
        LocalDate hoy = LocalDate.now();
        return hoy.getYear()-fechaDeNacimiento.getYear();
    }
}
