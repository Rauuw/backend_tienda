package com.example.back.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fecha;
    private Float monto_total;
    private String forma_pago;
    private String imagen;
    private int comprobante;
    private int cliente_id;
    private int factura_id;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Float monto_total) {
        this.monto_total = monto_total;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getComprobante() {
        return comprobante;
    }

    public void setComprobante(int comprobante) {
        this.comprobante = comprobante;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(int factura_id) {
        this.factura_id = factura_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String toString(){
        return forma_pago;
    }
}
