
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.HashMap;

/**
 *
 * @author michael
 */
public class CaseInformation {
 private HashMap<String, String> textInformation;
 
 public CaseInformation(){
     
 }
 
 public CaseInformation(HashMap<String, String> textInformation){
     this.textInformation = textInformation;
 }
 
 HashMap<String, String> getInformation(){
    return textInformation;
     
 }
    
}
