/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Funcionario;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bjewjb ndfas
 */
public class FuncionarioDao {

    private Connection conexao;

    public FuncionarioDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Funcionario func) throws SQLException {
        if (this.valida(func)) {
            String sql = " INSERT INTO funcionario( nome, telefone, dataentrada, rg, cpf, cargo, salario, endereço, senha) " + // Insert Postgresql
                    " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, func.getNome());
            pst.setString(2, func.getTelefone());
            java.sql.Date dtSQL = new java.sql.Date(func.getDataentrada().getTime());
            pst.setDate(3, dtSQL);
            pst.setString(4, func.getRg());
            pst.setString(5, func.getCpf());
            pst.setString(6, func.getCargo());
            pst.setString(7, func.getSalario());
            pst.setString(8, func.getEndereço());
            pst.setString(9, func.getSenha());
            pst.executeUpdate();
            pst.close();
        }
    }

        /**
     * Atualiza o funcionario no SGBD.
     * @param func Funcionario a ser atualizado do SGBD
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco será devolvido nesta Exceção
     */
    public void update(Funcionario func) throws SQLException {
        if (this.valida(func)) {
            String sql = "UPDATE funcionario SET nome = ?, telefone = ?,  dataentrada = ?, rg = ?, cpf = ?, cargo = ?, salario = ?, endereço = ?, senha = ? WHERE  idfuncionario=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, func.getNome());
            pst.setString(2, func.getTelefone());
            pst.setDate(3, new java.sql.Date(func.getDataentrada().getTime()));
            pst.setString(4, func.getRg());
            pst.setString(5, func.getCpf());
            pst.setString(6, func.getCargo());
            pst.setString(7, func.getSalario());
            pst.setString(8, func.getEndereço());
            pst.setString(9, func.getSenha());
            pst.setInt(10, func.getCod());
            pst.executeUpdate();
            pst.close();
        }
    }

    /**
     * Remove o código do funcionario do SGBD.
     * @param func Funcionario a ser excluído. Necessita apenas do atributo COD
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco será devolvido nesta Exceção
     */
    public void delete(Funcionario func) throws SQLException {
        String sql = "DELETE FROM FUNCIONARIO WHERE idfuncionario=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, func.getCod());
        pst.executeUpdate();
        pst.close();
    }

    
    public Funcionario retrieve(Funcionario func) throws SQLException {
        Funcionario funcRet = null;
        String sql = "SELECT idfuncionario, nome, telefone, dataentrada, rg, cpf, cargo, salario, endereço, senha FROM funcionario WHERE idfuncionario=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, func.getCod());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            funcRet = new Funcionario();
            funcRet.setCod(rs.getInt("idfuncionario"));
            funcRet.setNome(rs.getString("nome"));
            funcRet.setCargo(rs.getString("cargo"));
            funcRet.setDataentrada(rs.getDate("dataentrada"));
            funcRet.setTelefone(rs.getString("telefone"));
            funcRet.setRg(rs.getString("rg"));
            funcRet.setCpf(rs.getString("cpf"));
            funcRet.setCargo(rs.getString("cargo"));
            funcRet.setSalario(rs.getString("salario"));
            funcRet.setEndereço(rs.getString("endereço"));
            funcRet.setSenha(rs.getString("senha"));
        }
        rs.close();
        pst.close();
        return funcRet;
    }

    public List<Funcionario> listaTodos() throws SQLException {
        List<Funcionario> lista = new ArrayList<Funcionario>();
        String sql = "SELECT idfuncionario, nome, telefone, dataentrada, rg, cpf, cargo, salario, endereço, senha FROM funcionario ORDER BY idfuncionario";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Funcionario func = new Funcionario();
            func.setCod(rs.getInt("idfuncionario"));
            func.setNome(rs.getString("nome"));
            func.setCargo(rs.getString("cargo"));
            func.setDataentrada(rs.getDate("dataentrada"));
            func.setRg(rs.getString("rg"));
            func.setCpf(rs.getString("cpf"));
            func.setEndereço(rs.getString("endereço"));
            func.setSalario(rs.getString("salario"));
            func.setSenha(rs.getString("senha"));
            lista.add(func);
        }
        rs.close();
        st.close();
        return lista;
    }

    public Funcionario retrieve(String login) throws SQLException {
        Funcionario usrDept = new Funcionario();
        String sql = "SELECT idfuncionario,cpf,senha FROM funcionario WHERE cpf=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setString(1, login);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            usrDept.setCod(rs.getInt("idfuncionario"));
            usrDept.setCpf(rs.getString("cpf"));
            usrDept.setSenha(rs.getString("senha"));
        }
        rs.close();
        pst.close();
        return usrDept;
    }

    public boolean valida(Funcionario func) {
        boolean ret = false;
        if (func != null) {
            ret = true;
        }
        return ret;
    }

}
