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
 * @author Kasper
 */
public class AssessmentState implements IUdredState{
    private CheckList checkList;


    public AssessmentState() {
        this.checkList = new CheckList();
    }
    
    @Override
    public boolean savePhase(Information info) {
        BusinessFacade.getInstance().savePhase(info, EnumPhases.ASSESSMENT, info.getCaseID()); // temp
        
        if (info.getCaseID() == null) {
            return false;
        }
        return true;
    }

    @Override
    public void write(String text, Checklistable sourceInfo, Information info) {
        info.getAssessmentInformation().write(text, sourceInfo);
    }

    @Override
    public Set<Checklistable> checkFields(Information info) {
        return this.checkList.checkCollection(info.getAssessmentInformation().getFilledFields(), EnumPhases.ASSESSMENT);
    }

    @Override
    public Set<Checklistable> done(Information info) {
        this.savePhase(info);
        return this.checkList.checkCollection(info.getAssessmentInformation().getFilledFields(), EnumPhases.ASSESSMENT);
    }

    @Override
    public void discard(Information info) {
        info.setAssessmentInformation(null);
        String caseID = info.getCaseID();
        BusinessFacade.getInstance().discard(EnumPhases.ASSESSMENT, caseID); //temp
    }
    
}
