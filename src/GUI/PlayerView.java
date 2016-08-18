/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Simon
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel;
    private Napakalaki napakalakiModel;
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
        this.setBackground(Color.CYAN);
    }

    public void setNapakalakiModel(Napakalaki n){
        napakalakiModel=n;
    }
    
    public void setPlayer(Player p){
        playerModel=p;
        
        this.button_make_visible.setEnabled(true);
        
        this.name.setText(playerModel.getName());
        this.levels.setText("Level: " +Integer.toString(playerModel.getLevels())+ ""
                + ", Combat Level: " +Integer.toString(playerModel.getCombatLevel())+ ".");
      
        
        if(playerModel instanceof CultistPlayer)
            this.is_cultist.setText("yes");
        else
            this.is_cultist.setText("no");
        
        this.cultistsnumber.setText(Integer.toString(CultistPlayer.getTotalCultistPlayers()));
        
        this.fillTreasurePanel(visible_treasures,playerModel.getVisibleTreasures());
        this.fillTreasurePanel(hidden_treasures,playerModel.getHiddenTreasures());
        
        this.pendingBadConsequenceView1.setPending(playerModel.getPendingBadConsequence());
        
        repaint();
        revalidate();
    }
    
     public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua, si la hubiera
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel 
        for (Treasure t : aList){
            TreasureView aTreasureView = new TreasureView(); 
            aTreasureView.setTreasure(t); 
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView); 
        }
        // Se fuerza la actualización visual del panel 
        aPanel.repaint(); 
        aPanel.revalidate(); 
    }
    
    public void UndiscoveredMonster(){
        button_make_visible.setEnabled(true);
        button_discard.setEnabled(true);
        button_discard_all.setEnabled(true);
    } 
     
    public void DiscoveredMonster(){
        button_make_visible.setEnabled(false);
        button_discard.setEnabled(false);
        button_discard_all.setEnabled(false);
    }
     
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) { 
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellos que están seleccionados.
        // Finalmente se devuelve dicho vector.
    
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
                output.add (tv.getTreasure());
        }
        return output;
    }
    
    public javax.swing.JButton get_button_make_visible(){
        return button_make_visible;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        text_jugador = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();
        visible_treasures = new javax.swing.JPanel();
        hidden_treasures = new javax.swing.JPanel();
        text_visible = new javax.swing.JLabel();
        text_hidden = new javax.swing.JLabel();
        text_is_cultist = new javax.swing.JLabel();
        is_cultist = new javax.swing.JLabel();
        text_n_cultist = new javax.swing.JLabel();
        cultistsnumber = new javax.swing.JLabel();
        text_pending = new javax.swing.JLabel();
        pendingBadConsequenceView1 = new GUI.PendingBadConsequenceView();
        button_make_visible = new javax.swing.JButton();
        button_discard = new javax.swing.JButton();
        button_discard_all = new javax.swing.JButton();

        jButton1.setText("jButton1");

        text_jugador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        text_jugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_jugador.setText("CURRENT PLAYER:");
        text_jugador.setBorder(new javax.swing.border.MatteBorder(null));
        text_jugador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        text_jugador.setMaximumSize(new java.awt.Dimension(96, 14));
        text_jugador.setMinimumSize(new java.awt.Dimension(96, 14));
        text_jugador.setName(""); // NOI18N
        text_jugador.setPreferredSize(new java.awt.Dimension(96, 14));

        name.setText("name");

        levels.setText("level: 0, combat level: 0.");

        visible_treasures.setBorder(new javax.swing.border.MatteBorder(null));

        hidden_treasures.setBorder(new javax.swing.border.MatteBorder(null));

        text_visible.setText("Visible Treasures:");

        text_hidden.setText("Hidden Treasures:");

        text_is_cultist.setText("Is cultist?");

        is_cultist.setText("yes/no");

        text_n_cultist.setText("Cultists' number:");

        cultistsnumber.setText("n");

        text_pending.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        text_pending.setText("Pending Bad Consequence:");

        button_make_visible.setText("Make Visible");
        button_make_visible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_make_visibleActionPerformed(evt);
            }
        });

        button_discard.setText("Discard Treasure");
        button_discard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_discardActionPerformed(evt);
            }
        });

        button_discard_all.setText("Discard all Treasures");
        button_discard_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_discard_allActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_jugador, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_is_cultist)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(is_cultist))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_n_cultist)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cultistsnumber))
                            .addComponent(levels)
                            .addComponent(name)))
                    .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(text_pending)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 522, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_discard_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_make_visible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_discard, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(visible_treasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hidden_treasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text_visible)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_hidden)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text_jugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levels)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_is_cultist)
                                    .addComponent(is_cultist))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_n_cultist)
                                    .addComponent(cultistsnumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_pending)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pendingBadConsequenceView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_make_visible, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_discard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_discard_all, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text_visible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(visible_treasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(text_hidden)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hidden_treasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_make_visibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_make_visibleActionPerformed
        // TODO add your handling code here:
        ArrayList selHidden = getSelectedTreasures(hidden_treasures);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_button_make_visibleActionPerformed

    private void button_discardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_discardActionPerformed
        // TODO add your handling code here:
        ArrayList<Treasure> selVisible = getSelectedTreasures(visible_treasures);
        napakalakiModel.discardVisibleTreasures(selVisible);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hidden_treasures);
        napakalakiModel.discardHiddenTreasures(selHidden);
        
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_button_discardActionPerformed

    private void button_discard_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_discard_allActionPerformed
        // TODO add your handling code here:
        playerModel.discardAllTreasures();
        setPlayer(playerModel);
        
    }//GEN-LAST:event_button_discard_allActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_discard;
    private javax.swing.JButton button_discard_all;
    private javax.swing.JButton button_make_visible;
    private javax.swing.JLabel cultistsnumber;
    private javax.swing.JPanel hidden_treasures;
    private javax.swing.JLabel is_cultist;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel levels;
    private javax.swing.JLabel name;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView1;
    private javax.swing.JLabel text_hidden;
    private javax.swing.JLabel text_is_cultist;
    private javax.swing.JLabel text_jugador;
    private javax.swing.JLabel text_n_cultist;
    private javax.swing.JLabel text_pending;
    private javax.swing.JLabel text_visible;
    private javax.swing.JPanel visible_treasures;
    // End of variables declaration//GEN-END:variables
}
