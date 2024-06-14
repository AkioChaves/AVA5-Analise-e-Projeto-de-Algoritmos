import java.util.Scanner;

public class Menu {
    private static FilaAtendimento filaAtendimento = new FilaAtendimento();

    public static void exibirMenu(Scanner scanner) 
    {
        boolean sair = false;

        while (!sair) 
        {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Registrar paciente.");
            System.out.println("2. Consultar paciente.");
            System.out.println("3. Atender próximo da fila.");
            System.out.println("4. Consultar fila.");
            System.out.println("5. Consultar atendidos.");
            System.out.println("6. Sair.");
            System.out.print("Escolha uma opção: ");

            int escolha;
            try 
            {
                escolha = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) 
            {
                System.out.println("Por favor, digite um número válido.");
                continue;
            }

            switch (escolha)
            {
                case 1:
                    registrarPaciente(scanner);
                    break;
                case 2:
                    consultarPaciente(scanner);
                    break;
                case 3:
                    fazerProximo();
                    break;
                case 4:
                    consultarFila();
                    break;
                case 5:
                    consultarAtendidos();
                    break;
                case 6:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
            System.out.println("Pressione Enter para continuar.");
            scanner.nextLine();
            
            limparTela();
        }
    }

    private static void registrarPaciente(Scanner scanner) {
        Paciente paciente = Paciente.registrarPaciente(scanner);
        filaAtendimento.adicionarPaciente(paciente);
    }

    private static void consultarPaciente(Scanner scanner) 
    {
        System.out.println("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        Paciente paciente = filaAtendimento.consultarPaciente(cpf);
        if (paciente != null) 
        {
            System.out.println(paciente);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void fazerProximo() 
    {
        filaAtendimento.atenderProximo();
    }

    private static void consultarFila() 
    {
        filaAtendimento.mostrarFila();
    }

    private static void consultarAtendidos() 
    {
        filaAtendimento.mostrarFilaAtendidos();
    }

    public static void limparTela() 
    {
        try 
        {
            if (System.getProperty("os.name").contains("Windows")) 
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else 
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
