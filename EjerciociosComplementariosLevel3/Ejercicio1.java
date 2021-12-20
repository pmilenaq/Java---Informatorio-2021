package EjerciociosComplementariosLevel3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//Dada una lista que contiene valores de tipo String,
//se deberá filtrar todos los valores que NO sean null o vacío ("").

public class Ejercicio1 {

        public static void main(String[] args) {
            List<String> palabras = new ArrayList<>();
            palabras.add(null);
            palabras.add("Hola");
            palabras.add("");
            palabras.add("Informatorio");
            palabras.add(null);
            palabras.add("");
            List<String> filtroValores = palabras.stream()
                    .filter(palabra -> Objects.nonNull(palabra) && !("").equals(palabra))
                    .collect(Collectors.toList());
            System.out.println(filtroValores);
        }
}

