package carregabanco.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
@Table(name = "aluno")
public class AlunoModel extends PessoaModel {
	private static final long serialVersionUID = 1L;
	//campus,polo,coordenacao,curso,nome_estudante,situacao,idade,sexo,email_institucional,periodo_entrada

	private String campus;
	private String polo;
	private String email_institucional;
	private String coordenacao;
	private String curso;
	private String situacao;
	private String periodo_entrada;

	public AlunoModel() {}
	
	public AlunoModel(String coordenacao, String curso, String situacao,
			String periodo_entrada, String campus, String polo, String email_institucional) {
		super();
		this.campus = campus;
		this.polo = polo;
		this.email_institucional = email_institucional;
		this.coordenacao = coordenacao;
		this.curso = curso;
		this.situacao = situacao;
		this.periodo_entrada = periodo_entrada;
	}
	
	public AlunoModel(String nome_estudante, String coordenacao, String curso, String situacao,
			String periodo_entrada, String campus, String polo, String email_institucional, int idade, String sexo) {
		super(idade, sexo, nome_estudante);
		this.coordenacao = coordenacao;
		this.curso = curso;
		this.situacao = situacao;
		this.periodo_entrada = periodo_entrada;
	}

	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getPolo() {
		return polo;
	}
	public void setPolo(String polo) {
		this.polo = polo;
	}
	public String getEmail_institucional() {
		return email_institucional;
	}
	public void setEmail_institucional(String email_institucional) {
		this.email_institucional = email_institucional;
	}

	public String getCoordenacao() {
		return coordenacao;
	}

	public void setCoordenacao(String coordenacao) {
		this.coordenacao = coordenacao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getPeriodo_entrada() {
		return periodo_entrada;
	}

	public void setPeriodo_entrada(String periodo_entrada) {
		this.periodo_entrada = periodo_entrada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
