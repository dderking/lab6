package ControleAlunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleAlunoTest {

	private ControleAluno controleAluno;
	
	@BeforeEach
	void setup() {
		this.controleAluno = new ControleAluno();
		this.controleAluno.cadastraAluno("66", "Juan Salvador", "Computação");
		this.controleAluno.cadastraAluno("42", "Fidel Trinção", "Historia");
		this.controleAluno.cadastraGrupo("URSS");
	}
	
	@Test
	void testCadastraAluno() {
		assertEquals("CADASTRO REALIZADO! \n", this.controleAluno.cadastraAluno("121", "Gustavo", "CC"));
		assertEquals("CADASTRO REALIZADO! \n", this.controleAluno.cadastraAluno("223", "Juan Salvador", "Computação"));
		assertEquals("MATRÍCULA JÁ CADASTRADA! \n", this.controleAluno.cadastraAluno("66", "Juan Salvador", "Computação"));
	}
	
	@Test
	void testExisteAluno() {
		assertTrue(this.controleAluno.existeAluno("66"));
		assertTrue(this.controleAluno.existeAluno("42"));
		assertFalse(this.controleAluno.existeAluno("333"));
	}
	
	@Test
	void testExibeAluno() {
		assertEquals("Aluno não cadastrado. ", this.controleAluno.exibeAluno("333"));
		assertEquals("Aluno: 66 - Juan Salvador - Computação" , this.controleAluno.exibeAluno("66"));
		assertEquals("Aluno: 42 - Fidel Trinção - Historia" , this.controleAluno.exibeAluno("42"));
	}
	
	@Test
	void testCadastraGrupo() {
		assertEquals("CADASTRO REALIZADO! \n", this.controleAluno.cadastraGrupo("Grupos"));
		assertEquals("GRUPO JÁ CADASTRADO! \n", this.controleAluno.cadastraGrupo("Grupos"));
		assertEquals("GRUPO JÁ CADASTRADO! \n", this.controleAluno.cadastraGrupo("URSS"));
	}
	
	@Test
	void testExisteGrupo() {
		assertTrue(this.controleAluno.existeGrupo("URSS"));
		assertFalse(this.controleAluno.existeGrupo("Grupos"));
		assertFalse(this.controleAluno.existeGrupo("Informática"));
	}
	
	@Test
	void testAlocarAluno() {
		assertEquals("Aluno não cadastrado. ", this.controleAluno.alocaAlunoNoGrupo("333", "URSS"));
		assertEquals("ALUNO ALOCADO!. ", this.controleAluno.alocaAlunoNoGrupo("66", "URSS"));
		assertEquals("Grupo não cadastrado. ", this.controleAluno.alocaAlunoNoGrupo("42", "Informática"));
	}
	
	@Test
	void testImprimirGrupos() {
		assertEquals("Grupo não cadastrado. \n", this.controleAluno.imprimeGrupos("Java"));
		this.controleAluno.cadastraGrupo("Java");
		this.controleAluno.alocaAlunoNoGrupo("66", "Java");
		assertEquals("* Aluno: 66 - Juan Salvador - Computação" + "\n", this.controleAluno.imprimeGrupos("Java"));
		this.controleAluno.alocaAlunoNoGrupo("42", "Java");
		assertEquals("* Aluno: 42 - Fidel Trinção - Historia" + "\n" + 
					 "* Aluno: 66 - Juan Salvador - Computação" + "\n", this.controleAluno.imprimeGrupos("Java"));
	}
	
	@Test
	void testCadastrarAlunosQueResponderam() {
		assertEquals("Aluno não cadastrado. \n", this.controleAluno.cadastrarAlunosQueResponderam("333"));
		assertEquals("ALUNO REGISTRADO! \n", this.controleAluno.cadastrarAlunosQueResponderam("66"));
	}
	
	@Test
	void testImprimirAlunosQueResponderam() {
		this.controleAluno.cadastrarAlunosQueResponderam("66");
		assertEquals("1. Aluno: 66 - Juan Salvador - Computação" + "\n", 
				this.controleAluno.imprimirAlunosQueResponderam());
		this.controleAluno.cadastrarAlunosQueResponderam("42");
		assertEquals("1. Aluno: 66 - Juan Salvador - Computação" + "\n" + 
					 "2. Aluno: 42 - Fidel Trinção - Historia" + "\n", this.controleAluno.imprimirAlunosQueResponderam());
	}
}