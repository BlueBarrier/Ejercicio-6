/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Programación Orientada a Objetos
 * 
 * @author: Erick Barrera, Sandra Pineda
 * @version: 1.0.5
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Operador opps = new Operador();
        opps.LeerData();
        ArrayList<Dispositivo> dispositivos = opps.getDispositivos();
        boolean salir = false;
        while (!salir) {
            System.out.println("--Menú--"+
                            "\n 1. Ver Dispositivos"+
                            "\n 2. Controlar Dispositivo"+
                            "\n 3. Dispositivos más barato"+
                            "\n 4. Dispositivos más caro"+
                            "\n 5. Salir");
            try {
                int opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        for (int i = 0; i < dispositivos.size(); i++) {
                            int indice = i +1;
                            System.out.println(indice+". "+dispositivos.get(i).getModelo());
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese el número del dispositivo a controlar: ");
                        for (int i = 0; i < dispositivos.size(); i++) {
                            int indice = i +1;
                            System.out.println(indice+". "+dispositivos.get(i).getModelo());
                        }
                        try {
                            int dispo = scan.nextInt();
                            scan.nextLine();
                            if (dispo>=0 || dispo> 14) {
                                if (dispositivos.get(dispo-1) instanceof Celular) {
                                    opps.controlador(dispositivos.get(dispo-1), scan);
                                }else if (dispositivos.get(dispo-1) instanceof Computadora) {
                                    opps.controlador(dispositivos.get(dispo-1),scan);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        Dispositivo dispoMin = opps.min();
                        System.out.println("Dispositivo más barato: "+dispoMin.getModelo());
                        System.out.println("Precio: "+dispoMin.getPrecio());
                        break;
                    case 4:
                        Dispositivo dispoMax = opps.max();
                        System.out.println("Dispositivo más caro: "+dispoMax.getModelo());
                        System.out.println("Precio: "+dispoMax.getPrecio());
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida");
            }
        }
        scan.close();
    }
}
