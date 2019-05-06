package Modelos;


public class PrincipalVo {

    private String Nombre;
    private String cedula;
    private String rol;

    public PrincipalVo() {
    }

    @Override
    public String toString() {
        return "PrincipalVo{" + "Nombre=" + Nombre + ", cedula=" + cedula + '}';
    }

    public PrincipalVo(String Nombre, String cedula, String rol) {
        this.Nombre = Nombre;
        this.cedula = cedula;
        this.rol = rol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
