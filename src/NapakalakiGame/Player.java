/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import GUI.Dice;

/**
 *
 * @author Simon
 */
public class Player {
    static final int MAXLEVEL=10;
    private String name;
    private int level;
    private boolean dead=true;
    private ArrayList<Treasure> hiddenTreasures=new ArrayList();
    private ArrayList<Treasure> visibleTreasures=new ArrayList();
    private BadConsequence pendingBadConsequence;
    
    public Player(String name){
        this.name=name;
        //Creo que la inicializacion del badconsequence puede dar algun problema...
        this.pendingBadConsequence=new NumericBadConsequence("Inicializacion",0,0,0);
        this.level=1;
    }
    
    public Player(Player p){
        this.name=p.name;
        this.level=p.level;
        this.dead=p.dead;
        this.hiddenTreasures=p.hiddenTreasures;
        this.visibleTreasures=p.visibleTreasures;
        this.pendingBadConsequence=p.pendingBadConsequence;
    }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        dead=false;
    }
    
    public int getCombatLevel(){
        int bonus_visible=0;
        
        for(Treasure tesoro : visibleTreasures){
            bonus_visible+=tesoro.getBonus();
        }
        
        return level+bonus_visible;
    }
    
    private void incrementLevels(int i){
        if(i>=1)
            level+=i;
    }
    
    private void decrementeLevels(int i){
        if(i<level)
            level-=i;
        else
            level=1;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence=b;
    }
    
    private void applyPrize(Monster m){
        int nLevels=m.getLevelsGained();
        this.incrementLevels(nLevels);
        int nTreasures=m.getTreasuresGained();
        
        if(nTreasures>0){
            CardDealer dealer=CardDealer.getInstance();
            for(int i=0; i<nTreasures; i++){
                Treasure treasure=dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence=m.getBadConsequence();
        int nLevels=badConsequence.getLevels();
        this.decrementeLevels(nLevels);
        pendingBadConsequence=badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        this.setPendingBadConsequence(pendingBadConsequence); 
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        int manos_ocupadas=0;
        for(Treasure x : visibleTreasures){
            if(x.getType()==TreasureKind.ONEHAND)
                manos_ocupadas+=1;
                
            if(x.getType()==t.getType() && t.getType()!=TreasureKind.ONEHAND){ //PONGO MANOS_OCUPADAS AQUI?
                return false;
            }
            else{
                if(t.getType()==TreasureKind.BOTHHANDS){
                    if(x.getType()==TreasureKind.ONEHAND){
                        return false;
                    }
                }else if(t.getType()==TreasureKind.ONEHAND){
                    if(x.getType()==TreasureKind.BOTHHANDS || manos_ocupadas==2){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int n=0;
        
        for(Treasure tesoro: visibleTreasures){
            if(tesoro.getType()==tKind)
                n++;
        }
        
        return n;
    }
    
    private void dieIfNoTreasures(){
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            dead=true;
    }
    
    
    public boolean isDead(){
        return dead==true;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        CombatResult combatResult;
        
        int myLevel=this.getCombatLevel();
        int monsterLevel=this.getOponentLevel(m);
        
        if(myLevel>monsterLevel){
            this.applyPrize(m);
            if(level>=MAXLEVEL)
                combatResult=CombatResult.WINGAME;
            else
                combatResult=CombatResult.WIN;
        }
        else{
            if(this.shouldConvert())
                combatResult=CombatResult.LOSEANDCONVERT;
            else
                combatResult=CombatResult.LOSE;
            
            this.applyBadConsequence(m);
        }
        
        return combatResult;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canl=this.canMakeTreasureVisible(t);
        
        if(canl){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        CardDealer.getInstance().giveTreasureBack(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(t);
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        CardDealer.getInstance().giveTreasureBack(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substracHiddenTreasure(t);
        this.dieIfNoTreasures();
    }
    
    public boolean validState(){
        return (pendingBadConsequence.isEmpty() && hiddenTreasures.size()<=4);
    }
    
    public void initTreasures(){
        CardDealer dealer=CardDealer.getInstance();
        Dice dice=Dice.getInstance();
        this.bringToLife();
        Treasure treasure=dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number=dice.nextNumber("Lanza el dado para ","conseguir de uno a tres tesoros.");
        
        if(number>1){
            treasure=dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        if(number==6){
            treasure=dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public int getLevels(){
        return level;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> visibleCopy=new ArrayList(visibleTreasures);
        ArrayList<Treasure> hiddenCopy=new ArrayList(hiddenTreasures);
        
        for(Treasure x: visibleCopy){
            this.discardVisibleTreasure(x);
        }
        
        for(Treasure y: hiddenCopy){
            this.discardHiddenTreasure(y);
        }
    }
    
    public int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
    
    public boolean shouldConvert(){
        int number=Dice.getInstance().nextNumber("Lanza el dado; si sacas", "un 6, te convertirás en sectario.");
        
        return number==6;
    }
    
    //EL TOSTRING POR DEFECTO NO ME FUNCIONABA BIEN
    @Override
    public String toString(){
        return name +", nivel " +level+", nivel de combate " +this.getCombatLevel()+"\nMal rollo que cumplir: " +pendingBadConsequence.aCumplir();
    }

}
