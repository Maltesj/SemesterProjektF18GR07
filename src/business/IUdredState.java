/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquaintance.Checklistable;
import java.util.Set;

/**
 *
 * @author malte
 */
public interface IUdredState {

    boolean savePhase(Information information, boolean online);
    void write(String text, Checklistable sourceInfo, Information information);
    Set<Checklistable> checkFields(Information information);
    Set<Checklistable> done(Information information, boolean online);
    void discard(Information information);
}