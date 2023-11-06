import java.util.Iterator;

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

    public void subirVolumen();
    public void bajarVolumen();

    public void subirBrillo();
    public void bajarBrillo();

    public void informacionEstado();
    public void informacionDispositivo();

    public void controlarVideos(int opcion, Iterator<String> cambiar);

}
