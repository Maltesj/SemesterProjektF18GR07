/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.EnumPhases;
import acquaintance.IActionplan;
import acquaintance.IAssessment;
import acquaintance.ICaseInformation;
import acquaintance.IWork;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
    private Map<String, Serializable> blobMaaap;

    SaveDatabaseRun(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(EnumPhases.WORK.getPhase(), work);
        this.blobMaaap.put(EnumPhases.INFORMATION.getPhase(), caseInfo);
        this.blobMaaap.put(EnumPhases.ASSESSMENT.getPhase(), assessment);
        this.blobMaaap.put(EnumPhases.ACTIONPLAN.getPhase(), actionplan);

    }

    SaveDatabaseRun(ICaseInformation caseInfo, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(EnumPhases.INFORMATION.getPhase(), caseInfo);
    }

    SaveDatabaseRun(IAssessment assessment, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(EnumPhases.ASSESSMENT.getPhase(), assessment);
    }

    SaveDatabaseRun(IActionplan actionplan, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(EnumPhases.ACTIONPLAN.getPhase(), actionplan);
    }

    SaveDatabaseRun(IWork work, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(EnumPhases.WORK.getPhase(), work);
    }
    
    SaveDatabaseRun (EnumPhases phase, String caseID){
        this.caseID = caseID;
        
        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put(phase.getPhase(), null);
    }

   

    @Override
    public void run() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }

        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            
            PreparedStatement statement = db.prepareStatement("Insert into cases("
                    + "date_last_changed, "
                    + "caseID, "
                    + "date_created, "
                    + EnumPhases.WORK.getPhase() + ", "
                    + EnumPhases.ASSESSMENT.getPhase() + ", "
                    + EnumPhases.ACTIONPLAN.getPhase() + ", "
                    + EnumPhases.INFORMATION.getPhase() + " "
                    + ") values(now(), "
                    + "(Select caseID From cases where caseID = ? AND date_last_changed = (select max(date_last_changed) From cases where caseID = ?)), "
                    + "(Select date_created From cases where caseID = ? AND date_last_changed = (select max(date_last_changed) From cases where caseID = ?)), "
                    + "(Select " + EnumPhases.WORK.getPhase() + " From cases where caseID = ? AND date_last_changed = (select max(date_last_changed) From cases where caseID = ?)), "
                    + "(Select " + EnumPhases.ASSESSMENT.getPhase() + " From cases where caseID = ? AND date_last_changed = (select max(date_last_changed) From cases where caseID = ?)), "
                    + "(Select " + EnumPhases.ACTIONPLAN.getPhase() + " From cases where caseID = ? AND date_last_changed = (select max(date_last_changed) From cases where caseID = ?)), "
                    + "(Select " + EnumPhases.INFORMATION.getPhase() + " From cases where caseID = ? AND date_last_changed = (select max(date_last_changed) From cases where caseID = ?)))");
                                     
            
//            , date_created, work, assessment, actionplan, case_information
//            
//            + "ORDER BY caseID "
//                                     + "DESC LIMIT 1))");

            statement.setString(1, this.caseID);
            statement.setString(2, this.caseID);
            statement.setString(3, this.caseID);
            statement.setString(4, this.caseID);
            statement.setString(5, this.caseID);
            statement.setString(6, this.caseID);
            statement.setString(7, this.caseID);
            statement.setString(8, this.caseID);
            statement.setString(9, this.caseID);
            statement.setString(10, this.caseID);
            statement.setString(11, this.caseID);
            statement.setString(12, this.caseID);
            
             for (Map.Entry<String, Serializable> entry : this.blobMaaap.entrySet()) {
               
                ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
                ObjectOutputStream objectOS = new ObjectOutputStream(byteArrayOS);
                objectOS.writeObject(entry.getValue());
                objectOS.flush();
                byte[] byteA = byteArrayOS.toByteArray();

                PreparedStatement prepared = db.prepareStatement(
                        "Update Cases set " + entry.getKey() + "= ? "
                        + "where caseID = ? AND date_last_changed = (select max(date_last_changed) From cases where caseID = ?)");
                
                prepared.setBytes(1, byteA);
                prepared.setString(2, caseID);
                prepared.setString(3, caseID);

                prepared.executeUpdate();

            }
            
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
