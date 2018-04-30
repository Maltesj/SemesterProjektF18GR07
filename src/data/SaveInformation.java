/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
        try{
            OutputStream outStream = new FileOutputStream("assets\\" + caseID +".vigtigInfo" );
            ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
            fileObjectOut.writeObject(info);
            fileObjectOut.close();
            outStream.close();

            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveDummyCaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveDummyCaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
