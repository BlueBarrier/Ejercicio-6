import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("--Menú--"+
                            "\n 1. Ver Dispositivos");

            try {
                int opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        
                        break;
                
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida");
            }
        }
    }
}
