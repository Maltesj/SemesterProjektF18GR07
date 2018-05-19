/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.Checklistable;
import acquaintance.EnumPhases;
import acquaintance.IWork;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author malte
 */
public class Udred {
    
    /**
     * ID of the current case worker
     */
    private String currentCaseWorkerID;
    /**
     * ID of the current case
     */
    private String currentCaseID;
    /**
     * A map containing information about the cases and the case IDs as keys
     */
    private Map<String, Information> cases;
    /**
     * A CheckList object
     */
    private CheckList checkList;
    
    private IUdredState state;
    
    Udred(){
        this.checkList = new CheckList();
        this.cases = new HashMap<>();
    }
    
    /**
     * The method loads case information and sets up for the assessment.
     *
     * @param caseID The ID of the current case
     * @param caseWorkerID The ID of the current caseworker
     * @return Returns true if there was case information in the database
     */
    boolean startAssessment(String caseID, String caseWorkerID) {
        this.currentCaseID = caseID;
        this.currentCaseWorkerID = caseWorkerID;
        
        if (!this.cases.containsKey(caseID)) {
            CaseInformation Cinfo = (CaseInformation) BusinessFacade.getInstance().getCaseInfo(this.currentCaseID);
            
            Information info = new Information(caseID, Cinfo);
            cases.put(caseID, info);
            
            if (info == null) {
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * The method sends the current case to the database
     * @return Returns true if the current case wasn't null
     */
    boolean save() {
        Information info = cases.get(currentCaseID);
        BusinessFacade.getInstance().save(info, currentCaseID);
        
        if (currentCaseID == null) {
            return false;
        }
        return true;
    }
    
    /**
     * The method goes through the assessmentsfields and returns the missing fields after saving the case
     * @return Returns a set with the missing obligatory fields
     */
    Set<Checklistable> done() {
        Information info = cases.get(currentCaseID);
        return this.state.done(info);
    }
    
    /**
     * The method writes a string and it's source to an Information class
     * @param text
     * @param sourceInfo
     */
    void write(String text, Checklistable sourceInfo) {
        Information info = cases.get(currentCaseID); //Hard coded case as input
        this.state.write(text, sourceInfo, info);
    }
    
    /**
     * The method returns the case information
     * @return Returns a map with information and its source
     */
    Map<Checklistable, String> getCaseInformation() {
        Information info = cases.get(currentCaseID);
        Map<Checklistable, String> caseInfo = info.getCaseInformation().getInformation();
        
        return caseInfo;
    }
    
    Set<Checklistable> checkFields(){
        
        return this.state.checkFields(this.cases.get(this.currentCaseID));
    }
    
    Map<Checklistable, String> startActionPlan(String caseWorkerID, String caseID){
        IWork work = BusinessFacade.getInstance().getWork(caseID);
        Information info = this.cases.get(caseID);
        ActionplanInformation actionplan = new ActionplanInformation(work);
        
        info.setActionplanInformation(actionplan);
        
        return actionplan.getInformation();
    }
    
    Map<Checklistable, String> continueActionPlan(){
        Information info = this.cases.get(this.currentCaseID);
        
        ActionplanInformation actionplan = (ActionplanInformation)BusinessFacade.getInstance().getActionPlan();
        info.setActionplanInformation(actionplan);
        
        Map<Checklistable, String> fieldInfo = actionplan.getInformation();
        
        return fieldInfo;
    }
    
    void discardPhase(){
        Information info = this.cases.get(this.currentCaseID);
        this.state.discard(info);
    }
    
    boolean savePhase(){
        Information info = this.cases.get(this.currentCaseID);
        return this.state.savePhase(info);
    }
    
    void setState(EnumPhases phase){
        
        switch(phase){
            case ACTIONPLAN:
                this.state = new ActionplanState();
                break;
            case ASSESSMENT:
                this.state = new AssessmentState();
                break;
            case INFORMATION:
                break;
        }
        
    }
}