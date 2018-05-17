/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author HCHB
 */
public interface IBusinessFacade {
    
    public void injectDataFacade(IDataFacade dataFacade);
    public boolean startAssessment(String caseID , String caseWorkerID);
    public boolean save();
    public Set<Checklistable> done();
    public void write(String text, Checklistable sourceInfo);
    public Map<Checklistable, String> getCaseInformation(String caseID);
    public Set<String> getCaseIDs();
    public Set<Checklistable> checkFields();
    public Map<Checklistable,String> startActionPlan(String caseWorkerID, String caseID);
    public Map<Checklistable, String> continueActionPlan();
    public void discardPhase();
    public boolean savePhase();
    public void setState(String phase);
}