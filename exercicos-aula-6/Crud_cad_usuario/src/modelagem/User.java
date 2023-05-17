/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import controle.Conn;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm-2
 */
public class User {
   private String nome;
   private String email;
   private String login;
   private String senha;
   
   private Conn con = new Conn();
   
   public User(){
       this("","","","");
   }

    public User(String nome, String email, String login, String senha) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void cadastrarUsuario(){
        String sql;
        sql = "Insert into Usuarios(nome,email,login,senha)values"+"('"+ getNome() +"' , '"+ getEmail()+ "' ,  '" + getSenha() +"','"+ getLogin() +"' )";
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!!");
    }
    public ResultSet consultarUsuario(){
        ResultSet tabela;
        tabela = null;
        String sql = "Select * from usuarios";
        tabela = con.RetornarResultset(sql);
        return tabela;
    }
    public void excluirUsuario(){
        String sql;
        sql = "Delete from usuarios where LOGIN=" + getLogin();
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Registro excluído com sucesso!!");
    }
    
    public void alterarUsuario(){
        String sql;
        sql = "Update usuarios set nome='"+ getNome() +"', email='"+ getEmail() +"',senha='" + getSenha() + "' where Login='" + getLogin()+"'";
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Registro alterado com sucesso!!");    
    } 
    

}
