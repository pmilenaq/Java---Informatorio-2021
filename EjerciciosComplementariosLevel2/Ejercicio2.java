package EjerciciosComplementariosLevel2;
//Crear un ArrayList, agregar 5 números enteros. Luego, agregar un número entero al
//principio de la lista y otro al final. Por último, iterar e imprimir los elementos de la lista y el
//tamaño de la misma (antes y después de agregar a en la primera y última posición)//

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[]args) {
        ArrayList<String> numeros = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (i <= 5) {
            System.out.println("Ingrese un numero entero: ");
            String numero = sc.nextLine();
            numeros.add(numero);
            i++;
        }
        System.out.println("Ingrese numero entero para el principio en la lista: ");
        String numero = sc.nextLine();
        numeros.add(0, numero);
        System.out.println("Ingrese numero entero para el final en la lista: ");
        numero = sc.nextLine();
        numeros.add(numeros.size(), numero);
        System.out.println("Primera lista de numeros enteros: " + (numeros.size()-2));
        for (int x = 1; x < numeros.size()-1; x++) {
            System.out.println(numeros.get(x));
        }

        System.out.println("Resultado de lista completa: " + numeros.size());
        for (String x : numeros) {
            System.out.println(x);
        }
    }
}
