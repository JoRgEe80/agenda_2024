package dominio;

public class NoEncontradoException extends Exception{

    private Contacto cerror;
    public NoEncontradoException(Contacto c){
        cerror=c;
    }
    public NoEncontradoException(){

    }
    public Contacto getContacto(){
        return cerror;
    }

}
