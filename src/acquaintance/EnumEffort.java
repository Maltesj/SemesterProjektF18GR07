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
public enum EnumEffort {
    
    EFFORTPURPOSE("EffortPurpose"),
    EFFORTGOAL("EffortGoal"),
    EFFORTSERVICE1("EffortService1"),
    EFFORTSERVICE2("EffortService2"),
    EFFORTOFFER1("EffortOffer1"),
    EFFORTOFFER2("EffortOffer2"),
    EFFORTACCOUNTNUMBER1("EffortAccountNumber1"),
    EFFORTACCOUNTNUMBER2("EffortAccountNumber2"),
    EFFORTSUPPLIER1("EffortSupplier1"),
    EFFORTSUPPLIER2("EffortSupplier2"),
    EFFORTSTARTDATE1("EffortStartDate1"),
    EFFORTSTARTDATE2("EffortStartDate2"),
    EFFORTENDDATE1("EffortEndDate1"),
    EFFORTENDDATE2("EffortEndDate2"),
    EFFORTSERVICEUNIT1("EffortServiceUnit1"),
    EFFORTSERVICEUNIT2("EffortServiceUnit2"),
    EFFORTSERVICEAMOUNT1("EffortServiceAmount1"),
    EFFORTSERVICEAMOUNT2("EffortServiceAmount2"),
    EFFORTSERVICEPRICE1("EffortServicePrice1"),
    EFFORTSERVICEPRICE2("EffortServicePrice2"),
    EFFORTPRICE1("EffortPrice1"),
    EFFORTPRICE2("EffortPrice2"),
    EFFPRTPRICETOTAL("EffortPriceTotal");
    
    private String sourceID;
    
    EnumEffort(String in)
    {
        sourceID = in;
    }
    
    public String toString()
    {
        return sourceID;
    }
}
