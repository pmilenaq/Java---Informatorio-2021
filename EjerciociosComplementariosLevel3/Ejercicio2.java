package EjerciociosComplementariosLevel3;

import java.util.List;
import java.util.stream.Collectors;

//Dada una lista que contiene números enteros, se deberá generar otra lista que
// contendrá el resultado de aplicar la operación de potencia a 2

public class Ejercicio2 {
    public static void main(String[] args) {
        List<Integer> enteros = List.of(1, 2, 3, 4, 5);
        Integer elevado = 2;
        List<Integer> potenciaA2 = enteros.stream()
                .map(numero -> potencia(numero, elevado))
                .collect(Collectors.toList());
        System.out.println(potenciaA2);
    }

    private static Integer potencia(Integer numero, Integer potencia) {
        if (potencia == 0) {
            return 1;
        } else {
            return numero * potencia(numero,  potencia- 1);
        }
    }
}
