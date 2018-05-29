/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import acquaintance.Checklistable;
import acquaintance.EnumWork;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.Work;
import acquaintance.IWorkInformation;

/**
 *
 * @author Kasper
 */
public class SaveDummyWorkInfo {

    
    private HashMap<Checklistable, String> case1;
    private HashMap<Checklistable, String> case2;
    
    private IWorkInformation dummy1;
    private IWorkInformation dummy2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SaveDummyWorkInfo se = new SaveDummyWorkInfo();
        se.saveEffort();
    }

    SaveDummyWorkInfo() {
        System.out.println("hey listen");
        case1 = new HashMap<>();
        case2 = new HashMap<>();
        makeDummy();
        dummy1 = new Work(case1);
        dummy2 = new Work(case2);
        
    }

    public IWorkInformation getDummy1() {
        return dummy1;
    }

    public IWorkInformation getDummy2() {
        return dummy2;
    }
    

    private void makeDummy() {
        //Create case 2
        
        
        case1.put(EnumWork.NAME, "Jørgen Hansen");
        case1.put(EnumWork.CPR, "2233445566");
        case1.put(EnumWork.ADDRESS, "XXXXXXXXX");
        case1.put(EnumWork.TELEPHONENUMBER, "XXXXXXXXXX");
        case1.put(EnumWork.MAIL, "XXXXXXXXXX");
     
        case1.put(EnumWork.WORKPURPOSE, "Formålet med indsatsen er at støtte Jørgen til at blive stoffri, samt at han får stabile rammer angående sin økonomi og bolig.");
        case1.put(EnumWork.WORKGOAL, "1. At Jørgen bliver stoffri\n" +
                                                    "2. At Jørgen ikke får tilbagefald i perioden\n" +
                                                    "3. At Jørgen får afklaret sine ønsker ift. sin bolig");
        case1.put(EnumWork.WORKSERVICE1, "Misbrugsbehandling (§ 101)\n" +
                                                        "Støtte til administration (§85)");
        case1.put(EnumWork.WORKSERVICE2, "");
        case1.put(EnumWork.WORKOFFER1, "Midlertidigt botilbud");
        case1.put(EnumWork.WORKOFFER2, "");
        case1.put(EnumWork.WORKACCOUNTNUMBER1, "xxxxx");
        case1.put(EnumWork.WORKACCOUNTNUMBER2, "");
        case1.put(EnumWork.WORKSUPPLIER1, "Center for misbrug, xxx");
        case1.put(EnumWork.WORKSUPPLIER2, "");
        case1.put(EnumWork.WORKSTARTDATE1, "1.maj 2012");
        case1.put(EnumWork.WORKSTARTDATE2, "");
        case1.put(EnumWork.WORKENDDATE1, "1.august 2012");
        case1.put(EnumWork.WORKENDDATE2, "");
        case1.put(EnumWork.WORKSERVICEUNIT1, "dag");
        case1.put(EnumWork.WORKSERVICEUNIT2, "");
        case1.put(EnumWork.WORKSERVICEAMOUNT1, "90");
        case1.put(EnumWork.WORKSERVICEAMOUNT2, "");
        case1.put(EnumWork.WORKSERVICEPRICE1, "xxx");
        case1.put(EnumWork.WORKSERVICEPRICE2, "");
        case1.put(EnumWork.WORKPRICE1, "Ydelse 1 = (90*pris) = xxx\n" +
                                                      "Ydelse 2 = (10*pris) = vvv\n" +
                                                      "Pris for enkeltindsats = (xxx+vvv)");
        case1.put(EnumWork.WORKPRICE2, "");
        case1.put(EnumWork.WORKPRICETOTAL, "Forventet pris for samlet indsats = (Pris for indsats 1 + pris for indsats 2)");
        
        //Create case 2
        case2.put(EnumWork.NAME, "Rikke Hansen");
        case2.put(EnumWork.CPR, "1122344112");
        case2.put(EnumWork.ADDRESS, "XXXXXXXXX");
        case2.put(EnumWork.TELEPHONENUMBER, "XXXXXXXXXX");
        case2.put(EnumWork.MAIL, "XXXXXXXXXX");
        case2.put(EnumWork.WORKPURPOSE, "");
        case2.put(EnumWork.WORKGOAL, "");
        case2.put(EnumWork.WORKSERVICE1, "");
        case2.put(EnumWork.WORKSERVICE2, "");
        case2.put(EnumWork.WORKOFFER1, "");
        case2.put(EnumWork.WORKOFFER2, "");
        case2.put(EnumWork.WORKACCOUNTNUMBER1, "");
        case2.put(EnumWork.WORKACCOUNTNUMBER2, "");
        case2.put(EnumWork.WORKSUPPLIER1, "");
        case2.put(EnumWork.WORKSUPPLIER2, "");
        case2.put(EnumWork.WORKSTARTDATE1, "");
        case2.put(EnumWork.WORKSTARTDATE2, "");
        case2.put(EnumWork.WORKENDDATE1, "");
        case2.put(EnumWork.WORKENDDATE2, "");
        case2.put(EnumWork.WORKSERVICEUNIT1, "");
        case2.put(EnumWork.WORKSERVICEUNIT2, "");
        case2.put(EnumWork.WORKSERVICEAMOUNT1, "");
        case2.put(EnumWork.WORKSERVICEAMOUNT2, "");
        case2.put(EnumWork.WORKSERVICEPRICE1, "");
        case2.put(EnumWork.WORKSERVICEPRICE2, "");
        case2.put(EnumWork.WORKPRICE1, "");
        case2.put(EnumWork.WORKPRICE2, "");
        case2.put(EnumWork.WORKPRICETOTAL, "");
    }

    private void saveEffort() {
        try{

            OutputStream outStream = new FileOutputStream("assets\\DummyCase1.work");
            ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
            fileObjectOut.writeObject(dummy1);
            fileObjectOut.close();
            outStream.close();

            OutputStream outStream2 = new FileOutputStream("assets\\DummyCase2.work");
            ObjectOutputStream fileObjectOut2 = new ObjectOutputStream(outStream2);
            fileObjectOut2.writeObject(dummy2);
            fileObjectOut2.close();
            outStream2.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveDummyCaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveDummyCaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
