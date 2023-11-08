
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Operador{
    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public void LeerData(){
        String csvFilePath = "UVGespaceDataBase.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String espacio;
            while ((espacio = br.readLine()) != null) {
                String[] atributos = espacio.split(",");
                switch(atributos[0]){
                    case "celular":
                        dispositivos.add(new Celular(atributos[10],Integer.parseInt(atributos[16]),Integer.parseInt(atributos[17]), null, 
                        atributos[11], atributos[12], Integer.parseInt(atributos[18]), Integer.parseInt(atributos[15]), atributos[13], 
                        atributos[14], atributos[1], atributos[2], atributos[3],atributos[4], 
                        atributos[5], atributos[7]));
                        break;

                    case "computadora":
                        dispositivos.add(new Computadora(atributos[10],Integer.parseInt(atributos[16]),Integer.parseInt(atributos[17]), null, 
                        atributos[11], atributos[12], Integer.parseInt(atributos[18]), Integer.parseInt(atributos[15]), atributos[13], 
                        atributos[14], atributos[1], atributos[7],atributos[3], atributos[8], atributos[9]));
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object max(){
        if (dispositivos.isEmpty()) {
            return null;
        }
        Dispositivo maxDevice = dispositivos.get(0);
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.compareTo(maxDevice) > 0) {
                maxDevice = dispositivo;
            }
        }
        return maxDevice; 
    }

    public Object min(){
        if (dispositivos.isEmpty()) {
            return null;
        }
        Dispositivo minDevice = dispositivos.get(0);
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.compareTo(minDevice) < 0) {
                minDevice = dispositivo;
            }
        }
        return minDevice;

    }

    public void controlador(Dispositivo buscar) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.equals(buscar)) {
                
            }
            
        }
    }
    
}
