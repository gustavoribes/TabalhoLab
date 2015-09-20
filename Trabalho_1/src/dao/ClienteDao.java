/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
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
public class ClienteDao {
    
    private Connection conexao;

    public ClienteDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void create(Cliente cliente) throws SQLException {
        if (this.valida(cliente)) {
            String sql = " INSERT INTO cliente( nome, telefone, endereço, rg, email) " + 
                    " VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setInt(2, cliente.getTelefone());
            pst.setString(3, cliente.getEndereco());            
            pst.setInt(4, cliente.getRg());
            pst.setString(5, cliente.getEmail());
            pst.executeUpdate();
            pst.close();
        }
    }


    public void update(Cliente cliente) throws SQLException {
        if (this.valida(cliente)) {
            String sql = "UPDATE cliente SET nome = ?, telefone = ?, endereço = ?, rg = ?, email = ? WHERE  idcliente=?";
            PreparedStatement pst = this.conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setInt(2, cliente.getTelefone());
            pst.setString(3, cliente.getEndereco());
            pst.setInt(4, cliente.getRg());
            pst.setString(5, cliente.getEmail());
            pst.setInt(6, cliente.getId());
            pst.executeUpdate();
            pst.close();
        }
    }


    public void delete(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE idcliente=?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, cliente.getId());
        pst.executeUpdate();
        pst.close();
    }

    
    public Cliente retrieve(Cliente cliente) throws SQLException {
        Cliente clienteRet = null;
        String sql = "SELECT idcliente, nome, telefone, endereço, rg, email FROM cliente WHERE idcliente = ?";
        PreparedStatement pst = this.conexao.prepareStatement(sql);
        pst.setInt(1, cliente.getId());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            clienteRet = new Cliente();
            clienteRet.setId(rs.getInt("idcliente"));
            clienteRet.setNome(rs.getString("nome"));
            clienteRet.setTelefone(rs.getInt("telefone"));
            clienteRet.setEndereco(rs.getString("endereço"));
            clienteRet.setRg(rs.getInt("rg"));
            clienteRet.setEmail(rs.getString("email"));
        }
        rs.close();
        pst.close();
        return clienteRet;
    }

    public List<Cliente> listaTodos() throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT idcliente, nome, telefone, endereço, rg, email FROM cliente ORDER BY idcliente";
        Statement st = this.conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("idcliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getInt("telefone"));
            cliente.setEndereco(rs.getString("endereço"));
            cliente.setRg(rs.getInt("rg"));
            cliente.setEmail(rs.getString("email"));
            lista.add(cliente);
        }
        rs.close();
        st.close();
        return lista;
    }

    public boolean valida(Cliente cliente) {
        boolean ret = false;
        if (cliente != null) {
            ret = true;
        }
        return ret;
    }

}
