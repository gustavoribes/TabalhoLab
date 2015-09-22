/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Peça;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author bjewjb ndfas
 */
public class PeçaDao {
      
    private Connection conexao;

    public PeçaDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Peça peça) throws SQLException {
        if (this.valida(peça)) {
            String sql = " INSERT INTO peca( nome, valor, nomefornecedor) " + 
                    " VALUES ( ?, ?, ?)";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, peça.getNome());
            pst.setInt(2, peça.getValor());
            pst.setString(3, peça.getNomeFornecedor());
            pst.executeUpdate();
            pst.close();
        }
    }


    public void update(Peça peça) throws SQLException {
        if (this.valida(peça)) {
            String sql = "UPDATE peca SET nome = ?, valor = ?, nomefornecedor = ? WHERE  idpeca=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, peça.getNome());
            pst.setInt(2, peça.getValor());
            pst.setString(3, peça.getNomeFornecedor());
            pst.setInt(4, peça.getIdpeça());
            pst.executeUpdate();
            pst.close();
        }
    }


    public void delete(Peça peça) throws SQLException {
        try{
        String sql = "DELETE FROM peca WHERE idpeca=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, peça.getIdpeça());
        pst.executeUpdate();
        pst.close();
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Nao é possivel excluir esta peça.");
        }
    }

    
    public Peça retrieve(Peça peça) throws SQLException {
        Peça peçaRet = null;
        String sql = "SELECT idpeca, nome, valor, nomefornecedor  FROM peca WHERE idpeca = ?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, peça.getIdpeça());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            peçaRet = new Peça();
            peçaRet.setIdpeça(rs.getInt("idpeca"));
            peçaRet.setNome(rs.getString("nome"));
            peçaRet.setValor(rs.getInt("valor"));
            peçaRet.setNomeFornecedor(rs.getString("nomefornecedor"));
        }
        rs.close();
        pst.close();
        return peçaRet;
    }

    public List<Peça> listaTodos() throws SQLException {
        List<Peça> lista = new ArrayList<Peça>();
        String sql = "SELECT idpeca, nome, valor, nomefornecedor FROM peca ORDER BY idpeca";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Peça peça = new Peça();
            peça.setIdpeça(rs.getInt("idpeca"));
            peça.setNome(rs.getString("nome"));
            peça.setValor(rs.getInt("valor"));
            peça.setNomeFornecedor(rs.getString("nomefornecedor"));
            lista.add(peça);
        }
        rs.close();
        st.close();
        return lista;
    }

    public boolean valida(Peça peça) {
        boolean ret = false;
        if (peça != null) {
            ret = true;
        }
        return ret;
    }
}
