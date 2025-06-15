package carregabanco.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class PessoaModel implements Serializable{
	private static final long serialVersionUID = 1L;
	//campus,polo,coordenacao,curso,nome_estudante,situacao,idade,sexo,email_institucional,periodo_entrada
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPessoa;
	private String nome_estudante;
	private int idade;
	private String sexo;
	
	public PessoaModel() {}
	
	public PessoaModel(int idade, String sexo, String nome_estudante) {
		super();
		this.nome_estudante = nome_estudante;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome_estudante() {
		return nome_estudante;
	}

	public void setNome_estudante(String nome_estudante) {
		this.nome_estudante = nome_estudante;
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}	
}

