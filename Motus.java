package algo.dev.project;

import algo.dev.interf.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class Motus extends Dico implements JeuMot{
	
	protected int nbCpRestant=8;
	protected String motATrouver_ = this.motAleatoireHuitLettres();
	protected List<String> motATrouver = this.motDansTableau(motATrouver_);
	protected List<Boolean> trouvee= new ArrayList<Boolean>();
	protected List<String> affichage= new ArrayList<String>();
	Boolean trouve = false;
	
	
	
	public boolean motTrouve() {
		int i;
		boolean test=true;
		for(i=0;i<this.motATrouver.size();i++) {
			if(this.trouvee.get(i)==false) {
				test=false;
			}
		}
		return test;
	}
	
	public void jouerCoup (String coup){
		int i,j;
		try {
			if(this.motDansDico(coup)==true) {// si le mot existe dans le dictionnaire
				if(coup.length()==8) {//si le mot fait 8 lettres
					List <String> mot_=this.motDansTableau(coup);
					for(i=0;i<mot_.size();i++) {
						Boolean res = false;
						for(j=0;j<mot_.size();j++) {
							if(this.motATrouver.get(i).equals(mot_.get(i))) {
								this.trouvee.set(i, true);
								this.affichage.set(i, mot_.get(i));/*si les 2 lettres placées a la même position sont égales, 
								la liste trouvee passe a true a la position et on affiche la lettre*/
					
							}
							else {
								if(this.motATrouver.get(j).equals(mot_.get(i))) {
									res = true;//sinon si la lettre n'est pas a la bonne place, on passe res a true
								}
				
							}
						}
						if(res==true) {//si la lettre n'est pas a la bonne place
							int pos = i+1;
							System.out.println("La lettre : "+mot_.get(i)+" en position "+pos+" n'est pas a la bonne place !");
						}
			
				
			}
					this.nbCpRestant--;//on enleve un coup dans tous les cas 
					System.out.println("NOMBRE DE COUPS RESTANTS : "+this.nbCpRestant);
			}
				else {
					System.out.println("ATTENTION, LE MOT "+coup+" NE FAIT PAS 8 LETTRES");
					this.nbCpRestant--;
					System.out.println("NOMBRE DE COUPS RESTANTS: "+this.nbCpRestant);
				}
			}
			else {
				System.out.println("ATTENTION, LE MOT "+coup+" N'EXISTE PAS !");
				this.nbCpRestant--;
				System.out.println("NOMBRE DE COUPS RESTANTS: "+this.nbCpRestant);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	
	public void afficherListe(List<String> l) {
		int x=l.size();
		int i;
		for(i=0;i<x;i++) {
			System.out.print(l.get(i));
			
		}
		System.out.println();
	}
	
	public void initialisation() {
		int nbL=motATrouver.size();
		int i;
		for(i=0;i<nbL;i++) {
			this.trouvee.add(false);// on initialise toute la liste trouvee a false
			this.affichage.add("_ "); // on affiche des _ pour chaque lettre non trouvée
			this.nbCpRestant=8;// le nombre de coups au motus est 8
		}
		System.out.println("JOUONS AU MOTUS ! ");
	}
	

	
	public void jouer() {
		this.initialisation();//on initialise le jeu
		System.out.println("(mot a trouver) : "+motATrouver);//!! AIDE non présente dans le jeu final
		this.afficherListe(affichage);//on affiche la liste
		Scanner sc = new Scanner(System.in);
		while( !trouve /*trouve == false*/ && nbCpRestant>=0){/*si le mot n'est pas trouvé, 
			et qu'il reste des coups a jouer : on continue de jouer*/
			
			System.out.println("Veuillez saisir un mot :");
			String motRentre_ = sc.nextLine();
			String motRentre = motRentre_.toUpperCase();//on lit ce que le joueur écrit, et on le passe en majuscule
			this.jouerCoup(motRentre);//on joue un coup avec le mot rentré par l'utilisateur
			trouve = this.motTrouve();//on regarde si le mot a été trouvé
			this.afficherListe(affichage);//enfin, on affiche la liste 
		}
		if(this.motTrouve()==true) {
			System.out.println("GAGNE");
		}
		else {
			System.out.println("PERDU, PLUS DE COUPS POSSIBLES");
		}
		sc.close();
	}
}
