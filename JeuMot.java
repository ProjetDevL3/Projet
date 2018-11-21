package com.projet.algodev.l3.inter;

import java.util.List;

public interface JeuMot {

	public boolean motTrouve();
	public void jouerCoup(String coup);
	public void afficherListe(List<String> l);
	public void initialisation();
	public void jouer();
	
}
