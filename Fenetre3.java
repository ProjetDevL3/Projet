package algo.dev.project;

import java.awt.Button;
//import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class Fenetre3 extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	Scanner hc = new Scanner(System.in);

private int[][] getGrille()
{
	int[][] tab = new int[9][9];
	int choix = hc.nextInt();
	if(choix<1 || choix>9)
	{
		System.out.println("Erreur. Réessayez. (Grille introuvable.");
		tab = getGrille();
	}
	switch(choix) {
	case 1:
		tab[0][3] = 4;
		tab[0][6] = 8;
		tab[0][7] = 7;
		tab[1][1] = 4;
		tab[1][2] = 7;
		tab[1][4] = 9;
		tab[1][5] = 2;
		tab[1][7] = 5;
		tab[2][0] = 2;
		tab[2][3] = 6;
		tab[2][7] = 3;
		tab[3][0] = 9;
		tab[3][1] = 7;
		tab[3][3] = 5;
		tab[3][6] = 2;
		tab[3][8] = 3;
		tab[4][0] = 5;
		tab[4][2] = 8;
		tab[4][4] = 2;
		tab[4][5] = 4;
		tab[4][6] = 7;
		tab[4][8] = 6;
		tab[5][0] = 6;
		tab[5][2] = 4;
		tab[5][5] = 7;
		tab[5][7] = 8;
		tab[5][8] = 5;
		tab[6][1] = 9;
		tab[6][3] = 3;
		tab[6][5] = 8;
		tab[6][8] = 7;
		tab[7][2] = 3;
		tab[7][3] = 2;
		tab[7][4] = 4;
		tab[7][6] = 1;
		tab[7][7] = 6;
		tab[8][1] = 1;
		tab[8][2] = 2;
		tab[8][7] = 9;
		break;
	case 2:
		tab[0][1] = 5;
		tab[0][4] = 2;
		tab[0][6] = 9;
		tab[1][3] = 9;
		tab[1][7] = 1;
		tab[1][8] = 5;
		tab[2][1] = 9;
		tab[2][3] = 5;
		tab[2][4] = 1;
		tab[2][5] = 4;
		tab[2][7] = 3;
		tab[3][1] = 7;
		tab[3][4] = 5;
		tab[3][5] = 6;
		tab[3][6] = 1;
		tab[4][1] = 4;
		tab[4][2] = 5;
		tab[4][6] = 2;
		tab[4][7] = 9;
		tab[5][2] = 3;
		tab[5][3] = 2;
		tab[5][4] = 4;
		tab[5][7] = 8;
		tab[6][1] = 3;
		tab[6][3] = 1;
		tab[6][4] = 8;
		tab[6][5] = 7;
		tab[6][7] = 2;
		tab[7][0] = 4;
		tab[7][1] = 8;
		tab[7][5] = 2;
		tab[8][2] = 2;
		tab[8][4] = 3;
		tab[8][7] = 7;
		break;
	}
	return tab;
}

public Fenetre3(){
  this.setTitle("Grille sudoku");
  this.setSize(400, 500);
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLayout(new GridLayout(9,9));
  System.out.println("Le jeu Sudoku est proposé avec 9 grilles. (1-3 Facile / 4-6 Moyen / 7-9 Difficile");
  System.out.println("Choisissez la votre !");
  int[][] tab = getGrille();
  for(int i=0; i<9; i++)
  {
  	for(int j=0; j<9; j++)
  	{
  		int r = tab[i][j];
  		String c;
  		if(r==0)
  		{
  			c ="";
  			JToggleButton bouton = new JToggleButton(c);
  			bouton.addItemListener(new ItemListener(){
                  
                  public void itemStateChanged(ItemEvent itemEvent){
                     
                    if(itemEvent.getStateChange() == ItemEvent.SELECTED){ 
                         
                        //Change le texte du bouton
                        Thread t = new Thread(new Runnable(){
                          public void run() {
                              Thread st = new Thread(new Runnable(){
                                  public void run() {
                                      System.out.println("Coup confirmé !");
                                      int v = hc.nextInt();
                                      String b = Integer.toString(v);
                                      bouton.setText(b);
                                  }
                              });
       
                              if(SwingUtilities.isEventDispatchThread()){
                                  st.start();
                                   
                                  //Attend que le texte soit changé
                                  while(st.isAlive());
                              }
                              else{
                                SwingUtilities.invokeLater(st);
                                 
                                //Attend que le texte soit changé
                                while(!st.isAlive() && st.isAlive());
                              }
                          }
                        });
                        t.start();                     
                         
                        //Attend le changement de texte du bouton
                        while(t.isAlive());
                         
                        //Traitement
                        System.out.println("Jouez votre coup !");
                        try {
                          Thread.sleep(5000);
                        }  
                        catch (InterruptedException ex) {}  
                        System.out.println("Coup joué !");
                         
                        //Fin du traitement (jamais executé)
                        bouton.setSelected(false);
                    }
                  }
              });
      		add(bouton);
  		}    			
  		else
  		{
  			c = Integer.toString(r);
  			JToggleButton bouton = new JToggleButton(c);
  			bouton.setEnabled(false);
  			bouton.addItemListener(new ItemListener(){
                  
                  public void itemStateChanged(ItemEvent itemEvent){
                     
                    if(itemEvent.getStateChange() == ItemEvent.SELECTED){ 
                         
                        //Change le texte du bouton
                        Thread t = new Thread(new Runnable(){
                          public void run() {
                              Thread st = new Thread(new Runnable(){
                                  public void run() {
                                      System.out.println("Coup confirmé !");
                                      int v = hc.nextInt();
                                      String b = Integer.toString(v);
                                      bouton.setText(b);
                                  }
                              });
       
                              if(SwingUtilities.isEventDispatchThread()){
                                  st.start();
                                   
                                  //Attend que le texte soit changé
                                  while(st.isAlive());
                              }
                              else{
                                SwingUtilities.invokeLater(st);
                                 
                                //Attend que le texte soit changé
                                while(!st.isAlive() && st.isAlive());
                              }
                          }
                        });
                        t.start();                     
                         
                        //Attend le changement de texte du bouton
                        while(t.isAlive());
                         
                        //Traitement
                        System.out.println("Jouez votre coup !");
                        try {
                          Thread.sleep(5000);
                        }  
                        catch (InterruptedException ex) {}  
                        System.out.println("Coup Joué !");
                         
                        //Fin du traitement (jamais executé)
                        bouton.setSelected(false);
                    }
                  }
              });
      		add(bouton);
  		}    			
  	}
  }
  this.setVisible(true);
}
}
