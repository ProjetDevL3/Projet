package algo.dev.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Classement {
	//Classement pendu
		protected int nbVictPendu;
		protected int nbDefPendu;
	
	//Classement motus
		protected int nbVictMotus;
		protected int nbDefMotus;
		
	//Classement Mots Mélés
		protected int nbVictMotsM;
		protected int nbErrMotsM;
		
	//CLassement Sudoku
		protected int nbGrillesC;
		
	//Classement Sudoku Lettres
		
		protected int nbGrillesCL;
		
		//Classement pendu
				protected int nbVictPendu2=0;
				protected int nbDefPendu2=0;
			
			//Classement motus
				protected int nbVictMotus2=0;
				protected int nbDefMotus2=0;
				
			//Classement Mots Mélés
				protected int nbVictMotsM2=0;
				protected int nbErrMotsM2=0;
				
			//CLassement Sudoku
				protected int nbGrillesC2=0;
				
			//Classement Sudoku Lettres
				
				protected int nbGrillesCL2=0;		
		
		public void initClass() {
			File outFile = new File("Classement.txt");
			try {
				FileOutputStream outFileStream = new FileOutputStream(outFile);
				PrintWriter outStream = new PrintWriter(outFileStream);
				outStream.println(0);
				outStream.println(0);
				outStream.println(0);
				outStream.println(0);
				outStream.println(0);
				outStream.println(0);
				outStream.println(0);
				outStream.println(0);
				outStream.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public void envoyerClassementFichier() {
			File outFile = new File("Classement.txt");
			try {
				FileOutputStream outFileStream = new FileOutputStream(outFile);
				PrintWriter outStream = new PrintWriter(outFileStream);
				outStream.println(this.nbVictPendu+this.nbVictPendu2);
				outStream.println(this.nbDefPendu+this.nbDefPendu2);
				outStream.println(this.nbVictMotus+this.nbVictMotus2);
				outStream.println(this.nbDefMotus+this.nbDefMotus);
				outStream.println(this.nbVictMotsM+this.nbVictMotsM2);
				outStream.println(this.nbErrMotsM+this.nbErrMotsM2);
				outStream.println(this.nbGrillesC+this.nbGrillesC2);
				outStream.println(this.nbGrillesCL+this.nbGrillesCL2);
				outStream.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public void recupererClassement() {
			File inFile= new File("Classement.txt");
			try{
				FileReader inFileStream = new FileReader(inFile);
				BufferedReader bufReader = new BufferedReader(inFileStream);
				String str;
				
				str= bufReader.readLine();
				this.nbVictPendu= Integer.parseInt(str);
				
				str= bufReader.readLine();
				this.nbDefPendu= Integer.parseInt(str);

				str= bufReader.readLine();
				this.nbVictMotus= Integer.parseInt(str);
				
				str= bufReader.readLine();
				this.nbDefMotus= Integer.parseInt(str);
				
				str= bufReader.readLine();
				this.nbVictMotsM= Integer.parseInt(str);
				
				str= bufReader.readLine();
				this.nbErrMotsM= Integer.parseInt(str);
				
				str= bufReader.readLine();
				this.nbGrillesC= Integer.parseInt(str);
				
				str= bufReader.readLine();
				this.nbGrillesCL= Integer.parseInt(str);

				

				bufReader.close();
			} 
			catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		public void afficherCLassement() {
			this.recupererClassement();
			this.envoyerClassementFichier();
			System.out.println("Vous avez gagné "+this.nbVictPendu +" fois au pendu");
			System.out.println("Vous avez perdu "+this.nbDefPendu +" fois au pendu");
			System.out.println("Vous avez gagné "+this.nbVictMotus +" fois au Motus");
			System.out.println("Vous avez perdu "+this.nbDefMotus +" fois au Motus");
			System.out.println("Vous avez gagné "+this.nbVictMotsM +" fois au Mots Mélés");
			System.out.println("Vous avez fait "+this.nbErrMotsM +" erreurs au Mots Mélés");
			System.out.println("Vous avez fait "+this.nbGrillesC +" grilles de sudoku");
			System.out.println("Vous avez fait "+this.nbGrillesCL +" grilles de sudoku lettres");
		}
	
	

}
