/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.AssessmentEnum;
import acquaintance.ConstantsEnum;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author malte
 */
public class CheckList {
    
    Map<String, Set<String>> checklists;
    
    /**
     * Constructs a new, empty check list.
     */
    public CheckList() {
        checklists = new HashMap<>();
                
        Set<String> checklist = new HashSet<String>();
        for (AssessmentEnum value : AssessmentEnum.values()) {
            checklist.add(value.toString());
        }
        checklists.put("assessment", checklist);
    }
    
    /**
     * Checks if the specified element contains all the required elements for an assessment.
     *
     * @param info - filled fields
     * @return missingElements - Required fields which hasn't been filled.
     */
    public Set<String> checkCollection(Set<String> info, String phase){
        
        Set<String> checklist = checklists.get(phase);
        
        Set<String> missingElements = new HashSet<String>();
        for (String string : checklist) {
            if(!info.contains(string)){
                missingElements.add(string);
            }
        }
 //       if(missingElements.isEmpty())
        return missingElements;
    }
}
