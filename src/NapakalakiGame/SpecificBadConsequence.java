/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Simon
 */
public class SpecificBadConsequence extends BadConsequence {
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h){
        super(t,l);
        specificVisibleTreasures=v;
        specificHiddenTreasures=h;
    }
    
    @Override
    public boolean isEmpty(){
        return (specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty());
    }
    
   public ArrayList<TreasureKind> GetSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> GetSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(!specificVisibleTreasures.isEmpty())
            specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public void substracHiddenTreasure(Treasure t){
        if(!specificHiddenTreasures.isEmpty())
            specificHiddenTreasures.remove(t.getType());  
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence adjustBadConsequence;
        if(v.isEmpty() && h.isEmpty()){
            adjustBadConsequence=new SpecificBadConsequence(this.text,this.levels,new ArrayList(),new ArrayList());
            return adjustBadConsequence;
        }else{
            ArrayList<TreasureKind> adjustspecificV=new ArrayList();
            ArrayList<TreasureKind> adjustspecificH=new ArrayList();
                
            for(int i=0; i<v.size(); i++){
                for(int j=0; j<this.specificVisibleTreasures.size(); j++){
                    if(v.get(i).getType()==this.specificVisibleTreasures.get(j))
                        adjustspecificV.add(this.specificVisibleTreasures.get(j));
                }
            }
                
            for(int i=0; i<h.size(); i++){
                for(int j=0; j<this.specificHiddenTreasures.size(); j++){
                    if(h.get(i).getType()==this.specificHiddenTreasures.get(j))
                        adjustspecificH.add(this.specificHiddenTreasures.get(j));
                }
            }
                
            adjustBadConsequence=new SpecificBadConsequence(this.text, this.levels, adjustspecificV, adjustspecificH);
            return adjustBadConsequence;
        }
    }
    
    @Override
    public String aCumplir(){
        return "SpecificVisible = " +specificVisibleTreasures+".\nSpecificHidden = " +specificHiddenTreasures+".";
    }
    
}
