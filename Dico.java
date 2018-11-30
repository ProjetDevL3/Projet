package algo.dev.project;

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

public class Dico{
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
	
	public List<String> motDansTableau (String mot) {
		int n = mot.length();
	    int i;
	    List<String> listeMot= new ArrayList<String>();
	    for (i=0;i<=n-1;i++){
	        listeMot.add(mot.substring(i, (i+1)));
	    } 
	        
	    return listeMot;
	}
	
	public String motAleatoire () {
		try{
		FileReader fr = new FileReader("dico.txt");
		br = new BufferedReader(fr);
		Random rand = new Random(); 
		int alea = rand.nextInt(369086);
		for (int i=0 ; i<alea ; i++) 
		    br.readLine();
		String resultat = br.readLine(); 
		return resultat;
	}catch(FileNotFoundException e){
        e.printStackTrace();
        return null;
    }catch(IOException e){
        e.printStackTrace();
        return null;
    }
	}
	
	public List<String> chercheHuitLettres() {
		try{
		List<String> motsHuitLettres= new ArrayList<String>();
		FileReader fr = new FileReader("dico.txt");
		br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
	        if(line.length()==8) {
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
	
	public String motAleatoireHuitLettres () {
		try{
		FileReader fr = new FileReader("dico.txt");
		br = new BufferedReader(fr);
		List <String> motsHuitLettres = chercheHuitLettres();
		Random rand = new Random(); 
		int alea = rand.nextInt(44664);
		String resultat = motsHuitLettres.get(alea);
		return resultat;
	}catch(FileNotFoundException e){
        e.printStackTrace();
        return null;
    }
	}
	
	public void nbMotsDico() {
		
		int i = 0;
	
		try {
		
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("dico.txt" )));
		      String line;
		      while ((line = br.readLine()) != null) {
		         i=i+1;
		         System.out.println(i);
		      }
		      br.close();
		}catch(FileNotFoundException e){
	        e.printStackTrace();
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	
	 
}
	
public void nbMotsHuitLettres() {
		
		int i = 0;
	
		try {
		
			 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("dico.txt" )));
		      String line;
		      while ((line = br.readLine()) != null) {
		         if(line.length()==8) {
		        	 i=i+1;
			         System.out.println(i);
		         }
		    	
		      }
		      br.close();
		}catch(FileNotFoundException e){
	        e.printStackTrace();
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	
	 
}
public String motAleatoiretaille (int taille) {
	try{
	FileReader fr = new FileReader("dico.txt");
	br = new BufferedReader(fr);
	List <String> motstaille = cherchetaillelettre(taille);
	Random rand = new Random(); 
	int nbmottaille = this.nbMotsHuitLettres(taille);
	int alea = rand.nextInt(nbmottaille);
	String resultat = motstaille.get(alea);
	return resultat;
}catch(FileNotFoundException e){
    e.printStackTrace();
    return null;
}
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
public int nbMotsHuitLettres(int taille) {
	
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
public char[] motDansTableau2 (String mot) {
	char [] motretutn = mot.toCharArray();
        
    return motretutn;
}
public String motAleatoiretaille2 (int taille) {
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


}
