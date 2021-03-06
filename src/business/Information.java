/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.IInformation;
import java.io.Serializable;

/** Class for holding case information and asssessment information
 *
 * @author malte
 */
public class Information implements Serializable, IInformation{
    private String caseID;
    private AssessmentInformation assessmentInformation;
    private CaseInformation caseInformation;
    private ActionplanInformation actionplanInformation;

    /** Constructor for information
     *
     * @param caseID String identifier
     * @param caseInformation CaseInformation object
     */
    public Information(String caseID, CaseInformation caseInformation){
        this.caseID = caseID;
        System.out.println(caseID);
        this.caseInformation = caseInformation;
        System.out.println(caseInformation);
        this.assessmentInformation = new AssessmentInformation();
        System.out.println(assessmentInformation);
    }

    public Information(String caseID, CaseInformation caseInformation, ActionplanInformation actionplanInformation) {
        this(caseID, caseInformation);
    }

    AssessmentInformation getAssessmentInformation() {
        return assessmentInformation;
    }

    void setAssessmentInformation(AssessmentInformation assessmentInformation) {
        this.assessmentInformation = assessmentInformation;
    }

    void setCaseInformation(CaseInformation caseInformation) {
        this.caseInformation = caseInformation;
    }

    CaseInformation getCaseInformation(){
        return caseInformation;
    }
    
    void setActionplanInformation(ActionplanInformation actionplanInformation) {
        this.actionplanInformation = actionplanInformation;
    }

    ActionplanInformation getActionplanInformation() {
        return actionplanInformation;
    }
    

    /** Method to get case ID
     *
     * @return the case ID as a String
     */
    String getCaseID(){
        return caseID;
    }

  
    
}