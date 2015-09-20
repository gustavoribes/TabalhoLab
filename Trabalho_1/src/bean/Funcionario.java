/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author bjewjb ndfas
 */
public class Funcionario {

    private int cod;
    private String nome;
    private int rg;
    private Date dataentrada;
    private String cargo;
    private int salario;
    private String senha;

    public Funcionario() {

    }

    public Funcionario(int cod) {
        this.cod = cod;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * retirado do codigo exemplo!! Método utilizado para validar a senha do
     * usuário
     *
     * @param senha String a ser validada contra a senha do usuário
     * @return true se as duas senhas são iguais, ou false em caso contrário
     */
    public boolean validaSenha(String senha) {
        boolean ret = false;
        try {
            if (this.senha.equals(senha)) {
                ret = true;
            }
        } catch (NullPointerException ex) {
        }
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.cod;
        return hash;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.cod != other.cod) {
            return false;
        }
        return true;
    }

}
