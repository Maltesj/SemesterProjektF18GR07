/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

/**
 *
 * @author HCHB
 */
public enum EnumPhases {
    
    ACTIONPLAN(".actionplan"),
    ASSESSMENT(".assessment"),
    INFORMATION(".information");
    
    private String filetype;
    
    private EnumPhases(String filetype){
        this.filetype = filetype;
    }
    
    public String getFileType(){
        return this.filetype;
    }
}
