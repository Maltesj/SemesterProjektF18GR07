/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.IActionplan;
import acquaintance.IAssessment;
import acquaintance.ICaseInformation;
import acquaintance.IWork;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Simon
 */
public class LoadDatabase {
    
    LoadDatabase(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    
    Set<String> getCaseIDs() throws SQLException, IOException{
        
        Set<String> caseIDs = new HashSet<>();
        
        Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password);
        
        Statement statement = db.createStatement();
        ResultSet results = statement.executeQuery("select caseID from cases");
        
        while (results.next()) {
            String caseID = results.getString(1);
            caseIDs.add(caseID);
        }
        
        return caseIDs;
    }
    
    IWork loadWork(){
        return null;
        
    }
    
    IAssessment loadAssessment(){
        return null;
        
    }
    
    IActionplan loadActionplan(){
        return null;
        
    }
    
    ICaseInformation loadCaseInformation(){
        return null;
        
    }
}
