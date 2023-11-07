/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 *  clase abstracta con interfaz para heredar a dispositivos tipo celular y computadora
 * 
 * @author: Erick Barrera; Sandra Pineda
 * @version: 1.0.0 
 */
import java.util.Map;

public abstract class Dispositivo implements Interfaz, Comparable<Dispositivo>{

    protected String encencido, videoActual, descripcion, marca, modelo;
    protected int visaCuotas, volumen, brillo;
    protected double precio;
    protected Map<String, String> videos;
    
    /**
     * Clase abstracta para crear objetos con características de Dispositivo
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
     */
    public Dispositivo(String encendido, int volumen, int brillo, Map<String, String> videos,
    String videoActual, String descripcion, double precio, int visaCuotas, String marca, String modelo){

        this.encencido = encendido;
        this.volumen = volumen;
        this.brillo = brillo;
        this.videos = videos;
        this.videoActual = videoActual;
        this.descripcion = descripcion;
        this.precio = precio;
        this.visaCuotas = visaCuotas;
        this.marca = marca;
        this.modelo = modelo;
    }

    // getters y setters
    public String getEncencido() {
        return encencido;
    }
    public void setEncencido(String encencido) {
        this.encencido = encencido;
    }

    public int getVolumen() {
        return volumen;
    }
    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }
    
    public int getBrillo() {
        return brillo;
    }
    public void setBrillo(int brillo) {
        this.brillo = brillo;
    }

    public Map<String, String> getVideos() {
        return videos;
    }
    public void setVideos(Map<String, String> videos) {
        this.videos = videos;
    }

    public String getVideoActual() {
        return videoActual;
    }
    public void setVideoActual(String videoActual) {
        this.videoActual = videoActual;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio( double precio) {
        this.precio = precio;
    }

    public int getVisaCuotas() {
        return visaCuotas;
    }
    public void setVisaCuotas(int visaCuotas) {
        this.visaCuotas = visaCuotas;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int compareTo(Dispositivo dispositivo){
        if (this.getPrecio() == dispositivo.getPrecio()) {
            return 0;
        } else{
            return this.getPrecio() > dispositivo.getPrecio() ? 1 : -1 ;
        }
    }
}