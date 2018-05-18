
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.Checklistable;
import acquaintance.EnumCaseInformation;
import acquaintance.ICaseInformation;
import java.io.Serializable;
import java.util.HashMap;

/** Class for storage of case information
 *
 * @author michael
 */
public class CaseInformation implements Serializable, ICaseInformation {
    private HashMap<Checklistable, String> textInformation;
    
    public CaseInformation(){
        
    }

    /** Allows for constructing with a HashMap
     *
     * @param textInformation
     */
    public CaseInformation(HashMap<Checklistable, String> textInformation){
        this.textInformation = textInformation;
    }

    /** Method for getting the hashmap
     *
     * @return
     */
    HashMap<Checklistable, String> getInformation(){
        return this.textInformation;
    }    
}
