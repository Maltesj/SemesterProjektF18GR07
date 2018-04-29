/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package data;

import java.util.HashMap;
import acquaintance.ConstantsEnum;
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
    private HashMap<String, String> case1;
    private HashMap<String, String> case2;
    
    ICaseInformation dummy1;
    ICaseInformation dummy2;
    public static void main(String[] args) {
        SaveDummyCaseInfo sm = new SaveDummyCaseInfo();
        CaseInfoLoader cm = new CaseInfoLoader();
        System.out.println(cm.getCaseIDs());
    }
    
    private SaveDummyCaseInfo()
    {
        System.out.println("hey listen");
        case1 = new HashMap<>();
        case2 = new HashMap<>();
        makeDummy();
        dummy1 = new CaseInformation(case1);
        dummy2 = new CaseInformation(case2);
        saveGame();
    }
    
    private void makeDummy()
    {
        //Create cas1
        case1.put(ConstantsEnum.PHYSICPROBLEM1.toString(), "Jørgen fortæller, at han er blevet opereret for to diskusprolaps og er fysisk nedslidt. ");
        case1.put(ConstantsEnum.PHYSICPROBLEM2.toString(), "Det fremgår af notat fra egen læge, at Jørgen har gået i behandling for sin dårlige ryg igennem flere år. Han lider\n" +
                "af slidgigt i skulder, nakke og ryg. ");
        case1.put(ConstantsEnum.PHYSICPROBLEM3.toString(), "Jørgen virker meget plaget af sine fysiske problemer ");
        case1.put(ConstantsEnum.PHYSICPROBLEM4.toString(), "over 9000!");
        
        case1.put(ConstantsEnum.PSYCICPROBLEM1.toString(), "Jørgen fortæller, at han inden for de sidste tre måneder har følt sig angst og deprimeret. Han føler, at han har\n" +
                "været under pres i mange år, og han kan ikke selv finde ud af at blive glad. ");
        case1.put(ConstantsEnum.PSYCICPROBLEM2.toString(),"Det fremgår af notat fra egen læge, at Jørgen tidligere har fået ordineret antidepressiv medicin i kortere perioder.\n" +
                "Jørgen er stoppet inden afslutning på behandling flere gange, selvom psykiater har vurderet det har været\n" +
                "uhensigtsmæssigt (se notat xx). ");
        case1.put(ConstantsEnum.PSYCICPROBLEM3.toString(), "");
        case1.put(ConstantsEnum.PSYCICPROBLEM4.toString(), "less than 9000...");
        
        case1.put(ConstantsEnum.SOCIALPROBLEM1.toString(), "Jørgen fortæller, at han har røget hash dagligt de sidste 15 år. Han bruger hashen som selvmedicinering mod\n" +
                "sine fysiske problemer og mod sin nedtrykthed. Jørgen fortæller, at han dagligt ryger mellem 2 og 4 gram. Han får\n" +
                "det dårligt hvis han ikke får sin daglige dosis.\n" +
                "Jørgen fortæller, at han ikke har nogen fast bopæl, og at han nogle gange bor på gaden. Han er derfor er bange\n" +
                "for at blive anholdt af politiet. ");
        case1.put(ConstantsEnum.SOCIALPROBLEM2.toString(), "");
        case1.put(ConstantsEnum.SOCIALPROBLEM3.toString(), "Jørgen er reelt at betragte som hjemløs. Jørgen virker lettere påvirket af hash under samtalen. ");
        case1.put(ConstantsEnum.SOCIALPROBLEM4.toString(), "3");
        
        //Case 2 is beeing created
        case2.put(ConstantsEnum.SOCIALPROBLEM1.toString(), "Rikke fortæller at hun tidligere har været i et stofmisbrug, men hun er i dag stoffri efter et længerevarende\n behandlingsforløb ");
        case2.put(ConstantsEnum.SOCIALPROBLEM2.toString(), "Det fremgår af journalnotat fra familieafdelingen, at Rikkes datter blev anbragt grundet Rikkes stofmisbrug (dato " +
                "xxx). Selve anbringelsen forløber godt og der er god kontakt mellem Rikke og datteren, samt i relationen til\n" +
                "plejefamilien. ");
        case2.put(ConstantsEnum.SOCIALPROBLEM3.toString(), "Til samtalen taler Rikke meget om, hvor glad hun er for at være ude af sit misbrug. Hun virker som om, at hun har\n" +
                "lagt misbruget bag sig. ");
        case2.put(ConstantsEnum.SOCIALPROBLEM4.toString(), "0");
    }
    
    public void saveGame() {
        try{
            System.out.println("got to here");
            OutputStream outStream = new FileOutputStream("C:\\Users\\malte\\OneDrive\\Dokumenter\\NetBeansProjects\\SemesterProjektF18\\assets\\DummyCase1.dummy");
            ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
            fileObjectOut.writeObject(dummy1);
            fileObjectOut.close();
            outStream.close();
            System.out.println("made it this far");
            
            
            OutputStream outStream2 = new FileOutputStream("C:\\Users\\malte\\OneDrive\\Dokumenter\\NetBeansProjects\\SemesterProjektF18\\assets\\DummyCase2.dummy");
            ObjectOutputStream fileObjectOut2 = new ObjectOutputStream(outStream2);
            fileObjectOut2.writeObject(dummy2);
            fileObjectOut2.close();
            outStream2.close();
            System.out.println("here too");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveDummyCaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveDummyCaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}