package algo.dev.project;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dico d=new Dico();
		Motus m=new Motus();
		Pendu p=new Pendu();
		Classement c=new Classement();
		MotMele jeu = new MotMele(10);
		String[] jeux= {"Pendu","Motus","Mots Mélés","Sudoku","Sudoku Lettres","Classement","Quitter"};
		JOptionPane jop = new JOptionPane();
		ImageIcon icon = new ImageIcon("becaro.gif");
		int rang=0;
		while(rang!=6) {
			rang = jop.showOptionDialog(null, "Bienvenue je suis Thierry Becaro\n"+"Que voulez vous faire ? ", "Choix Jeu!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon, jeux,jeux[0]);
			if(rang==0) {
				p.jouer();
			}
			if(rang==1) {
				m.jouer();
			}
			if(rang==5) {
				c.afficherCLassement();
			}
		}
		


}
}
