package com.codefix.jc.dao;
import com.codefix.jc.util.Conection;
import com.codefix.jc.model.Participantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Participantes_dao_implements extends Conection implements Participantes_dao {
    @Override
    public void insert(Participantes participantes) throws Exception {
        this.conectar();
        String sql = "INSERT INTO participantes(nombres,apellidos,id_seminario,confirmado) VALUES(?,?,?,?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, participantes.getNombres());
        ps.setString(2, participantes.getApellidos());
        ps.setInt(3, participantes.getId_seminario());
        ps.setInt(4, participantes.getConfirmado());
        ps.executeUpdate();
        this.desconn();
    }
    @Override
    public void update(Participantes participantes) throws Exception {
        this.conectar();
        String sql = "UPDATE participantes SET nombres=?,apellidos=?,id_seminario=?,confirmado=? WHERE id=?";
        
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, participantes.getNombres());
        ps.setString(2, participantes.getApellidos());
        ps.setInt(3, participantes.getId_seminario());
        ps.setInt(4, participantes.getConfirmado());
        ps.setInt(5, participantes.getId());
        ps.executeUpdate();
        this.desconn();
    }
    @Override
    public void delete(int id) throws Exception {
        this.conectar();
        String sql = "DELETE FROM participantes WHERE id=" + id;
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.executeUpdate();
        this.desconn();
    }

    @Override
    public Participantes getById(int id) throws Exception {
        this.conectar();
        Participantes cl = new Participantes();
        String sql = "SELECT id,nombres,apellidos,id_seminario,confirmado FROM participantes WHERE  id=" + id;
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            cl.setId(rs.getInt("id"));
            cl.setNombres(rs.getString("nombres"));
            cl.setApellidos(rs.getString("apellidos"));
            cl.setId_seminario(rs.getInt("id_seminario"));
            cl.setConfirmado(rs.getInt("confirmado"));
        }
        this.desconn();
        return cl;
    }

    @Override
    public List<Participantes> select() throws Exception {
        List<Participantes> lista = new ArrayList<>();
        this.conectar();
        String sql = "SELECT P.id,P.nombres,P.apellidos,P.id_seminario,P.confirmado,S.titulo  "
                + "FROM participantes P INNER JOIN seminarios S ON (S.id=P.id_seminario)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Participantes cl = new Participantes();
            cl.setId(rs.getInt("id"));
            cl.setNombres(rs.getString("nombres"));
            cl.setApellidos(rs.getString("apellidos"));
            cl.setId_seminario(rs.getInt("id_seminario"));
            cl.setConfirmado(rs.getInt("confirmado"));
            cl.setSeminarios(rs.getString("titulo"));
            lista.add(cl);
        }
        this.desconn();
        return lista;
    }
}
