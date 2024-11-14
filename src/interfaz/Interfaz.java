package interfaz;

import dominio.Libreta;
import dominio.NoEncontradoException;
import dominio.Contacto;
import dominio.DuplicadoException;

import java.util.*;
import java.io.*;

public class Interfaz implements Serializable {
    public static void ejecutar(String [] args) {
        Scanner sc = new Scanner(System.in);
        Libreta libreta= new Libreta();
        if (args[0].equalsIgnoreCase("add")) {
            if (args.length == 5) {
                String nombre = args[1];
                String apellidos= args[2];
                String telefono= args[3];
                String email= args[4];

                try{
                    libreta.annadirContacto(new Contacto(nombre, apellidos, telefono, email));
                System.out.println("Contacto añadido: " + nombre + ", " + apellidos
                +", "+telefono+", "+email);
                }catch(DuplicadoException e){
                    System.out.println("'Contacto duplicado', pruebe a introducir un nuevo contacto");
                }
            } else {
                System.out.println("Formato incorrecto. Formato: add <nombre> <apellidos> <telefono> <email>");
            }
        } else if (args[0].equalsIgnoreCase("list")) {
            System.out.println("Contactos en la libreta:");
            System.out.println(libreta);
        } else if (args[0].equalsIgnoreCase("help")) {
            System.out.println("Las operaciones posibles son las siguientes:");
            System.out.println("- Añadir contacto: 'java -jar libreta.jar add <nombre> <apellidos> <telefono> <email>'");
            System.out.println("- Modificar un contacto: 'java -jar libreta.jar mofify <Nombre> <Apellidos> <nuevo telefono> <nuevo email>'");
            System.out.println("- Eliminar contacto: 'java -jar libreta.jar remove <nombre> <apellidos>");
            System.out.println("- Mostrar contactos: 'java -jar libreta.jar list'");
            System.out.println("- Mostrar esta ayuda: 'java -jar libreta.jar help'");
        }else if (args[0].equalsIgnoreCase("remove")){
            try{
                libreta.borrar(new Contacto(args[1],args[2]));
            }catch(NoEncontradoException e){
                System.out.println("El contacto: "+e.getContacto().getNombre()+" no se ha encontrado");

            }

        }else if (args[0].equalsIgnoreCase("modify")){
            try{
                libreta.modificarContacto(args[1], args[2], args[3], args[4]);
            }catch(NoEncontradoException e){
                System.out.println("El contacto que quiere modificar no existe, para añadirlo ejectue desde consola 'java -jar libreta.jar add <nombre> <apellidos> <telefono> <email>'");
            }
        }else{
            System.out.println("Comando no reconocido. Usa 'help' para ver las instrucciones disponibles.");
        }
        sc.close();
    }
}
