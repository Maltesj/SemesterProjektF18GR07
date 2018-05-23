/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import acquaintance.ICaseInformation;
import acquaintance.IEffortInformation;
import data.EnumDatabaseAccount;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;

/**
 *
 * @author Simon
 */
public class SQLDatabaseResetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SQLDatabaseResetter resetter = new SQLDatabaseResetter();
        resetter.clearDatabase();
        resetter.setupDatabase();
        resetter.populateDatabase();
    }

    private void clearDatabase() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }

        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            Statement st = db.createStatement();
            st.executeQuery("drop table cases");
            
        } catch (Exception e) {
            System.out.println(e);

        }
        
    }

    private void setupDatabase() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }

        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            Statement st = db.createStatement();
            st.executeQuery("create table cases ("
                    + "caseID varchar(20), "
                    + "date_created date, "
                    + "date_last_changed date, "
                    + "work blob, "
                    + "assessment blob, "
                    + "actionplan blob, "
                    + "case_information blob, "
                    + "primary key(caseID, date_last_changed)"
                    + ")"
            );
            
            
            
            
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    private void populateDatabase() {

        ICaseInformation caseInfo1 = new SaveDummyCaseInfo().getDummy1();
        ICaseInformation caseInfo2 = new SaveDummyCaseInfo().getDummy2();
        IEffortInformation effort1 = new SaveDummyEffortInfo().getDummy1();
        IEffortInformation effort2 = new SaveDummyEffortInfo().getDummy2();
        
        
          try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }

        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            PreparedStatement st = db.prepareStatement("insert into cases("
                    + "caseID, "
                    + "date_created, "
                    + "date_last_changed, "
                    + "work, "
                    + "assessment, "
                    + "actionplan, "
                    + "case_information "
                    + ") values(?, getDate(), getDate(), ?, null, null, ?)"
                    );
            
            
            
            Blob case1 = db.createBlob();
                ByteArrayOutputStream d = new ByteArrayOutputStream();
                ObjectOutputStream bs = new ObjectOutputStream(d);
                bs.writeObject(caseInfo1);
                bs.flush();
                case1.setBytes(0, d.toByteArray());
                d.reset();
                
                Blob case2 = db.createBlob();
                bs.writeObject(caseInfo2);
                bs.flush();
                case2.setBytes(0, d.toByteArray());
                d.reset();
                
                Blob effort1Blob = db.createBlob();
                bs.writeObject(effort1);
                bs.flush();
                effort1Blob.setBytes(0, d.toByteArray());
                d.reset();
                
                Blob effort2Blob = db.createBlob();
                bs.writeObject(effort2);
                bs.flush();
                effort2Blob.setBytes(0, d.toByteArray());
                d.reset();
                
            st.setString(1, "DummyCase1");    
            st.setBlob(3, case1);
            st.setBlob(2, effort1Blob);
            st.execute();
            st.setString(1, "DummyCase2");
            st.setBlob(2, effort2Blob);
            st.setBlob(3, case2);
            st.execute();
          
           
        } catch (Exception e) {
            System.out.println(e);

        }
        
    }

}
