package com.modelo;

import com.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnuncioDAO {
    ConexionDB cn = new ConexionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql="select * from anuncio";
        List<Anuncio>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Anuncio an=new Anuncio();
                an.setId(rs.getInt(1));
                an.setTitulo(rs.getString(2));
                an.setContenido(rs.getString(3));
                an.setPrecio(rs.getInt(4));
                an.setFecha(rs.getDate(5));
                lista.add(an);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Anuncio a){ 
        String sql="insert into anuncio(titulo,contenido,precio,fecha)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, a.getTitulo());
            ps.setString(2, a.getContenido());
            ps.setInt(3, a.getPrecio());  
            ps.setDate(4, (Date)a.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;      
    }
    public Anuncio listarId(int id){
        Anuncio an=new Anuncio();
        String sql="select * from anuncio where id_anuncio="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                an.setTitulo(rs.getString(2));
                an.setContenido(rs.getString(3));
                an.setPrecio(rs.getInt(4));
                an.setFecha(rs.getDate(5));
            }
        } catch (Exception e) {
        }
        return an;
    }
    public int actualizar(Anuncio an){
        String sql="update anuncio set titulo=?, contenido=?, precio=?, fecha=? where id_anuncio=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, an.getTitulo());
            ps.setString(2, an.getContenido());
            ps.setInt(3, an.getPrecio());    
            ps.setDate(4, (Date) an.getFecha());
            ps.setInt(5, an.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from anuncio where id_anuncio="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int guardarTipo_anuncio(Anuncio anuncio){
        String sql="insert into tipo_anuncio(id_anuncio, categoria, fecha)values(?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, anuncio.getId());
            ps.setInt(2, anuncio.getCategoria());
            ps.setDate(3, (Date) anuncio.getFecha());
          
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
}

 

