package algo.dev.project;


import java.io.BufferedReader;
import java.util.Random;

import java.util.Random;
import java.util.Scanner;

public class MotsMele extends Dico {
	
    int taille = 10;
    int nbSolution = 5;
	char T[][] = new char[taille][taille];
	char Mot[] = new char[taille];
	char Solution[][] = new char [nbSolution][taille];
	char Grille[][] = new char[taille][taille];
	
	void init() {
		this.CreerSolution();
		this.CreationGrille();
		this.afficherGrille();
	}
	
	
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
	
	public char alealigne(){
		
		Random rand = new Random();
		char c = (char)(rand.nextInt(26) + 65);
		return c;
	}
	
	char[] Mot() {
		char [] Mot = this.motDansTableau2(this.motAleatoiretaille(this.taille));
		return Mot;
	}
	
	
	void CreerSolution() {
		int i;
		int j;
		int taillemot;
		for (i = 0; i<nbSolution;i++) {
			this.Mot = this.Mot();
			taillemot = this.Mot.length;
			for(j=0 ; j< taillemot; j++) {
				this.Solution[i][j] = this.Mot[j];
				this.T[i][j]= this.Mot[j];
			}
		}
	}
	
	void CreationGrille() {
		int i;
		int j;
		int inverse;
		for(i=0; i<this.taille;i++) {
			for(j = 0; j<this.taille;j++) {
				this.Grille[i][j] = T[i][j];
				if(Grille[i][j] == '\u0000') {
					this.Grille[i][j] = this.alealigne();
			}
			}
			inverse = 1 + (int)(Math.random() * ((2 - 1) + 1));
			if(inverse == 1) {
				this.inverser(i);
			}
		}
	}
	
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
	
	
	boolean compare (char[] mot ,int i) {
		boolean verif = true;
		int j ;
		for(j = 0;j <this.taille;j++) {
			if(this.Solution[i][j] != '\u0000' && verif == true) {
				if(this.Solution[i][j] != mot[j]) {
					verif = false;
				}
			}
		}
		return verif;
	}
	
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
		this.init();
		Scanner sc = new Scanner(System.in);
		boolean verif = false;
		int nbmottrouver = 0;
		while(nbmottrouver < this.taille ){
			System.out.println("Veuillez saisir un mot :");
			String motRentre_ = sc.nextLine();
			String motRentre = motRentre_.toUpperCase();
			char[] Motrentre = motRentre.toCharArray();
			verif = this.comp(Motrentre);
			if(verif == true){
				  nbmottrouver++;
				  System.out.println("bien jouer");
			}
			else{
					 System.out.println("Erreur");
			}
		}
	}
	
}
