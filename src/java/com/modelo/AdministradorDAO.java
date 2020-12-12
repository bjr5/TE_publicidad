
package com.modelo;

import com.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AdministradorDAO {
    ConexionDB cn = new ConexionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
     public List listar(){
        String sql="select * from administrador";
        List<Administrador>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Administrador ad=new Administrador();
                ad.setId(rs.getInt(1));
                ad.setNombre(rs.getString(2));
                ad.setApe_pat(rs.getString(3));
                ad.setApe_mat(rs.getString(4));   
                ad.setCelular(rs.getString(5));
                lista.add(ad);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Administrador a){ 
        String sql="insert into administrador( nombre,ape_pat,ape_mat,celular)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApe_pat());
            ps.setString(3, a.getApe_mat()); 
            ps.setString(4, a.getCelular());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;      
    }
    public Administrador listarId(int id){
        Administrador ad=new Administrador();
        String sql="select * from administrador where id_administrador="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                ad.setNombre(rs.getString(2));
                ad.setApe_pat(rs.getString(3));
                ad.setApe_mat(rs.getString(4)); 
                ad.setCelular(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return ad;
    }
    public int actualizar(Administrador ad){
        String sql="update administrador set nombre=?, ape_pat=?, ape_mat=?, celular=? where id_administrador=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, ad.getNombre());
            ps.setString(2, ad.getApe_pat());
            ps.setString(3, ad.getApe_mat()); 
            ps.setString(4, ad.getCelular());
            ps.setInt(5, ad.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from administrador where id_administrador="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}

