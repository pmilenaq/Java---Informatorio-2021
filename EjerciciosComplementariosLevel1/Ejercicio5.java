package EjerciciosComplementariosLevel1;
//Se desea una aplicación que solicite 2 números enteros y realice la operación de multiplicación
// por sumas sucesivas (sin uso de librerías).//
import java.util.Scanner;
public class Ejercicio5 {
  public Ejercicio5() {}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese primer numero entero: ");
        int num1 = sc.nextInt();
        System.out.println("Ingrese segundo numero entero: ");
        int num2 = sc.nextInt();
        System.out.println("La multiplicacion de " + num1 + " x " + num2 + " = " + num1 * num2);
    }
}
