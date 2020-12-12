
package com.modelo;

public class Registro {
   int id;
   int id_administrador;
   int id_usuario;
   int contraseña;
   String nombre_usuario;
   String tipo;
   public Registro(){
       
   }

    public Registro(int id, int id_administrador, int id_usuario, int contraseña, String nombre_usuario, String tipo) {
        this.id = id;
        this.id_administrador = id_administrador;
        this.id_usuario = id_usuario;
        this.contraseña = contraseña;
        this.nombre_usuario = nombre_usuario;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
}
