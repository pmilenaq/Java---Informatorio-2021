package EjerciciosComplementariosLevel1;

import java.util.Scanner;

//Crear una aplicación que solicite de entrada los datos de una persona en este orden:
//Nombre y Apellido
//Edad
//Dirección
//Ciudad
//Luego imprimirá el siguiente mensaje:
//{Ciudad} - {Dirección} - {Edad} - {Nombre y Apellido}//
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Ingrese nombre y apellido: ");

            String nombreAp = sc.nextLine();

            System.out.println("Ingrese edad: ");

            String edad = sc.nextLine();

            System.out.println("Ingrese dirección: ");

            String direccion = sc.nextLine();

            System.out.println("Ingrese Ciudad: ");

            String ciudad = sc.nextLine();

            System.out.println(ciudad +" - "+ direccion +" - "+ edad +" - "+ nombreAp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}