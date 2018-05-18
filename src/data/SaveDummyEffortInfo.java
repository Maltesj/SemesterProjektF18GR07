/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.EnumEffort;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import acquaintance.IEffortInformation;
import business.EffortInformation;

/**
 *
 * @author Kasper
 */
public class SaveDummyEffortInfo {

    
    private HashMap<String, String> case1;
    private HashMap<String, String> case2;
    
    IEffortInformation dummy1;
    IEffortInformation dummy2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new SaveDummyEffortInfo();
        EffortInfoLoader EILoader = new EffortInfoLoader();
        System.out.println(EILoader.getCaseIDs());
    }

    public SaveDummyEffortInfo() {
        System.out.println("hey listen");
        case1 = new HashMap<>();
        case2 = new HashMap<>();
        makeDummy();
        dummy1 = new EffortInformation(case1);
        dummy2 = new EffortInformation(case2);
        saveEffort();
    }

    private void makeDummy() {
        //Create case 2
        case1.put(EnumEffort.EFFORTPURPOSE.toString(), "Formålet med indsatsen er at støtte Jørgen til at blive stoffri, samt at han får stabile rammer angående sin økonomi og bolig.");
        case1.put(EnumEffort.EFFORTGOAL.toString(), "1. At Jørgen bliver stoffri\n" +
                                                    "2. At Jørgen ikke får tilbagefald i perioden\n" +
                                                    "3. At Jørgen får afklaret sine ønsker ift. sin bolig");
        case1.put(EnumEffort.EFFORTSERVICE1.toString(), "Misbrugsbehandling (§ 101)\n" +
                                                        "Støtte til administration (§85)");
        case1.put(EnumEffort.EFFORTSERVICE2.toString(), "");
        case1.put(EnumEffort.EFFORTOFFER1.toString(), "Midlertidigt botilbud");
        case1.put(EnumEffort.EFFORTOFFER2.toString(), "");
        case1.put(EnumEffort.EFFORTACCOUNTNUMBER1.toString(), "xxxxx");
        case1.put(EnumEffort.EFFORTACCOUNTNUMBER2.toString(), "");
        case1.put(EnumEffort.EFFORTSUPPLIER1.toString(), "Center for misbrug, xxx");
        case1.put(EnumEffort.EFFORTSUPPLIER2.toString(), "");
        case1.put(EnumEffort.EFFORTSTARTDATE1.toString(), "1.maj 2012");
        case1.put(EnumEffort.EFFORTSTARTDATE2.toString(), "");
        case1.put(EnumEffort.EFFORTENDDATE1.toString(), "1.august 2012");
        case1.put(EnumEffort.EFFORTENDDATE2.toString(), "");
        case1.put(EnumEffort.EFFORTSERVICEUNIT1.toString(), "dag");
        case1.put(EnumEffort.EFFORTSERVICEUNIT2.toString(), "");
        case1.put(EnumEffort.EFFORTSERVICEAMOUNT1.toString(), "90");
        case1.put(EnumEffort.EFFORTSERVICEAMOUNT2.toString(), "");
        case1.put(EnumEffort.EFFORTSERVICEPRICE1.toString(), "xxx");
        case1.put(EnumEffort.EFFORTSERVICEPRICE2.toString(), "");
        case1.put(EnumEffort.EFFORTPRICE1.toString(), "Ydelse 1 = (90*pris) = xxx\n" +
                                                      "Ydelse 2 = (10*pris) = vvv\n" +
                                                      "Pris for enkeltindsats = (xxx+vvv)");
        case1.put(EnumEffort.EFFORTPRICE2.toString(), "");
        case1.put(EnumEffort.EFFPRTPRICETOTAL.toString(), "Forventet pris for samlet indsats = (Pris for indsats 1 + pris for indsats 2)");
        
        //Create case 2
        case2.put(EnumEffort.EFFORTPURPOSE.toString(), "");
        case2.put(EnumEffort.EFFORTGOAL.toString(), "");
        case2.put(EnumEffort.EFFORTSERVICE1.toString(), "");
        case2.put(EnumEffort.EFFORTSERVICE2.toString(), "");
        case2.put(EnumEffort.EFFORTOFFER1.toString(), "");
        case2.put(EnumEffort.EFFORTOFFER2.toString(), "");
        case2.put(EnumEffort.EFFORTACCOUNTNUMBER1.toString(), "");
        case2.put(EnumEffort.EFFORTACCOUNTNUMBER2.toString(), "");
        case2.put(EnumEffort.EFFORTSUPPLIER1.toString(), "");
        case2.put(EnumEffort.EFFORTSUPPLIER2.toString(), "");
        case2.put(EnumEffort.EFFORTSTARTDATE1.toString(), "");
        case2.put(EnumEffort.EFFORTSTARTDATE2.toString(), "");
        case2.put(EnumEffort.EFFORTENDDATE1.toString(), "");
        case2.put(EnumEffort.EFFORTENDDATE2.toString(), "");
        case2.put(EnumEffort.EFFORTSERVICEUNIT1.toString(), "");
        case2.put(EnumEffort.EFFORTSERVICEUNIT2.toString(), "");
        case2.put(EnumEffort.EFFORTSERVICEAMOUNT1.toString(), "");
        case2.put(EnumEffort.EFFORTSERVICEAMOUNT2.toString(), "");
        case2.put(EnumEffort.EFFORTSERVICEPRICE1.toString(), "");
        case2.put(EnumEffort.EFFORTSERVICEPRICE2.toString(), "");
        case2.put(EnumEffort.EFFORTPRICE1.toString(), "");
        case2.put(EnumEffort.EFFORTPRICE2.toString(), "");
        case2.put(EnumEffort.EFFPRTPRICETOTAL.toString(), "");
    }

    private void saveEffort() {
        try{

            OutputStream outStream = new FileOutputStream("assets\\DummyEffort1.dummy");
            ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
            fileObjectOut.writeObject(dummy1);
            fileObjectOut.close();
            outStream.close();

            OutputStream outStream2 = new FileOutputStream("assets\\DummyEffort2.dummy");
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
