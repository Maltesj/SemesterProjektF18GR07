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
    
    ACCOUNT1("sqsddxha","LU1LWOLTFJq3YDxKAMCY1hoOklV53oZq","jdbc:postgresql://horton.elephantsql.com:5432/sqsddxha");
    
    public final String userName;
    public final String password;
    public final String url;
    
    private EnumDatabaseAccount(String userName, String pw, String url){
        this.userName = userName;
        this.password = pw;
        this.url = url;
    }
    
}