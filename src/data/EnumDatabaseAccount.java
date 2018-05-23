/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author HCHB
 */
public enum EnumDatabaseAccount {
    
    ACCOUNT1("ukwglswb","86RbpudM5gWs0TOqEpWyckJS8YPJ34W9","jdbc:postgresql://horton.elephantsql.com:5432/ukwglswb");
    
    public final String userName;
    public final String password;
    public final String url;
    
    private EnumDatabaseAccount(String userName, String pw, String url){
        this.userName = userName;
        this.password = pw;
        this.url = url;
    }
    
}