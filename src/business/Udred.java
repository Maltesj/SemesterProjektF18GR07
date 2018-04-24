/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.IDataFacade;
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
    
    /**
     * The method loads case information and sets up for the assessment.
     *
     * @param caseID The ID of the current case
     * @param caseWorkerID The ID of the current caseworker
     * @return Returns true if there was case information in the database
     */
    public boolean startAssessment(String caseID, String caseWorkerID) {
        this.currentCaseID = caseID;
        this.currentCaseWorkerID = caseWorkerID;
        
        BusinessFacade business = BusinessFacade.getInstance();
        IDataFacade data = business.getDataFacade();
        CaseInformation Cinfo = (CaseInformation) data.getInfo();
        
        Information info = new Information(caseID, Cinfo);
        cases.put(caseID, info);
        if (info == null) {
            return false;
        }
        return true;
    }
    
    /**
     * The method sends the current case to the database
     * @return Returns true if the current case wasn't null
     */
    public boolean save() {
        BusinessFacade business = BusinessFacade.getInstance();
        IDataFacade data = business.getDataFacade();
        
        data.save(cases.get(currentCaseID));
        
        if (currentCaseID == null) {
            return false;
        }
        return true;
    }
    
    /**
     * The method goes through the assessmentsfields and returns the missing fields after saving the case
     * @return Returns a set with the missing obligatory fields
     */
    public Set<String> done() {
        Information info = cases.get(currentCaseID);
        Set<String> filedAssessment = info.getFilledAssessmentFields();
        
        Set<String> missingFields = checkList.checkCollection(filedAssessment);
        
        BusinessFacade business = BusinessFacade.getInstance();
        IDataFacade data = business.getDataFacade();
        data.save(info);
        
        return missingFields;
    }
    
    /**
     * The method writes a string and it's source to an Information class
     * @param text
     * @param sourceInfo
     */
    public void write(String text, String sourceInfo) {
        Information info = cases.get(text);
        info.write(text, sourceInfo);
    }
    
    /**
     * The method returns the case information
     * @return Returns a map with information and its source
     */
    public Map<String, String> getCaseInformation() {
        Information info = cases.get(currentCaseID);
        Map<String, String> caseinfo = info.getCaseInformation();
        
        return caseinfo;
    }
    
}