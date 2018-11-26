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
				if(this.trouvee.get(i)==false) {
					test=false;
				}
			}
			return test;
		}
		
		public boolean jouerCoup(String coup){
		int i;
		int cpt=0;
		String lettre = coup.toUpperCase();
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
			return false;
		}
		return true;
		}


		public void jouer() {
		System.out.println("( mot a trouver ) : "+this.motList);
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
		ImageIcon victoire = new ImageIcon("victoire.gif");
		this.afficherListe(affichage);
		while(this.nbCpRestant>0 && this.motTrouve()==false) {
			if(this.nbCpRestant==10) {
				String lettre1=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre1);
				JOptionPane.showMessageDialog(null, "","",JOptionPane.INFORMATION_MESSAGE,img9);
				this.motTrouve();
			}
			if(this.nbCpRestant==9) {
				String lettre2=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre2);
				
					JOptionPane.showMessageDialog(null, "","",JOptionPane.INFORMATION_MESSAGE,img8);
				
				this.motTrouve();
			}
			if(this.nbCpRestant==8) {
				String lettre3=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre3);
				
					JOptionPane.showMessageDialog(null, "","",JOptionPane.INFORMATION_MESSAGE,img7);

				
				this.motTrouve();
			}
			if(this.nbCpRestant==7) {
				String lettre4=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre4);
				
					JOptionPane.showMessageDialog(null, "","",JOptionPane.INFORMATION_MESSAGE,img6);

				
				this.motTrouve();
			}
			if(this.nbCpRestant==6) {
				String lettre5=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre5);
				
					JOptionPane.showMessageDialog(null, "","",JOptionPane.INFORMATION_MESSAGE,img5);

				
				this.motTrouve();
			}
			if(this.nbCpRestant==5) {
				String lettre6=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre6);
				
					JOptionPane.showMessageDialog(null, "","",JOptionPane.INFORMATION_MESSAGE,img4);

				
				this.motTrouve();
			}
			if(this.nbCpRestant==4) {
				String lettre7=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre7);
				
					JOptionPane.showMessageDialog(null, "","",JOptionPane.INFORMATION_MESSAGE,img3);

				
				this.motTrouve();
			}
			if(this.nbCpRestant==3) {
				String lettre8=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre8);
				
					JOptionPane.showMessageDialog(null, "","",JOptionPane.INFORMATION_MESSAGE,img2);

				
				this.motTrouve();
			}
			if(this.nbCpRestant==2) {
				String lettre9=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre9);
				
					JOptionPane.showMessageDialog(null, "","",JOptionPane.INFORMATION_MESSAGE,img1);

				
				this.motTrouve();
			}
			if(this.nbCpRestant==1) {
				String lettre10=JOptionPane.showInputDialog(null,"Jouer une lettre\n"+"Nombre de coups restants: "+this.nbCpRestant+"\n"+String.join("", this.affichage),"Le jeu du pendu!", JOptionPane.QUESTION_MESSAGE);
				this.jouerCoup(lettre10);

				
				this.motTrouve();
			}
			
			
			
		}
		if(this.motTrouve()==true) {
			JOptionPane.showMessageDialog(null,"Victoire, le mot à trouver était\n"+this.mot,"Victoire", JOptionPane.INFORMATION_MESSAGE,victoire);
		}
		else {
			JOptionPane.showMessageDialog(null,"Défaite, le mot à trouver était: \n"+this.mot,"Défaite", JOptionPane.INFORMATION_MESSAGE,img0);
			
		}
		//hj.close();
		
		
	}


}
