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
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Simon
 */
public class SaveDatabaseRun implements Runnable {
    
    private String caseID;
    private Map<String, Blob> blobMaaap;
    
    SaveDatabaseRun(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan, String caseID){
        this.caseID = caseID;
        
        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(caseID, work);
        this.blobMaaap.put(caseID, caseInfo);
        this.blobMaaap.put(caseID, assessment);
        this.blobMaaap.put(caseID, actionplan);
        
    }
    
    SaveDatabaseRun(ICaseInformation caseInfo, String caseID){
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(caseID, caseInfo);
    }
    
    SaveDatabaseRun(IAssessment assessment, String caseID){
        this.caseID = caseID;
        
        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(caseID, assessment);
    }
    
    SaveDatabaseRun(IActionplan actionplan, String caseID){
        this.caseID = caseID;
        
        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(caseID, actionplan);
    }
    
    SaveDatabaseRun(IWork work, String caseID){
        this.caseID = caseID;
        
        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(caseID, work);
    }
    
    @Override
    public void run(){
        try {
            Class.forName("assets/org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
        
//        try (Connection db = DriverManager.getConnection(DatabaseEnum.ACCOUNT1.url,DatabaseEnum.ACCOUNT1.userName,DatabaseEnum.ACCOUNT1.password);
//                Statement st = db.createStatement();
//                ResultSet rs = st.executeQuery(command);) {
//            for (String type : types) {
//                switch (type){
//                    case "int":
//                        rs.getInt(4);
//                        break;
//                }
//            }
//            
//            
//            return rs;
//        } catch (Exception e) {
//            System.out.println(e);
//            return null;
//        }
//        
//        
//        try (Connection db = DriverManager.getConnection(DatabaseEnum.ACCOUNT1.url,DatabaseEnum.ACCOUNT1.userName,DatabaseEnum.ACCOUNT1.password);
//                Statement st = db.createStatement();
//                ) {
//            
//            int rs = st.executeUpdate(command);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
    
    
}
