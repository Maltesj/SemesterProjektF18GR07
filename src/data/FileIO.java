/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.EnumPhases;
import acquaintance.IActionplan;
import acquaintance.IAssessment;
import acquaintance.ICaseInformation;
import acquaintance.IWork;
import generator.CaseInfoLoader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class FileIO {
    
    private String caseID;
    
    FileIO(String caseID){
        this.caseID = caseID;
    }
    
    void save(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan){
        this.save(caseInfo);
        this.save(assessment);
        this.save(actionplan);
        this.save(work);
    }
    
    void save(ICaseInformation caseInfo){
        try(OutputStream outStream = new FileOutputStream("assets\\" + this.caseID +EnumPhases.INFORMATION.getFileType()); 
                ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream)){
            fileObjectOut.writeObject(caseInfo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void save(IAssessment assessment){
        try(OutputStream outStream = new FileOutputStream("assets\\" + this.caseID +EnumPhases.ASSESSMENT.getFileType()); 
                ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream)){
            fileObjectOut.writeObject(assessment);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void save(IActionplan actionplan){
        try(OutputStream outStream = new FileOutputStream("assets\\" + this.caseID +EnumPhases.ACTIONPLAN.getFileType()); 
                ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream)){
            fileObjectOut.writeObject(actionplan);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    void save(IWork work){
        try(OutputStream outStream = new FileOutputStream("assets\\" + this.caseID +EnumPhases.WORK.getFileType()); 
                ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream)){
            fileObjectOut.writeObject(work);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    ICaseInformation loadCaseInfo(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("assets\\" + this.caseID + EnumPhases.INFORMATION.getFileType()))) {
            ICaseInformation caseInfo = (ICaseInformation) in.readObject();
            return caseInfo;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    IAssessment loadAssessment(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("assets\\" + this.caseID + EnumPhases.ASSESSMENT.getFileType())))
        {
            IAssessment assessmentInfo = (IAssessment) in.readObject();
            return assessmentInfo;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    IActionplan loadActionplan(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("assets\\" + this.caseID + EnumPhases.ACTIONPLAN.getFileType())))
        {
            IActionplan actionplanInfo = (IActionplan) in.readObject();
            return actionplanInfo;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    IWork loadWork(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("assets\\" + this.caseID + EnumPhases.WORK.getFileType())))
        {
            IWork workInfo = (IWork) in.readObject();
            return workInfo;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CaseInfoLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}