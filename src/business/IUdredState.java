/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author malte
 */
public interface IUdredState {
    
<<<<<<< HEAD
    boolean savePhase(Information information);
    void write(String text, String sourceInfo, Information information);
    Set<String> checkFields(Information information);
    Set<String> done(Information information);
    void discard(Information information);
=======
    boolean savePhase(Information infoHolder);
    void write(String text, String sourceInfo);
    Set<String> checkFields();
    Set<String> done();
    void discard(Information infoHolder);
>>>>>>> 9506661273824e0bde851cab2345a72f55ad9181
    
}
