/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.IEffortInformation;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Kasper
 */
public class EffortInformation implements Serializable, IEffortInformation {
    private HashMap<String, String> textInformation;

    public EffortInformation() {
        
    }

    public EffortInformation(HashMap<String, String> textInformation) {
        this.textInformation = textInformation;
    }

    public HashMap<String, String> getTextInformation() {
        return textInformation;
    }
    
    
    
}
