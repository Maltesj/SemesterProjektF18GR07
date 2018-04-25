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

/**
 *
 * @author HCHB
 */
public class DataFacade implements IDataFacade{
    
    private static DataFacade instance;
    
    public static DataFacade getInstance(){
        if (instance == null) {
            instance = new DataFacade();
        }
        
        return instance;
    }
    
    private DataFacade(){
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}