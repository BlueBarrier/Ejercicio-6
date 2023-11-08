import java.util.Iterator;
import java.util.Map;

public class Computadora extends Dispositivo {
    private String ram, size, disco, velocidadCPU, velocidadGPU;

    public Computadora(String encendido, int volumen, int brillo, Map<String, String> videos,
                       String videoActual, String descripcion, double precio, int visaCuotas,
                       String marca, String modelo, String ram, String size, String disco,
                       String velocidadCPU, String velocidadGPU) {

        super(encendido, volumen, brillo, videos, videoActual, descripcion, precio, visaCuotas, marca, modelo);
        this.ram = ram;
        this.size = size;
        this.disco = disco;
        this.velocidadCPU = velocidadCPU;
        this.velocidadGPU = velocidadGPU;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public String getVelocidadCPU() {
        return velocidadCPU;
    }

    public void setVelocidadCPU(String velocidadCPU) {
        this.velocidadCPU = velocidadCPU;
    }

    public String getVelocidadGPU() {
        return velocidadGPU;
    }

    public void setVelocidadGPU(String velocidadGPU) {
        this.velocidadGPU = velocidadGPU;
    }

    @Override
    public void subirVolumen(){
        if (getVolumen() <=98) {
            setVolumen(getVolumen()+2);
            System.out.println("Volumen: "+getVolumen()+"%");
        }
    };

    @Override
    public void bajarVolumen(){
        if (getVolumen() >= 2) {
            setVolumen(getVolumen()-2);
            System.out.println("Volumen: "+getVolumen()+"%");
        }
    };

    @Override
    public void subirBrillo(){
        if (getBrillo() <= 99) {
            setBrillo(getBrillo() + 3 );
            System.out.println("Brillo: "+getBrillo()+"%");
        }
    };
    
    @Override
    public void bajarBrillo(){
        if (getBrillo() >=3) {
            setBrillo(getBrillo() - 3 );
            System.out.println("Brillo: "+getBrillo()+"%");
        }
    };

    @Override
    public void informacionEstado(){

        if (getEncencido().equals("True")) {
            System.out.println("\nReproduciendo: "+getVideoActual()+
                               "\nVolumen: "+getVolumen()+"%"+
                               "\nBrillo: "+getBrillo()+"%"+
                               "\nPrecio: "+getPrecio()+
                               "\nVisaCuotas: "+getVisaCuotas()+
                               "\nDescripción: "+getDescripcion()+
                               "\nMarca: "+getMarca()+
                               "\tModelo: "+getModelo());
        }else{
            System.out.println("Dispositivo Apagado");
        }
    };

    @Override
    public void informacionDispositivo(){
        System.out.println("\nMarca: "+getMarca()+
                           "\tModelo: "+getModelo()+"\tPrecio: "+getPrecio()+
                           "\nOpción visa cuotas: "+getVisaCuotas()+
                           "\nRAM: "+getRam()+
                           "\nSize: "+getSize()+
                           "\nDisco: "+getDisco()+
                           "\nVelocidad CPU: "+getVelocidadCPU()+
                           "\nVelocidad GPU: "+getVelocidadGPU());
    };

    @Override
    public void controlarVideos(int opcion, Iterator<String> cambiar){
        Map<String,String> controlar = getVideos();
        switch (opcion) {
            case 1:
                // reproducir
                controlar.put(getVideoActual(),"Reproduciendo");
                break;
            case 2:
                // pausar
                controlar.put(getVideoActual(), "Pausado");
                break;
            case 3:
                // cambiar
                controlar.put(getVideoActual(), "Pausado");
                if (!cambiar.hasNext()) {
                    cambiar = controlar.keySet().iterator();
                }
                setVideoActual(cambiar.next());
                controlar.put(getVideoActual(), "Reproduciendo");
                System.out.println("Video cambiado");
                break;
            default:
                break;
        }
    }
    @Override
    public int compareTo(Dispositivo o) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    };
}
