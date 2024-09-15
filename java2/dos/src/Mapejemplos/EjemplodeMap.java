package Mapejemplos;

import java.util.HashMap;
import java.util.Map;

/**
 * EjemplodeMap
 */
public class EjemplodeMap {
    public static void main(String[] args) {
        Map<String, Integer> Mappersonas = new HashMap<>();

        Mappersonas.put("Neo", 20);
        Mappersonas.put("Akira", 22);
        
        System.out.println("> Edad de Neo: " + Mappersonas.get("Neo"));

        for (Map.Entry<String, Integer> e : Mappersonas.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

}