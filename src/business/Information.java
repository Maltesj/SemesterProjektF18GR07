/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author malte
 */
public class Information {
  private String caseID;
  private AssessmentInformation assessmentInformation;
  private CaseInformation caseInformation;

public Information(String caseID, CaseInformation caseInformation){
  this.caseID = caseID;
    System.out.println(caseID);
  this.caseInformation = caseInformation;
    System.out.println(caseInformation);
  this.assessmentInformation = new AssessmentInformation();
    System.out.println(assessmentInformation);
}
public String getCaseID(){
  return caseID;  
}
void write(String text, String sourceInfo){
 assessmentInformation.write(text, sourceInfo);
}
Set<String> getFilledAssessmentFields(){
 return assessmentInformation.getFilledFields();
}
HashMap<String, String> getCaseInformation(){
  return caseInformation.getInformation() ;  
}
}
