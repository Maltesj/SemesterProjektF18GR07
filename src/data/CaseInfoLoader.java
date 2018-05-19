/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import acquaintance.ICaseInformation;
import acquaintance.IWork;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author malte
 */
public class CaseInfoLoader {

    private Set<String> caseIDs;
    CaseInfoLoader() {
        caseIDs = new TreeSet<>();
    }
    
    ICaseInformation getCaseInfo(String caseID) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("assets\\" + caseID + ".info")))
        {
            ICaseInformation caseInfo = (ICaseInformation) in.readObject();
            return caseInfo;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    IWork getWork(String caseID) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("assets\\" + caseID + ".effort")))
        {
            IWork work = (IWork) in.readObject();
            return work;
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