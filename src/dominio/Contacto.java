package dominio;
import java.io.Serializable;
public class Contacto implements Serializable{
        private String nombre;
        private String apellidos;
        private String email;
        private String telefono;
        public Contacto (String nombre_, String apellidos_, String telefono_, String email_){
         nombre=nombre_;
         apellidos=apellidos_;
         email=email_;
         telefono=telefono_;
       }
       public Contacto(String nombre_, String apellidos_){
        nombre=nombre_;
        apellidos=apellidos_;
        telefono="";
        email="";
       }
       public Contacto(){
        nombre="";
        apellidos="";
        telefono="";
        email="";
       }

        public String getNombre(){
         return nombre;
        }
        public String getApellidos(){
         return apellidos;
        }
        public String getTelefono(){
         return telefono;
        }
        public String getEmail(){
         return email;
        }
        public void setNombre(String nombre_){
         nombre=nombre_;
        }
        public Contacto setApellidos(String apellidos_){
         apellidos=apellidos_;
         return this;
        }

        public Contacto setTelefono(String telefono_){
         telefono=telefono_;
         return this;
        }
        public Contacto setEmail(String email_){
         email=email_;
         return this;
        }
        public String toString(){
                StringBuilder sb=new StringBuilder();
                sb.append("Nombre: ").append(nombre).append(" ").append(apellidos)
                .append("\n telefono; ").append(telefono).append("\n email: ")
                .append(email);
                return sb.toString();
        }
 
        public boolean equals(Object o){
                if (o==null)
                   return false;
                if (this.getClass()!=o.getClass())
                   return false;
                Contacto c= (Contacto) o;
                return nombre.equals(c.nombre)&& apellidos.equals(c.apellidos);
       }
}
