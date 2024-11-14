package dominio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Libreta{
    private String nombre;
    private ArrayList<Contacto> contactos;

    public Libreta() {
        contactos = new ArrayList<>();
        nombre="";
        cargarContactos();
    }
    public Contacto buscar(Contacto c){
        int p=contactos.indexOf(c);
        if (p==1)
        return null;
        return contactos.get(p);

    }
    public Contacto buscar(String nombre, String apellidos){
        for(Contacto c: contactos){
            if(c.getNombre().equals(nombre) && c.getApellidos().equals(apellidos)){
            return c;
            }
        }
        return null;        
    }
    /* public boolean borrar(Contacto c){
        int index = contactos.indexOf(c);
        if(index !=-1){
            contactos.remove(index);
            return true;
        }
        return false;
    }
    */
    public Libreta borrar(Contacto c)throws NoEncontradoException{
        if(contactos.contains(c)){
            contactos.remove(c);
            volcarContactos();
            return this;
        }else{
            throw new NoEncontradoException(c);
        }
    }

    public Libreta annadirContacto(Contacto contacto)throws DuplicadoException {
        if(contactos.contains(contacto)){
            throw new DuplicadoException(contacto);
        }else{    
            contactos.add(contacto);
            volcarContactos();
            return this;
        }
    
    }
    public Libreta modificarContacto(String nombre, String apellidos, String nuevoTelefono, String nuevoEmail)throws NoEncontradoException {
        Contacto contacto = buscar(nombre, apellidos);
        if (contacto != null) { 
        contacto.setTelefono(nuevoTelefono);
        contacto.setEmail(nuevoEmail);
        volcarContactos();
        return this;
        }else{
            throw new NoEncontradoException();
        }
    
    } 
    public ArrayList<Contacto> getContactos(){
        return contactos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Contacto contacto : contactos) {
            sb.append(contacto.toString()).append("\n");
        }
        return sb.toString();
    }
    private void cargarContactos(){
        try{
            File fichero = new File("libreta.csv");
    
            if (!fichero.exists()) {
                System.out.println("La libreta no extiste");
                return;
            }
            Scanner sc = new Scanner(fichero);
            sc.useDelimiter("[,\n]");
            while(sc.hasNext()){
                Contacto c = new Contacto(sc.next(),sc.next(),sc.next(),sc.next());
                contactos.add(c);
            }
            sc.close();
        }catch(IOException ex){
            System.out.println("No hay contactos registrados");
        }

    }
     public void volcarContactos(){
    try{
        FileWriter fw = new FileWriter("libreta.csv");
        for(Contacto c : contactos){
            fw.write(c.getNombre() + "," +c.getApellidos() + "," +c.getTelefono()+","+c.getEmail()+"\n");
        }
        fw.close();
        }catch(IOException ex){
        System.err.println(ex);
        }
    }

}
