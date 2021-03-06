/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Simon
 */
public class CardDealer {
    private static final CardDealer instance=new CardDealer();
    private ArrayList<Monster> unusedMonsters=new ArrayList();
    private ArrayList<Monster> usedMonsters=new ArrayList();
    private ArrayList<Treasure> unusedTreasures=new ArrayList();
    private ArrayList<Treasure> usedTreasures=new ArrayList();
    private ArrayList<Cultist> unusedCultist=new ArrayList();
    
    private CardDealer(){
        
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora de Thompson", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato de Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycón", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
    }
    
    private void initMonsterCardDeck(){
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
    /*
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));

        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));

        badConsequence = new BadConsequence("Te atrapan para llevarte de ﬁesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta" , 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));

        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));

        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));

        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence, prize));

        badConsequence = new BadConsequence(" Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));

        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));

        badConsequence = new BadConsequence("Estos monstruos resultan bastante superﬁciales y te aburren mortalmente. Estas muerto");
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));

        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));

        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));

        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));

        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto");
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));

        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.");
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));

        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro bothhands visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));

        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));

        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence, prize));

        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
    */
        //MONSTRUOS QUE AFECTAN A SECTARIOS
        badConsequence = new BadConsequence("Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
        
        badConsequence = new BadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, badConsequence, prize, +2));
        
        badConsequence = new BadConsequence("Hoy no es tu día de suerte. Mueres");
        prize = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran Cthulhu", 20, badConsequence, prize, +4));
        
        badConsequence = new BadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente Político", 8, badConsequence, prize, -2));
        
        badConsequence = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, +5));
        
        badConsequence = new BadConsequence("Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        badConsequence = new BadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, +3));
    }
    
    private void initCultistCardDeck(){
        unusedCultist.add(new Cultist("Agaricus", 1));
        unusedCultist.add(new Cultist("Boletus", 2));
        unusedCultist.add(new Cultist("Daldinia", 1));
        unusedCultist.add(new Cultist("Bolbitius", 2));
        unusedCultist.add(new Cultist("Calvatia", 1));
        unusedCultist.add(new Cultist("Dermoloma", 1));
    }
    
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    private void shuffleCultist(){
        Collections.shuffle(unusedCultist);
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    public Treasure nextTreasure(){
        if(unusedTreasures.isEmpty()){
            unusedTreasures=new ArrayList(usedTreasures);
            usedTreasures.clear();
            shuffleTreasures();
        }
        
        Treasure a_devolver=unusedTreasures.get(0);
        unusedTreasures.remove(0);
        return a_devolver;
    }
    
    public Monster nextMonster(){
        if(unusedMonsters.isEmpty()){
            unusedMonsters=new ArrayList(usedMonsters);
            usedMonsters.clear();
            shuffleMonsters();
        }
        
        Monster a_devolver=unusedMonsters.get(0);
        unusedMonsters.remove(0);
        return a_devolver;
    }
    
    public Cultist nextCultist(){
        Cultist a_devolver=unusedCultist.get(0);
        unusedCultist.remove(0);
        return a_devolver;
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        this.initMonsterCardDeck();
        this.initTreasureCardDeck();
        this.initCultistCardDeck();
        this.shuffleTreasures();
        this.shuffleMonsters();
        this.shuffleCultist();
    }
    
}
