/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

/**
 *
 * @author HCHB
 */
public enum EnumActionplan implements Checklistable {

    RANDOMFIELD1("RandomField1", true),
    RANDOMFIELD2("RandomField2", true);
    
    private String sourceID;
    private boolean obligatory;
    
    private EnumActionplan(String sourceID, boolean obligatory){
        this.sourceID = sourceID;
        this.obligatory = obligatory;
    }
    
    @Override
    public String toString(){
        return this.sourceID;
    }
    
    @Override
    public boolean isObligatory(){
        return this.obligatory;
    }
    
}
