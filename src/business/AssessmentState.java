/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.IDataFacade;
import java.util.Set;

/**
 *
 * @author Kasper
 */
public class AssessmentState implements IUdredState{
    private CheckList checkList;


    public AssessmentState() {
        this.checkList = new CheckList();
    }
    
    @Override
    public boolean savePhase(Information info) {
        BusinessFacade.getInstance().savePhase(info, "assessment", info.getCaseID());
        
        if (info.getCaseID() == null) {
            return false;
        }
        return true;
    }

    @Override
    public void write(String text, String sourceInfo, Information info) {
        info.getAssessmentInformation().write(text, sourceInfo);
    }

    @Override
    public Set<String> checkFields(Information info) {
        return this.checkList.checkCollection(info.getAssessmentInformation().getFilledFields(), "assessment");
    }

    @Override
    public Set<String> done(Information info) {
        this.savePhase(info);
        return this.checkList.checkCollection(info.getAssessmentInformation().getFilledFields(), "assessment");
    }

    @Override
    public void discard(Information info) {
        info.setAssessmentInformation(null);
        String caseID = info.getCaseID();
        BusinessFacade.getInstance().discard("assessment", caseID); //temp
    }
    
}
