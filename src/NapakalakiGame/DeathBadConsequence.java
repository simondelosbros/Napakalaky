/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Simon
 */
public class DeathBadConsequence extends NumericBadConsequence {
    public DeathBadConsequence(String t){
        super(t, Player.MAXLEVEL, BadConsequence.MAXTREASURES, BadConsequence.MAXTREASURES);
    }
    
/*    @Override
    public String aCumplir(){
        return "Mueres. Descarta todos tus tesoros.";
    }*/
}
