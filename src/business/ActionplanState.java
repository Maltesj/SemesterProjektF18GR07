/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.Checklistable;
import acquaintance.EnumPhases;
import java.util.Set;

/**
 *
 * @author micha
 */
public class ActionplanState implements IUdredState {
    
    CheckList checkList;
    ActionplanState(){
        checkList = new CheckList();
    }
    
    @Override
    public boolean savePhase(Information information, boolean online) {
        String caseID = information.getCaseID();
        BusinessFacade.getInstance().saveActionplan(information.getActionplanInformation(), caseID, online);
        
        if (information.getCaseID() == null) {
            return false;
        }
        return true;
    }
    
    @Override
    public void write(String text, Checklistable sourceInfo, Information information) {
        information.getActionplanInformation().write(text, sourceInfo);
    }
    
    @Override
    public Set<Checklistable> checkFields(Information information) {
        return checkList.checkCollection(information.getActionplanInformation().getFilledFields(), EnumPhases.ACTIONPLAN);
    }
    
    @Override
    public Set<Checklistable> done(Information information, boolean online) {
        this.savePhase(information, online);
        return this.checkFields(information);
    }
    
    @Override
    public void discard(Information information) {
        information.setActionplanInformation(null);
        String caseID = information.getCaseID();
        BusinessFacade.getInstance().discard(EnumPhases.ACTIONPLAN,caseID ); // temp, 
    }
    
    
    
}
