package view;

import controller.FifaController;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		String caminho = "C:/temp";
		String nome = "data.csv";
		
		try {
			FifaController cont = new FifaController();
			
			Stack<String> brasileiros = new Stack<String>();
			brasileiros = cont.empilhaBrasileiros(caminho, nome);
			cont.desempilhaBonsBrasileiros(brasileiros);
			System.out.println("--------------------------------------------------");
			
			LinkedList<String> jovens = new LinkedList<String>();
			jovens = cont.listaRevelacoes(caminho, nome);
			cont.buscaListaBonsJovens(jovens);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}