package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	// N è il numero di righe e colonne della scacchiera
	//   (righe e colonne numerate da 0 a N-1)
	// ad ogni livello posizioniamo una regina in una nuova riga
	
	// soluzione parziale: lista delle colonne in cui mettere le regine (prime righe)
	// 		List<Integer>
	// livello = quante righe sono già piene
	// livello = 0 => nessuna riga piena (devo mettere la regina nella riga 0)
	// livello = 3 => 3 righe piene (0, 1, 2), devo mettere la regina nella riga 3
	// [0]
	//     [0, 2]
	//            [0, 2, 4]
	private int N ;
	private List<Integer> soluzione ;
	// private List<List<Integer>> soluzioni; (calcola tutte le soluzioni)
    // public List<List<Integer>> risolvi(int N) { (calcola tutte le soluzioni)
	public List<Integer> risolvi(int N) {
		this.N = N ;
		List<Integer> parziale = new ArrayList<Integer>() ;
		this.soluzione = null ;
		// this.soluzioni = new ArrayList<>(); (calcola tutte le soluzioni)

		cerca(parziale, 0); 

		return this.soluzione ;
		// return this.soluzioni ; (calcola tutte le soluzioni)
	}

	// cerca == true : trovato; cerca == false : cerca ancora
	private boolean cerca(List<Integer>parziale, int livello) {  // [0, 6, 4, 7]
// private void cerca(List<Integer>parziale, int livello) {  // [0, 6, 4, 7] (calcola tutte le soluzioni)
		if(livello==N) {
			// caso terminale
//			System.out.println(parziale);
			this.soluzione = new ArrayList<>(parziale) ;
			return true;
			// this.soluzioni.add(new ArrayList<>(parziale)) ;  (calcola tutte le soluzioni)
		} else {
			for(int colonna=0; colonna<N; colonna++) {
				// if la mossa nella casella [livello][colonna] è valida
				// se sì, aggiungi a parziale e fai ricorsione

				if( posValida(parziale, colonna) ) {

//					List<Integer> parzialeNuovo = new ArrayList<>(parziale) ;
//					parzialeNuovo.add(colonna) ;
//					cerca(parzialeNuovo, livello+1) ;

					parziale.add(colonna) ; // [0, 6, 4, 7, XXX ] 
					boolean trovato = cerca(parziale, livello+1) ;
					if(trovato)
						return true ;
					// cerca(parziale, livello+1) ;  (calcola tutte le soluzioni)
					parziale.remove(parziale.size()-1) ; // backtracking
				}
			}
			return false ;
			// cancella riga (calcola tutte le soluzioni)
		}
	}

	private boolean posValida(List<Integer> parziale, int colonna) {
		int livello = parziale.size();

		// controlla se viene mangiata in verticale
		if(parziale.contains(colonna))
			return false ;

		// controlla le diagonali: confronta la posizione (livello, colonna) con (r,c) delle
		// regine esistenti
		for(int r=0; r<livello; r++) {
			int c = parziale.get(r) ;

			if(r+c == livello+colonna || r-c == livello-colonna)
				return false ;
		}

		return true;
	}
		
}
