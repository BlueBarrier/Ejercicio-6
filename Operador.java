
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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

    public ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
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

    public void controlador(Dispositivo buscar, Scanner scan) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.equals(buscar)) {
                System.out.println("Seleccione que desee controlar: ");
                System.out.println("\n1. bajar volumen"+
                                    "\n2. subir volumen"+
                                    "\n3. bajar brillo"+ 
                                    "\n4. subir brillo"+
                                    "\n5. información estado"+
                                    "\n6. información dispositivo"+
                                    "\n7. cambiar video");
                try {
                    int aplicar = scan.nextInt();
                    scan.nextLine();
                    if (dispositivo instanceof Celular) {
                        Celular cel = (Celular) dispositivo;
                        switch (aplicar) {
                        case 1:
                            cel.bajarVolumen();
                            break;
                        case 2:
                            cel.subirVolumen();
                            break;
                        case 3:
                            cel.bajarBrillo();
                            break;
                        case 4:
                            cel.subirBrillo();
                            break;
                        case 5:
                            cel.informacionEstado();
                            break;
                        case 6:
                            cel.informacionDispositivo();
                            break;
                        case 7:
                            // cel.controlarVideos(aplicar, scan);
                            break;
                        default:
                            break;
                    }
                    } else if (dispositivo instanceof Computadora) {
                        Computadora compu = (Computadora) dispositivo;
                        switch (aplicar) {
                        case 1:
                            compu.bajarVolumen();;
                            break;
                        case 2:
                            compu.subirVolumen();
                            break;
                        case 3:
                            compu.bajarBrillo();
                            break;
                        case 4:
                            compu.subirBrillo();                            
                            break;
                        case 5:
                            compu.informacionEstado();
                            break;
                        case 6:
                            compu.informacionDispositivo();
                            break;
                        case 7:
                            // compu.controlarVideos();
                            break;
                        default:
                            break;
                    }
                    }                        
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            
        }
    }
    
}
