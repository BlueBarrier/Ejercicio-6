import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class csv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creación de un archivo CSV");

        // Nombre del archivo CSV
        System.out.print("Nombre del archivo CSV: ");
        String nombreArchivo = scanner.nextLine() + ".csv";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            // Cabecera del CSV
            writer.append("encendido,volumen,brillo,videos,videoActual,descripcion,precio,visaCuotas,marca,modelo,ram,procesador,almacenamiento,microUSB,cargador,cincoG,tipo");
            writer.append("\n");

            boolean continuar = true;

            while (continuar) {
                // Solicitar los datos al usuario
                System.out.print("Encendido (true/false): ");
                String encendido = scanner.nextLine();
                System.out.print("Volumen (entero): ");
                int volumen = Integer.parseInt(scanner.nextLine());
                System.out.print("Brillo (entero): ");
                int brillo = Integer.parseInt(scanner.nextLine());
                System.out.print("Descripción: ");
                String descripcion = scanner.nextLine();
                System.out.print("Precio (decimal): ");
                double precio = Double.parseDouble(scanner.nextLine());
                System.out.print("Visa Cuotas (entero): ");
                int visaCuotas = Integer.parseInt(scanner.nextLine());
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                // Otros campos específicos para Celular
                System.out.print("RAM: ");
                String ram = scanner.nextLine();
                System.out.print("Procesador: ");
                String procesador = scanner.nextLine();
                System.out.print("Almacenamiento: ");
                String almacenamiento = scanner.nextLine();
                System.out.print("MicroUSB (true/false): ");
                String microUSB = scanner.nextLine();
                System.out.print("Cargador (true/false): ");
                String cargador = scanner.nextLine();
                System.out.print("5G (true/false): ");
                String cincoG = scanner.nextLine();

                // Escribir los datos en el archivo CSV
                writer.append(encendido);
                writer.append(",");
                writer.append(String.valueOf(volumen));
                writer.append(",");
                writer.append(String.valueOf(brillo));
                writer.append(",");
                writer.append("video1,video2,video3"); // Videos separados por comas
                writer.append(",");
                writer.append("video1"); // Video actual
                writer.append(",");
                writer.append(descripcion);
                writer.append(",");
                writer.append(String.valueOf(precio));
                writer.append(",");
                writer.append(String.valueOf(visaCuotas));
                writer.append(",");
                writer.append(marca);
                writer.append(",");
                writer.append(modelo);
                writer.append(",");
                writer.append(ram);
                writer.append(",");
                writer.append(procesador);
                writer.append(",");
                writer.append(almacenamiento);
                writer.append(",");
                writer.append(microUSB);
                writer.append(",");
                writer.append(cargador);
                writer.append(",");
                writer.append(cincoG);
                writer.append(",");
                writer.append("Celular"); // Tipo de dispositivo

                writer.append("\n");

                // Preguntar si desea continuar
                System.out.print("¿Desea agregar otro dispositivo? (S/N): ");
                String respuesta = scanner.nextLine().toLowerCase();
                if (!respuesta.equals("s")) {
                    continuar = false;
                }
            }

            System.out.println("Archivo CSV creado con éxito: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al crear el archivo CSV.");
        }
    }
}
    

