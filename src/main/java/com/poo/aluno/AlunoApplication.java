package com.poo.aluno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poo.Professor;

@SpringBootApplication
public class AlunoApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(AlunoApplication.class, args);

		Scanner sc = new Scanner(System.in);
		List<Aluno> alunoCadastrados = new ArrayList<>();
		List<Professor> professorCadastrados = new ArrayList<>();

		boolean continuarCadastro = true;

		while (continuarCadastro) {
			System.out.println("==================");
			System.out.println("Cadastro de alunos:");
			System.out.println("==================");
			System.out.println("\nDigite o nome do aluno:");
			String nome = sc.nextLine();

			System.out.println("\nDigite a data de nascimento do aluno (dd/MM/yyyy):");
			String dataNascimentoStr = sc.nextLine();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dataNascimento = dateFormat.parse(dataNascimentoStr);

			Aluno aluno = new Aluno(nome, dataNascimento);
			alunoCadastrados.add(aluno);

			System.out.println("\nAluno cadastrado com sucesso!");

			System.out.println("\nDeseja continuar cadastrando novo aluno? (S/N)");
			String resposta = sc.nextLine();
			continuarCadastro = resposta.equalsIgnoreCase("S");
		}

		boolean continuarCadastroProf = true;

		while (continuarCadastroProf) {
			System.out.println("==================");
			System.out.println("Cadastro de professores:");
			System.out.println("==================");
			System.out.println("\nDigite o nome do professor:");
			String nomeProf = sc.nextLine();

			System.out.println("\nDigite o número de matrícula do professor:");
			int matricula = sc.nextInt();
			sc.nextLine();

			System.out.println("\nDigite o CPF do professor:");
			String cpf = sc.nextLine();

			try {
				Professor professor = new Professor(nomeProf, matricula, cpf);
				professorCadastrados.add(professor);

				System.out.println("\nProfessor cadastrado com sucesso!");

				System.out.println("\nDeseja continuar cadastrando novo professor? (S/N)");
				String respostaProf = sc.nextLine();
				continuarCadastroProf = respostaProf.equalsIgnoreCase("S");

			} catch (Exception e) {
				System.out.println("\nCPF não cadastrado.");
			}
		}

		System.out.println("\nProfessores cadastrados:");
		for (Professor professor : professorCadastrados) {
			System.out.println("\nNome: " + professor.getnome());
			System.out.println("CPF: " + professor.getCpf());
			System.out.println("Matrícula: " + professor.getMatricula());
		}

		sc.close();
	}
}
