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
public class CultistPlayer extends Player{
    static private int totalCultistPlayer=0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard=c;
        totalCultistPlayer++;
    }
    
    @Override
    protected int getCombatLevel(){
        double suma=super.getCombatLevel()*1.5+myCultistCard.getGainedLevels()*totalCultistPlayer;
        int a_devolver=(int)suma;
        return a_devolver;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
       return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    static public int getTotalCultistPlayer(){
        return totalCultistPlayer;
    }
    
}
