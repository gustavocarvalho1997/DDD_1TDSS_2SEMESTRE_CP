package br.com.fiap.cp1.operators;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;

import br.com.fiap.cp1.models.*;
public class AlunoDao {
	// Atributos
	private HashMap<String, Aluno> alunos;
	// Construtor
	public AlunoDao() {
		super();
	}
	// Getter
	public HashMap<String, Aluno> getAlunos() {
		return alunos;
	}
	// Setter
	public void setAlunos(HashMap<String, Aluno> alunos) {
		this.alunos = alunos;
	}
	// Métodos
	public void iniciandoHash() {
		this.alunos = new HashMap<>();
	}//iniciandoHash
	
	public void cadastrarAluno() {
		String idAluno = JOptionPane.showInputDialog("Informe o id do aluno (Ex. RM459586): ").toUpperCase();
		String primeiroNome = JOptionPane.showInputDialog("Informe o primeiro nome do aluno: ");
		String sobrenome = JOptionPane.showInputDialog("Informe o sobrenome do aluno: ");
		String curso = JOptionPane.showInputDialog("Informe o curso do aluno (Ex. Engenharia de Software): ");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do aluno: "));
		int anoDeInicio = Integer.parseInt(JOptionPane.showInputDialog("Informe a ano de início do aluno no curso: "));
		
		if(!alunos.containsKey(idAluno)) {
			alunos.put(idAluno, new Aluno(idAluno, primeiroNome, sobrenome, curso, idade, anoDeInicio));
			System.out.println("Aluno cadastrado com sucesso");
		} else {
			System.out.println("Identificador ja cadastrado!");
		}
	}//cadastrarAluno
	
	public void removerAluno() {
		String alunoKey = JOptionPane.showInputDialog("Informe o identificador do aluno a ser removido (Ex: RM559432): ").toUpperCase();
		if(alunos.containsKey(alunoKey)) {
			alunos.remove(alunoKey);
			System.out.println("Aluno removido com sucesso!");
		} else {
			System.out.println("Aluno não cadastrado!");
		}
	}//removerAluno
	
	public void listarAlunos() {
		Set<String> chaves = alunos.keySet();
		
		if(!alunos.isEmpty()) {
			for(String item : chaves) {
				System.out.println("Identificador: " + item + " - Informações completas do aluno:" + alunos.get(item).retornarInformacoesCompletas());
			}
		} else {
			System.out.println();
		}
	}//listarAlunos
	
	public void pesquisarPorIdentificador() {
		String identificador = JOptionPane.showInputDialog("Informe o identificador do aluno (Ex: RM 569862): ").toUpperCase();
		if(alunos.containsKey(identificador)) {
			System.out.println(alunos.get(identificador).retornarInformacoesCompletas());
		} else {
			System.out.println("Aluno não cadastrado!");
		}
	}//pesquisarPorIdentificador

	public void pesquisarPorSobrenome() {
		Set<String> chaves = alunos.keySet();
		String sobrenome = JOptionPane.showInputDialog("Informe o sobrenome do aluno: ");
		boolean verificado = false;
		
		for(String item : chaves) {
			if(alunos.get(item).getSobrenome().equalsIgnoreCase(sobrenome)) {
				System.out.println(alunos.get(item).retornarInformacoesCompletas());
				verificado = true;
			}
		}
		if(!verificado) {
			System.out.println("Nenhum aluno foi localizado, verifique se o sobrenome foi digitado corretamente!");
		}
	}//pesquisarPorSobrenome
	
	public void editar() {
		//private String idAluno, primeiroNome, sobrenome, curso;
		//private int idade, anoDeInicio;
		String identificador = JOptionPane.showInputDialog("Informe o identificador do aluno para editar as informações (Ex:RM552466): ").toUpperCase();
		if(alunos.containsKey(identificador)) {
			JOptionPane.showConfirmDialog(null, "Primeiro serão confirmadas quais informações você deseja alterar: ");
			int confirmacaoNome = Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar o nome? \n Digite 1 para SIM \n Digite 2 para NÃO"));
			int confirmacaoSobrenome = Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar o sobrenome? \n Digite 1 para SIM \n Digite 2 para NÃO"));
			int confirmacaoCurso = Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar o curso? \n Digite 1 para SIM \n Digite 2 para NÃO"));
			int confirmacaoIdade = Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar o idade? \n Digite 1 para SIM \n Digite 2 para NÃO"));
			int confirmacaoAnoInicio = Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar o ano de inicio? \n Digite 1 para SIM \n Digite 2 para NÃO"));
			
			boolean alterarNome = false;
			boolean alterarSobrenome = false;
			boolean alterarCurso = false;
			boolean alterarIdade = false;
			boolean alterarAnoInicio = false;
			
			if(confirmacaoNome == 1) alterarNome = true;
			if(confirmacaoSobrenome == 1) alterarSobrenome = true;
			if(confirmacaoCurso == 1) alterarCurso = true;
			if(confirmacaoIdade == 1) alterarIdade = true;
			if(confirmacaoAnoInicio == 1) alterarAnoInicio = true;
			
			if(alterarNome) {
				String nome = JOptionPane.showInputDialog("Informe o nome atualizado: ");
				alunos.get(identificador).setPrimeiroNome(nome);
			}//if nome
			if(alterarSobrenome) {
				String sobrenome = JOptionPane.showInputDialog("Informe o sobrenome atualizado: ");
				alunos.get(identificador).setSobrenome(sobrenome);
			}//if sobrenome
			if(alterarCurso) {
				String curso = JOptionPane.showInputDialog("Informe o curso atualizado: ");
				alunos.get(identificador).setCurso(curso);
			}//if curso
			if(alterarIdade) {
				int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade atualizada: "));
				alunos.get(identificador).setIdade(idade);
			}//if idade
			if(alterarAnoInicio) {
				int anoInicio = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de início atualizado: "));
				alunos.get(identificador).setAnoDeInicio(anoInicio);;
			}//if ano de inicio
		} else {
			System.out.println("Identificador não localizado!");
		}
		
		System.out.println("Processo de edição finalizado!");
	}//editar

	
}// CLASS