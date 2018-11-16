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
		protected int nbVictPendu=0;
		protected int nbDefPendu=0;
	
	//Classement motus
		protected int nbVictMotus=0;
		protected int nbDefMotus=0;
		
	//Classement Mots Mélés
		protected int nbVictMotsM=0;
		protected int nbErrMotsM=0;
		
	//CLassement Sudoku
		protected int nbGrillesC=0;
		
	//Classement Sudoku Lettres
		
		protected int nbGrillesCL=0;
		
		public void envoyerClassementFichier() {
			File outFile = new File("Classement.txt");
			try {
				FileOutputStream outFileStream = new FileOutputStream(outFile);
				PrintWriter outStream = new PrintWriter(outFileStream);
				outStream.println(this.nbVictPendu);
				outStream.println(this.nbDefPendu);
				outStream.println(this.nbVictMotus);
				outStream.println(this.nbDefMotus);
				outStream.println(this.nbVictMotsM);
				outStream.println(this.nbErrMotsM);
				outStream.println(this.nbGrillesC);
				outStream.println(this.nbGrillesCL);
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
