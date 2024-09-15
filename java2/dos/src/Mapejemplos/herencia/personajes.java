package mapejemplos.herencia;

import java.util.HashMap;
import java.util.Map;

public class personajes {
    private Map<String, String> characterMap;

    public personajes(Map<String, String> characterMap) {
        this.characterMap = new HashMap<>();
    }

    public void Agregar (String nombre, String anime){
        characterMap.put(nombre, anime);
    }
    public String Obtener (String nombre){
        return  characterMap.getOrDefault(nombre, "No se ha encontrado");
    }

    public  void Mostrar(){
        for (Map.Entry<String, String> e : characterMap.entrySet()) {
            System.out.println(e.getKey() );
            
        }
    }



}
