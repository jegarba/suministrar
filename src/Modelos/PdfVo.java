package Modelos;

import java.sql.Date;

public class PdfVo {

    /*Todo los atributos*/
    private int IDdro, IDpro;
    int codigopdf, valorpdf, drogeria, proveedor;
    String nombrepdf, Nombre;
    Date fechaemi, fechavenci;
    byte[] archivopdf;

    public PdfVo() {
    }

    public int getIDdro() {
        return IDdro;
    }

    public void setIDdro(int IDdro) {
        this.IDdro = IDdro;
    }

    public int getIDpro() {
        return IDpro;
    }

    public void setIDpro(int IDpro) {
        this.IDpro = IDpro;
    }

    public int getCodigopdf() {
        return codigopdf;
    }

    public void setCodigopdf(int codigopdf) {
        this.codigopdf = codigopdf;
    }

    public int getValorpdf() {
        return valorpdf;
    }

    public void setValorpdf(int valorpdf) {
        this.valorpdf = valorpdf;
    }

    public int getDrogeria() {
        return drogeria;
    }

    public void setDrogeria(int drogeria) {
        this.drogeria = drogeria;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombrepdf() {
        return nombrepdf;
    }

    public void setNombrepdf(String nombrepdf) {
        this.nombrepdf = nombrepdf;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechaemi() {
        return fechaemi;
    }

    public void setFechaemi(Date fechaemi) {
        this.fechaemi = fechaemi;
    }

    public Date getFechavenci() {
        return fechavenci;
    }

    public void setFechavenci(Date fechavenci) {
        this.fechavenci = fechavenci;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }

    @Override
    public String toString() {
        return this.Nombre;
    }
}
