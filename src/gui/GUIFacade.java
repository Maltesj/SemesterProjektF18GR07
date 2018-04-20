/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Acquaintance.IBusinessFacade;
import Acquaintance.IGUIFacade;

/**
 *
 * @author HCHB
 */
public class GUIFacade implements IGUIFacade {
    
    private static GUIFacade instance;
    private IBusinessFacade businessFacade;

    @Override
    public void injectBusinessFacadde(IBusinessFacade businessFacade) {
        this.businessFacade = businessFacade;
    }
    
    public static GUIFacade getInstance(){
        if (instance == null) {
            instance = new GUIFacade();
        }
        
        return instance;
    }
    
    private GUIFacade(){
        
    }
    
    @Override
    public void startApplication(String[] args) {
        guiStarter.main(args);
    }
}