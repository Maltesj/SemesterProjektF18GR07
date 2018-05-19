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
    private CaseInfoLoader caseInfoLoader;
    private SaveInformation si;
    
    public static DataFacade getInstance(){
        if (instance == null) {
            instance = new DataFacade();
        }
        
        return instance;
    }
    
    private DataFacade(){
        caseInfoLoader = new CaseInfoLoader();
        si = new SaveInformation();
        
    }

    @Override
    public ICaseInformation getCaseInfo(String caseID) {
        return caseInfoLoader.getCaseInfo(caseID);
    }

    @Override
    public void save(IInformation info, String caseID) {
        si.saveInformation(info, caseID);
    }

    @Override
    public Set<String> getCaseIDs() {
        return caseInfoLoader.getCaseIDs();
    }

    @Override
    public IWork getWork(String caseID) {
        return this.caseInfoLoader.getWork(caseID);
    }

    @Override
    public boolean discard(EnumPhases phase, String caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean savePhase(IInformation info, EnumPhases phase, String caseID) {
        this.save(info, caseID);  
        return true; // temp
    }

    @Override
    public IActionplan getActionPlan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void saveDatabase(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan){
        
    }
    void saveDatabase(ICaseInformation caseInfo){
        
    }
    void saveDatebase(IAssessment assessment){
        
    }
    void saveDatebase(IActionplan actionplan){
        
    }
    void saveDatabase(IWork work){
        
    }
    void saveLocal(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan){
        
    }
    void saveLocal(ICaseInformation caseInfo){
        
    }
    void saveLocal(IWork work){
        
    }
    void saveLocal(IAssessment assessment){
        
    }
    void saveLocal(IActionplan actionpan){
        
    }
    ICaseInformation loadCaseInformationDatabase(){
        return null;
        
    }
    IAssessment loadAssessmentDatabase(){
        return null;
        
    }
    IActionplan loadActionplanDatabase(){
        return null;
        
    }
    IWork loadWorkDatabase(){
        return null;
        
    }
    ICaseInformation loadCaseInformationLocal(){
        return null;
        
    }
    IAssessment loadAssessmentLocal(){
        return null;
        
    }
    IActionplan loadActionplanLocal(){
        return null;
        
    }
    IWork loadWorkLocal(){
        return null;
        
    }
    
    

}
