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
    private String currentCaseWorkerID;
    private String currentCaseID;
    private Map<String, Information> cases;
    private CheckList checkList;
    
    public boolean startAssessment(String caseID , String caseWorkerID) {
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
    
    public boolean save(){
       BusinessFacade business = BusinessFacade.getInstance();
       IDataFacade data = business.getDataFacade();
       
       data.save(cases.get(currentCaseID));
       
        if (currentCaseID == null) {
            return false;
        }
       return true;
        
    }
    
    public Set<String> done(){
        Information info = cases.get(currentCaseID);
        Set<String> filedAssessment = info.getFilledAssessmentFields();
        
        Set<String> missingFields = checkList.checkCollection(filedAssessment);
        
        BusinessFacade business = BusinessFacade.getInstance();
        IDataFacade data = business.getDataFacade();
        data.save(info);
        
        return missingFields;
    }
    public void write(String text, String sourceInfo){
        Information info = cases.get(text);
        info.write(text, sourceInfo);
        
    }
    public Map<String, String> getCaseInformation(){
        Information info = cases.get(currentCaseID);
        Map<String, String> caseinfo = info.getCaseInformation();
        
        return  caseinfo;
    }
    
}
