/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

/**
 *
 * @author Kasper
 */
public enum AssessmentEnum {
    
    PROFFESSIONALASSESSMENT1("ProffesionalAssessment1"),
    PROFFESSIONALASSESSMENT2("ProffesionalAssessment2"),
    WORKPURPOSE("WorkPurpose"),
    WORKGOAL("WorkGoal"),
    PRIMARYWORK("PrimaryWork"),
    ALTWORK("AltWork");
    
    private String sourceID;
    
    AssessmentEnum(String in)
    {
        sourceID = in;
    }
    
    public String toString()
    {
        return sourceID;
    }
    
}
