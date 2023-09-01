package br.com.fiap.cp1.models;

public class Aluno {
	// Atributos
	private String idAluno, primeiroNome, sobrenome, curso;
	private int idade, anoDeInicio;
	// Construtor
	public Aluno(String idAluno, String primeiroNome, String sobrenome, String curso, int idade, int anoDeInicio) {
		super();
		this.idAluno = idAluno;
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
		this.curso = curso;
		this.idade = idade;
		this.anoDeInicio = anoDeInicio;
	}
	//toString
	@Override
	public String toString() {
		return " Aluno [idAluno = " + idAluno + ", primeiroNome = " + primeiroNome + ", sobrenome = " + sobrenome + ", curso = "
				+ curso + "]";
	}
	// Getters
	public String getIdAluno() {
		return idAluno;
	}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getCurso() {
		return curso;
	}
	public int getIdade() {
		return idade;
	}
	public int getAnoDeInicio() {
		return anoDeInicio;
	}
	// Setters
	public void setIdAluno(String idAluno) {
		this.idAluno = idAluno;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setAnoDeInicio(int anoDeInicio) {
		this.anoDeInicio = anoDeInicio;
	}
	// Métodos
	public String retornarInformacoesCompletas() {
		return "ID: " + idAluno + ", Nome Completo: " + primeiroNome + " " + sobrenome +
				", Idade: " + idade + ", Curso: " + curso + ", Ano de início: " + anoDeInicio + ".";
	}
}//CLASS