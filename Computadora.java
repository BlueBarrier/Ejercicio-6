/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 *  clase computadora para almacenar y controlar dispositivos tipo computadora
 * 
 * @author: Erick Barrera; Sandra Pineda
 * @version: 1.0.0 
 */

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Computadora extends Dispositivo {
    private String ram, size, disco, velocidadCPU, velocidadGPU;

    /**
     * Constructor
     * 
     * @param encendido
     * @param volumen
     * @param brillo
     * @param videos
     * @param videoActual
     * @param descripcion
     * @param precio
     * @param visaCuotas
     * @param marca
     * @param modelo
     * @param ram
     * @param size
     * @param disco
     * @param velocidadCPU
     * @param velocidadGPU
     */
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

    /**
     * Función get para atríbuto RAM
     * @return
     */
    public String getRam() {
        return ram;
    }

    /**
     * @param ram
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Función get para atríbuto size
     * 
     * @return
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Función get para atríbuto disco
     * 
     * @return
     */
    public String getDisco() {
        return disco;
    }

    /**
     * @param disco
     */
    public void setDisco(String disco) {
        this.disco = disco;
    }

    /**
     * Función get para atríbuto velocidadCPU
     * 
     * @return
     */
    public String getVelocidadCPU() {
        return velocidadCPU;
    }

    /**
     * @param velocidadCPU
     */
    public void setVelocidadCPU(String velocidadCPU) {
        this.velocidadCPU = velocidadCPU;
    }

    /**
     * Función get para atríbuto GPU
     * 
     * @return
     */
    public String getVelocidadGPU() {
        return velocidadGPU;
    }

    /**
     * @param velocidadGPU
     */
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
    public void controlarVideos(Scanner scan, Iterator<String> cambiar){
        try {
            int opcion = scan.nextInt();
            Map<String,String> controlar = getVideos();
            switch (opcion) {
                case 1:
                    // reproducir
                    controlar.put(getVideoActual(),"Reproduciendo");
                    System.out.println(controlar.get(getVideoActual()));
                    break;
                case 2:
                    // pausar
                    controlar.put(getVideoActual(), "Pausado");
                    System.out.println(controlar.get(getVideoActual()));
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
        } catch (Exception e) {
            System.out.println("Ingrese una opción válida");
        }
    }
    @Override
    public int compareTo(Dispositivo o) {
        if (this.getPrecio() == o.getPrecio()) {
            return 0;
        } else{
            return this.getPrecio() > o.getPrecio() ? 1 : -1 ;
        }
    };

    /**
     * Funicón para encender o apagar 
     */
    public void encender(){
        if (getEncencido().equals("true")) {
            setEncencido("false");
            System.out.println(getEncencido());
        }else{
            setEncencido("true");
            System.out.println(getEncencido());
        }
    }
}
