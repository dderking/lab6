package lab2;

import java.util.Arrays;

public class Disciplina {
	private String nomeDisciplina;
	private int horasEstudo;
	private double media;
	private double[] notas;
	private int nota;
	private double valorNota;
/*
	Disciplina(String nomeDisciplina,int notas) {
		this.horasEstudo = 0;
		this.notas = new double[] ;
		this.nomeDisciplina = nomeDisciplina;

	}*/
	Disciplina(String nomeDisciplina) {
		this.horasEstudo = 0;
		this.notas = new double[] { 0.0, 0.0, 0.0, 0.0 };
		this.nomeDisciplina = nomeDisciplina;

	}

	public void cadastraHoras(int horas) {
		this.horasEstudo = horasEstudo + horas;

	}

	/*
	 * Cadastrar uma nota
	 * 
	 */
	public void cadastraNota(int nota, double valorNota) { // notas possíveis: 1,2,3 e 4
		this.nota = nota;
		this.notas[nota - 1] = valorNota;

	}

	public double calculaMedia() {
		double soma = 0;
		this.media = 0;
		for (int i = 0; i < notas.length; i++) {
			soma += notas[i];

		}
		this.media = soma / 4.0;
		return this.media;

	}

	public boolean aprovado() {
		if (this.calculaMedia() >= 7.0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return nomeDisciplina + " " + horasEstudo + " " + this.calculaMedia() + " " + Arrays.toString(notas);
	}

}
