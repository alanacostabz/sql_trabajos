/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WineStoreDB;

import java.util.Date;

/**
 *
 * @author bryan
 */
public class compra {
    
    String ID_Compra, ID_Cliente,Apellido, Nombre, ID_Vino, NombreVino,Fecha_Compra,CantidadTotal,CantidadBotellas;

    public compra(String ID_Compra, String ID_Cliente, String Apellido, String Nombre, String ID_Vino, String NombreVino, String Fecha_Compra, String CantidadTotal, String CantidadBotellas) {
        this.ID_Compra = ID_Compra;
        this.ID_Cliente = ID_Cliente;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.ID_Vino = ID_Vino;
        this.NombreVino = NombreVino;
        this.Fecha_Compra = Fecha_Compra;
        this.CantidadTotal = CantidadTotal;
        this.CantidadBotellas = CantidadBotellas;
    }

    compra(String idpurchase, String idcustomer, String apellido, String nombre, String idvino, Date fecha, int cantidadTotal, int cantidadBotellas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getID_Compra() {
        return ID_Compra;
    }

    public void setID_Compra(String ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public String getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getID_Vino() {
        return ID_Vino;
    }

    public void setID_Vino(String ID_Vino) {
        this.ID_Vino = ID_Vino;
    }

    public String getNombreVino() {
        return NombreVino;
    }

    public void setNombreVino(String NombreVino) {
        this.NombreVino = NombreVino;
    }

    public String getFecha_Compra() {
        return Fecha_Compra;
    }

    public void setFecha_Compra(String Fecha_Compra) {
        this.Fecha_Compra = Fecha_Compra;
    }

    public String getCantidadTotal() {
        return CantidadTotal;
    }

    public void setCantidadTotal(String CantidadTotal) {
        this.CantidadTotal = CantidadTotal;
    }

    public String getCantidadBotellas() {
        return CantidadBotellas;
    }

    public void setCantidadBotellas(String CantidadBotellas) {
        this.CantidadBotellas = CantidadBotellas;
    }
    
    
    
    
    
}
