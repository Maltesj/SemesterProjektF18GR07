/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import java.util.Set;

/**
 *
 * @author micha
 */
public class ActionplanState implements IUdredState {
    
    CheckList cL;
    ActionplanState(){
        cL = new CheckList();
    }
    
    @Override
    public boolean savePhase(Information information) {
        information.getActionplanInformation();
        BusinessFacade.getInstance().getDataFacade().save(information, "changeThisWhenReady");
        return true;
    }
    
    @Override
    public void write(String text, String sourceInfo, Information information) {
        information.getActionplanInformation().write(text, sourceInfo);
    }
    
    @Override
    public Set<String> checkFields(Information information) {
        
        return cL.checkCollection(information.getActionplanInformation().getFilledFields(), "ActionplanInformation");
    }
    
    @Override
    public Set<String> done(Information information) {
        savePhase(information);
        return checkFields(information);
    }
    
    @Override
    public void discard(Information information) {
        information.setActionplanInformation(null);
        String caseID = information.getCaseID();
        BusinessFacade.getInstance().getDataFacade().discard("ActionplanInformation",caseID );
    }
    
    
    
}
