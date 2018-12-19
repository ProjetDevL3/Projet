package algo.dev.project;


import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

import algo.dev.interf.*;
import java.util.ArrayList;
import java.util.List;

public class Pendu extends Dico implements JeuMot{

		protected String mot=this.motAleatoire();
		protected List<String> motList= this.motDansTableau(this.mot);
		protected List<Boolean> trouvee= new ArrayList<Boolean>();
		protected List<String> affichage= new ArrayList<String>();
		protected int nbCpRestant=10;
		
		public void afficherListe(List<String> l) {
			int x=l.size();
			int i;
			for(i=0;i<x;i++) {
				System.out.print(l.get(i));
				
			}
		}
		
		public void initialisation() {
			int nbL=motList.size();
			int i;
			for(i=0;i<nbL;i++) {
				this.trouvee.add(false);
				this.affichage.add("_ ");
			}
		}
		
		public boolean motTrouve() {
			int i;
			boolean test=true;
			for(i=0;i<this.motList.size();i++) {
				if(this.trouvee.get(i)==false) {// on verifie lettre par lettre si le mot a été trouvé
					test=false;
				}
			}
			return test;
		}
		
		public void jouerCoup(String coup){
		int i;
		int cpt=0;
		String lettre = coup.toUpperCase();//on met toutes les lettres en majuscules 
		for(i=0;i<this.motList.size();i++) {
			if(this.motList.get(i).equals(lettre)) {//si la lettre jouée est égale a la lettre recherchée
				this.trouvee.set(i, true);//on met true dans la liste trouvee, car la lettre a été trouvée
				this.affichage.set(i, lettre);// la lettre trouvée s'affiche
				cpt++;//on incremente cpt si la lettre appartient au mot
			}
			
			
		}
		if(cpt==0) {
			this.nbCpRestant--;// si la lettre n'appartient pas au mot, on enleve un coup
			System.out.println("Cette lettre n'appartient pas au mot. Nombre de vie restante: "+this.nbCpRestant);
		}
		}


		public void jouer() {
		System.out.println("( mot a trouver ) : "+this.motList);//aide pour les tests
		this.initialisation();
		ImageIcon img0 = new ImageIcon("pendu0.png");
		ImageIcon img1 = new ImageIcon("pendu1.png");
		ImageIcon img2 = new ImageIcon("pendu2.png");
		ImageIcon img3 = new ImageIcon("pendu3.png");
		ImageIcon img4 = new ImageIcon("pendu4.png");
		ImageIcon img5 = new ImageIcon("pendu5.png");
		ImageIcon img6 = new ImageIcon("pendu6.png");
		ImageIcon img7 = new ImageIcon("pendu7.png");
		ImageIcon img8 = new ImageIcon("pendu8.png");
		ImageIcon img9 = new ImageIcon("pendu9.png");
		ImageIcon img10 = new ImageIcon("pendu10.png");
		ImageIcon victoire = new ImageIcon("victoire.gif");//on affecte toutes les images
		while(this.nbCpRestant>0 && this.motTrouve()==false) {// en fonction du nombre de coups restants on va afficher l'image correspondante, en jouant un coup en meme temps
			if(this.nbCpRestant==10) {
				String lettre1=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img10,null,"");
				this.jouerCoup(lettre1);
				this.motTrouve();
			}
			if(this.nbCpRestant==9) {
				String lettre2=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img9,null,"");
				this.jouerCoup(lettre2);
				this.motTrouve();
			}
			if(this.nbCpRestant==8) {
				String lettre3=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img8,null,"");
				this.jouerCoup(lettre3);
				this.motTrouve();
			}
			if(this.nbCpRestant==7) {
				String lettre4=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img7,null,"");
				this.jouerCoup(lettre4);
				this.motTrouve();
			}
			if(this.nbCpRestant==6) {
				String lettre5=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img6,null,"");
				this.jouerCoup(lettre5);
				this.motTrouve();
			}
			if(this.nbCpRestant==5) {
				String lettre6=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img5,null,"");
				this.jouerCoup(lettre6);
				this.motTrouve();
			}
			if(this.nbCpRestant==4) {
				String lettre7=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img4,null,"");
				this.jouerCoup(lettre7);
				this.motTrouve();
			}
			if(this.nbCpRestant==3) {
				String lettre8=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img3,null,"");
				this.jouerCoup(lettre8);
				this.motTrouve();
			}
			if(this.nbCpRestant==2) {
				String lettre9=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img2,null,"");
				this.jouerCoup(lettre9);
				this.motTrouve();
			}
			if(this.nbCpRestant==1) {
				String lettre10=(String) JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE,img1,null,"");
				this.jouerCoup(lettre10);
				this.motTrouve();
			}
			
			
			
		}// on sort de la boucle, le mot a été trouvé, ou on a perdu la partie
		if(this.motTrouve()==true) { //si le mot a été trouvé
			JOptionPane.showMessageDialog(null,"Victoire, le mot à trouver était\n"+this.mot,"Victoire", JOptionPane.INFORMATION_MESSAGE,victoire);
		}
		else {//si lemot n'a pas été trouvé, on met un petit mot d'encouragement au joueur 
			JOptionPane.showMessageDialog(null,"Défaite, le mot à trouver était: \n"+this.mot+"\n Vous aurez plus de chance la prochaine fois !\n","Défaite", JOptionPane.INFORMATION_MESSAGE,img0);
			
		}
		
		
	}


}
