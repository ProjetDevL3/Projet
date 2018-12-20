package algo.dev.project;


import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Mots_Mele extends Dico {
	
    int taille = 10;     // taille de la grille taille*taille
    int nbSolution = 5;  //nombre de mot a trouver dans la grille
	char T[][] = new char[taille][taille];
	char Mot[] = new char[taille];
	char Solution[][] = new char [nbSolution][taille];
	char Grille[][] = new char[taille][taille]; 
	
	
	//initialisation du jeu 
	void init() {
		this.CreerSolution();
		this.CreationGrille();
		InterfaceMot M = new InterfaceMot(this);
	}
	
	//Permet d'afficher les solution
	void afficherSolution() {
		int i;
		int j;
		for(i = 0; i < this.nbSolution; i++) {
			for(j = 0; j < this.taille; j++) {
				System.out.print(this.Solution[i][j]);
			}
			System.out.println();
			}
		}
	
	//Permet d'afficher la grille de jeu
	void afficherGrille() {
		int i;
		int j;
		for(i = 0; i < this.taille; i++) {
			for(j = 0; j < this.taille; j++) {
				System.out.print(this.Grille[i][j]);
			}
			System.out.println();
			}
		}
	
	// renvoi une lettre alleatoire en majuscule
	public char alealigne(){
		
		Random rand = new Random();
		char c = (char)(rand.nextInt(26) + 65);
		return c;
	}
	
	// Permet de chercher un mot dans le dico
	char[] Mot() {
		char [] Mot = this.motDansTableau(this.motAleatoiretaille(this.taille));
		return Mot;
	}
	
	// Permet la creation du tableau Solution
	void CreerSolution() {
		int i;
		int j;
		int taillemot;
		for (i = 0; i<nbSolution;i++) {
			this.Mot = this.Mot(); // recuperation mot du dico
			taillemot = this.Mot.length; // recuperation taille du mot
			for(j=0 ; j< taillemot; j++) {
				this.Solution[i][j] = this.Mot[j]; //on ajoute le mot du dico dans le tableau solution
				this.T[i][j]= this.Mot[j]; //on ajoute le mot du dico dans le tableau Tampon
			}
		}
	}
	
	// Permet la creation de la Grille de Jeux 
	void CreationGrille() {
		int i;
		int j;
		int inverse;
		for(i=0; i<this.taille;i++) {
			for(j = 0; j<this.taille;j++) {
				this.Grille[i][j] = T[i][j]; // on ajoute le mot stocker dans le tableau tampon dans la grille
				if(Grille[i][j] == '\u0000') {  //permet de completer la ligne de la grille si le mot dans le tampon est inferieur a la taille
					this.Grille[i][j] = this.alealigne(); 
			}
			}
			inverse = 1 + (int)(Math.random() * ((2 - 1) + 1));
			if(inverse == 1) {
				this.inverser(i); // on inver le mot stocker dans la ligne i
			}
		}
	}
	
	/* Compare si le mot renter par l'utilisateur se trouver 
	dans la grille solution*/
	boolean comp(char[] mot) {
		boolean v = false;
		int i;
		for(i = 0; i< this.nbSolution;i++) {
			if (v == false) {
				v = this.compare(mot, i);
			}
		}
		return v;
	}
	
	//Compare le mot de l'utilisateur avec une ligne de la grille Solution
	boolean compare (char[] mot ,int i) {
		boolean verif = true;
		int j ;
		for(j = 0;j <this.taille;j++) {
			if(this.Solution[i][j] != '\u0000' & verif == true) {
				if(this.Solution[i][j] != mot[j]) {
					verif = false;
				}
			}
		}
		if(verif == true) { // Si le mot renter est correct alors suppresion de la ligne
			this.supprimerMot(i);
		}
		return verif;
	}
	 // Permet la supression de la ligne i dans la grille solution
	void supprimerMot(int i) {
		int j;
		for(j=0;j<this.taille;j++){
			this.Solution[i][j] = 'A'; // on remplace par A car si on met '\u0000' on obtient un erreur
		}
	}
	//Permet d'inverser un mot dans la grille 
	void inverser(int i) {
		int j;
		int taille = this.taille(this.Grille[i]);
		char temp;
		for(j=0;j < taille/2 ;j++) {
			temp = this.Grille[i][j]; 
			this.Grille[i][j] = this.Grille[i][taille-j-1];
			this.Grille[i][taille-j-1] = temp;
		}
	}
	
	// Calcule la taille d'un mot
	int taille(char[] mot) {
		int i;
		int comp = 0;
		for(i =0; i<this.taille;i++){
			if(mot[i] !='\u0000') {
				comp++;
			}
		}
		
		return comp;
	}
	
	void jouer() {
		this.init();  // Initialisation du jeux
		Scanner sc = new Scanner(System.in);
		boolean verif = false; 
		int nbmottrouver = 0; // initialisation du nombre de mot trouver
		while(nbmottrouver < this.nbSolution ){
			this.afficherSolution();
			System.out.println("Veuillez saisir un mot :");
			String motRentre_=(String) JOptionPane.showInputDialog(null,"Jouer un mot\n"+String.join(""),"Le jeu du Mots Meles!", JOptionPane.QUESTION_MESSAGE);
			String motRentre = motRentre_.toUpperCase(); // Met le mot en majuscule
			char[] Motrentre = motRentre.toCharArray();  // Covertit le String en Char
			verif = this.comp(Motrentre);
			if(verif == true){
				  nbmottrouver++;
				  JOptionPane.showMessageDialog(null,"bien jouer","bien jouer", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
					 JOptionPane.showMessageDialog(null,"Erreur","Erreur", JOptionPane.INFORMATION_MESSAGE);
			}
			int resteMot = this.nbSolution-nbmottrouver;
			System.out.println("Il vous reste "+ resteMot+ " Mots");
		}
		if(nbmottrouver == this.nbSolution) {
			JOptionPane.showMessageDialog(null,"Victoire","Victoire", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null,"Défaite","Défaite", JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
	
}

