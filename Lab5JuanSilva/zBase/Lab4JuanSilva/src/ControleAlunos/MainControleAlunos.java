package ControleAlunos;

import java.util.Scanner;

public class MainControleAlunos {
	public static void main(String[] args) {
		ControleAluno controleAluno = new ControleAluno();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, controleAluno, scanner);
		}

	}

	
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n" + 
						"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
						"(R)egistrar Aluno que Respondeu\n" + 
						"(I)mprimir Alunos que Responderam\n" + 
						"(O)ra, vamos fechar o programa!\n" + 
						"\n" + 
						"Opção>\n" + 
						"");
		return scanner.next().toUpperCase();
	}


	private static void comando(String opcao, ControleAluno controleAluno, Scanner scanner) {
		switch (opcao) {
		case "C":
			ValidacaoControleAluno.cadastraAluno(controleAluno, scanner);
			break;
		case "E":
			System.out.println(ValidacaoControleAluno.exibeAluno(controleAluno, scanner));
			break;
	    case "N":
	    	ValidacaoControleAluno.cadastraGrupo(controleAluno, scanner);
			break;
		case "A":
			ValidacaoControleAluno.imprimeOuAloca(controleAluno, scanner);
			break;
		case "R":
			ValidacaoControleAluno.registraAlunoR(controleAluno, scanner);
			break;
		case "I":
			System.out.println(ValidacaoControleAluno.imprimeAlunosR(controleAluno));
			break;
		case "O":
			ValidacaoControleAluno.sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
}


