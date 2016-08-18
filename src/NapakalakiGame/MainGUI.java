/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.Dice;
import GUI.NapakalakiView;
import java.util.ArrayList;
import GUI.PlayerNamesCaptures;

/**
 *
 * @author Simon
 */
public class MainGUI {
    public static void main(String[] args){
        Napakalaki game=Napakalaki.getInstance();
        NapakalakiView napakalakiView=new NapakalakiView();
        ArrayList<String> names=new ArrayList();
        PlayerNamesCaptures namesCapture= new PlayerNamesCaptures(napakalakiView, true);
        Dice.createInstance(napakalakiView);
        names=namesCapture.getNames();
        game.initGame(names);
        napakalakiView.setNapakalaki(game);
        napakalakiView.setVisible(true);
    }
}
