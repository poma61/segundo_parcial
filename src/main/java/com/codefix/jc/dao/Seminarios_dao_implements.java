package com.codefix.jc.dao;
import com.codefix.jc.model.Seminarios;
import com.codefix.jc.util.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Seminarios_dao_implements  extends Conection implements Seminarios_dao{
      @Override
    public void insert(Seminarios seminarios) throws Exception {
        this.conectar();
        String sql = "INSERT INTO seminarios(titulo,fecha,cupo) VALUES(?,?,?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, seminarios.getTitulo());
        ps.setString(2, seminarios.getFecha());
        ps.setInt(3, seminarios.getCupo());
        ps.executeUpdate();
        this.desconn();
    }
    @Override
    public void update(Seminarios seminarios) throws Exception {
        this.conectar();
        String sql = "UPDATE seminarios SET titulo=?,fecha=?,cupo=? where id=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
         
        ps.setString(1, seminarios.getTitulo());
        ps.setString(2, seminarios.getFecha());
        ps.setInt(3, seminarios.getCupo());
        ps.setInt(4, seminarios.getId());
        ps.executeUpdate();
        this.desconn();
    }
    @Override
    public void delete(int id) throws Exception {
        this.conectar();
        String sql = "DELETE FROM seminarios WHERE id=" + id;
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.executeUpdate();
        this.desconn();
    }
    @Override
    public Seminarios getById(int id) throws Exception {
        this.conectar();
        Seminarios cl = new Seminarios();
        String sql = "SELECT id,titulo,fecha,cupo  FROM seminarios WHERE  id=" + id;
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            cl.setId(rs.getInt("id"));
            cl.setTitulo(rs.getString("titulo"));
            cl.setFecha(rs.getString("fecha"));
            cl.setCupo(rs.getInt("cupo"));
        }
        this.desconn();
        return cl;
    }

    @Override
    public List<Seminarios> select() throws Exception {
        List<Seminarios> lista = new ArrayList<>();
        this.conectar();
        String sql = "SELECT id,titulo,fecha,cupo FROM seminarios";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Seminarios cl = new Seminarios();
            cl.setId(rs.getInt("id"));
            cl.setTitulo(rs.getString("titulo"));
            cl.setFecha(rs.getString("fecha"));
            cl.setCupo(rs.getInt("cupo"));
            lista.add(cl);
        }
        this.desconn();
        return lista;
    }
}
