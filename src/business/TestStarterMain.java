/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author micha
 */
public class TestStarterMain {
    public static void main(String[] args) {
        Information info = new Information("den seje case", new CaseInformation());
        info.write("jfhsdo", "sourceInfo");
        info.write("jfhsdo", "sourceInfo1");
        info.write("jfhsdo", "sourceInfo3");
        info.write("jfhsdo", "sourceInfo2");
        
        System.out.println(info.getFilledAssessmentFields());
    }
}
