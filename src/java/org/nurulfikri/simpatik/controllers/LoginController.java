/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nurulfikri.simpatik.controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rojul
 */
@ManagedBean(name="login")
@RequestScoped
public class LoginController implements Serializable{
    private String username;
    private String password;
    private String status;
    
    public LoginController() {
        this.status="";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
    public String prosesLogin(){
        
        if(this.username.equals("admin")
                && this.password.equals("123456")){
            this.status="Login Berhasil";
            return "welcome?faces-redirect=true";// arahkan ke page welcome
        }else{
            this.status="User atau Password Salah";
            return "login";// arahkan ke page login
        }
    }
    
    
    
}
