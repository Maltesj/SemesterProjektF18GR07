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
    
    boolean savePhase();
    void write(String text, String sourceInfo);
    Set<String> checkFields();
    Set<String> done();
    void discard();
    
}
