package controller;

import java.io.*;
import java.util.*;

public class FifaController implements IFifaController {

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		
		File arquivo = new File(caminho, nome);
		Stack<String> brasileiros = new Stack<String>();
		
		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			linha = buffer.readLine();
			while(linha != null) {
				String[] jogador = linha.split(",");
				if(jogador[5].equals("Brazil")) {
					brasileiros.push(linha);
				}
				linha = buffer.readLine();
			}
			
			fluxo.close();
			leitor.close();
			buffer.close();

			return brasileiros;
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void desempilhaBonsBrasileiros(Stack<String> pilha) throws IOException {

		int tamanho = pilha.size();
		for(int i = 0; i < tamanho; i++) {
			String jogador = pilha.pop();
			String[] vetJogador = jogador.split(",");
			int overall = Integer.parseInt(vetJogador[7]); 
			
 			if(overall > 80) {
				System.out.println("Jogador: " + vetJogador[2] + " | Overall: " + vetJogador[7]);
			}
		}
	}

	@Override
	public LinkedList<String> listaRevelacoes(String caminho, String nome) throws IOException {
		File arquivo = new File(caminho, nome);
		LinkedList<String> jovens = new LinkedList<String>();
		
		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			linha = buffer.readLine();
			while(linha != null) {
				String[] jogador = linha.split(",");
				int idade = Integer.parseInt(jogador[3]);
				
				if(idade <= 20) {
					jovens.add(linha);
				}
				linha = buffer.readLine();
			}
			
			fluxo.close();
			leitor.close();
			buffer.close();

			return jovens;
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void buscaListaBonsJovens(LinkedList<String> lista) throws IOException {
		int tamanho = lista.size();
		for(int i = (tamanho-1); i >= 0 ; i--) {
			String jogador = lista.get(i);
			String[] vetJogador = jogador.split(",");
			int idade = Integer.parseInt(vetJogador[3]);
			int overall = Integer.parseInt(vetJogador[7]);
			
			if(idade <= 20 && overall > 80)
				System.err.println("Jogador: " + vetJogador[2] + " | Idade: " + idade + " | Overall: " + overall);
		}
	}
}