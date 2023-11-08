import java.util.Iterator;
import java.util.Scanner;

/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * Interfaz para métodos abstractos de dispositivos 
 * 
 * @author: Erick Barrera; Sandra Pineda
 * @version: 1.0.0 
 */
public interface Interfaz {

    /**
     * Funciones para bajar y subir volumen
     */
    public void subirVolumen();
    public void bajarVolumen();

    /**
     * Funciones para bajar y subir el brillo
     */
    public void subirBrillo();
    public void bajarBrillo();

    /**
     * Funciones para obtener información del estado del dispositivo y sus componentes
     */
    public void informacionEstado();
    public void informacionDispositivo();

    /**
     * Función para controlar un dispositivo
     * 
     * @param scan
     * @param cambiar
     */
    public void controlarVideos(Scanner scan, Iterator<String> cambiar);

}
