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
public enum EnumWork implements Checklistable {
    
    NAME("name", true),
    CPR("cpr", true),
    ADDRESS("address", true),
    TELEPHONENUMBER("telephone number", true),
    MAIL("mail", true),
    WORKPURPOSE("WorkPurpose", true),
    WORKGOAL("WorkGoal", true),
    WORKSERVICE1("WorkService1", true),
    WORKSERVICE2("WorkService2", true),
    WORKOFFER1("WorkOffer1", true),
    WORKOFFER2("WorkOffer2", true),
    WORKACCOUNTNUMBER1("WorkAccountNumber1", true),
    WORKACCOUNTNUMBER2("WorkAccountNumber2", true),
    WORKSUPPLIER1("WorkSupplier1", true),
    WORKSUPPLIER2("WorkSupplier2", true),
    WORKSTARTDATE1("WorkStartDate1", true),
    WORKSTARTDATE2("WorkStartDate2", true),
    WORKENDDATE1("WorkEndDate1", true),
    WORKENDDATE2("WorkEndDate2", true),
    WORKSERVICEUNIT1("WorkServiceUnit1", true),
    WORKSERVICEUNIT2("WorkServiceUnit2", true),
    WORKSERVICEAMOUNT1("WorkServiceAmount1", true),
    WORKSERVICEAMOUNT2("WorkServiceAmount2", true),
    WORKSERVICEPRICE1("WorkServicePrice1", true),
    WORKSERVICEPRICE2("WorkServicePrice2", true),
    WORKPRICE1("WorkPrice1", true),
    WORKPRICE2("WorkPrice2", true),
    WORKPRICETOTAL("WorkPriceTotal", true);
    
    private String sourceID;
    private boolean obligatory;
    
    EnumWork(String sourceID, boolean obligatory)
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
