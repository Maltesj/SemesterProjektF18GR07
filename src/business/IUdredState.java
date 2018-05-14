/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author malte
 */
public interface IUdredState {
    
    boolean savePhase(Information info);
    void write(String text, String sourceInfo, Information info);
    Set<String> checkFields(Information info);
    Set<String> done(Information info);
    void discard(Information info);
    
}
