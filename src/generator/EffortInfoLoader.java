/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import acquaintance.IEffortInformation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class EffortInfoLoader {
    private Set<String> caseIDs;
    
    EffortInfoLoader() {
        caseIDs = new TreeSet<>();
    }
    
    IEffortInformation getCaseInfo(String caseID) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("assets\\" + caseID + ".dummy")))
        {
            IEffortInformation EffortInfo = (IEffortInformation) in.readObject();
            return EffortInfo;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    Set<String> getCaseIDs(){
        File file = new File("assets\\");
        String[] files = file.list(); 
        for (int i = 0; i < files.length; i++) {
            int endIndex = files[i].indexOf('.');
            if(endIndex != -1) {
                caseIDs.add(files[i].substring(0, endIndex));
            }
        }
     
        return caseIDs;
    }
}
