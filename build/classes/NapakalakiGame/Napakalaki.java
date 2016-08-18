/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Simon
 */
public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private int currentPlayerIndex;
    private Monster currentMonster;
    private CardDealer dealer=CardDealer.getInstance();
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    private Napakalaki(){
        currentPlayer=null;
        currentMonster=null;
    }
    
    private void initPlayers(ArrayList<String> names){
        players=new ArrayList();
        for(int i=0; i<names.size(); i++){
            Player x=new Player(names.get(i));
            players.add(x);
        }
    }
    
    private Player nextPlayer(){    
        if(currentPlayer==null){
            int numeroAleatorio = (int) (Math.random()*(players.size()));
            currentPlayerIndex=numeroAleatorio;
        }else{
            if(currentPlayerIndex==players.size()-1){
                currentPlayerIndex=0;
            }else{
                currentPlayerIndex++;
            }
        }
        
        this.currentPlayer=players.get(currentPlayerIndex);
        
        return players.get(currentPlayerIndex);
    }
    
    private boolean nextTurnAllowed(){
        if (this.currentPlayer == null) {
            return true;
        } else {
            return this.currentPlayer.validState();
        }
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
        CombatResult some_combat;
        some_combat=currentPlayer.combat(currentMonster);
        if(some_combat==CombatResult.LOSEANDCONVERT){
            Cultist next=dealer.nextCultist();
            CultistPlayer cultistPlayer = new CultistPlayer(currentPlayer, next);
            currentPlayer=cultistPlayer;
            players.set(currentPlayerIndex, currentPlayer);
        }
            
        dealer.giveMonsterBack(currentMonster);
        return some_combat;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure x: treasures){
            currentPlayer.discardVisibleTreasure(x);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure x: treasures){
            currentPlayer.discardHiddenTreasure(x);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure x: treasures){
            currentPlayer.makeTreasureVisible(x);
        }
    }
    
    public void initGame(ArrayList<String> players){
        this.initPlayers(players);
        dealer.initCards();
        this.nextTurn();
    }
    
    public Player getCurrentPlayer(){
        //currentPlayer=players.get(0);
        return this.currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return this.currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK=this.nextTurnAllowed();
                
        if(stateOK){
            currentMonster=dealer.nextMonster();
            currentPlayer=this.nextPlayer();
            boolean dead=currentPlayer.isDead();
            if(dead){
                currentPlayer.initTreasures();
            }
        }
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result==CombatResult.WINGAME;
    }
    
}
