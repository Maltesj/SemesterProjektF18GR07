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
public class FacadeController implements IBusinessFacade {
    
    private static FacadeController instance;
    private IDataFacade dataFacade;
    
    public static FacadeController getInstance(){
        if (instance == null) {
            instance = new FacadeController();
        }
        
        return instance;
    }
    
    private FacadeController(){
        
    }
    
    @Override
    public void injectDataFacade(IDataFacade dataFacade){
        this.dataFacade = dataFacade;
        
    }
    
}
