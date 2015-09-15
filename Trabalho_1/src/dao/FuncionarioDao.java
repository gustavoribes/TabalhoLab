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
    
    public FuncionarioDao(Connection conexao){
        this.conexao = conexao;
    }
    
    /**
     * Retorna uma Lista com todos os Funcionarios cadastrados no SGBD.
     * @return Lista com os funcionarios.
     * @throws java.sql.SQLException Qualquer erro entre o Sistema e o Banco será devolvido nesta Exceção
     */
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
     
}
