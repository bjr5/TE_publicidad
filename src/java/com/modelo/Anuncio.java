
package com.modelo;

import java.util.Date;

public class Anuncio {
  int id;
  String titulo;
  String contenido;
  int precio;
  Date fecha;
  Integer categoria;
    public Anuncio(){
        
    }

    public Anuncio(int id, String titulo, String contenido, int precio, Date fecha,Integer categoria) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.precio = precio;
        this.fecha = fecha;
        this.categoria = categoria;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String coontenido) {
        this.contenido = coontenido;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
