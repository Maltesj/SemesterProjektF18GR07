/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.Checklistable;
import acquaintance.IActionplan;
import acquaintance.IWork;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/** Class for storage of assessment information
 *
 * @author michael og malte
 */
public class ActionplanInformation implements Serializable, IActionplan {
    private HashMap<Checklistable, String> textInformation;
    
    ActionplanInformation(IWork work){
        textInformation = new HashMap<>();
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