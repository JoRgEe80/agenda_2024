package interfaz;

import dominio.Libreta;
import dominio.Contacto;
import java.io.*;

public class Interfaz implements Serializable {
    public static void ejecutar(String [] args) {
        Libreta libreta= new Libreta();
        if (args[0].equalsIgnoreCase("add")) {
            if (args.length == 5) {
                String nombre = args[1];
                String apellidos= args[2];
                String telefono= args[3];
                String email= args[4];

                libreta.annadirContacto(new Contacto(nombre, apellidos, telefono, email));
                System.out.println("Contacto añadido: " + nombre + ", " + apellidos
                +", "+telefono+", "+email);
            } else {
                System.out.println("Formato incorrecto. Formato: add <nombre> <apellidos> <telefono> <email>");
            }
        } else if (args[0].equalsIgnoreCase("list")) {
            System.out.println("Contactos en la libreta:");
            System.out.println(libreta);
        } else if (args[0].equalsIgnoreCase("help")) {
            System.out.println("Las operaciones posibles son las siguientes:");
            System.out.println("- Añadir contacto: 'java -jar libreta.jar add <nombre> <apellidos> <telefono> <email>'");
            System.out.println("- Modificar un contacto: 'java -jar libreta.jar add <nuevo nombre> <nuevos apellidos> <nuevo telefono> <nuevo email>'");
            System.out.println("- Eliminar contacto: 'java -jar libreta.jar add <nombre> <apellidos>");
            System.out.println("- Mostrar contactos: 'java -jar libreta.jar list'");
            System.out.println("- Mostrar esta ayuda: 'java -jar libreta.jar help'");
        }else if (args[0].equalsIgnoreCase("remove")){
            libreta.borrar(new Contacto(args[1],args[2]));
        }else if (args[0].equalsIgnoreCase("modify")){
            libreta.modificarContacto(args[1], args[2], args[3], args[4]);

        }else{
            System.out.println("Comando no reconocido. Usa 'help' para ver las instrucciones disponibles.");
        }
    }
}
