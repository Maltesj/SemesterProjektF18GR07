/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author malte
 */
public class AssessmentInformation {
  private HashMap<String, String> textInformation;

  
  public AssessmentInformation(){
    textInformation =   new HashMap<>();
  }
  public Set<String> getFilledFields(){
      
   return textInformation.keySet();   
  }
  public void write(String text, String sourceInfo){
      textInformation.put(sourceInfo, text);
      if (text.equals("")||text.equals(null)){
        textInformation.remove(sourceInfo);
        
      }
   
   
         
      
  } 
  }

