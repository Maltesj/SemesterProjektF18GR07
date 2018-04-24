/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.IBusinessFacade;
import acquaintance.IDataFacade;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author HCHB
 */
public class BusinessFacade implements IBusinessFacade {
    
    private static BusinessFacade instance;
    private IDataFacade dataFacade;
    private Udred udred;
    
    public static BusinessFacade getInstance(){
        if (instance == null) {
            instance = new BusinessFacade();
        }
        
        return instance;
    }
    
    private BusinessFacade(){
        this.udred = new Udred();
    }
    
    @Override
    public void injectDataFacade(IDataFacade dataFacade){
        this.dataFacade = dataFacade;
        
    }
   IDataFacade getDataFacade(){
       return this.dataFacade;
   } 

    @Override
    public boolean startAssessment(String caseID, String caseWorkerID) {
        boolean returnValue = this.udred.startAssessment(caseID, caseWorkerID);
        return returnValue;
    }

    @Override
    public boolean save() {
        boolean returnValue = this.udred.save();
        return returnValue;
    }

    @Override
    public Set<String> done() {
        Set<String> returnValue = this.udred.done();
        return returnValue;
    }

    @Override
    public void write(String text, String sourceInfo) {
        this.udred.write(text, sourceInfo);
    }

    @Override
    public Map<String, String> getCaseInformation(String CaseID) {
        Map<String, String> returnValue = this.udred.getCaseInformation();
        return returnValue;
    }

    @Override
    public Set<String> getCaseIDs() {
        Set<String> returnValue = this.dataFacade.getCaseIDs();
        return returnValue;
    }
   
}
