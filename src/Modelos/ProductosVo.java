package Modelos;

public class ProductosVo {

    private int IDcate, IDlab;
    private String cod, Nombre;
    private int Categoria, Laboratorio, Unidades, Cajas, Costo, Porcentaje;

    public ProductosVo(String cod, String Nombre, int Categoria, int Laboratorio, int Unidades, int Cajas, int Costo, int Porcentaje) {
        this.cod = cod;
        this.Nombre = Nombre;
        this.Categoria = Categoria;
        this.Laboratorio = Laboratorio;
        this.Unidades = Unidades;
        this.Cajas = Cajas;
        this.Costo = Costo;
        this.Porcentaje = Porcentaje;
    }

    public ProductosVo() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getIDcate() {
        return IDcate;
    }

    public void setIDcate(int IDcate) {
        this.IDcate = IDcate;
    }

    public int getIDlab() {
        return IDlab;
    }

    public void setIDlab(int IDlab) {
        this.IDlab = IDlab;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }

    public int getLaboratorio() {
        return Laboratorio;
    }

    public void setLaboratorio(int Laboratorio) {
        this.Laboratorio = Laboratorio;
    }

    public int getUnidades() {
        return Unidades;
    }

    public void setUnidades(int Unidades) {
        this.Unidades = Unidades;
    }

    public int getCajas() {
        return Cajas;
    }

    public void setCajas(int Cajas) {
        this.Cajas = Cajas;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    public int getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(int Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    @Override
    public String toString() {
        return this.Nombre;
    }
}
