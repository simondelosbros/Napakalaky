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
public class Monster {
    private String name;
    private int combatLevel;
    private BadConsequence badConsequence;
    private Prize prize;
    private int levelChangeAgainstCultistPlayer=0;
    
    public Monster(String name, int combatLevel, BadConsequence badConsequence, Prize prize){
        this.name=name;
        this.combatLevel=combatLevel;
        this.badConsequence=badConsequence;
        this.prize=prize;
        this.levelChangeAgainstCultistPlayer=0;
    }
    
    public Monster(String name, int combatLevel, BadConsequence badConsequence, Prize prize, int lC){
        this.name=name;
        this.combatLevel=combatLevel;
        this.badConsequence=badConsequence;
        this.prize=prize;
        this.levelChangeAgainstCultistPlayer=lC;
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return this.getCombatLevel()+levelChangeAgainstCultistPlayer;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return badConsequence;
    }
    
    public int getLevelsGained(){
        return prize.GetLevels();
    }
    
    public int getTreasuresGained(){
        return prize.GetTreasures();
    }
    
    
    //EL TOSTRING POR DEFECTO NO ME FUNCIONABA BIEN
    @Override
    public String toString(){
        return "Name = " + name + ", Combat Level = " + combatLevel + ".\n" + badConsequence.toString() + "Bonus: " +this.getTreasuresGained()+" tesoros y "+this.getLevelsGained()+" nivel.";
    }

}
