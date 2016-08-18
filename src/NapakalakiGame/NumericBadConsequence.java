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
public class NumericBadConsequence extends BadConsequence {
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence(String t, int l, int vis, int hid){
        super(t,l);
        nVisibleTreasures=vis;
        nHiddenTreasures=hid;
    }
    
    @Override
    public boolean isEmpty(){
        return (nVisibleTreasures==0 && nHiddenTreasures==0);
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTresures(){
        return nHiddenTreasures;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures>0)
            nVisibleTreasures--;
    }
    
    @Override
    public void substracHiddenTreasure(Treasure t){
        if(nHiddenTreasures>0)
            nHiddenTreasures--;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence adjustBadConsequence;
        if(v.isEmpty() && h.isEmpty()){
            adjustBadConsequence=new NumericBadConsequence(this.text,this.levels,0,0);
            return adjustBadConsequence;
        }else{
            int adjustVisible=this.nVisibleTreasures, adjustHidden=this.nHiddenTreasures;
            if(this.nVisibleTreasures>v.size())
                adjustVisible=v.size();
            if(this.nHiddenTreasures>h.size())
                adjustHidden=h.size();
            adjustBadConsequence=new NumericBadConsequence(this.text, this.levels, adjustVisible, adjustHidden);
            return adjustBadConsequence;
        }
    }
    
    @Override
    public String aCumplir(){
        return "nVisible = " + nVisibleTreasures + ".\nnHidden = " +nHiddenTreasures+".";
    }
    
}
