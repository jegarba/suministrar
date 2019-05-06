/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author PC ACER OFICINA
 */
public class ProveedoresVo {
    private String Proveedor, ciudad, nit;
    private int telefono;

    public ProveedoresVo(String Proveedor, String ciudad, String nit, int telefono) {
        this.Proveedor = Proveedor;
        this.ciudad = ciudad;
        this.nit = nit;
        this.telefono = telefono;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
