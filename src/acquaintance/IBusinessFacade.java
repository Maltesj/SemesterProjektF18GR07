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
    public boolean startAssessment(String caseID , String caseWorkerID, boolean online);
    public boolean save(boolean online);
    public Set<Checklistable> done(boolean online);
    public void write(String text, Checklistable sourceInfo);
    public Map<Checklistable, String> getCaseInformation(String caseID);
    public Set<String> getCaseIDs();
    public Set<Checklistable> checkFields();
    public Map<Checklistable,String> startActionPlan(String caseWorkerID, String caseID, boolean online);
    public Map<Checklistable, String> continueActionPlan(boolean online);
    public void discardPhase();
    public boolean savePhase(boolean online);
    public void setState(EnumPhases phase);
}