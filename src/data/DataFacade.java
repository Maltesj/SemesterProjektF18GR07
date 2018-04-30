/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.ICaseInformation;
import acquaintance.IDataFacade;
import business.Information;
import java.util.Set;
import java.util.TreeSet;

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
    public void save(Information info, String caseID) {
        si.saveInformation(info, caseID);
    }

    @Override
    public Set<String> getCaseIDs() {
        return caseInfoLoader.getCaseIDs();
    }

}