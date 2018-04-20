/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusinessFacade;
import Acquaintance.IDataFacade;
import Acquaintance.IGUIFacade;
import Data.DataFacade;
import business.BusinessFacade;
import gui.GUIFacade;

/**
 *
 * @author HCHB
 */
public class Start {
    
    public static void main(String[] args) {
        IDataFacade dataFacade = DataFacade.getInstance();
        IBusinessFacade businessFacade = BusinessFacade.getInstance();
        IGUIFacade guiFacade = GUIFacade.getInstance();
        
        businessFacade.injectDataFacade(dataFacade);
        guiFacade.injectBusinessFacadde(businessFacade);
        
        guiFacade.startApplication(args);
    }
}