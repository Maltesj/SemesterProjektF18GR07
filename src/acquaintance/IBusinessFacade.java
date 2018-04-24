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
    public Set<String> done();
    public void write(String text, String sourceInfo);
    public Map<String, String> getCaseInformation(String CaseID);
    public Set<String> getCaseIDs();
}