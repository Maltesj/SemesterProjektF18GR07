/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.EnumPhases;
import acquaintance.IActionplan;
import acquaintance.ICaseInformation;
import acquaintance.IWork;
import acquaintance.IAssessment;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Simon
 */
public class DataController {
    
    DataController(){
        
    }
    
    void saveDatabase(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan, String caseID){
        new DatabaseIO().save(work, caseInfo, assessment, actionplan, caseID);
    }
    
    void saveDatabase(ICaseInformation caseInfo, String caseID){
        new DatabaseIO().save(caseInfo, caseID);
    }
    
    void saveDatebase(IAssessment assessment, String caseID){
        new DatabaseIO().save(assessment, caseID);
    }
    
    void saveDatebase(IActionplan actionplan, String caseID){
        new DatabaseIO().save(actionplan, caseID);
    }
    
    void saveDatabase(IWork work, String caseID){
        new DatabaseIO().save(work, caseID);
    }
    
    void saveLocal(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan, String caseID){
        FileIO localIO = new FileIO(caseID);
        localIO.save(actionplan);
        localIO.save(assessment);
        localIO.save(caseInfo);
        localIO.save(work);
    }
    
    void saveLocal(ICaseInformation caseInfo, String caseID){
        FileIO localIO = new FileIO(caseID);
        localIO.save(caseInfo);
    }
    
    void saveLocal(IWork work, String caseID){
        FileIO localIO = new FileIO(caseID);
        localIO.save(work);
    }
    
    void saveLocal(IAssessment assessment, String caseID){
        FileIO localIO = new FileIO(caseID);
        localIO.save(assessment);
    }
    
    void saveLocal(IActionplan actionpan, String caseID){
        FileIO localIO = new FileIO(caseID);
        localIO.save(actionpan);
    }
    
    ICaseInformation loadCaseInformationDatabase(String caseID){
        return new DatabaseIO().loadCaseInformation(caseID);
    }
    
    IAssessment loadAssessmentDatabase(String caseID){
        return new DatabaseIO().loadAssessment(caseID);
    }
    
    IActionplan loadActionplanDatabase(String caseID){
        return new DatabaseIO().loadActionplan(caseID);
    }
    
    IWork loadWorkDatabase(String caseID){
        return new DatabaseIO().loadWork(caseID);
    }
    
    ICaseInformation loadCaseInformationLocal(String caseID){
        return new FileIO(caseID).loadCaseInfo();
    }
    
    IAssessment loadAssessmentLocal(String caseID){
        return new FileIO(caseID).loadAssessment();        
    }
    
    IActionplan loadActionplanLocal(String caseID){
        return new FileIO(caseID).loadActionplan();        
    }
    
    IWork loadWorkLocal(String caseID){
        return new FileIO(caseID).loadWork();        
    }
    
    Set<String> getCaseIDs(){
        Set<String> caseIDs = new TreeSet<>();
        
        try{
            DatabaseIO loadDatabase = new DatabaseIO();
            caseIDs = loadDatabase.getCaseIDs();
        }
        catch (IOException | SQLException ex) {
            File file = new File("assets\\");
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                int endIndex = files[i].indexOf('.');
                if(endIndex != -1) {
                    caseIDs.add(files[i].substring(0, endIndex));
                }
            }
        }
        
        return caseIDs;
    }

    boolean discard(EnumPhases phase, String caseID){

        new DatabaseIO().discardPhase(phase, caseID);
        new FileIO(caseID).discard(phase);
        return true;
    }
}