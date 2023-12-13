package br.edu.ifsul.cstsi.lpoo_objetivo_5.participantes;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class ParticipanteController {

        private static final Scanner input = new Scanner(System.in);
        private static ParticipanteService participanteService;

        public ParticipanteController(ParticipanteService ParticipanteService) {
            ParticipanteController.participanteService = ParticipanteService;
        }

        public static void main(String[] args) {

            int opcao;
            do {
                System.out.print("\n\"-------  MENU participante -------\"");
                System.out.print(
                        """
        
                            1. Inserir novo participante
                            2. Atualizar um participante
                            3. Excluir um participante
                            4. Listar todos os participantes
                            5. Buscar participante pelo código
                            6. Buscar participantes pelo nome
                            7. Buscar participante pelo Login
                            Opção (Zero p/sair):\s""");
                opcao = input.nextInt();
                input.nextLine();
                switch (opcao) {
                    case 1 -> inserir();
                    case 2 -> atualizar();
                    case 3 -> excluir();
                    case 4 -> selectparticipantes();
                    case 5 -> selectparticipantesById();
                    case 6 -> selectparticipantesByNome();
                    case 7 -> selectparticipantesByLogin();
                    default -> {
                        if (opcao != 0) System.out.println("Opção inválida.");
                    }
                }
            } while (opcao != 0);
        }


        private static void inserir() {
            Participante participante = new Participante();
            System.out.println("\n++++++ Cadastro de novo Participante ++++++");
            System.out.print("Digite o nome do Participante: ");
            participante.setNome(input.nextLine());
            System.out.print("\nDigite o Login do Participante: ");
            participante.setLogin(input.nextLine());
            System.out.print("\nDigite a Senha do Participante: ");
            participante.setSenha(input.nextLine());
            System.out.print("\nDigite o E-mail do Participante: ");
            participante.setEmail(input.nextLine());
            System.out.print("\nDigite o Endereco do Participante: ");
            participante.setEndereco(input.nextLine());
            System.out.print("\nDigite o Telefone do Participante: ");
            participante.setTelefone(input.nextLine());
            System.out.println("participante salvo com sucesso:" + participanteService.insert(participante));
        }


        private static void atualizar() {
            System.out.println("\n++++++ Alterar um Participante ++++++");
            Participante participante;
            int opcao = 0;
            do {
                System.out.print("\nDigite o código do Participante (Zero p/sair): ");
                long codigo = input.nextLong();
                input.nextLine();
                if (codigo == 0) {
                    opcao = 0;
                } else {
                    participante = participanteService.getParticipanteById(codigo);
                    if (participante == null) {
                        System.out.println("Código inválido.");
                    } else {
                        System.out.println("Nome: " + participante.getNome());
                        System.out.print("Alterar? (0-sim/1-não) ");
                        if(input.nextInt() == 0){
                            input.nextLine();
                            System.out.println("Digite o novo nome do participante: ");
                            participante.setNome(input.nextLine());
                        }
                        System.out.println("Login: " + participante.getLogin());
                        System.out.print("Alterar? (0-sim/1-não) ");
                        if(input.nextInt() == 0){
                            input.nextLine();
                            System.out.print("Digite o novo login do participante: ");
                            participante.setLogin(input.nextLine());
                        }
                        System.out.println("Senha: " + participante.getSenha());
                        System.out.print("Alterar? (0-sim/1-não) ");
                        if(input.nextInt() == 0){
                            input.nextLine();
                            System.out.print("Digite a nova senha do participante: ");
                            participante.setSenha(input.nextLine());
                        }
                        System.out.println("Email: " + participante.getEmail());
                        System.out.print("Alterar? (0-sim/1-não) ");
                        if(input.nextInt() == 0){
                            input.nextLine();
                            System.out.print("Digite o novo email do participante: ");
                            participante.setEmail(input.nextLine());
                        }
                        System.out.println("Endereco: " + participante.getEndereco());
                        System.out.print("Alterar? (0-sim/1-não) ");
                        if(input.nextInt() == 0){
                            input.nextLine();
                            System.out.print("Digite o novo endereco do participante: ");
                            participante.setEndereco(input.nextLine());
                        }
                        System.out.println("Telefone: " + participante.getTelefone());
                        System.out.print("Alterar? (0-sim/1-não) ");
                        if(input.nextInt() == 0){
                            input.nextLine();
                            System.out.print("Digite o novo telefone do participante: ");
                            participante.setTelefone(input.nextLine());
                        }
                        if(participanteService.update(participante) != null) {
                            System.out.println("participante atualizado com sucesso. " + participanteService.getParticipanteById(participante.getId()));
                        } else {
                            System.out.println("Não foi possível atualizar este participante. Por favor, contate o administrador.");
                        }

                        opcao = 1;
                    }
                }
            } while (opcao != 0);
        }

        private static void excluir() {
            System.out.println("\n++++++ Excluir um participante ++++++");
            Participante participante;
            int opcao = 0;
            do {
                System.out.print("\nDigite o código do participante (Zero p/sair): ");
                long codigo = input.nextLong();
                input.nextLine();
                if (codigo == 0) {
                    opcao = 0;
                } else if(codigo > 0){
                    participante = participanteService.getParticipanteById(codigo);
                    if (participante == null) {
                        System.out.println("Código inválido.");
                    } else {
                        System.out.println(participante);
                        System.out.print("Excluir este participante? (0-sim/1-não) ");
                        if (input.nextInt() == 0) {
                            input.nextLine();
                            System.out.print("Tem certeza disso? (0-sim/1-não) ");
                            input.nextLine();
                            participanteService.delete(participante.getId());
                            System.out.println("participante excluído com sucesso:" + participante);
                        }

                    }
                } else {
                    System.out.println("Digite um código válido!!!");
                }
            } while (opcao != 0);
        }



        private static void selectparticipantes() {
            System.out.println("\nLista de participantes cadastrados no banco de dados:\n" + participanteService.getParticipantes());
        }


        private static void selectparticipantesById() {
            System.out.print("\nDigite o código do participante: ");
            Participante participante = participanteService.getParticipanteById(input.nextLong());
            input.nextLine();
            if (participante != null) {
                System.out.println(participante);
            } else {
                System.out.println("Código não localizado.");
            }
        }

        private static void selectparticipantesByNome() {
            System.out.print("Digite o nome do cliente: ");
            String nome = input.next();
            System.out.println("Chave de pesquisa: " + nome);
            List<Participante> participantes = participanteService.getParticipantesByNome(nome + "%");
            if (participantes.isEmpty()) {
                System.out.println("Não há registros correspondentes para: " + nome);
            } else {
                System.out.println(participantes);
            }
        }

        private static void selectparticipantesByLogin() {
            System.out.print("Digite o login do participante: ");
            String login = input.next();
            System.out.println("Chave de pesquisa: " + login);
            List<Participante> participantes  = participanteService.getParticipantesByLogin(login + "%");
            if (participantes.isEmpty()) {
                System.out.println("Não há registros correspondentes para: " + login);
            } else {
                System.out.println(participantes);
            }
        }

    }

