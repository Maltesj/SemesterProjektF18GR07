/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

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
     * Returns the IDataFacade in this object
     * @return The IDataFacade in this object
     */
    IDataFacade getDataFacade(){
        return this.dataFacade;
    }
    
    /**
     * Initializes an assessment of a case and loads the case information
     * @param caseID ID of a case
     * @param caseWorkerID ID of a case worker
     * @return 
     */
    @Override
    public boolean startAssessment(String caseID, String caseWorkerID) {
        boolean returnValue = this.udred.startAssessment(caseID, caseWorkerID);
        return returnValue;
    }
    
    /**
     * Saves the current case to the database
     * @return True if the case exists in Udred
     */
    @Override
    public boolean save() {
        boolean returnValue = this.udred.save();
        return returnValue;
    }
    
    /**
     * Checks if the obligatory fields are filled and saves the case to the database
     * @return The set of obligatory fields that aren't filled
     */
    @Override
    public Set<String> done() {
        Set<String> returnValue = this.udred.done();
        return returnValue;
    }
    
    /**
     * Writes text and its source to the current case
     * @param text A string of text
     * @param sourceInfo A string describing the source of the text
     */
    @Override
    public void write(String text, String sourceInfo) {
        this.udred.write(text, sourceInfo);
    }
    
    /**
     * Returns the case information corresponding to the case ID
     * @param CaseID ID of a case
     * @return 
     */
    @Override
    public Map<String, String> getCaseInformation(String CaseID) {
        Map<String, String> returnValue = this.udred.getCaseInformation();
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
    public Set<String> checkFields() {
        return this.udred.checkFields();
        
    }

    @Override
    public Map<String, String> startActionPlan(String caseWorkerID, String caseID) {
        return this.udred.startActionPlan(caseWorkerID, caseID);
    }

    @Override
    public Map<String, String> continueActionPlan() {
        return this.udred.continueActionPlan();
    }

    @Override
    public void discardPhase() {
        this.udred.discardPhase();
    }

    @Override
    public boolean savePhase() {
        return this.udred.savePhase();
    }
    
    @Override
    public void setState(String phase){
        this.udred.setState(phase);
    }
    
    boolean savePhase(Information info, String phase, String caseID){
        return this.dataFacade.savePhase(info, phase, caseID);
    }
    
    boolean discard(String phase, String cseID){
        return this.dataFacade.discard(phase, cseID);
    }
    
    IActionplan getActionPlan(){
        return this.dataFacade.getActionPlan();
    }
    
    IWork getWork(){
        return this.dataFacade.getWork();
    }
    
    void save(Information info, String caseID){
        this.dataFacade.save(info, caseID);
    }
    
    ICaseInformation getCaseInfo(String caseID){
        return this.dataFacade.getCaseInfo(caseID);
    }
    
}