import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class InterfaceMot extends JFrame {

	public InterfaceMot(Mots_Mele M){
		int i;
		int j;
	    this.setTitle("Mots_Mele");
	   this.setSize(600,700);
	    this.setLocation(0, 0);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setAlwaysOnTop(true);
	    //JFrame test = this;
	    GridLayout gl = new GridLayout(10,10);
	    gl.setHgap(1);
	    gl.setVgap(1);
	    setLayout(gl);
	    for(i = 0 ; i< M.taille;i++) {
	    	for(j = 0; j<M.taille;j++) {
	    		char r = M.Grille[i][j];
    			String c = Character.toString(r);
    			JToggleButton bouton = new JToggleButton(c);
    			bouton.setEnabled(false);
        		add(bouton);
	    	}
	    }
	    this.setVisible(true);
	}
}
