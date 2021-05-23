package it.polito.tdp.regine.model;

import java.util.List;

public class TestRegine {
	 public static void main(String args[]) {
			Regine r = new Regine() ;

			List<Integer> soluzione ;
			soluzione = r.risolvi(6);
			System.out.println(soluzione) ;
			// List<List<Integer>> soluzioni ; (calcola tutte le soluzioni)
			// soluzioni = r.risolvi(6); (calcola tutte le soluzioni)
			// System.out.println(soluzioni) ; (calcola tutte le soluzioni)

		}
}
