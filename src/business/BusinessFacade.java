/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.IBusinessFacade;
import acquaintance.IDataFacade;

/**
 *
 * @author HCHB
 */
public class BusinessFacade implements IBusinessFacade {
    
    private static BusinessFacade instance;
    private IDataFacade dataFacade;
    
    public static BusinessFacade getInstance(){
        if (instance == null) {
            instance = new BusinessFacade();
        }
        
        return instance;
    }
    
    private BusinessFacade(){
        
    }
    
    @Override
    public void injectDataFacade(IDataFacade dataFacade){
        this.dataFacade = dataFacade;
        
    }
   IDataFacade getDataFacade(){
       return this.dataFacade;
   } 
}
