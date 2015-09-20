/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import bean.Funcionario;
import bean.Manutençao;
import bean.Peça;
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
public class ManutençaoDao {

    private Connection conexao;

    public ManutençaoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Manutençao manut) throws SQLException {
        if (this.valida(manut)) {
            String sql = " INSERT INTO manutencao( idveiculo, idfuncionario, idpeca, valor) "
                    + " VALUES ( ?, ?, ?, ?)";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            if (manut.getVeiculo() == null) {
                pst.setNull(1, Types.NUMERIC);
            } else {
                pst.setInt(1, manut.getVeiculo().getId());
            }
            if (manut.getFuncionario() == null) {
                pst.setNull(2, Types.NUMERIC);
            } else {
                pst.setInt(2, manut.getFuncionario().getCod());
            }
            if (manut.getPeça() == null) {
                pst.setNull(3, Types.NUMERIC);
            } else {
                pst.setInt(3, manut.getPeça().getIdpeça());
            }
            pst.setInt(4, manut.getValor());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void update(Manutençao manut) throws SQLException {
        if (this.valida(manut)) {
            String sql = "UPDATE manutencao SET idveiculo = ?, idfuncionario = ?, idpeca = ?, valor = ? WHERE  idmanutencao=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            if (manut.getVeiculo() == null) {
                pst.setNull(1, Types.NUMERIC);
            } else {
                pst.setInt(1, manut.getVeiculo().getId());
            }
            if (manut.getFuncionario() == null) {
                pst.setNull(2, Types.NUMERIC);
            } else {
                pst.setInt(2, manut.getFuncionario().getCod());
            }
            if (manut.getPeça() == null) {
                pst.setNull(3, Types.NUMERIC);
            } else {
                pst.setInt(3, manut.getPeça().getIdpeça());
            }
            pst.setInt(4, manut.getValor());
            pst.setInt(5, manut.getId());
            pst.executeUpdate();
            pst.close();
        }
    }

    public void delete(Manutençao manut) throws SQLException {
        String sql = "DELETE FROM manutencao WHERE idmanutencao = ?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, manut.getId());
        pst.executeUpdate();
        pst.close();
    }

    public Manutençao retrieve(Manutençao manut) throws SQLException {
        Manutençao manutRet = null;
        String sql = "SELECT idmanutencao, idveiculo, idfuncionario, idpeca, valor FROM manutencao WHERE idmanutencao = ?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, manut.getId());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            manutRet = new Manutençao();
            Veiculo veiculo = new Veiculo(rs.getInt("idveiculo"));
            VeiculoDao veiculodao = new VeiculoDao(conexao);
            manutRet.setVeiculo(veiculodao.retrieve(veiculo));
            Funcionario func = new Funcionario(rs.getInt("idfuncionario"));
            FuncionarioDao funcdao = new FuncionarioDao(conexao);
            manutRet.setFuncionario(funcdao.retrieve(func));
            Peça peça = new Peça(rs.getInt("idpeca"));
            PeçaDao pecadao = new PeçaDao(conexao);
            manutRet.setPeça(pecadao.retrieve(peça));
            manutRet.setValor(rs.getInt("valor"));
            manutRet.setId(rs.getInt("idmanutencao"));

        }
        rs.close();
        pst.close();
        return manutRet;
    }

    public List<Manutençao> listaTodos() throws SQLException {
        List<Manutençao> lista = new ArrayList<Manutençao>();
        String sql = "SELECT idmanutencao, idveiculo, idfuncionario, idpeca, valor FROM manutencao ORDER BY idmanutencao";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Manutençao manutRet = new Manutençao();
            Veiculo veiculo = new Veiculo(rs.getInt("idveiculo"));
            VeiculoDao veiculodao = new VeiculoDao(conexao);
            manutRet.setVeiculo(veiculodao.retrieve(veiculo));
            Funcionario func = new Funcionario(rs.getInt("idfuncionario"));
            FuncionarioDao funcdao = new FuncionarioDao(conexao);
            manutRet.setFuncionario(funcdao.retrieve(func));
            Peça peça = new Peça(rs.getInt("idpeca"));
            PeçaDao pecadao = new PeçaDao(conexao);
            manutRet.setPeça(pecadao.retrieve(peça));
            manutRet.setValor(rs.getInt("valor"));
            manutRet.setId(rs.getInt("idmanutencao"));

            lista.add(manutRet);
        }
        rs.close();
        st.close();
        return lista;
    }

    public boolean valida(Manutençao manut) {
        boolean ret = false;
        if (manut != null) {
            ret = true;
        }
        return ret;
    }
}
