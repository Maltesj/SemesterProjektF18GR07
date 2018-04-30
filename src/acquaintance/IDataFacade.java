/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import business.Information;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author HCHB
 */
public interface IDataFacade {
    
    public ICaseInformation getCaseInfo(String caseID);     
    public void save(Information info, String caseID);
    public Set<String> getCaseIDs();
}
