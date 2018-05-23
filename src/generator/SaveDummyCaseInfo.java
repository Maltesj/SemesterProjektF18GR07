/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package generator;

import acquaintance.Checklistable;
import java.util.HashMap;
import acquaintance.EnumCaseInformation;
import acquaintance.ICaseInformation;
import business.CaseInformation;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author malte
 */
public class SaveDummyCaseInfo {
    private HashMap<Checklistable, String> case1;
    private HashMap<Checklistable, String> case2;
    
    ICaseInformation dummy1;
    ICaseInformation dummy2;
    
    public static void main(String[] args) {
        SaveDummyCaseInfo sm = new SaveDummyCaseInfo();
        sm.saveGame();
    }
    
    SaveDummyCaseInfo()
    {
        System.out.println("hey listen");
        case1 = new HashMap<>();
        case2 = new HashMap<>();
        makeDummy();
        dummy1 = new CaseInformation(case1);
        dummy2 = new CaseInformation(case2);
        
    }

    public ICaseInformation getDummy1() {
        return dummy1;
    }

    public ICaseInformation getDummy2() {
        return dummy2;
    }
    
    private void makeDummy()
    {
        //Create cas1
        case1.put(EnumCaseInformation.PHYSICPROBLEM1, "Jørgen fortæller, at han er blevet opereret for to diskusprolaps og er fysisk nedslidt. ");
        case1.put(EnumCaseInformation.PHYSICPROBLEM2, "Det fremgår af notat fra egen læge, at Jørgen har gået i behandling for sin dårlige ryg igennem flere år. Han lider af slidgigt i skulder, nakke og ryg. ");
        case1.put(EnumCaseInformation.PHYSICPROBLEM3, "Jørgen virker meget plaget af sine fysiske problemer ");
        case1.put(EnumCaseInformation.PHYSICPROBLEM4, " 4 ");
        
        case1.put(EnumCaseInformation.PSYCICPROBLEM1, "Jørgen fortæller, at han inden for de sidste tre måneder har følt sig angst og deprimeret. Han føler, at han har været under pres i mange år, og han kan ikke selv finde ud af at blive glad. ");
        case1.put(EnumCaseInformation.PSYCICPROBLEM2,"Det fremgår af notat fra egen læge, at Jørgen tidligere har fået ordineret antidepressiv medicin i kortere perioder.\n" +
                "Jørgen er stoppet inden afslutning på behandling flere gange, selvom psykiater har vurderet det har været uhensigtsmæssigt (se notat xx). ");
        case1.put(EnumCaseInformation.PSYCICPROBLEM3, "");
        case1.put(EnumCaseInformation.PSYCICPROBLEM4, " 2 ");
        
        case1.put(EnumCaseInformation.SOCIALPROBLEM1, "Jørgen fortæller, at han har røget hash dagligt de sidste 15 år. Han bruger hashen som selvmedicinering mod sine fysiske problemer og mod sin nedtrykthed. Jørgen fortæller, at han dagligt ryger mellem 2 og 4 gram. Han får det dårligt hvis han ikke får sin daglige dosis.\n" +
                "Jørgen fortæller, at han ikke har nogen fast bopæl, og at han nogle gange bor på gaden. Han er derfor er bange for at blive anholdt af politiet. ");
        case1.put(EnumCaseInformation.SOCIALPROBLEM2, "");
        case1.put(EnumCaseInformation.SOCIALPROBLEM3, "Jørgen er reelt at betragte som hjemløs. Jørgen virker lettere påvirket af hash under samtalen. ");
        case1.put(EnumCaseInformation.SOCIALPROBLEM4, "3");
        
        //Case 2 is beeing created
        case2.put(EnumCaseInformation.SOCIALPROBLEM1, "Rikke fortæller at hun tidligere har været i et stofmisbrug, men hun er i dag stoffri efter et længerevarende behandlingsforløb ");
        case2.put(EnumCaseInformation.SOCIALPROBLEM2, "Det fremgår af journalnotat fra familieafdelingen, at Rikkes datter blev anbragt grundet Rikkes stofmisbrug (dato " +
                "xxx). Selve anbringelsen forløber godt og der er god kontakt mellem Rikke og datteren, samt i relationen til plejefamilien. ");
        case2.put(EnumCaseInformation.SOCIALPROBLEM3, "Til samtalen taler Rikke meget om, hvor glad hun er for at være ude af sit misbrug. Hun virker som om, at hun har lagt misbruget bag sig. ");
        case2.put(EnumCaseInformation.SOCIALPROBLEM4, " 4 ");
    }
    
    public void saveGame() {
        try{
            OutputStream outStream = new FileOutputStream("assets\\DummyCase1.info");
            ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
            fileObjectOut.writeObject(dummy1);
            fileObjectOut.close();
            outStream.close();

            OutputStream outStream2 = new FileOutputStream("assets\\DummyCase2.info");
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