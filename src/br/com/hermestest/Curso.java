package br.com.hermestest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Curso {
	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}
	
	//Desta forma vc n�o permite que seja feita uma inclus�o/altera��o/remo��o desta lista sem 
	// que seja utilizado o metodo desta classe.  
	public List<Aula> getAulas(){
		return Collections.unmodifiableList(aulas);		
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getInstrutor() {
		return instrutor;
	}
	
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

//	public int getTempoTotal() {
//		int tempoTotal = 0;
//		for (Aula aula : aulas) {
//			tempoTotal += aula.getTempo();			
//		}
//		return tempoTotal;
//	}

	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Curso: " + nome + "tempo total:" + this.getTempoTotal() + "]";
	}
	
}
