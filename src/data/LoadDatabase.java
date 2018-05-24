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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
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
    
    IWork loadWork(String caseID){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
        
        IWork work = null;
        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            
            Statement statement = db.createStatement();
            ResultSet results = statement.executeQuery("Select work "
                    + "From cases "
                    + "Where caseID = '"+caseID+"' "
                            + "AND date_last_changed = (Select MAX(date_last_Changed) "
                            + "From cases "
                            + "Where caseID = '"+caseID+"')");
            
            results.next();
            byte[] bytes = results.getBytes(1);
            
            ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(bytes);
            ObjectInputStream objectIS = new ObjectInputStream(byteArrayIS);
            
            work = (IWork)objectIS.readObject();
            
            return work;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return work; // temp
    }
    
    IAssessment loadAssessment(String caseID){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
        
        IAssessment assessment = null;
        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            
            Statement statement = db.createStatement();
            ResultSet results = statement.executeQuery("Select assessment "
                    + "From cases "
                    + "Where caseID = '"+caseID+"' "
                            + "AND date_last_changed = (Select MAX(date_last_Changed) "
                            + "From cases "
                            + "Where caseID = '"+caseID+"')");
            
            results.next();
            byte[] bytes = results.getBytes(1);
            
            ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(bytes);
            ObjectInputStream objectIS = new ObjectInputStream(byteArrayIS);
            
            assessment = (IAssessment)objectIS.readObject();
            
            return assessment;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return assessment; // temp
    }
    
    IActionplan loadActionplan(String caseID){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
        
        IActionplan actionplan = null;
        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            
            Statement statement = db.createStatement();
            ResultSet results = statement.executeQuery("Select actionplan "
                    + "From cases "
                    + "Where caseID = '"+caseID+"' "
                            + "AND date_last_changed = (Select MAX(date_last_Changed) "
                            + "From cases "
                            + "Where caseID = '"+caseID+"')");
            
            results.next();
            byte[] bytes = results.getBytes(1);
            
            ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(bytes);
            ObjectInputStream objectIS = new ObjectInputStream(byteArrayIS);
            
            actionplan = (IActionplan)objectIS.readObject();
            
            return actionplan;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return actionplan; // temp
    }
    
    ICaseInformation loadCaseInformation(String caseID){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
        
        ICaseInformation caseInfo = null;
        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            
            Statement statement = db.createStatement();
            ResultSet results = statement.executeQuery("Select case_information "
                    + "From cases "
                    + "Where caseID = '"+caseID+"' "
                            + "AND date_last_changed = (Select MAX(date_last_Changed) "
                            + "From cases "
                            + "Where caseID = '"+caseID+"')");
            
            results.next();
            byte[] bytes = results.getBytes(1);
            
            ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(bytes);
            ObjectInputStream objectIS = new ObjectInputStream(byteArrayIS);
            
            caseInfo = (ICaseInformation)objectIS.readObject();
            
            return caseInfo;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return caseInfo; // temp
    }
    
    public static void main(String[] args) {
        String caseID = "DummyCase1";
        LoadDatabase load = new LoadDatabase();
        
//        IWork work = load.loadWork(caseID);
//        ICaseInformation info = load.loadCaseInformation(caseID);
//        IAssessment ass = load.loadAssessment(caseID);
//        IActionplan action = load.loadActionplan(caseID);
        load.updateTest();
        
        System.out.println("");
    }
    
    private void updateTest(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
        
        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            
            Statement statement = db.createStatement();
            statement.executeUpdate("Insert into cases("
                    + "date_last_changed, "
                    + "caseID, "
                    + "date_created, "
                    + "work, "
                    + "assessment, "
                    + "actionplan, "
                    + "case_information "
                    + ") values(CAST('2006-05-09' AS DATE), "
                    + "(Select caseID From cases where caseID = 'DummyCase1' AND date_last_changed = (select max(date_last_changed) From cases where caseID = 'DummyCase1')), "
                    + "(Select date_created From cases where caseID = 'DummyCase1' AND date_last_changed = (select max(date_last_changed) From cases where caseID = 'DummyCase1')), "
                    + "(Select work From cases where caseID = 'DummyCase1' AND date_last_changed = (select max(date_last_changed) From cases where caseID = 'DummyCase1')), "
                    + "(Select assessment From cases where caseID = 'DummyCase1' AND date_last_changed = (select max(date_last_changed) From cases where caseID = 'DummyCase1')), "
                    + "(Select actionplan From cases where caseID = 'DummyCase1' AND date_last_changed = (select max(date_last_changed) From cases where caseID = 'DummyCase1')), "
                    + "(Select case_information From cases where caseID = 'DummyCase1' AND date_last_changed = (select max(date_last_changed) From cases where caseID = 'DummyCase1')))");
                                     
            
//            , date_created, work, assessment, actionplan, case_information
//            
//            + "ORDER BY caseID "
//                                     + "DESC LIMIT 1))");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

//            PreparedStatement st = db.prepareStatement("Select ? "
//                                                     + "From cases "
//                                                     + "Where caseID = '?' "
//                                                     + "AND date_last_changed = '(Select MAX(date_last_Changed) "
//                                                                             + "From cases "
//                                                                             + "Where caseID = '?')'");

//            st.setString(0, "work");
//            st.setString(1, "work");
//            st.setString(2, caseID);
//            st.setString(3, caseID);
//            ResultSet results =  st.executeQuery();
