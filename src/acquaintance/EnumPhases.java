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
    
    ACTIONPLAN(".actionplan", "actionplan"),
    ASSESSMENT(".assessment", "assessment"),
    WORK(".work", "work"),
    INFORMATION(".information", "information");
    
    private String filetype;
    private String phase;

    
    private EnumPhases(String filetype, String phase){
        this.filetype = filetype;
        this.phase = phase;
    }
    
    public String getFileType(){
        return this.filetype;
    }

    public String getPhase() {
        return phase;
    }
    
    
}
