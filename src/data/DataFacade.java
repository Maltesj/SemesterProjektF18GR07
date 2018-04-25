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
    
    public static DataFacade getInstance(){
        if (instance == null) {
            instance = new DataFacade();
        }
        
        return instance;
    }
    
    private DataFacade(){
        caseInfoLoader = new CaseInfoLoader();
        
    }

    @Override
    public ICaseInformation getcCasenfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Information info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getCaseIDs() {
        
        return caseInfoLoader.getCaseIDs();
    }
    
}