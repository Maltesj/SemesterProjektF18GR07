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
    
    public ICaseInformation getCaseInfo(String caseID);     
    public void save(IInformation info, String caseID);
    public Set<String> getCaseIDs();
    public IWork getWork();
    public boolean discard(String phase, String caseID);
    public boolean savePhase(IInformation info, String phase, String caseID);
}
