package br.upe.ia.buscas;

import java.util.Scanner;

import br.upe.ia.estruturas.ListaOrdenada;
import br.upe.ia.geo.Adjacente;
import br.upe.ia.geo.Mapa;
import br.upe.ia.geo.MatrizCidades;
import br.upe.ia.geo.Municipio;

public class BuscaGulosa {

	private ListaOrdenada fronteira;
	private Municipio destino;
	protected boolean achou;
	private int visitados;

	public BuscaGulosa(Municipio destino) {
		this.destino = destino;
		this.achou = false;
		this.visitados = 0;
	}

	public void buscar(Municipio origem) {
		System.out.println("================================================");
		System.out.println("Cidade atual: " + origem.getNome());
		System.out.println("================================================");
		origem.setVisitado(true);
		if (origem.getNome().equals(destino.getNome())) {
			this.achou = true;
		} else {
			this.visitados++;
			this.fronteira = new ListaOrdenada();
			for (Adjacente a : origem.getAdjacentes()) {

				if (!a.getMunicipio().isVisitado()) {
					a.getMunicipio().setVisitado(true);
					this.fronteira.inserir(a.getMunicipio());
				}
			}

			this.fronteira.mostrar();
			if (this.fronteira.getPrimeiro() != null) {
				this.buscar(this.fronteira.getPrimeiro());
			}
		}

		if (this.achou) {
			System.out.println("Achou o destino: " + origem.getNome());
			System.out.println("Visitados: " + this.visitados);
			System.exit(0);
		}

	}
	
	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Ciades e seus respectivos numeros:\n 0 para Angelim \n 1 para Caetes \n 2 para Calçado \n 3 para Canhotinho"
					+ "\n 4 para Capoeiras \n 5 para Garanhuns \n 6 para Jucati \n 7 para Jupi \n 8 para Jurema \n 9 para  Lajedo"
					+ "\n 10 para Paranatama \n 11 para São Bento do Una \n 12 para São João \n");
	
			System.out.println("Digite a cidade Origem: ");
				int cidadeOrigem = scan.nextInt();
			System.out.println("Digite a cidade destino desejada: ");
				int cidadeDestino = scan.nextInt();
	
	
			Mapa mapa = new Mapa(cidadeDestino);
			BuscaGulosa busca = new BuscaGulosa(mapa.apontaCidade(cidadeDestino));
			busca.buscar(mapa.apontaCidade(cidadeOrigem));
	}

}
