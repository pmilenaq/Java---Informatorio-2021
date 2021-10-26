package EjerciciosComplementariosLevel2;
//Crear un ArrayList y cargarlo con tus ciudades favoritas de Argentina, luego imprimir por pantalla el ranking//

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<String> ciudades = new ArrayList();
        Scanner sc = new Scanner(System.in);

        int numeroCiudades = 0;

        System.out.println("Ingrese nombre de Ciudaded favorita de Argentina: ");
        String ciudad = sc.nextLine();

        while (!ciudad.equals("salir")) {

            ciudades.add(ciudad);

            System.out.println("Ingrese otro nombre de Ciudad favorita de Argentina: ");

            System.out.println("Para terminar escriba  \"salir\"");

            ciudad = sc.nextLine();
        }
        int i;
        i = 0;
        for (i = 0; i< ciudades.size(); i++) {
            System.out.println("#" + (i+1) + "-" + ciudades.get(i));
        }

    }
}
