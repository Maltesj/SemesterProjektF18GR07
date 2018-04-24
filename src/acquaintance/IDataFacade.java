/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import business.Information;
import java.util.Map;

/**
 *
 * @author HCHB
 */
public interface IDataFacade {
    
    public ICaseInformation getInfo();     
    public void save(Information info);
}
