/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui;

import acquaintance.IBusinessFacade;
import acquaintance.IGUIFacade;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author HCHB
 */
public class GUIFacade implements IGUIFacade {
    
    /*
    At bruge denne klasse betyder at der ikke er tvivl om om den eksisterer når man forsøger at injecte businessFacaden, i modsætning
    til hvis man prøver at injecte i controlleren. for den eksisterer ikke?? før main i guiStarter har kørt, hvilket den ikke har før
    start.java har kørt.
    */
    
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
    
    void startAssessment(String caseID, String caseWorkerID){
        this.businessFacade.startAssessment(caseID, caseWorkerID);
    }
    
    Set<String> getCaseIDS(){
        return businessFacade.getCaseIDs();
    }
    
    @Override
    public void startApplication(String[] args) {
        guiStarter.main(args);
    }
}