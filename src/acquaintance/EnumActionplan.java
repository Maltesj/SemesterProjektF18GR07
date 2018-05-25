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

    NAME("name", true),
    CPR("cpr", true),
    ADDRESS("address", true),
    TELEPHONENUMBER("telephone number", true),
    MAIL("mail", true),
    WORKPURPOSE("EffortPurpose", true),
    WORKGOAL("EffortGoal", true),
    WORKSERVICE1("EffortService1", true),
    WORKSERVICE2("EffortService2", true),
    WORKOFFER1("EffortOffer1", true),
    WORKOFFER2("EffortOffer2", true),
    WORKACCOUNTNUMBER1("EffortAccountNumber1", true),
    WORKACCOUNTNUMBER2("EffortAccountNumber2", true),
    WORKSUPPLIER1("EffortSupplier1", true),
    WORKSUPPLIER2("EffortSupplier2", true),
    WORKSTARTDATE1("EffortStartDate1", true),
    WORKSTARTDATE2("EffortStartDate2", true),
    WORKENDDATE1("EffortEndDate1", true),
    WORKENDDATE2("EffortEndDate2", true),
    WORKSERVICEUNIT1("EffortServiceUnit1", true),
    WORKSERVICEUNIT2("EffortServiceUnit2", true),
    WORKSERVICEAMOUNT1("EffortServiceAmount1", true),
    WORKSERVICEAMOUNT2("EffortServiceAmount2", true),
    WORKSERVICEPRICE1("EffortServicePrice1", true),
    WORKSERVICEPRICE2("EffortServicePrice2", true),
    WORKPRICE1("EffortPrice1", true),
    WORKPRICE2("EffortPrice2", true),
    WORKPRICETOTAL("EffortPriceTotal", true);
    
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
