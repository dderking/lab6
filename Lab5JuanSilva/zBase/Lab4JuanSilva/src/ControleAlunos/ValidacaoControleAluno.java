package ControleAlunos;

/**
 * Classe que tem função simples de auxiliar a classe Main em encasular a funções deixando mais facil visualmente de analísar o código. 
 * 
 * @author Juan Silva - 119210821
 */

import java.util.Scanner;

public class ValidacaoControleAluno {
	private static int CONTADOR_ALUNOS_QUE_RESPONDERAM = 0;

	public static void sai() {
		System.out.println("\nPrograma encerrado!");
		System.exit(0);
	}

	public static boolean cadastraAluno(ControleAluno controleAluno, Scanner scanner) {
		System.out.print("Matrícula: ");
		scanner.nextLine();
		String matricula = scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Curso: ");
		String curso = scanner.nextLine();
		controleAluno.cadastraAluno(matricula, nome, curso);
		return true;
	}

	public static String exibeAluno(ControleAluno controleAluno, Scanner scanner) {
		System.out.println("Matrícula: ");
		scanner.nextLine();
		String matricula = scanner.nextLine();
		return controleAluno.exibeAluno(matricula);
	}

	public static boolean cadastraGrupo(ControleAluno controleAluno, Scanner scanner) {
		System.out.print("Grupo: ");
		scanner.nextLine();
		String nomeGrupo = scanner.nextLine().toLowerCase();
		controleAluno.cadastraGrupo(nomeGrupo);
		return true;
	}

	public static boolean imprimeOuAloca(ControleAluno controleAluno, Scanner scanner) {
		System.out.println("(A)locar Aluno ou (I)mprimir Grupo?");
		scanner.nextLine();
		String opcao = scanner.nextLine().toUpperCase();
		switch (opcao) {
		case "A":
			alocaAluno(controleAluno, scanner);
			break;
		case "I":
			System.out.println(imprimeGrupo(controleAluno, scanner));
			break;
		default:
			System.out.println("Opção inválida!");
		}
		return false;
	}

	public static boolean alocaAluno(ControleAluno controleAluno, Scanner scanner) {
		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		System.out.print("Grupo: ");
		String nomeGrupo = scanner.nextLine();
		controleAluno.alocaAlunoNoGrupo(matricula, nomeGrupo);
		System.out.println("ALUNO ALOCADO!\n");
		return true;

	}

	public static String imprimeGrupo(ControleAluno controleAluno, Scanner scanner) {
		System.out.println("Grupo: ");
		String nomeGrupo = scanner.nextLine();
		System.out.println("Alunos do grupo " + nomeGrupo + ":");
		return controleAluno.imprimeGrupos(nomeGrupo);
	}

	public static void registraAlunoR(ControleAluno controleAluno, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		System.out.println(controleAluno.cadastrarAlunosQueResponderam(matricula));
		CONTADOR_ALUNOS_QUE_RESPONDERAM += 1;
	}

	public static String imprimeAlunosR(ControleAluno controleAluno) {
		if (CONTADOR_ALUNOS_QUE_RESPONDERAM > 0) {
			System.out.println("Alunos: ");
		}
		return controleAluno.imprimirAlunosQueResponderam();
	}
}
