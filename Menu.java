package algo.dev.project;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dico d=new Dico();
		Classement c=new Classement();
		String[] jeux= {"Pendu","Motus","Mots Mélés","Sudoku","Sudoku Lettres","Classement","Quitter"};
		JOptionPane jop = new JOptionPane();
		ImageIcon icon = new ImageIcon("becaro.gif");
		int rang=0;
		while(rang!=6) {
			rang = jop.showOptionDialog(null, "Bienvenue je suis Thierry Becaro\n"+"Que voulez vous faire ? ", "Choix Jeu!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon, jeux,jeux[0]);
			if(rang==0) {
				Pendu p=new Pendu();
				p.jouer();
				if(p.motTrouve()==true) {
					c.nbVictPendu2++;
				}
				else c.nbDefPendu2++;
			}
			if(rang==1) {
				Motus m=new Motus();
				m.jouer();
				if(m.motTrouve()==true) {
					c.nbVictMotus2++;
				}
				else c.nbDefMotus2++;
			}
			if(rang==2) {
				MotsMele jeu = new MotsMele();
				jeu.jouer();
			}
			if(rang==5) {
				c.afficherCLassement();
			}
		}
		


}
}
