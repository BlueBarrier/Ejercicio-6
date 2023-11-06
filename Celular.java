import java.util.Map;

import java.util.Iterator;

public class Celular extends Dispositivo{
    private String ram, procesador, almacenamiento, microUSB, cargador, cincoG;

    public Celular(String encendido, int volumen, int brillo, Map<String, String> videos,
    String videoActual, String descripcion, String precio, int visaCuotas, String marca, String modelo,
    String ram, String procesador, String almacenamiento, String microUSB, String cargador, String cincoG){
        
        super(encendido, volumen, brillo, videos, videoActual, descripcion, precio, visaCuotas, marca, modelo);
        this.ram = ram;
        this.procesador = procesador;
        this.almacenamiento = almacenamiento;
        this.microUSB=microUSB;
        this.cargador = cargador;
        this.cincoG = cincoG;
    }
    // getters y setters
    public String getRam() {
        return ram;
    }
    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getMicroUSB() {
        return microUSB;
    }
    public void setMicroUSB(String microUSB) {
        this.microUSB = microUSB;
    }

    public String getCargador() {
        return cargador;
    }
    public void setCargador(String cargador) {
        this.cargador = cargador;
    }

    public String getCincoG() {
        return cincoG;
    }
    public void setCincoG(String cincoG) {
        this.cincoG = cincoG;
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
                           "\nProcesador: "+getProcesador()+
                           "\nAlmacenamiento: "+getAlmacenamiento()+
                           "\nPermite expandir por Micro USB: "+getMicroUSB()+
                           "\nIncluye cargador: "+getCargador()+
                           "\nTecnología 5G: "+getCincoG());
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
    };
}
