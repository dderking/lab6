package ControleAlunos;
/**
 * Classe que representa um grupo. Todo grupo tem um nome e um conjunto de alunos que fazem parte desse grupo.
 * O grupo é identificado pelo seu nome.
 * @author Juan Silva - 119210821
 */
import java.util.HashSet;

public class GrupoEscolar {
	private String nomeGrupo;
	private HashSet<Aluno> alunos;
	/**
	 * Construtor responsável por construir um grupo a partir do seu nome.
	 * E cria um conjunto de alunos que pertencem ao grupo.
	 * 
	 * @param nomeGrupo O nome do grupo
	 */
	public GrupoEscolar(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
		this.alunos = new HashSet<>();
	}

	public void cadastraGrupoAluno(Aluno aluno) {
		this.alunos.add(aluno);

	}
	/**
	 * Retorno a String que representa o nome do grupo.
	 * 
	 * @return matricula O nome do grupo.
	 */
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	/**
	 * Retorno o HashMap que representa os alunos presentes no grupo.
	 * 
	 * @return alunos Os alunos no grupo
	 */
	public HashSet<Aluno> getGrupo() {
		return alunos;
	}
	/**
	 * Método que adiciona alunos no grupo.
	 * 
	 * @param aluno O próprio aluno que deve ser adicionado
	 */
	public void alocaAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	/**
	 * Método que representa os alunos do grupo em formato de uma String.
	 * Caso não tenha nenhum aluno, exibe a mensagem "Nenhum aluno foi cadastrado." 
	 * 
	 * @return Uma String que representa os alunos do grupo.
	 */
	public String toStringGrupo() {
		String retorno = "";
		for (Aluno aluno: this.alunos) {
			retorno += "* " + aluno.toStringExibeAluno() + "\n";
		}
		if (retorno == "") {
			return "* Nenhum aluno foi cadastrado. \n";
		}
		return retorno;
	}
	/**
	 * Método que calcula o número hash do Grupo.
	 * 
	 * @return Um valor inteiro que representa o número hash do objeto Grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}
	/**
	 * Método que testa se dois objetos são iguais, nesse caso, se o nome do grupo são iguais.
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
		GrupoEscolar other = (GrupoEscolar) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}
	
}