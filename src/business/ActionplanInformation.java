/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.Checklistable;
import acquaintance.EnumActionplan;
import acquaintance.EnumWork;
import acquaintance.IActionplan;
import acquaintance.IWork;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** Class for storage of assessment information
 *
 * @author michael og malte
 */
public class ActionplanInformation implements Serializable, IActionplan {
    private HashMap<Checklistable, String> textInformation;
    
    ActionplanInformation(IWork work){
        textInformation = new HashMap<>();
        Work businessWork = (Work)work;
        Map<Checklistable, String> workInfo = businessWork.getTextInformation();
        
        for (EnumActionplan action : EnumActionplan.values()) {
            for (EnumWork effort : EnumWork.values()) {
                if (action.toString().equals(effort.toString())) {
                    textInformation.put(action, workInfo.get(effort));
                }
            }
        }
    }
    
    /** Method to get keyset for filled fields
     *
     * @return the keyset from hashmap
     */
     Set<Checklistable> getFilledFields(){
        return textInformation.keySet();
    }
    
    /** Method to add or overwrite text in the hashmap
     *
     * @param text is the value
     * @param sourceInfo is the key
     */
     void write(String text, Checklistable sourceInfo){
        this.textInformation.put(sourceInfo, text);
        if (text.equals("")||text.equals(null)){
            this.textInformation.remove(sourceInfo);
        }
    }
     
     /** Method for getting the hashmap
     *
     * @return
     */
    HashMap<Checklistable, String> getInformation(){
        return this.textInformation;
    }   
}