package br.edu.ifsul.cstsi.lpoo_objetivo_5;

    import br.edu.ifsul.cstsi.lpoo_objetivo_5.participantes.ParticipanteController;

    import java.util.Scanner;

    public class HomeController {

        private static final Scanner input = new Scanner(System.in);

        public static void main(String[] args) {

            int opcao;
            do {
                System.out.print("\n-------  Home -------");
                System.out.print(
                        """
        
                            1. Manter Participantes
                            2. Manter Produtos
                            3. Manter Clientes
                            4. Manter Itens
                            5. Manter Pedidos
                            Opção (Zero p/sair):\s""");
                opcao = input.nextInt();
                input.nextLine();
                switch (opcao) {
                    case 1 -> ParticipanteController.main(null);
                    case 2 -> System.out.println("Em desenvolvimento"); // LeilaoController.main(null)
                    case 3 -> System.out.println("Em desenvolvimento"); // LanceController.main(null)
                    case 4 -> System.out.println("Em desenvolvimento"); //Item_LeilaoController.main(null);
                    default -> {
                        if (opcao != 0) System.out.println("Opção inválida.");
                    }
                }
            } while(opcao != 0) ;
            System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
            input.close();
        }

    }
