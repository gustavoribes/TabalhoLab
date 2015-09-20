/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import bean.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bjewjb ndfas
 */
public class VeiculoDao {

    private Connection conexao;

    public VeiculoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Veiculo veiculo) throws SQLException {
        if (this.valida(veiculo)) {
            String sql = " INSERT INTO veiculo( idcliente, fabricante, modelo, ano, kilometragem) "
                    + " VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            if (veiculo.getCliente() == null) {
                pst.setNull(1, Types.NUMERIC);
            } else {
                pst.setInt(1, veiculo.getCliente().getId());
            }
            pst.setString(2, veiculo.getFabricante());
            pst.setString(3, veiculo.getModelo());
            pst.setInt(4, veiculo.getAno());
            pst.setInt(5, veiculo.getKm());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void update(Veiculo veiculo) throws SQLException {
        if (this.valida(veiculo)) {
            String sql = "UPDATE veiculo SET idcliente = ?, fabricante = ?, modelo = ?, ano = ?, kilometragem = ? WHERE  idveiculo=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            if (veiculo.getCliente() == null) {
                pst.setNull(1, Types.NUMERIC);
            } else {
                pst.setInt(1, veiculo.getCliente().getId());
            }
            pst.setString(2, veiculo.getFabricante());
            pst.setString(3, veiculo.getModelo());
            pst.setInt(4, veiculo.getAno());
            pst.setInt(5, veiculo.getKm());
            pst.setInt(6, veiculo.getId());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void delete(Veiculo veiculo) throws SQLException {
        String sql = "DELETE FROM veiculo WHERE idveiculo = ?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, veiculo.getId());
        pst.executeUpdate();
        pst.close();
    }

    public Veiculo retrieve(Veiculo veiculo) throws SQLException {
        Veiculo veiculoRet = null;
        String sql = "SELECT idveiculo, idcliente, fabricante, modelo, ano, kilometragem  FROM veiculo WHERE idveiculo = ?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, veiculo.getId());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            veiculoRet = new Veiculo();
            Cliente cliente = new Cliente(rs.getInt("idcliente"));
            ClienteDao clientedao = new ClienteDao(conexao);
            veiculoRet.setCliente(clientedao.retrieve(cliente));
            veiculoRet.setId(rs.getInt("idveiculo"));
            veiculoRet.setFabricante(rs.getString("fabricante"));
            veiculoRet.setAno(rs.getInt("ano"));
            veiculoRet.setModelo(rs.getString("modelo"));
            veiculoRet.setKm(rs.getInt("kilometragem"));

        }
        rs.close();
        pst.close();
        return veiculoRet;
    }

    public List<Veiculo> listaTodos() throws SQLException {
        List<Veiculo> lista = new ArrayList<Veiculo>();
        String sql = "SELECT idveiculo, idcliente, fabricante, modelo, ano, kilometragem  FROM veiculo ORDER BY idveiculo";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Veiculo veiculo = new Veiculo();
            veiculo.setId(rs.getInt("idveiculo"));
            veiculo.setFabricante(rs.getString("fabricante"));
            veiculo.setModelo(rs.getString("modelo"));
            veiculo.setAno(rs.getInt("ano"));
            veiculo.setKm(rs.getInt("kilometragem"));
            Cliente cliente = new Cliente(rs.getInt("idcliente"));
            ClienteDao clientedao = new ClienteDao(conexao);
            veiculo.setCliente(clientedao.retrieve(cliente));

            lista.add(veiculo);
        }
        rs.close();
        st.close();
        return lista;
    }

    public boolean valida(Veiculo veiculo) {
        boolean ret = false;
        if (veiculo != null) {
            ret = true;
        }
        return ret;
    }
}
