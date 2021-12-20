package EjerciociosComplementariosLevel3;
/*
Se posee una Lista con objetos de clase Alumno con los atributos: apellido, nombre y fechaDeNacimiento
(con tipos: String, String y LocalDate). Se desea generar un Map<String, Integer> donde la clave de Map
será el apellido concatenado con el nombre (con separador de espacio en blanco) y el value la edad del alumno.
La lista de entrada debe estar cargada con varios alumnos (al menos 5) para subir el ejemplo y demostrar
su funcionamiento.
En ejemplo se muestra solo con 1 Alumno a modo de abreviar
En el ejemplo también se usa LocalDate.now().minusYears(30), en el ejercicio a presentar se deberá usar
otra tecnica de construcción para la fecha (no usar .now(). Pueden ver métodos .parse(), etc)
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Alumno> alumnos = List.of(
                new Alumno("Homero", "Simpson", LocalDate.parse("1982-10-29")),
                new Alumno("Kenny", "Mckormick", LocalDate.parse("2002-01-22")),
                new Alumno("Eric", "Cartman", LocalDate.parse("2003-07-01")),
                new Alumno("Stan", "Marsh", LocalDate.parse("2004-10-19")),
                new Alumno("Sharon","Marsh", LocalDate.parse("1989-03-12")));
        Map<String, Integer> alumnosEdades = new HashMap<>();
        for (Alumno alumno : alumnos) {
            if (alumnosEdades.put(nombreYApellido(alumno), edad(alumno)) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        System.out.println(alumnosEdades);
    }
    private static String nombreYApellido(Alumno alumno) {
        return alumno.getNombre().concat(" ").concat(alumno.getApellido());
    }
    private static Integer edad(Alumno alumno) {
        return Period.between(alumno.getFechaDeNacimiento(), LocalDate.now()).getYears();
    }
    public static class Alumno {
        private String nombre;
        private String apellido;
        private LocalDate fechaDeNacimiento;

        public Alumno(String nombre, String apellido, LocalDate fechaDeNacimiento) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaDeNacimiento = fechaDeNacimiento;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getApellido() {
            return apellido;
        }
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
        public LocalDate getFechaDeNacimiento() {
            return fechaDeNacimiento;
        }
        public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
            this.fechaDeNacimiento = fechaDeNacimiento;
        }
        @Override
        public String toString() {
            return "Alumno [apellido=" + apellido + ", fechaDeNacimiento=" + fechaDeNacimiento +
                    ", nombre=" + nombre + "]";
        }
    }
}
