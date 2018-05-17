/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.IActionplan;
import acquaintance.ICaseInformation;
import acquaintance.IDataFacade;
import acquaintance.IInformation;
import acquaintance.IWork;
import java.util.Set;

/**
 *
 * @author HCHB
 */
public class DataFacade implements IDataFacade{
    
    private static DataFacade instance;
    private CaseInfoLoader caseInfoLoader;
    private SaveInformation si;
    
    public static DataFacade getInstance(){
        if (instance == null) {
            instance = new DataFacade();
        }
        
        return instance;
    }
    
    private DataFacade(){
        caseInfoLoader = new CaseInfoLoader();
        si = new SaveInformation();
        
    }

    @Override
    public ICaseInformation getCaseInfo(String caseID) {
        return caseInfoLoader.getCaseInfo(caseID);
    }

    @Override
    public void save(IInformation info, String caseID) {
        si.saveInformation(info, caseID);
    }

    @Override
    public Set<String> getCaseIDs() {
        return caseInfoLoader.getCaseIDs();
    }

    @Override
    public IWork getWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean discard(String phase, String caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean savePhase(IInformation info, String phase, String caseID) {
        this.save(info, caseID);  
        return true; // temp
    }

    @Override
    public IActionplan getActionPlan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}