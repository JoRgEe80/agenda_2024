package interfaz;

import dominio.Libreta;
import dominio.Contacto;

public class Interfaz {
    private Libreta libreta;

    public Interfaz() {
        libreta = new Libreta();
    }

    public void procesarPeticion(String [] args) {
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
            System.out.println("- Mostrar contactos: 'java -jar libreta.jar list'");
            System.out.println("- Mostrar esta ayuda: 'java -jar libreta.jar help'");
        } else {
            System.out.println("Comando no reconocido. Usa 'help' para ver las instrucciones disponibles.");
        }
    }
}
