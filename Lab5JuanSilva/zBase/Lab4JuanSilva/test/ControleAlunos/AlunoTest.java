package ControleAlunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {

	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	
	@BeforeEach
	void criaAluno() {
		this.aluno1 = new Aluno("66", "Juan Salvador", "CC");
		this.aluno2 = new Aluno("124", "Klebio Réuso", "EE");
		this.aluno3 = new Aluno("66", "Juan Salvador", "CC");
	}
	@Test
	void testToStringExibeAluno() {
		assertEquals("Aluno: 66 - Juan Salvador - CC", this.aluno1.toStringExibeAluno());
		assertEquals("Aluno: 124 - Klebio Réuso - EE", this.aluno2.toStringExibeAluno());
		assertEquals("Aluno: 66 - Juan Salvador - CC", this.aluno3.toStringExibeAluno());
	}
	@Test
	void testHashCode() {
		assertEquals(this.aluno1.hashCode(), this.aluno3.hashCode());
		assertNotEquals(this.aluno1.hashCode(), this.aluno2.hashCode());
	}
	
	@Test
	void testEquals() {
		assertTrue(this.aluno1.equals(aluno3));
		assertFalse(this.aluno1.equals(aluno2));
	}
}

