/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moelagem;

import Controle.Conn;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm-2
 */
public class Produto {
    private int codigo;
    private String nomeProduto;
    private String descricao;
    
    Conn con = new Conn();
    
    public Produto(){
        this(0,"","");
    }

    public Produto(int codigo, String nomeProduto, String descricao) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void cadastrarProduto(){
        String sql = "Insert into produtos(codigo,nomeProduto,descricao)values"+"('"+getCodigo()+"' ,'"+getNomeProduto()+"' , '"+getDescricao()+"')";
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Registro salvo com sucesso!!");
    }
    
     public ResultSet listarProduto(){
        ResultSet tabela;
        tabela = null;
        String sql = "Select * from produtos";
        tabela = con.RetornarResultset(sql);
        return tabela;
    }
    
}