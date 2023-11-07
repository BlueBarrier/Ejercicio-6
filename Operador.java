
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Operador{
    private ArrayList<Dispositivo> dispositivos;

    public void LeerData(){
        String csvFilePath = "UVGespaceDataBase.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String espacio;
            while ((espacio = br.readLine()) != null) {
                String[] atributos = espacio.split(",");
                switch(atributos[4]){
                    case "celular":
                        Celular celular = new Celular(atributos[0],Integer.parseInt(atributos[1]),Integer.parseInt(atributos[2]), null, 
                        espacio, espacio, 0, 0, espacio, 
                        espacio, espacio, espacio, espacio, espacio, 
                        csvFilePath, espacio);
                        break;

                    case "compu":
                        // Oficina oficina = new Oficina(atributos[0],atributos[1],atributos[2],atributos[3],atributos[4],atributos[5],atributos[6],atributos[7]);
                        // allData.add(oficina);
                        break;
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void max(){
        
    }

    public void min(){

    }

    
}
