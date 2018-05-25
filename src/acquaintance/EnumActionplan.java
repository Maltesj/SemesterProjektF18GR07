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
    WORKPRICETOTAL("WorkPriceTotal", true),
    ACTIONPLANOTHER1("ActionplanOther1", true),
    ACTIONPLANOTHER2("ActionplanOther2", true),
    ACTIONPLANCOORDINATING1("ActionplanCoordinating1", true),
    ACTIONPLANCOORDINATING2("ActionplanCoordinating2", true);
    
    
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
