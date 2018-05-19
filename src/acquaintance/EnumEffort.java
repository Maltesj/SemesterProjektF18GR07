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
public enum EnumEffort implements Checklistable {
    
    EFFORTPURPOSE("EffortPurpose", true),
    EFFORTGOAL("EffortGoal", true),
    EFFORTSERVICE1("EffortService1", true),
    EFFORTSERVICE2("EffortService2", true),
    EFFORTOFFER1("EffortOffer1", true),
    EFFORTOFFER2("EffortOffer2", true),
    EFFORTACCOUNTNUMBER1("EffortAccountNumber1", true),
    EFFORTACCOUNTNUMBER2("EffortAccountNumber2", true),
    EFFORTSUPPLIER1("EffortSupplier1", true),
    EFFORTSUPPLIER2("EffortSupplier2", true),
    EFFORTSTARTDATE1("EffortStartDate1", true),
    EFFORTSTARTDATE2("EffortStartDate2", true),
    EFFORTENDDATE1("EffortEndDate1", true),
    EFFORTENDDATE2("EffortEndDate2", true),
    EFFORTSERVICEUNIT1("EffortServiceUnit1", true),
    EFFORTSERVICEUNIT2("EffortServiceUnit2", true),
    EFFORTSERVICEAMOUNT1("EffortServiceAmount1", true),
    EFFORTSERVICEAMOUNT2("EffortServiceAmount2", true),
    EFFORTSERVICEPRICE1("EffortServicePrice1", true),
    EFFORTSERVICEPRICE2("EffortServicePrice2", true),
    EFFORTPRICE1("EffortPrice1", true),
    EFFORTPRICE2("EffortPrice2", true),
    EFFPRTPRICETOTAL("EffortPriceTotal", true);
    
    private String sourceID;
    private boolean obligatory;
    
    EnumEffort(String sourceID, boolean obligatory)
    {
        this.obligatory = obligatory;
        this.sourceID = sourceID;
    }
    
    public String toString()
    {
        return sourceID;
    }

    @Override
    public boolean isObligatory() {
        return this.obligatory;
        }
}
