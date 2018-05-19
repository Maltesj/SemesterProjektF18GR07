/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.Checklistable;
import acquaintance.IEffortInformation;
import acquaintance.IWork;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Kasper
 */
public class EffortInformation implements Serializable, IEffortInformation, IWork {
    private HashMap<Checklistable, String> textInformation;

    public EffortInformation() {
        
    }

    public EffortInformation(HashMap<Checklistable, String> textInformation) {
        this.textInformation = textInformation;
    }

    public HashMap<Checklistable, String> getTextInformation() {
        return textInformation;
    }
    
    
    
}
