/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import java.util.Set;

/**
 *
 * @author HCHB
 */
public interface IDataFacade {
    
    public Set<String> getCaseIDs();
    
    public void saveDatabase(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan, String caseID);
    public void saveDatabase(ICaseInformation caseInfo, String caseID);
    public void saveDatebase(IAssessment assessment, String caseID);
    public void saveDatebase(IActionplan actionplan, String caseID);
    public void saveDatabase(IWork work, String caseID);
    
    public void saveLocal(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan, String caseID);
    public void saveLocal(ICaseInformation caseInfo, String caseID);
    public void saveLocal(IWork work, String caseID);
    public void saveLocal(IAssessment assessment, String caseID);
    public void saveLocal(IActionplan actionpan, String caseID);
    
    public ICaseInformation loadCaseInformationDatabase(String caseID);
    public IAssessment loadAssessmentDatabase(String caseID);
    public IActionplan loadActionplanDatabase(String caseID);
    public IWork loadWorkDatabase(String caseID);
    
    public ICaseInformation loadCaseInformationLocal(String caseID);
    public IAssessment loadAssessmentLocal(String caseID);
    public IActionplan loadActionplanLocal(String caseID);
    public IWork loadWorkLocal(String caseID);
    
    
    public boolean discard(EnumPhases phase, String caseID); //temp
    
}
