package com.example.demo;

public class Product {
    private final String nombre;
    private final int precio;
    private final String cantidad;
    private final String categoria;

    public Product(String nombre, int precio, String cantidad, String categoria){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }
}
