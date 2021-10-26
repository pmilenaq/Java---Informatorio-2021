package EjerciciosComplementariosLevel2;

import java.util.HashMap;
import java.util.HashSet;

//Se dispone de una colección de Empleados, de cada empleado se conoce:
//Nombre y Apellido
//DNI
//horasTrabajadas
//valorPorHora
//Todos los empleados están cargados en un Set (HashSet), se desea calcular el sueldo
// (horasTrabajadas x valorPorHora) de toda esa lista para luego almacenar en un Map (o Diccionario)
// donde la clave (key) es el dni y el valor (value) es el sueldo calculado. //
public class Ejercicio6 {
    public static void main(String[] args) {
        HashSet<Empleado> empl = new HashSet<>();
        HashMap<Integer, Float> salarios = new HashMap<>();

        empl.add(new Empleado("Empleado 1", 34567893, 4, 653));
        empl.add(new Empleado("Empleado 2", 35858908, 5, 765));
        empl.add(new Empleado("Empleado 3", 23175843, 6, 842));
        empl.add(new Empleado("Empleado 4", 13567345, 7, 943));

        for (Empleado i : empl) {
            salarios.put(i.getDni(), i.getSalary());
        }

        salarios.forEach((dni, salario) -> System.out.println("Dni: " + dni + " - Sueldo correspondiente: " + salario));
    }
}
class Empleado {
    String nombre;
    int dni;
    float horasTrabajadas;
    float precioPorHora;

    public Empleado(String nombre, int dni, float horasTrabajadas, float precioPorHora) {
        this.nombre = nombre;
        this.dni = dni;
        this.horasTrabajadas = horasTrabajadas;
        this.precioPorHora = precioPorHora;
    }

    public int getDni() {
        return dni;
    }

    public float getSalary() {
        return this.horasTrabajadas * this.precioPorHora;
    }
}

