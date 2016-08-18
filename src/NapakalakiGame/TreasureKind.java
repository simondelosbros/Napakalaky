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
public enum TreasureKind {
    ARMOR, ONEHAND, BOTHHANDS, HELMET, SHOES;
    
    @Override
    public String toString(){
        String s;
        
        switch (this) {
            case ARMOR: {
                s = "Armor";
                break;
            }
            case ONEHAND: {
                s = "One hand";
                break;
            }
            case BOTHHANDS: {
                s = "Both hands";
                break;
            }
            case HELMET: {
                s = "Helmet";
                break;
            }
            case SHOES: {
                s = "Shoes";
                break;
            }
            default: {
                s = "ERROR";
                break;
            }
        }
        
        return s; 
    }

}
