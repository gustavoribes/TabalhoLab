/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author bjewjb ndfas
 */
public class Peça {

    private int idpeça;
    private String nome;
    private int valor;
    private String nomeFornecedor;

    public Peça() {

    }

    public Peça(int idpeca) {
        this.idpeça = idpeca;
    }

    public int getIdpeça() {
        return idpeça;
    }

    public void setIdpeça(int idpeça) {
        this.idpeça = idpeça;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idpeça;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Peça other = (Peça) obj;
        if (this.idpeça != other.idpeça) {
            return false;
        }
        return true;
    }

}
