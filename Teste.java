package techStoree;
import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
	static Scanner scann =new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> noms = new ArrayList<String>();
        noms.add("Micro Casque 588 Filaire");
        noms.add("Clavier");
        noms.add("Souris");
        ArrayList<Double> prix = new ArrayList<Double>();
        prix.add(80.0);
        prix.add(45.0);
        prix.add(25.0);
        ArrayList<Long> quantites = new ArrayList<Long>();
        quantites.add(10L);
        quantites.add(15L);
        quantites.add(20L);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ArrayList<String> references = new ArrayList<String>();
        references.add(genererreference("Micro Casque 588 Filaire",1));
        references.add(genererreference("Clavier",2));
        references.add(genererreference("Souris",3));
        Stock stock = new Stock(ids,noms, references, prix, quantites);
        int choix;
        do {
            System.out.println("\n====== GESTION DU STOCK TECHSTORE ======");
            System.out.println("0 - Ajouter un article");
            System.out.println("1 - Augmenter la quantite d'un article");
            System.out.println("2 - Modifier un article");
            System.out.println("3 - Supprimer un article");
            System.out.println("4 - Consulter le stock");
            System.out.println("5 - Quitter");
            System.out.print("Donner votre choix : ");
            choix = scann.nextInt();
            scann.nextLine();
            switch (choix) {
                case 0:
                	System.out.print("Donner l'id : ");
                    int id = scann.nextInt();
                    System.out.print("Donner le nom : ");
                    String nom = scann.nextLine();
                    System.out.print("Donner le prix : ");
                    double p =Double.parseDouble(scann.nextLine());
                    System.out.print("Donner la quantite : ");
                    long q = scann.nextLong();
                    scann.nextLine();
                    if (p < 0 || q <= 0) {
                        System.out.println("Prix ou quantite invalide !");
                    } else {
                        stock.ajouterArticle(id,nom, genererreference(nom,id), p, q);
                        System.out.println("Article ajoute avec succes !");
                    } break;
                case 1:
                    System.out.println(stock);
                    System.out.print("Donner la reference : ");
                    String ref1 = scann.nextLine();
                    System.out.print("Donner la quantite a ajouter : ");
                    long qte = scann.nextLong();
                    scann.nextLine();
                    if (qte <= 0) {
                        System.out.println("Quantite invalide !");
                    } else if (stock.trouverArticle(ref1) == null) {
                        System.out.println("Article introuvable !");
                    } else {
                        stock.incrementerQuantiteArticle(ref1, qte);
                        System.out.println("Quantite augmentee avec succes !");
                    }break;
                case 2:
                    System.out.println(stock);
                    System.out.print("Donner la reference : ");
                    String ref2 = scann.nextLine();
                    System.out.print("Donner l'id : ");
                    int id2 = scann.nextInt();
            
                    Element e = stock.trouverArticle(ref2);
                    if (e == null) {
                        System.out.println("Article introuvable !");
                    } else {
                        System.out.print("Donner le nouveau prix : ");
                        Double prixx =Double.parseDouble(scann.nextLine());
                        Double px = scann.nextDouble();
                        if (px < 0) {
                            System.out.println("Prix invalide !");
                        } else {
                            stock.modifierArticle(id2, ref2,e.getNomArticle(),px,e.getQuantite()
                            );

                            System.out.println("Article modifie avec succes !");
                        }
                    }break;
                case 3:
                    System.out.println(stock);
                    System.out.print("Donner la reference : ");
                    String ref3 = scann.nextLine();
                    if (stock.trouverArticle(ref3) == null) {
                        System.out.println("Article introuvable !");
                    } else {
                        stock.supprimerArticle(ref3);
                        System.out.println("Article supprime avec succes !");
                    }break;
                case 4:
                    System.out.println("\n====== CONTENU DU STOCK ======");
                    System.out.println(stock);
                    System.out.println("Nombre d'articles : "+ stock.getArticleNb());
                    break;
                case 5:
                    System.out.println("Fin du programme !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 5);
    }
    public static String genererreference(String nom,int id) {
		String ref="";
		for (int i=0;i<nom.length();i++) {
			if(i%5==0) {
				char x=nom.charAt(i);
				if(x!=' ') {
					ref =ref + x;
				}
			}
		}
		return ref+ id;
	}
	
}