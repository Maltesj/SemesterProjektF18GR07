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
public enum EnumCaseInformation {
    
    
    PHYSICPROBLEM1("Fysisk_borger_oplysning", true), 
    PHYSICPROBLEM2("PhysicProblem2", true), 
    PHYSICPROBLEM3("PhysicProblem3", true), 
    PHYSICPROBLEM4("PhysicProblem4", true),
    PSYCICPROBLEM1("PsycicProblem1", true),
    PSYCICPROBLEM2("PsycicProblem2", true),
    PSYCICPROBLEM3("PsycicProblem3", true),
    PSYCICPROBLEM4("PsycicProblem4", true),
    SOCIALPROBLEM1("SocialProblem1", true),
    SOCIALPROBLEM2("SocialProblem2", true),
    SOCIALPROBLEM3("SocialProblem3", true),
    SOCIALPROBLEM4("SocialProblem4", true),
    PRACTICALWORK1("PracticalWork1", true),
    PRACTICALWORK2("PracticalWork2", true),
    PRACTICALWORK3("PracticalWork3", true),
    PRACTICALWORK4("PracticalWork4", true),
    SELFHELP1("SelfHelp1", true),
    SELFHELP2("SelfHelp2", true),
    SELFHELP3("SelfHelp3", true),
    SELFHELP4("SelfHelp4", true),
    MOBILITY1("Mobility1", true),
    MOBILITY2("Mobility2", true),
    MOBILITY3("Mobility3", true),
    MOBILITY4("Mobility4", true),
    COMMUNICATION1("Communication1", true),
    COMMUNICATION2("Communication2", true),
    COMMUNICATION3("Communication3", true),
    COMMUNICATION4("Communication4", true),
    COMMUNITYLIFE1("CommunityLife1", true),
    COMMUNITYLIFE2("CommunityLife2", true),
    COMMUNITYLIFE3("CommunityLife3", true),
    COMMUNITYLIFE4("CommunityLife4", true),
    SOCIALLIFE1("SocicalLife1", true),
    SOCIALLIFE2("SocicalLife2", true),
    SOCIALLIFE3("SocicalLife3", true),
    SOCIALLIFE4("SocicalLife4", true),
    HEALTH1("Health1", true),
    HEALTH2("Health2", true),
    HEALTH3("Health3", true),
    HEALTH4("Health4", true),
    SORROUNDINGS1("Sorroundings1", true),
    SORROUNDINGS2("Sorroundings2", true),
    SORROUNDINGS3("Sorroundings3", true),
    SORROUNDINGS4("Sorroundings4", true),
    TOTALASSESMENT("TotalAssesment", true),
    CASEINFOCONCLUSSION("CaseInfoConclussion", true);
    
    
    private String sourceID;
    private boolean obligatory;
    
    EnumCaseInformation(String sourceID, boolean obligatory)
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
