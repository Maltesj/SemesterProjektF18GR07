/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui;

import acquaintance.Checklistable;
import acquaintance.EnumPhases;
import acquaintance.IBusinessFacade;
import acquaintance.IGUIFacade;
import java.util.Map;
import java.util.Set;

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
    
    Set<Checklistable> checkAssessment(){
        return this.businessFacade.checkFields();
    }
    
    Map<Checklistable, String> getCaseInformation(String caseID){
        return this.businessFacade.getCaseInformation(caseID);
    }
    
    Set<Checklistable> done(){
        return this.businessFacade.done();
    }
    
    void write(String text, Checklistable sourceInfo){
        this.businessFacade.write(text, sourceInfo);
    }
    
    boolean save(){
        return this.businessFacade.save();
    }
    
    void setState(EnumPhases phase){
        this.businessFacade.setState(phase);
    }
    
    boolean savePhase(){
        return this.businessFacade.savePhase();
    }
    
    void discardPhase(){
        this.businessFacade.discardPhase();
    }
    
    Map<Checklistable, String> continueActionPlan(){
        return this.businessFacade.continueActionPlan();
    }
    
    Map<Checklistable, String> startActionPlan(String caseWorkerID, String caseID){
        return this.businessFacade.startActionPlan(caseWorkerID, caseID);
    }
    
}