/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.Checklistable;
import acquaintance.EnumPhases;
import acquaintance.IActionplan;
import acquaintance.IBusinessFacade;
import acquaintance.ICaseInformation;
import acquaintance.IDataFacade;
import acquaintance.IWork;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author HCHB
 */
public class BusinessFacade implements IBusinessFacade {
    
    /**
     * A static instance of BusinessFacade
     */
    private static BusinessFacade instance;
    /**
     * An instance of IDataFacade
     */
    private IDataFacade dataFacade;
    /**
     * An instance of Udred
     */
    private Udred udred;
    
    /**
     * The method returns the an instance of BusinessFacade if it exits and otherwise creates one
     * @return The static instance of BusinessFacade
     */
    public static BusinessFacade getInstance(){
        if (instance == null) {
            instance = new BusinessFacade();
        }
        
        return instance;
    }
    
    /**
     * Private constructor for BusinessFacade to prevent outside instantiation
     */
    private BusinessFacade(){
        this.udred = new Udred();
    }
    
    /**
     * The methods gets and saves an IDataFacade in this object
     * @param dataFacade
     */
    @Override
    public void injectDataFacade(IDataFacade dataFacade){
        this.dataFacade = dataFacade;
    }
    
    /**
     * Initializes an assessment of a case and loads the case information
     * @param caseID ID of a case
     * @param caseWorkerID ID of a case worker
     * @return
     */
    @Override
    public boolean startAssessment(String caseID, String caseWorkerID, boolean online) {
        boolean returnValue = this.udred.startAssessment(caseID, caseWorkerID, online);
        return returnValue;
    }
    
    /**
     * Saves the current case to the database
     * @return True if the case exists in Udred
     */
    @Override
    public boolean save(boolean online) {
        boolean returnValue = this.udred.save(online);
        return returnValue;
    }
    
    /**
     * Checks if the obligatory fields are filled and saves the case to the database
     * @return The set of obligatory fields that aren't filled
     */
    @Override
    public Set<Checklistable> done(boolean online) {
        Set<Checklistable> returnValue = this.udred.done(online);
        return returnValue;
    }
    
    /**
     * Writes text and its source to the current case
     * @param text A string of text
     * @param sourceInfo A string describing the source of the text
     */
    @Override
    public void write(String text, Checklistable sourceInfo) {
        this.udred.write(text, sourceInfo);
    }
    
    /**
     * Returns the case information corresponding to the case ID
     * @param CaseID ID of a case
     * @return
     */
    @Override
    public Map<Checklistable, String> getCaseInformation(String CaseID) {
        Map<Checklistable, String> returnValue = this.udred.getCaseInformation();
        return returnValue;
    }
    
    /**
     * Returns all the case IDs in the database
     * @return Set of case IDs
     */
    @Override
    public Set<String> getCaseIDs() {
        Set<String> returnValue = this.dataFacade.getCaseIDs();
        return returnValue;
    }
    
    @Override
    public Set<Checklistable> checkFields() {
        return this.udred.checkFields();
    }
    
    @Override
    public Map<Checklistable, String> startActionPlan(String caseWorkerID, String caseID, boolean online) {
        return this.udred.startActionPlan(caseWorkerID, caseID, online);
    }
    
    @Override
    public Map<Checklistable, String> continueActionPlan(boolean online) {
        return this.udred.continueActionPlan(online);
    }
    
    @Override
    public void discardPhase() {
        this.udred.discardPhase();
    }
    
    
    
    @Override
    public void setState(EnumPhases phase){
        this.udred.setState(phase);
    }
    
    
    
    boolean discard(EnumPhases phase, String caseID){ // temp
        return this.dataFacade.discard(phase, caseID);
    }
    
    IActionplan getActionPlan(String caseID, boolean online){
        if (online) {
            return this.dataFacade.loadActionplanDatabase(caseID);
        }
        else{
            return this.dataFacade.loadActionplanLocal(caseID);
        }
    }
    
    IWork getWork(String caseID, boolean online){
        if (online) {
            return this.dataFacade.loadWorkDatabase(caseID);
        }
        else{
            return this.dataFacade.loadWorkLocal(caseID);
        }
    }
    
    ICaseInformation getCaseInfo(String caseID, boolean online){
        if (online) {
            return this.dataFacade.loadCaseInformationDatabase(caseID);
        }
        else{
            return this.dataFacade.loadCaseInformationLocal(caseID);
        }
    }
    
    void saveCaseInfo(CaseInformation caseInfo, String caseID, boolean online){
        if (online) {
            this.dataFacade.saveDatabase(caseInfo, caseID);
        }
        else{
            this.dataFacade.saveLocal(caseInfo, caseID);
        }
    }
    
    void saveWork(Work work, String caseID, boolean online){
        if (online) {
            this.dataFacade.saveDatabase(work, caseID);
        }
        else{
            this.dataFacade.saveLocal(work, caseID);
        }
    }
    
    void saveActionplan(ActionplanInformation actionplan, String caseID, boolean online){
        if (online) {
            this.dataFacade.saveDatebase(actionplan, caseID);
        }
        else{
            this.dataFacade.saveLocal(actionplan, caseID);
        }
    }
    
    void saveAssessment(AssessmentInformation assessment, String caseID, boolean online){
        if (online) {
           this.dataFacade.saveDatebase(assessment, caseID);
        }
        else{
            this.dataFacade.loadActionplanLocal(caseID);
        }
    }

    @Override
    public boolean savePhase(boolean online) {
        return this.udred.savePhase(online);
    }
    
    void save(AssessmentInformation assessment, ActionplanInformation actionplan, CaseInformation caseInfo, String caseID, boolean online){
        if (online) {
           this.dataFacade.saveDatebase(assessment, caseID);
        }
        else{
            this.dataFacade.loadActionplanLocal(caseID);
            this.dataFacade.saveLocal(assessment, caseID);
        }
    }
    
}