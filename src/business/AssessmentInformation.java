/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.Checklistable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/** Class for storage of assessment information
 *
 * @author michael og malte
 */
public class AssessmentInformation implements Serializable {
    private HashMap<Checklistable, String> textInformation;
    
    public AssessmentInformation(){
        textInformation = new HashMap<>();
    }
    
    /** Method to get keyset for filled fields
     *
     * @return the keyset from hashmap
     */
    public Set<Checklistable> getFilledFields(){
        return textInformation.keySet();
    }
    
    /** Method to add or overwrite text in the hashmap
     *
     * @param text is the value
     * @param sourceInfo is the key
     */
    public void write(String text, Checklistable sourceInfo){
        textInformation.put(sourceInfo, text);
        if (text.equals("")||text.equals(null)){
            textInformation.remove(sourceInfo);
        }
    }
}