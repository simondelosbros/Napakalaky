/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package NapakalakiGame;

//import java.util.ArrayList;
//import java.util.Arrays;

/**
 *
 * @author Simon
 */
//public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
        // TODO code application logic here
    /*  BadConsequence example= new BadConsequence("e", 5, 5, 5);
        Prize anything= new Prize(2, 2);
        Monster anyone= new Monster("idk", 5, example, anything);
        
        System.out.print(anyone.toString());
    */   
/*    
    //Creación de todos los Monstruos
    ArrayList<Monster> monstruos = new ArrayList();
    
    BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
    Prize prize = new Prize(2, 1);
    monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
    
    badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
    prize = new Prize(1, 1);
    monstruos.add(new Monster("Chibithulhu", 2, badConsequence, prize));
    
    badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
    prize = new Prize(1, 1);
    monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
    
    badConsequence = new BadConsequence("Te atrapan para llevarte de ﬁesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta" , 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
    prize = new Prize(4, 1);
    monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
    
    badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles", 0, 10, 0);
    prize = new Prize(3, 1);
    monstruos.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
    
    badConsequence = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
    prize = new Prize(2, 1);
    monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
    
    badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
    prize = new Prize(1, 1);
    monstruos.add(new Monster("Bichgooth", 2, badConsequence, prize));
    
    badConsequence = new BadConsequence(" Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
    prize = new Prize(4, 2);
    monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
    
    badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
    prize = new Prize(1, 1);
    monstruos.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
    
    badConsequence = new BadConsequence("Estos monstruos resultan bastante superﬁciales y te aburren mortalmente. Estas muerto");
    prize = new Prize(2, 1);
    monstruos.add(new Monster("Los hondos", 8, badConsequence, prize));
    
    badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
    prize = new Prize(2, 1);
    monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
    
    badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
    prize = new Prize(2, 1);
    monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
    
    badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
    prize = new Prize(1, 1);
    monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
    
    badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto");
    prize = new Prize(3, 1);
    monstruos.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
    
    badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.");
    prize = new Prize(4, 1);
    monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
    
    badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro bothhands visible", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
    prize = new Prize(2, 1);
    monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
    
    badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
    prize = new Prize(1, 1);
    monstruos.add(new Monster("El espia", 5, badConsequence, prize));
    
    badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
    prize = new Prize(1, 1);
    monstruos.add(new Monster("El Lenguas", 20, badConsequence, prize));
    
    badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND, TreasureKind.ONEHAND)), new ArrayList());
    prize = new Prize(1, 1);
    monstruos.add(new Monster("Bicéfalo", 20, badConsequence, prize));
    
    //Consultas
    
    System.out.print("\nMonstruos que tienen un nivel de combate superior a 10:\n");
    
    for(Monster monstruo : monstruos){
        if(monstruo.GetCombatLevel()>10){
            System.out.print(monstruo.GetName());
            System.out.print("\n");
        }
    }
    
    System.out.print("\nMonstruos que tienen un mal rollo que implica sólo pérdida de niveles: \n");
    
    for(Monster monstruo : monstruos){
        if(monstruo.GetBC().GetLevels()>0 && monstruo.GetBC().GetnHiddenTresures()==0 && monstruo.GetBC().GetnVisibleTreasures()==0 && monstruo.GetBC().GetSpecificHiddenTreasures().isEmpty() && monstruo.GetBC().GetSpecificVisibleTreasures().isEmpty()){
            System.out.print(monstruo.GetName());
            System.out.print("\n");
        }
    }
    
    System.out.print("\nMonstruos que su buen rollo indica una ganancia de niveles superior a 1.\n");
    
    for(Monster monstruo : monstruos){
        if(monstruo.GetPrize().GetLevel()>1){
            System.out.print(monstruo.GetName());
            System.out.print("\n");
        }
    }
    
    System.out.print("\nMonstruos que su mal rollo supone la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos...\n"); 
    
    for(Monster monstruo : monstruos){
        if(monstruo.GetBC().GetSpecificHiddenTreasures().size()>0 || monstruo.GetBC().GetSpecificVisibleTreasures().size()>0){
            System.out.print(monstruo.GetName());
            System.out.print("\n");
        }
    }

    }
}

*/