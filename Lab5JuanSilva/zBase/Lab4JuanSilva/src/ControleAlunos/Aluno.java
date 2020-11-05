package ControleAlunos;

/**
 * Classe que representa um aluno. Todo aluno tem uma matrícula, nome e curso. O
 * aluno é identificado pela sua matrícula.
 * 
 * @author Juan Silva - 119210821
 *
 */
public class Aluno {
	private String matricula;
	private String nome;
	private String curso;

	/**
	 * Construtor responsável por construir um aluno a partir da sua matrícula, seu
	 * nome e seu curso.
	 * 
	 * @param matricula A matrícula do aluno
	 * @param nome      O nome do aluno
	 * @param curso     O curso do aluno
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * Retorno a String que representa a matrícula do aluno.
	 * 
	 * @return matricula A matrícula do aluno
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Retorno a String que representa o nome do aluno.
	 * 
	 * @return nome O nome do aluno
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorno a String que representa o curso do aluno.
	 * 
	 * @return curso O curso do aluno
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Método que representa o aluno no formato: MATRICULA - NOME - CURSO.
	 * 
	 * @return Uma string que é a representação do aluno
	 */
	public String toStringExibeAluno() {
		return "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso;
	}

	/**
	 * Método que calcula o número hash do Aluno.
	 * 
	 * @return Um valor inteiro que representa o número hash do objeto Aluno.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Método que testa se dois objetos são iguais, nesse caso, se a matrícula é
	 * igual.
	 * 
	 * @return Um valor booleano que representa se são iguais ou não.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
