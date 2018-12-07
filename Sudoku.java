import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
 
public class Sudoku extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int nbPoints = 0;
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);

private boolean verifColonne(int choix, int[][] tab, int ligne, int colonne)
{
	boolean verifLigne = true;
	for(int i=0; i<colonne; i++)
	{
		if(tab[i][colonne]==choix)
			verifLigne = false;
	}
	for(int i=colonne+1; i<9; i++)
	{
		if(tab[i][colonne]==choix)
			verifLigne = false;
	}
	return verifLigne;
}

private boolean verifLigne(int choix, int[][] tab, int ligne, int colonne)
{
	boolean verifColonne = true;
	for(int j=0; j<ligne; j++)
	{
		if(tab[ligne][j]==choix)
			verifColonne = false;
	}
	for(int j=ligne+1; j<9; j++)
	{
		if(tab[ligne][j]==choix)
			verifColonne = false;
	}
	return verifColonne;
}

private boolean verifRegion(int choix, int[][] tab, int ligne, int colonne)
{
	boolean verifRegion = true;
	int codeRegion=0;
	if(ligne >= 0 && ligne <= 2)
	{
		if(colonne >= 0 && colonne <= 2)
			codeRegion = 1;
		if(colonne >= 3 && colonne <= 5)
			codeRegion = 2;
		if(colonne >= 6 && colonne <= 8)
			codeRegion = 3;
	}
	if(ligne >= 3 && ligne <=5)
	{
		if(colonne >= 0 && colonne <= 2)
			codeRegion = 4;
		if(colonne >= 3 && colonne <= 5)
			codeRegion = 5;
		if(colonne >= 6 && colonne <= 8)
			codeRegion = 6;
	}
	if(ligne >= 6 && ligne <= 8)
	{
		if(colonne >= 0 && colonne <= 2)
			codeRegion = 7;
		if(colonne >= 3 && colonne <= 5)
			codeRegion = 8;
		if(colonne >= 6 && colonne <= 8)
			codeRegion = 9;
	}
	switch(codeRegion)
	{
	case 1:
		for(int i = 0; i <= 2; i++)
		{
			for(int j = 0; j <= 2; j++)
			{
				if(tab[i][j] == choix)
					verifRegion = false;
			}
		}
		break;
	case 2:
		for(int i = 0; i <= 2; i++)
		{
			for(int j = 3; j <= 5; j++)
			{
				if(tab[i][j] == choix)
					verifRegion = false;
			}
		}
		break;
	case 3:
		for(int i = 0; i <= 2; i++)
		{
			for(int j = 6; j <= 8; j++)
			{
				if(tab[i][j] == choix)
					verifRegion = false;
			}
		}
		break;
	case 4:
		for(int i = 3; i <= 5; i++)
		{
			for(int j = 0; j <= 2; j++)
			{
				if(tab[i][j] == choix)
					verifRegion = false;
			}
		}
		break;
	case 5:
		for(int i = 3; i <= 5; i++)
		{
			for(int j = 3; j <= 5; j++)
			{
				if(tab[i][j] == choix)
					verifRegion = false;
			}
		}
		break;
	case 6:
		for(int i = 3; i <= 5; i++)
		{
			for(int j = 6; j <= 8; j++)
			{
				if(tab[i][j] == choix)
					verifRegion = false;
			}
		}
		break;
	case 7:
		for(int i = 6; i <= 8; i++)
		{
			for(int j = 0; j <= 2; j++)
			{
				if(tab[i][j] == choix)
					verifRegion = false;
			}
		}
		break;
	case 8:
		for(int i = 6; i <= 8; i++)
		{
			for(int j = 3; j <= 5; j++)
			{
				if(tab[i][j] == choix)
					verifRegion = false;
			}
		}
		break;
	case 9:
		for(int i = 6; i <= 8; i++)
		{
			for(int j = 6; j <= 8; j++)
			{
				if(tab[i][j] == choix)
					verifRegion = false;
			}
		}
		break;
	}
	return verifRegion;
}

private boolean coupPossible(int choix, int[][] tab, int ligne, int colonne)
{
	boolean verif = false;
	if(verifLigne(choix, tab, ligne, colonne) == true && verifColonne(choix, tab, ligne, colonne) == true && verifRegion(choix, tab, ligne, colonne) == true)
		verif = true;
	return verif;
}

public void partieGagnee(int[][] tab, JFrame grille)
{
	boolean rempli = true;
	for(int i = 0; i<9; i++)
	{
		for(int j = 0; j<9; j++)
		{
			if(tab[i][j] == 0)
				rempli = false;
		}
	}
	if(rempli == true)
	{
		this.nbPoints = this.nbPoints + 1;
		JOptionPane.showMessageDialog(grille, "Victoire !\nVous avez remporté la partie !\n Vous avec actuellement " + nbPoints + "points.", "Victoire !", JOptionPane.INFORMATION_MESSAGE);
		String[] renouveau = { "Oui ", " Non" };
		int relance = JOptionPane.showOptionDialog(grille,
				"Voulez-vous retenter votre chance ?",
				"Relancer !",
				JOptionPane.YES_NO_CANCEL_OPTION,
	    		JOptionPane.QUESTION_MESSAGE,
				null,
				renouveau,
				renouveau[1]);
		if(relance == 0)
		{
			this.dispose();
			new JeuSudoku(this.nbPoints);
		}
		else
		{
			this.dispose();
			System.out.println(this.nbPoints);
		}
		
	}
}

public int getNbPoints()
{
	return this.nbPoints;
}
	
private int[][] getGrille(int choix)
{
	int[][] tab = new int[9][9];
	switch(choix) {
	//Grille level facile
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
	case 3:
		tab[0][0] = 8;
		tab[0][1] = 3;
		tab[0][4] = 4;
		tab[0][7] = 9;
		tab[0][8] = 2;
		tab[1][0] = 1;
		tab[1][3] = 2;
		tab[1][5] = 3;
		tab[1][6] = 7;
		tab[2][4] = 9;
		tab[2][5] = 7;
		tab[2][6] = 4;
		tab[2][7] = 1;
		tab[2][8] = 3;
		tab[3][3] = 3;
		tab[3][4] = 7;
		tab[3][5] = 8;
		tab[3][7] = 2;
		tab[4][0] = 3;
		tab[4][3] = 4;
		tab[4][5] = 9;
		tab[4][8] = 1;
		tab[5][1] = 7;
		tab[5][3] = 1;
		tab[5][4] = 6;
		tab[5][5] = 5;
		tab[6][0] = 2;
		tab[6][1] = 4;
		tab[6][2] = 3;
		tab[6][3] = 9;
		tab[6][4] = 8;
		tab[7][2] = 9;
		tab[7][3] = 5;
		tab[7][5] = 2;
		tab[7][8] = 6;
		tab[8][0] = 6;
		tab[8][1] = 8;
		tab[8][4] = 1;
		tab[8][7] = 3;
		tab[8][8] = 9;
		break;
	//Grille level moyen
	case 4:
		tab[0][2] = 8;
		tab[0][4] = 5;
		tab[0][5] = 9;
		tab[0][6] = 7;
		tab[0][7] = 2;
		tab[0][8] = 3;
		tab[1][0] = 2;
		tab[1][2] = 6;
		tab[1][3] = 3;
		tab[1][4] = 1;
		tab[1][7] = 5;
		tab[3][4] = 2;
		tab[3][5] = 5;
		tab[3][6] = 9;
		tab[3][7] = 3;
		tab[4][0] = 4;
		tab[4][8] = 7;
		tab[5][1] = 2;
		tab[5][2] = 3;
		tab[5][3] = 7;
		tab[5][4] = 8;
		tab[7][1] = 3;
		tab[7][4] = 9;
		tab[7][5] = 4;
		tab[7][6] = 6;
		tab[7][8] = 8;
		tab[8][0] = 8;
		tab[8][1] = 1;
		tab[8][2] = 4;
		tab[8][3] = 2;
		tab[8][4] = 6;
		tab[8][6] = 5;
		break;
	case 5:
		tab[0][1] = 3;
		tab[0][3] = 9;
		tab[0][6] = 5;
		tab[1][3] = 8;
		tab[1][5] = 5;
		tab[1][6] = 7;
		tab[1][7] = 3;
		tab[1][8] = 1;
		tab[2][2] = 5;
		tab[2][3] = 3;
		tab[2][8] = 6;
		tab[3][4] = 8;
		tab[3][5] = 9;
		tab[3][6] = 6;
		tab[3][8] = 4;
		tab[4][0] = 6;
		tab[4][3] = 7;
		tab[4][5] = 4;
		tab[4][8] = 3;
		tab[5][0] = 9;
		tab[5][2] = 4;
		tab[5][3] = 2;
		tab[5][4] = 6;
		tab[6][0] = 8;
		tab[6][5] = 2;
		tab[6][6] = 3;
		tab[7][0] = 4;
		tab[7][1] = 1;
		tab[7][2] = 2;
		tab[7][3] = 5;
		tab[7][5] = 7;
		tab[8][2] = 7;
		tab[8][5] = 8;
		tab[8][7] = 2;
		break;
	case 6:
		tab[0][0] = 7;
		tab[0][4] = 1;
		tab[0][5] = 9;
		tab[0][6] = 6;
		tab[1][1] = 6;
		tab[1][4] = 8;
		tab[1][7] = 9;
		tab[2][0] = 3;
		tab[2][4] = 5;
		tab[2][5] = 6;
		tab[2][7] = 2;
		tab[2][8] = 1;
		tab[3][1] = 2;
		tab[3][4] = 4;
		tab[3][6] = 7;
		tab[3][7] = 3;
		tab[3][8] = 8;
		tab[4][1] = 1;
		tab[4][7] = 5;
		tab[5][0] = 8;
		tab[5][1] = 7;
		tab[5][2] = 9;
		tab[5][4] = 2;
		tab[5][7] = 1;
		tab[6][0] = 9;
		tab[6][1] = 5;
		tab[6][3] = 8;
		tab[6][4] = 3;
		tab[6][8] = 4;
		tab[7][1] = 4;
		tab[7][4] = 9;
		tab[7][7] = 8;
		tab[8][2] = 8;
		tab[8][3] = 1;
		tab[8][4] = 6;
		tab[8][8] = 5;
		break;
	//Grille level difficile
	case 7:
		tab[0][3] = 4;
		tab[0][5] = 6;
		tab[0][8] = 8;
		tab[1][0] = 8;
		tab[1][1] = 5;
		tab[1][2] = 6;
		tab[1][7] = 3;
		tab[1][8] = 4;
		tab[2][1] = 4;
		tab[2][3] = 7;
		tab[2][4] = 8;
		tab[3][1] = 6;
		tab[3][6] = 5;
		tab[3][7] = 9;
		tab[4][2] = 4;
		tab[4][6] = 2;
		tab[5][1] = 8;
		tab[5][2] = 2;
		tab[5][7] = 1;
		tab[6][4] = 2;
		tab[6][5] = 9;
		tab[6][7] = 4;
		tab[7][0] = 9;
		tab[7][1] = 2;
		tab[7][6] = 8;
		tab[7][7] = 7;
		tab[7][8] = 5;
		tab[8][0] = 4;
		tab[8][3] = 1;
		tab[8][5] = 7;
		break;
	case 8:
		tab[0][0] = 2;
		tab[0][2] = 5;
		tab[0][5] = 1;
		tab[0][8] = 6;
		tab[1][0] = 8;
		tab[1][2] = 7;
		tab[1][6] = 9;
		tab[1][7] = 1;
		tab[2][3] = 6;
		tab[2][4] = 4;
		tab[3][1] = 2;
		tab[3][3] = 1;
		tab[3][6] = 3;
		tab[3][8] = 8;
		tab[5][0] = 1;
		tab[5][2] = 9;
		tab[5][5] = 6;
		tab[5][7] = 5;
		tab[6][4] = 7;
		tab[6][5] = 2;
		tab[7][1] = 3;
		tab[7][2] = 2;
		tab[7][6] = 6;
		tab[7][8] = 9;
		tab[8][0] = 5;
		tab[8][3] = 8;
		tab[8][6] = 2;
		tab[8][8] = 1;
		break;
	//Grille level diabolique
	case 9:
		tab[0][1] = 3;
		tab[0][3] = 2;
		tab[0][7] = 4;
		tab[1][1] = 7;
		tab[1][2] = 6;
		tab[1][5] = 9;
		tab[2][0] = 4;
		tab[2][1] = 5;
		tab[2][5] = 3;
		tab[2][6] = 2;
		tab[3][4] = 2;
		tab[3][8] = 1;
		tab[4][0] = 8;
		tab[4][2] = 7;
		tab[4][6] = 3;
		tab[4][8] = 4;
		tab[5][0] = 9;
		tab[5][4] = 4;
		tab[6][2] = 2;
		tab[6][3] = 5;
		tab[6][7] = 3;
		tab[6][8] = 9;
		tab[7][3] = 1;
		tab[7][6] = 5;
		tab[7][7] = 6;
		tab[8][1] = 9;
		tab[8][5] = 7;
		tab[8][7] = 1;
		break;
	}
	return tab;
}

public Sudoku(int nbPoints){
	this.nbPoints = nbPoints;
    this.setTitle("Grille sudoku");
    this.setSize(600,700);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setContentPane(new Graphique());
    this.setAlwaysOnTop(true);
    JFrame test = this;
    GridLayout gl = new GridLayout(9,9);
    gl.setHgap(1);
    gl.setVgap(1);
    setLayout(gl);
    String[] choixGrille = {" Facile - 1", " Facile - 2 ", " Facile - 3 ", " Moyen - 4 ", " Moyen - 5 ", " Moyen - 6 ", " Difficile - 7 ", " Difficile - 8 ", " Diabolique - 9 "};
    int choix = JOptionPane.showOptionDialog(null,
    		"Le jeu Sudoku est proposé avec 9 grilles.\nChoisissez la votre !",
    		"Choix de grille",
    		JOptionPane.YES_NO_CANCEL_OPTION,
    		JOptionPane.QUESTION_MESSAGE,
    		null,
    		choixGrille,
    		choixGrille[8]);
    final int[][] tab = getGrille(choix+1);
    for(int i=0; i<9; i++)
    {
    	final int ligne = i;
    	for(int j=0; j<9; j++)
    	{
    		int r = tab[i][j];
    		final int colonne = j;
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
                                    	String entier = JOptionPane.showInputDialog(test, "Jouez votre coup !", "Coup", JOptionPane.QUESTION_MESSAGE);
                                        int v = Integer.parseInt(entier);
                                        boolean coup = coupPossible(v, tab, ligne, colonne);
                                        tab[ligne][colonne] = v;
                                        if(coup == true)
                                        {
                                        	bouton.setText(entier);
                                        	partieGagnee(tab, test);
                                        }                                        	
                                        else
                                        {
                                    		JOptionPane.showMessageDialog(test, "Erreur. Impossible de jouer le coup.", "Erreur", JOptionPane.INFORMATION_MESSAGE);
                                        	tab[ligne][colonne] = 0;
                                        }                                       	
                                        
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
                          //System.out.println("Jouez votre coup !");
                          try {
                            Thread.sleep(0);
                          }  
                          catch (InterruptedException ex) {}  
                          //System.out.println("Coup joué !");
                           
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
        		add(bouton);
    		}    			
    	}
    }
    this.setVisible(true);
  }
}
