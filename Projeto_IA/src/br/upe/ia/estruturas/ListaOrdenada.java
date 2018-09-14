package br.upe.ia.estruturas;

import java.util.LinkedList;

import br.upe.ia.geo.Municipio;

public class ListaOrdenada {

	private LinkedList<Municipio> municipios;

	public ListaOrdenada() {
		this.municipios = new LinkedList<Municipio>();
	}

	public void inserir(Municipio municipio) {
		this.municipios.add(municipio);
		this.ordenar();
	}

	private void ordenar() {
		boolean repetir = false;
		for (int i = 0; i < this.municipios.size() - 1; i++) {
			if (this.municipios.get(i).getDistanciaPercurso() > this.municipios.get(i + 1).getDistanciaPercurso()) {
				trocar(i);
				ordenar();
			}
		}
	}

	public void trocar(int i) {

		Municipio m1 = new Municipio(
				this.municipios.get(i).getNome(), 
				this.municipios.get(i).getDistanciaPercurso());
		
		m1.setVisitado(this.municipios.get(i).isVisitado());
		m1.setAdjacentes(this.municipios.get(i).getAdjacentes());

		Municipio m2 = new Municipio(
				this.municipios.get(i + 1).getNome(),
				this.municipios.get(i + 1).getDistanciaPercurso());
		m2.setVisitado(this.municipios.get(i + 1).isVisitado());
		m2.setAdjacentes(this.municipios.get(i + 1).getAdjacentes());

		this.municipios.get(i).setAdjacentes(m2.getAdjacentes());
		this.municipios.get(i).setDistanciaPercurso(m2.getDistanciaPercurso());
		this.municipios.get(i).setNome(m2.getNome());
		this.municipios.get(i).setVisitado(m2.isVisitado());

		this.municipios.get(i + 1).setAdjacentes(m1.getAdjacentes());
		this.municipios.get(i + 1).setDistanciaPercurso(m1.getDistanciaPercurso());
		this.municipios.get(i + 1).setNome(m1.getNome());
		this.municipios.get(i + 1).setVisitado(m1.isVisitado());
	}

	public void mostrar() {
		for (int i = 0; i < this.municipios.size(); i++) {
			System.out
					.println(this.municipios.get(i).getNome() + " -> " + this.municipios.get(i).getDistanciaPercurso());
		}
	}

	public Municipio getPrimeiro() {
		return this.municipios.getFirst();
	}

	public static void main(String[] args) {
	}

}
