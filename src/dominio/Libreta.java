package dominio;

import java.util.ArrayList;

public class Libreta{
    private String nombre;
    private String apellidos;
    private ArrayList<Contacto> contactos;

    public Libreta() {
        contactos = new ArrayList<>();
        nombre="";
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
    public boolean borrar(Contacto c){
        if(contactos.contains(c)){
            contactos.remove(c);
            return true;
        }
        return false;
    }

    public Libreta annadirContacto(Contacto contacto) {
        contactos.add(contacto);
        return this;
    }
    public boolean modificarContacto(String nuevoNombre, String nuevosApellidos, String nuevoTelefono, String nuevoEmail) {
        Contacto contacto = buscar(nombre, apellidos);
        if (contacto != null) { 
        contacto.setTelefono(nuevoTelefono);
        contacto.setNombre(nuevoNombre); 
        contacto.setApellidos(nuevosApellidos);
        contacto.setEmail(nuevoEmail);
        return true;
        } 
    return false;
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
}
