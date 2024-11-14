package dominio;

public class DuplicadoException extends Exception{

    private Contacto cerror;
    public DuplicadoException(Contacto c){
        cerror=c;
    }
    public DuplicadoException(){

    }
    public Contacto getContacto(){
        return cerror;
    }

}