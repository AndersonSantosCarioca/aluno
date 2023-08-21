package com.poo.aluno;

//Importação das biblioltecas
import java.text.SimpleDateFormat;//usado para formatação de data para formato desejado
import java.util.ArrayList;// manipulação de listas 
import java.util.Date;
import java.util.List;//estruturade dados agrupados
import java.util.Scanner;//Usado para interagir com o usuário.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlunoApplication {// declaração do pacote e declaração da classe

	public static void main(String[] args) {// classe principal.
		SpringApplication.run(AlunoApplication.class, args);

		Scanner sc = new Scanner(System.in);// criação do objeto Scanner
		List<Aluno> alunoCadastrados = new ArrayList<>();

		boolean continuarCadastro = true;// criação do loop do cadastro de alunos
		while (continuarCadastro) {
			System.out.println("==================");
			System.out.println("Cadastro de alunos:");
			System.out.println("==================");
			System.out.println("\nDigite o nome do aluno:");
			String nome = sc.nextLine();

			System.out.println("\nDigite a data de nascimento do aluno (dd/MM/yyyy):");
			String dataNascimentoStr = sc.nextLine();

			try {// tratamento de erro
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date dataNascimento = dateFormat.parse(dataNascimentoStr);

				Aluno aluno = new Aluno(nome, dataNascimento);
				alunoCadastrados.add(aluno);

				System.out.println("\nAlunocadastrado com sucesso!");

				System.out.println("\nDeseja continuar cadastrando novo aluno? (S/N)");
				String resposta = sc.nextLine();
				continuarCadastro = resposta.equalsIgnoreCase("S");

			} catch (Exception e) {// Lança o código de erro
				System.out.println("Erro no formato da data. Formato correto (dia/mês/ano)");
			}

		}

		System.out.println("\nAlunos cadastrados: ");// Exibe os alunos cadastrados
		for (Aluno aluno : alunoCadastrados) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			System.out.println("\nNome: " + aluno.getNome());
			System.out.println("Data de nascimento: " + dateFormat.format(aluno.getDataNascimento()));
			System.out.println("Matrícula: " + aluno.getMatricula());
		}

		sc.close();// Fechamento do Scanner
	}

}