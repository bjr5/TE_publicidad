
package com.modelo;

import com.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO {
    ConexionDB cn = new ConexionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
     public Registro validar(String nombre_usuario, int contraseña) {
        Registro re = new Registro();
        String sql = "select * from registro where nombre_usuario=? and contraseña=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre_usuario);
            ps.setInt(2, contraseña);
            rs = ps.executeQuery();
            while (rs.next()) {
                re.setId(rs.getInt("id_registro"));
                re.setNombre_usuario(rs.getString("nombre_usuario"));
                re.setContraseña(rs.getInt("contraseña"));
                
            }
        } catch (Exception e) {
        }
        return re;
    }
    
    public List listar(){
        String sql="select * from registro";
        List<Registro>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Registro re=new Registro();
                re.setId(rs.getInt(1));
                re.setId_administrador(rs.getInt(2));
                re.setId_usuario(rs.getInt(3));
                re.setContraseña(rs.getInt(4)); 
                re.setNombre_usuario(rs.getString(5));
                re.setTipo(rs.getString(6));
                
                lista.add(re);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Registro re){ 
        String sql="insert into registro(id_administrador,id_usuario,contraseña,nombre_usuario,tipo)values(?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, re.getId_administrador());
            ps.setInt(2, re.getId_usuario());
            ps.setInt(3, re.getContraseña());
            ps.setString(4, re.getNombre_usuario());
            ps.setString(5, re.getTipo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;      
    }
    public Registro listarId(int id){
        Registro re=new Registro();
        String sql="select * from registro where id_registro="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                re.setId_administrador(rs.getInt(2));
                re.setId_usuario(rs.getInt(3));
                re.setContraseña(rs.getInt(4));
                re.setNombre_usuario(rs.getString(5));
                re.setTipo(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return re;
    }
    
}



 
