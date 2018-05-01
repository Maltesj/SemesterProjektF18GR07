/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.Constants;
import acquaintance.IInformation;
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
public class SaveInformation {
    
   
    
    
     public void saveInformation(IInformation info, String caseID) {
        try(ObjectOutputStream fileObjectOut = new ObjectOutputStream(new FileOutputStream("assets\\" + caseID + Constants.fileType ))){
             
            
            fileObjectOut.writeObject(info);
  

            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveDummyCaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveDummyCaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    
}
