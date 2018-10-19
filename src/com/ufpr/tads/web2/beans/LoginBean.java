/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;

/**
 *
 * @author ikki
 */
public class LoginBean implements Serializable {
    private String id;
    private String nome;
    
    public LoginBean (){
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setId(String id){
        this.id = id;
    }
}
