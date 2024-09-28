package com.example.back.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String marca;
    private String color;
    private int stock;
    private Float precio_comercial;
    private Float precio_compra;
    private String imagen;

    public Productos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Float getPrecio_comercial() {
        return precio_comercial;
    }

    public void setPrecio_comercial(Float precio_comercial) {
        this.precio_comercial = precio_comercial;
    }

    public Float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String toString(){
        return nombre;
    }
}
