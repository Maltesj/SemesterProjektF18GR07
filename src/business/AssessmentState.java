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
        this.data = business.getDataFacade();
        this.data.save(info, info.getCaseID());
        
        
        
        if (info.getCaseID() == null) {
            return false;
        }
        return true;
    }

    @Override
    public void write(String text, String sourceInfo, Information info) {
        
        info.write(text, sourceInfo);
    }

    @Override
    public Set<String> checkFields(Information info) {
        Set<String> filledFields = info.getFilledAssessmentFields();
        Set<String> missingFields = this.checkList.checkCollection(filledFields, "assessment");
        
        return missingFields;
    }

    @Override
    public Set<String> done(Information info) {
        Set<String> filledAssessment = info.getFilledAssessmentFields();
        //sout for testing. temp
        for (String string : filledAssessment) {
            System.out.println(string);
        }
        System.out.println(filledAssessment);
        Set<String> missingFields = this.checkList.checkCollection(filledAssessment, "assessment");
        this.savePhase(info);
        
        return missingFields;
    }

    @Override
    public void discard(Information info) {
        this.data = business.getDataFacade();
        info.setAssessmentInformation(null);
        String caseID = info.getCaseID();
        //data.discard("assessment", caseID);
    }
    
}
