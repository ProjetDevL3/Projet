package algo.dev.project;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Pendu extends Dico {

		protected List<String> motList= this.motDansTableau(this.motAleatoire());
		protected List<Boolean> trouvee= new ArrayList<Boolean>();
		protected List<String> affichage= new ArrayList<String>();
		protected int nbCpRestant=5;
		
		protected void afficherListe(List<String> l) {
			int x=l.size();
			int i;
			for(i=0;i<x;i++) {
				System.out.print(l.get(i));
				
			}
			System.out.println();
		}
		
		protected void initialisation() {
			int nbL=motList.size();
			int i;
			for(i=0;i<nbL;i++) {
				this.trouvee.add(false);
				this.affichage.add("_ ");
			}
			System.out.println("Bienvenue au jeu du pendu");
		}
		
		protected boolean motTrouve() {
			int i;
			boolean test=true;
			for(i=0;i<this.motList.size();i++) {
				if(this.trouvee.get(i)==false) {
					test=false;
				}
			}
			return test;
		}
		
		protected void jouerLettre(String lettre_){
		int i;
		int cpt=0;
		String lettre = lettre_.toUpperCase();
		for(i=0;i<this.motList.size();i++) {
			if(this.motList.get(i).equals(lettre)) {
				this.trouvee.set(i, true);
				this.affichage.set(i, lettre);
				cpt++;
				
			}
			
			
		}
		if(cpt==0) {
			this.nbCpRestant--;
			System.out.println("Cette lettre n'appartient pas au mot. Nombre de vie restante: "+this.nbCpRestant);
		}
		}


		protected void jouer() {
		System.out.println("( mot a trouver ) : "+this.motList);
		this.initialisation();
		Scanner hj=new Scanner(System.in);
		this.afficherListe(affichage);
		while(this.nbCpRestant>0 && this.motTrouve()==false) {
			System.out.println("Entrer une Lettre: ");
			String lettre = hj.next();
			this.jouerLettre(lettre);
			this.motTrouve();
			this.afficherListe(affichage);
			
			
		}
		if(this.motTrouve()==true) {
			System.out.println("VICTOIRE");
		}
		else {
			System.out.println("DEFAITE");
		}
		hj.close();
	}


}
