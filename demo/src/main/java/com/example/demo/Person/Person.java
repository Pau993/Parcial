package com.example.demo.Person;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private String nombre;
    @Basic
    private Integer precio;
    @Basic
    private Integer cantidad;
    @Basic 
    private String categoria;
    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setStock(int newStock) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStock'");
    }
}

