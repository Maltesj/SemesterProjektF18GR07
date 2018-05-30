/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package generator;

import acquaintance.ICaseInformation;
import acquaintance.IWork;
import data.EnumDatabaseAccount;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import acquaintance.EnumPhases;

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
//        resetter.testWork();
    }
    
    private void clearDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
        
        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            Statement st = db.createStatement();
            st.execute("drop table if exists cases");
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
            st.execute("create table cases ("
                    + "caseID varchar(20), "
                    + "date_created date, "
                    + "date_last_changed timestamp, "
                    + EnumPhases.WORK.getPhase()+ " bytea, "
                    + EnumPhases.ASSESSMENT.getPhase() + " bytea, "
                    + EnumPhases.ACTIONPLAN.getPhase() + " bytea, "
                    + EnumPhases.INFORMATION.getPhase() + " bytea, "
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
        IWork effort1 = new SaveDummyWorkInfo().getDummy1();
        IWork effort2 = new SaveDummyWorkInfo().getDummy2();
        
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
                    + EnumPhases.WORK.getPhase() + ", "
                    + EnumPhases.ASSESSMENT.getPhase() + ", "
                    + EnumPhases.ACTIONPLAN.getPhase() + ", "
                    + EnumPhases.INFORMATION.getPhase() + " "
                    + ") values(?, now(), now(), ?, null, null, ?)"
            );
            
            ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
            ObjectOutputStream objectOS = new ObjectOutputStream(byteArrayOS);
            objectOS.writeObject(caseInfo1);
            objectOS.flush();
            byte[] caseInfoBytes1 = byteArrayOS.toByteArray();
            objectOS.close();
            
            byteArrayOS = new ByteArrayOutputStream();
            objectOS = new ObjectOutputStream(byteArrayOS);
            objectOS.writeObject(caseInfo2);
            objectOS.flush();
            byte[] caseInfoBytes2 = byteArrayOS.toByteArray();
            objectOS.close();
            
            byteArrayOS = new ByteArrayOutputStream();
            objectOS = new ObjectOutputStream(byteArrayOS);
            objectOS.writeObject(effort1);
            objectOS.flush();
            byte[] workBytes1 = byteArrayOS.toByteArray();
            objectOS.close();
            
            byteArrayOS = new ByteArrayOutputStream();
            objectOS = new ObjectOutputStream(byteArrayOS);
            objectOS.writeObject(effort2);
            objectOS.flush();
            byte[] workBytes2 = byteArrayOS.toByteArray();
            objectOS.close();
            
            st.setString(1, "DummyCase1");
            st.setBytes(3, caseInfoBytes1);
            st.setBytes(2, workBytes1);
            st.execute();
            st.setString(1, "DummyCase2");
            st.setBytes(2, workBytes2);
            st.setBytes(3, caseInfoBytes2);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void testWork(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
        
        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            Statement statement = db.createStatement();
            ResultSet results = statement.executeQuery("SELECT work "
                                                     + "FROM cases "
                                                     + "WHERE caseID = 'DummyCase1'");
            results.next();
            byte[] bytes = results.getBytes(1);
            
            System.out.println(Arrays.toString(bytes));
            
            ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(bytes);
            ObjectInputStream objectIS = new ObjectInputStream(byteArrayIS);
            
            IWork work = (IWork)objectIS.readObject();
            
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
