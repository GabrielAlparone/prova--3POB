import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            List<cama> camas = new ArrayList<>();
            List<cliente> clientes = new ArrayList<>();
            List<quarto> quartos = new ArrayList<>();
            List<reserva> reservas = new ArrayList<>();

            int opcaoPrincipal;

            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1.Incluir Camas");
                System.out.println("2.Incluir Clientes");
                System.out.println("3.Incluir Quartos");
                System.out.println("4.Incluir Reservas");
                System.out.println("5.Alterar Camas");
                System.out.println("6.Alterar Clientes");
                System.out.println("7.Alterar Quartos");
                System.out.println("8.Alterar Reservas");
                System.out.println("9.Excluir Camas");
                System.out.println("10.Excluir Clientes");
                System.out.println("11.Excluir Quartos");
                System.out.println("12.Excluir Reservas");
                System.out.println("13.Listar Camas");
                System.out.println("14.Listar Clientes");
                System.out.println("15.Listar Quartos");
                System.out.println("16.Listar Reservas");
                System.out.println("0.Sair");

                opcaoPrincipal = scanner.nextInt();

                switch (opcaoPrincipal) {
                    case 1:
                    cama.incluirCama(camas, scanner);
                        break;
                    case 2:
                        cliente.incluirCliente(clientes, scanner);
                        break;

                    case 3:
                    quarto.incluirQuarto(quartos, scanner);
                        break;

                    case 4:
                        reserva.incluirReserva(reservas, scanner);
                        break;

                    case 5:
                     cama.alterarCama(camas, scanner);
                        break;

                    case 6:
                        cliente.alterarCliente(clientes, scanner);
                        break;
                    case 7:
                    quarto.alterarQuarto(quartos, scanner);
                        break;
                    case 8:
                    reserva.alterarReserva(reservas, scanner);
                        break;
                     case 9:
                        cama.excluirCama(camas, scanner);
                        break;
                    case 10:
                        cliente.excluirCliente(clientes, scanner);
                        break;
                    case 11:
                        quarto.excluirQuarto(quartos, scanner);
                         break;
                     case 12:
                        reserva.excluirReserva(reservas, scanner);
                        break;
                    case 13:
                    cama.listarCamas(camas);
                        break;
                    case 14:
                        cliente.listarClientes(clientes);
                        break;
                    case 15:
                        quarto.listarQuartos(quartos);
                        break;
                    case 16:
                        reserva.listarReservas(reservas);
                        break;
                    case 0:
                        System.out.println("Encerrando o programa.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } while (opcaoPrincipal != 0);
        }
    }
}