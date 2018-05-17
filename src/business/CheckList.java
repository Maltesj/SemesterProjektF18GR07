/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import acquaintance.Checklistable;
import acquaintance.EnumAssessment;
import acquaintance.EnumCaseInformation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author malte
 */
public class CheckList {
    
    Map<String, Set<Checklistable>> checklists;
    
    /**
     * Constructs a new, empty check list.
     */
    public CheckList() {
        checklists = new HashMap<>();
                
        Set<Checklistable> checklist = new HashSet<>();
        for (EnumAssessment value : EnumAssessment.values()) {
            checklist.add(value);
        }
        checklists.put("assessment", checklist);
    }
    
    /**
     * Checks if the specified element contains all the required elements for an assessment.
     *
     * @param info - filled fields in a particular phase
     * @param phase - The phase to be checked
     * @return missingElements - Required fields which hasn't been filled.
     */
    public Set<Checklistable> checkCollection(Set<Checklistable> info, String phase){
        
        Set<Checklistable> checklist = checklists.get(phase);
        
        Set<Checklistable> missingElements = new HashSet<>();
        
        missingElements.addAll(checklist);
        missingElements.removeAll(info);
        
        return missingElements;
    }
}
