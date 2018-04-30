/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package business;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author malte
 */
public class CheckList {
    
    private Set<String> checkList;
    
    /**
     * Constructs a new, empty check list.
     */
    public CheckList() {
        checkList = new HashSet<String>();
        checkList.add(acquaintance.Constants.fieldAcademicallyAssessment);
    }
    
    /**
     * Checks if the specified element contains all the required elements for an assessment.
     *
     * @param info - filled fields
     * @return missingElements - Required fields which hasn't been filled.
     */
    public Set<String> checkCollection(Set<String> info){
        Set<String> missingElements = new HashSet<String>();
        for (String string : checkList) {
            if(!info.contains(string)){
                missingElements.add(string);
            }
        }
 //       if(missingElements.isEmpty())
        return missingElements;
    }
}
