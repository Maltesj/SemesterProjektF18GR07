/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.IDataFacade;
import java.util.Map;

/**
 *
 * @author malte
 */
public class Udred {
    private String currentCaseWorkerID;
    private String currentCaseID;
    private Map<String, Information> cases;
    
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
    
    
}
