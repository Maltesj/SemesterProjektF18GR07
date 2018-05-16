/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.IActionplan;
import acquaintance.IDataFacade;
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
            BusinessFacade business = BusinessFacade.getInstance();
            IDataFacade data = business.getDataFacade();
            
            CaseInformation Cinfo = (CaseInformation) data.getCaseInfo(this.currentCaseID);
            
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
        BusinessFacade business = BusinessFacade.getInstance();
        IDataFacade data = business.getDataFacade();
        Information info = cases.get(currentCaseID);
        data.save(info, currentCaseID);
        
        if (currentCaseID == null) {
            return false;
        }
        return true;
    }
    
    /**
     * The method goes through the assessmentsfields and returns the missing fields after saving the case
     * @return Returns a set with the missing obligatory fields
     */
    Set<String> done() {
        Information info = cases.get(currentCaseID);
        return this.state.done(info);
    }
    
    /**
     * The method writes a string and it's source to an Information class
     * @param text
     * @param sourceInfo
     */
    void write(String text, String sourceInfo) {
        Information info = cases.get(currentCaseID); //Hard coded case as input
        this.state.write(text, sourceInfo, info);
    }
    
    /**
     * The method returns the case information
     * @return Returns a map with information and its source
     */
    Map<String, String> getCaseInformation() {
        Information info = cases.get(currentCaseID);
        Map<String, String> caseinfo = info.getCaseInformation().getInformation();
        
        return caseinfo;
    }
    
    Set<String> checkFields(){
        
        return this.state.checkFields(this.cases.get(this.currentCaseID));
//        
//        Information info = this.cases.get(this.currentCaseID);
//        
//        Set<String> filledFields = info.getFilledAssessmentFields();
//        
//        Set<String> missingFields = this.checkList.checkCollection(filledFields, "assessment");
//        
//        return missingFields;
    }
    
    Map<String,String> startActionPlan(String caseWorkerID, String caseID){
        IWork work = BusinessFacade.getInstance().getDataFacade().getWork();
        Information info = this.cases.get(caseID);
        ActionplanInformation actionplan = new ActionplanInformation(work);
        
        info.setActionplanInformation(actionplan);
        
        return actionplan.getInformation();
    }
    
    Map<String, String> continueActionPlan(){
        
        ActionplanInformation actionplan = (ActionplanInformation)BusinessFacade.getInstance().getDataFacade().getActionPlan();
        
        Map<String, String> fieldInfo = actionplan.getInformation();
        
        Information info = this.cases.get(this.currentCaseID);
        
        info.setActionplanInformation(actionplan);
        
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
    
    void setState(String phase){
        
        switch(phase){
            case "Actionplan":
                this.state = new ActionplanState();
                break;
            case "Assessment":
                this.state = new AssessmentState();
                break;
        }
        
    }
}