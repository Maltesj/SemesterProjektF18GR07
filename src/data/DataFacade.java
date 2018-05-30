/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


import acquaintance.EnumPhases;
import acquaintance.IActionplan;
import acquaintance.ICaseInformation;
import acquaintance.IDataFacade;
import acquaintance.IInformation;
import acquaintance.IWork;
import acquaintance.IAssessment;
import java.util.Set;

/**
 *
 * @author HCHB
 */
public class DataFacade implements IDataFacade{
    
    private static DataFacade instance;
    private DataController dataController;
    
    public static DataFacade getInstance(){
        if (instance == null) {
            instance = new DataFacade();
        }
        
        return instance;
    }
    
    private DataFacade(){
        this.dataController = new DataController();
    }
    
    @Override
    public Set<String> getCaseIDs() {
        return this.dataController.getCaseIDs();
    }

    @Override
    public boolean discard(EnumPhases phase, String caseID) {
        return this.dataController.discard(phase, caseID);
    }

    @Override
    public void saveDatabase(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan, String caseID){
        this.dataController.saveDatabase(work, caseInfo, assessment, actionplan, caseID);
    }
  
    @Override
    public void saveDatabase(ICaseInformation caseInfo, String caseID){
        this.dataController.saveDatabase(caseInfo, caseID);
    }
    
    @Override
    public void saveDatebase(IAssessment assessment, String caseID){
        this.dataController.saveDatebase(assessment, caseID);
    }
    
    @Override
    public void saveDatebase(IActionplan actionplan, String caseID){
        this.dataController.saveDatebase(actionplan, caseID);
    }
    
    @Override
    public void saveDatabase(IWork work, String caseID){
        this.dataController.saveDatabase(work, caseID);
    }
    
    @Override
    public void saveLocal(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan, String caseID){
        this.dataController.saveLocal(work, caseInfo, assessment, actionplan, caseID);
    }
    
    @Override
    public void saveLocal(ICaseInformation caseInfo, String caseID){
        this.dataController.saveLocal(caseInfo, caseID);
    }
    
    @Override
    public void saveLocal(IWork work, String caseID){
        this.dataController.saveLocal(work, caseID);
    }
    
    @Override
    public void saveLocal(IAssessment assessment, String caseID){
        this.dataController.saveLocal(assessment, caseID);
    }
    
    @Override
    public void saveLocal(IActionplan actionpan, String caseID){
        this.dataController.saveLocal(actionpan, caseID);
    }
    
    @Override
    public ICaseInformation loadCaseInformationDatabase(String caseID){
       return this.dataController.loadCaseInformationDatabase(caseID);
    }
    
    @Override
    public IAssessment loadAssessmentDatabase(String caseID){
        return this.dataController.loadAssessmentDatabase(caseID);
    }
    
    @Override
    public IActionplan loadActionplanDatabase(String caseID){
        return this.dataController.loadActionplanDatabase(caseID);
    }
    
    @Override
    public IWork loadWorkDatabase(String caseID){
        return this.dataController.loadWorkDatabase(caseID);
    }
    
    @Override
    public ICaseInformation loadCaseInformationLocal(String caseID){
        return this.dataController.loadCaseInformationLocal(caseID);
    }
    
    @Override
    public IAssessment loadAssessmentLocal(String caseID){
        return this.dataController.loadAssessmentDatabase(caseID);
    }
    
    @Override
    public IActionplan loadActionplanLocal(String caseID){
        return this.dataController.loadActionplanLocal(caseID);
    }
    
    @Override
    public IWork loadWorkLocal(String caseID){
        return this.dataController.loadWorkLocal(caseID);
    }

}
