/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

/**
 *
 * @author malte
 */
public enum ConstantsEnum {
    
    
    PHYSICPROBLEM1("Fysisk_borger_oplysning"), 
    PHYSICPROBLEM2("PhysicProblem2"), 
    PHYSICPROBLEM3("PhysicProblem3"), 
    PHYSICPROBLEM4("PhysicProblem4"),
    PSYCICPROBLEM1("PsycicProblem1"),
    PSYCICPROBLEM2("PsycicProblem2"),
    PSYCICPROBLEM3("PsycicProblem3"),
    PSYCICPROBLEM4("PsycicProblem4"),
    SOCIALPROBLEM1("SocialProblem1"),
    SOCIALPROBLEM2("SocialProblem2"),
    SOCIALPROBLEM3("SocialProblem3"),
    SOCIALPROBLEM4("SocialProblem4"),
    PRACTICALWORK1("PracticalWork1"),
    PRACTICALWORK2("PracticalWork2"),
    PRACTICALWORK3("PracticalWork3"),
    PRACTICALWORK4("PracticalWork4"),
    SELFHELP1("SelfHelp1"),
    SELFHELP2("SelfHelp2"),
    SELFHELP3("SelfHelp3"),
    SELFHELP4("SelfHelp4"),
    MOBILITY1("Mobility1"),
    MOBILITY2("Mobility2"),
    MOBILITY3("Mobility3"),
    MOBILITY4("Mobility4"),
    COMMUNICATION1("Communication1"),
    COMMUNICATION2("Communication2"),
    COMMUNICATION3("Communication3"),
    COMMUNICATION4("Communication4"),
    COMMUNITYLIFE1("CommunityLife1"),
    COMMUNITYLIFE2("CommunityLife2"),
    COMMUNITYLIFE3("CommunityLife3"),
    COMMUNITYLIFE4("CommunityLife4"),
    SOCIALLIFE1("SocicalLife1"),
    SOCIALLIFE2("SocicalLife2"),
    SOCIALLIFE3("SocicalLife3"),
    SOCIALLIFE4("SocicalLife4"),
    HEALTH1("Health1"),
    HEALTH2("Health2"),
    HEALTH3("Health3"),
    HEALTH4("Health4"),
    SORROUNDINGS1("Sorroundings1"),
    SORROUNDINGS2("Sorroundings2"),
    SORROUNDINGS3("Sorroundings3"),
    SORROUNDINGS4("Sorroundings4"),
    TOTALASSESMENT("TotalAssesment"),
    CASEINFOCONCLUSSION("CaseInfoConclussion"),
    PROFFESSIONALASSESSMENT1("ProffesionalAssessment1"),
    PROFFESSIONALASSESSMENT2("ProffesionalAssessment2"),
    WORKPURPOSE("WorkPurpose"),
    WORKGOAL("WorkGoal"),
    PRIMARYWORK("PrimaryWork"),
    ALTWORK("AltWork");
    
    
    private String sourceID;
    
    ConstantsEnum(String in)
    {
        sourceID = in;
    }
    
    public String toString()
    {
        return sourceID;
    }
    
}
