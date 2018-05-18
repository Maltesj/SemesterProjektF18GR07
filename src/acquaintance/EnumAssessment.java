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
public enum EnumAssessment implements Checklistable {
    
    PROFFESSIONALASSESSMENT1("ProffesionalAssessment1", true),
    PROFFESSIONALASSESSMENT2("ProffesionalAssessment2", false),
    WORKPURPOSE("WorkPurpose", false),
    WORKGOAL("WorkGoal", false),
    PRIMARYWORK("PrimaryWork", false),
    ALTWORK("AltWork", false);
    
    private String sourceID;
    private boolean obligatory;
    
    EnumAssessment(String sourceID, boolean obligatory)
    {
        this.sourceID = sourceID;
        this.obligatory = obligatory;
    }
    
    public String toString()
    {
        return sourceID;
    }
    
    public boolean isObligatory(){
        return this.obligatory;
    }
    
}
