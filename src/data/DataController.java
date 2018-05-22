/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.IActionplan;
import acquaintance.ICaseInformation;
import acquaintance.IWork;
import acquaintance.IAssessment;
import java.io.File;
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
        SaveDatabaseRun saveRunnable = new SaveDatabaseRun(work, caseInfo, assessment, actionplan, caseID);
        
        Thread saveThread = new Thread(saveRunnable);
        
        saveThread.start();       
    }
    
    void saveDatabase(ICaseInformation caseInfo, String caseID){
        SaveDatabaseRun saveRunnable = new SaveDatabaseRun(caseInfo, caseID);
        
        Thread saveThread = new Thread(saveRunnable);
        
        saveThread.start();
    }
    
    void saveDatebase(IAssessment assessment, String caseID){
        SaveDatabaseRun saveRunnable = new SaveDatabaseRun(assessment, caseID);
        
        Thread saveThread = new Thread(saveRunnable);
        
        saveThread.start();
    }
    
    void saveDatebase(IActionplan actionplan, String caseID){
        SaveDatabaseRun saveRunnable = new SaveDatabaseRun(actionplan, caseID);
        
        Thread saveThread = new Thread(saveRunnable);
        
        saveThread.start();
    }
    
    void saveDatabase(IWork work, String caseID){
        SaveDatabaseRun saveRunnable = new SaveDatabaseRun(work, caseID);
        
        Thread saveThread = new Thread(saveRunnable);
        
        saveThread.start();
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
        return new LoadDatabase().loadCaseInformation();
        
    }
    
    IAssessment loadAssessmentDatabase(String caseID){
        return new LoadDatabase().loadAssessment();
    }
    
    IActionplan loadActionplanDatabase(String caseID){
        return new LoadDatabase().loadActionplan();
        
    }
    
    IWork loadWorkDatabase(String caseID){
        return new LoadDatabase().loadWork();
        
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
        
        File file = new File("assets\\");
        String[] files = file.list(); 
        for (int i = 0; i < files.length; i++) {
            int endIndex = files[i].indexOf('.');
            if(endIndex != -1) {
                caseIDs.add(files[i].substring(0, endIndex));
            }
        }
     
        return caseIDs;
    }

}