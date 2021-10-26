package EjerciciosComplementariosLevel1;
//Dado un String de entrada (frase, texto, etc) calcular la cantidad de veces que aparece una letra dada//

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese frase o texto: ");
        String frase = sc.nextLine();
        System.out.print("Ingrese una letra para contar : ");
        char letra = sc.nextLine().charAt(0);
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (letra == frase.charAt(i)) {
                contador++;
            }
        }

        System.out.println("Cantidad de veces que aparece la letra dada: " + contador);

    }

}
