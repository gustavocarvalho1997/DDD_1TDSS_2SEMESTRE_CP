package br.com.fiap.cp1.view;

import javax.swing.JOptionPane;

import br.com.fiap.cp1.operators.AlunoDao;

public class Terminal {
	public static void main(String[] args) {
		//Instanciando DAO
		AlunoDao operadorAluno = new AlunoDao();
		operadorAluno.iniciandoHash();
		
		while(true) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n 1 - Para cadastrar um aluno\n 2 - Para mostrar os alunos cadastrados\n 3 - Pesquisar aluno por identificador\n 4 - Pesquisar aluno por sobrenome\n 5 - Editar aluno\n 6 - Remover aluno\n 7 - Sair"));
			if(opcao == 1) {
				operadorAluno.cadastrarAluno();
			} else if(opcao == 2) {
				operadorAluno.listarAlunos();
			} else if(opcao == 3) {
				operadorAluno.pesquisarPorIdentificador();
			} else if(opcao == 4) {
				operadorAluno.pesquisarPorSobrenome();
			} else if(opcao == 5) {
				operadorAluno.editar();
			} else if(opcao == 6) {
				operadorAluno.removerAluno();
			} else if(opcao == 7) {
				JOptionPane.showConfirmDialog(null, "Aplicação finalizada!");
				break;
			} else {
				JOptionPane.showConfirmDialog(null, "Opção inválida");
			}
		}
		
		
	}// MAIN
}// CLASS