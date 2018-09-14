package br.upe.ia.geo;

import java.util.ArrayList;
import java.util.List;

public class Municipio {
	
	private String nome;
	private boolean visitado;
	private List<Adjacente> adjacentes;
	private int distanciaPercurso;
	
	public Municipio(String nome, int distanciaPercurso) {
		this.nome = nome;
		visitado = false;
		adjacentes = new ArrayList<Adjacente>();
		this.distanciaPercurso = distanciaPercurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public List<Adjacente> getAdjacentes() {
		return adjacentes;
	}

	public void setAdjacentes(List<Adjacente> adjacentes) {
		this.adjacentes = adjacentes;
	}
	
	public void addAjacente(Adjacente cidade) {
		adjacentes.add(cidade);
	}
	
	public int getDistanciaPercurso() {
		return distanciaPercurso;
	}

	public void setDistanciaPercurso(int distanciaPercurso) {
		this.distanciaPercurso = distanciaPercurso;
	}

	public String toString(){
		return this.nome;
	}
}
