
package com.modelo;

import com.utiles.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    ConexionDB cn = new ConexionDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql="select * from usuario";
        List<Usuario>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Usuario us=new Usuario();
                us.setId(rs.getInt(1));
                us.setId_tipo(rs.getInt(2));
                us.setCi(rs.getInt(3));
                us.setNombre(rs.getString(4)); 
                us.setApe_pat(rs.getString(5));
                us.setApe_mat(rs.getString(6));
                us.setCelular(rs.getString(7));
                us.setCorreo(rs.getString(8));
                
                lista.add(us);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Usuario us){ 
        String sql="insert into usuario(ci, nombre, ape_pat, ape_mat, celular, correo)values(?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(3, us.getNombre());
            ps.setString(4, us.getApe_pat() );
            ps.setString(5, us.getApe_pat() );   
            ps.setString(6, us.getCelular());
            ps.setString(7, us.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;      
    }
    public Usuario listarId(int id){
        Usuario us=new Usuario();
        String sql="select * from usuario where id_usuario="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                us.setId_tipo(rs.getInt(2));
                us.setNombre(rs.getString(3));
                us.setApe_pat(rs.getString(4)); 
                us.setApe_mat(rs.getString(5));
                us.setCelular(rs.getString(6));
                us.setCorreo(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return us;
    }
    
}
