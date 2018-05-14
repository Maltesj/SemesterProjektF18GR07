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
    private BusinessFacade business;
    private IDataFacade data;

    public AssessmentState(CheckList checkList, BusinessFacade business, IDataFacade data) {
        this.checkList = new CheckList();
        this.business = BusinessFacade.getInstance();
    }
    
    @Override
    public boolean savePhase(Information info) {
        business.getDataFacade().save(info, info.getCaseID());
        
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
        business.getDataFacade().discard("assessment", caseID);
    }
    
}
