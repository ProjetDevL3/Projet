import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Dico_Mele {
	private BufferedReader br;

	public boolean motDansDico(String mot) throws IOException {
		try{
		String motTrouver=mot.toUpperCase();
		FileReader fr = new FileReader("dico.txt");
		br = new BufferedReader(fr);
		String line=null;
		while((line=br.readLine())!=null){
		   StringTokenizer st=new StringTokenizer(line);
		   while(st.hasMoreTokens()){
		      if(st.nextToken().equals(motTrouver)){
		         return true;
		      }
		      
		   }
		
		}
		return false;
	}catch(FileNotFoundException e){
        e.printStackTrace();
        return false;
    }catch(IOException e){
        e.printStackTrace();
        return false;
    }
	}
	
	public char[] motDansTableau (String mot) {
		char [] motretutn = mot.toCharArray();
	        
	    return motretutn;
	}
	
	public String motAleatoiretaille (int taille) {
		try{
		FileReader fr = new FileReader("dico.txt");
		br = new BufferedReader(fr);
		List <String> motstaille = cherchetaillelettre(taille);
		Random rand = new Random(); 
		int nbmottaille = this.nbMotsTaille(taille);
		int alea = rand.nextInt(nbmottaille);
		String resultat = motstaille.get(alea);
		return resultat;
	}catch(FileNotFoundException e){
	    e.printStackTrace();
	    return null;
	}
	}
	
	public int nbMotsTaille(int taille) {
		
		int i = 0;

		try {
		
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("dico.txt" )));
		      String line;
		      while ((line = br.readLine()) != null) {
		         if(line.length() <= taille) {
		        	 i=i+1;
		         }
		      }
		      br.close();
		}catch(FileNotFoundException e){
	        e.printStackTrace();
	        return i;
	    }catch(IOException e){
	        e.printStackTrace();
	        return i;
	    }

		return i;
	}
	
	public List<String> cherchetaillelettre(int taille) {
		try{
		List<String> motsHuitLettres= new ArrayList<String>();
		FileReader fr = new FileReader("dico.txt");
		br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
	        if(line.length() <= taille) {
	        	motsHuitLettres.add(line);
	        }
			
	    }
		return motsHuitLettres;
		}catch(FileNotFoundException e){
	        e.printStackTrace();
	        return null;
	    }catch(IOException e){
	        e.printStackTrace();
	        return null;
	    }
	}
	
}
