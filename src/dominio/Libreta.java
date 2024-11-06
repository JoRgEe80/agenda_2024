package dominio;

import java.util.ArrayList;

public class Libreta{
    private ArrayList<Contacto> contactos;

    public Libreta() {
        contactos = new ArrayList<>();
    }

    public void annadirContacto(Contacto contacto) {
        contactos.add(contacto);
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
