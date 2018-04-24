/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.HashMap;
import java.util.Set;

/** Class for holding case information and asssessment information
 *
 * @author malte
 */
public class Information {
  private String caseID;
  private AssessmentInformation assessmentInformation;
  private CaseInformation caseInformation;
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
/** Method to get case ID 
 * 
 * @return the case ID as a String
 */
public String getCaseID(){
  return caseID;  
}
/** Method for writing to assessment information
 * 
 * @param text is the value part of the hashmap
 * @param sourceInfo is the key of the hashmap
 */
void write(String text, String sourceInfo){
 assessmentInformation.write(text, sourceInfo);
}
/** Method to get keyset for filled fields from assessment information
 * 
 * @return the keyset from hashmap in assessment information
 */
Set<String> getFilledAssessmentFields(){
 return assessmentInformation.getFilledFields();
}
/** Method for getting the case information in the hashmap
 * 
 * @return hashmap from case information
 */
HashMap<String, String> getCaseInformation(){
  return caseInformation.getInformation() ;  
}
}
