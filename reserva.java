import java.util.List;
import java.util.Scanner;

public class reserva {
    private static int idCounter = 1; // Contador para gerar IDs únicos
    private int id;
    private int idQuarto;
    private int idCama;
    private int idCliente;
    private String dataEntrada;
    private String dataSaida;

    // Construtor
    public reserva(int idQuarto, int idCama, int idCliente, String dataEntrada, String dataSaida) {
        this.id = idCounter++;
        this.idQuarto = idQuarto;
        this.idCama = idCama;
        this.idCliente = idCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    // Métodos getter e setter para os atributos

    public int getId() {
        return id;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getIdCama() {
        return idCama;
    }

    public void setIdCama(int idCama) {
        this.idCama = idCama;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", idQuarto=" + idQuarto + ", idCama=" + idCama
                + ", idCliente=" + idCliente + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + "]";
    }

    // Função para incluir reserva
    public static void incluirReserva(List<reserva> reservas, Scanner scanner) {
        System.out.println("Incluindo Reserva");

        System.out.print("ID do Quarto: ");
        int idQuarto = scanner.nextInt();
        System.out.print("ID da Cama: ");
        int idCama = scanner.nextInt();
        System.out.print("ID do Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("Data de Entrada (YYYY-MM-DD): ");
        String dataEntrada = scanner.next();
        System.out.print("Data de Saída (YYYY-MM-DD): ");
        String dataSaida = scanner.next();

        // Criar o objeto Reserva e adicionar à lista
        reserva novaReserva = new reserva(idQuarto, idCama, idCliente, dataEntrada, dataSaida);
        reservas.add(novaReserva);

        System.out.println("Reserva incluída com sucesso!");
    }

    // Função para excluir reserva
    public static void excluirReserva(List<reserva> reservas, Scanner scanner) {
        System.out.println("Excluindo Reserva");

        System.out.print("Informe o ID da reserva a ser excluída: ");
        int idReservaExcluir = scanner.nextInt();

        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getId() == idReservaExcluir) {
                reservas.remove(i);
                System.out.println("Reserva excluída com sucesso!");
                return;
            }
        }

        System.out.println("Reserva não encontrada. Nenhuma reserva foi excluída.");
    }

    // Função para alterar reserva
    public static void alterarReserva(List<reserva> reservas, Scanner scanner) {
        System.out.println("Alterando Reserva");

        System.out.print("Informe o ID da reserva a ser alterada: ");
        int idReservaAlterar = scanner.nextInt();

        for (reserva r : reservas) {
            if (r.getId() == idReservaAlterar) {
                // Opções de alteração
                System.out.println("Opções de alteração:");
                System.out.println("1. Alterar ID do quarto");
                System.out.println("2. Alterar ID da cama");
                System.out.println("3. Alterar ID do cliente");
                System.out.println("4. Alterar data de entrada");
                System.out.println("5. Alterar data de saída");
                // Adicione mais opções conforme necessário

                int opcaoAlteracao = scanner.nextInt();
                switch (opcaoAlteracao) {
                    case 1:
                        System.out.print("Novo ID do quarto: ");
                        int novoIdQuarto = scanner.nextInt();
                        r.setIdQuarto(novoIdQuarto);
                        System.out.println("ID do quarto na reserva alterado com sucesso!");
                        return;
                    case 2:
                        System.out.print("Novo ID da cama: ");
                        int novoIdCama = scanner.nextInt();
                        r.setIdCama(novoIdCama);
                        System.out.println("ID da cama na reserva alterado com sucesso!");
                        return;
                    case 3:
                        System.out.print("Novo ID do cliente: ");
                        int novoIdCliente = scanner.nextInt();
                        r.setIdCliente(novoIdCliente);
                        System.out.println("ID do cliente na reserva alterado com sucesso!");
                        return;
                    case 4:
                        System.out.print("Nova data de entrada (YYYY-MM-DD): ");
                        String novaDataEntrada = scanner.next();
                        r.setDataEntrada(novaDataEntrada);
                        System.out.println("Data de entrada na reserva alterada com sucesso!");
                        return;
                    case 5:
                        System.out.print("Nova data de saída (YYYY-MM-DD): ");
                        String novaDataSaida = scanner.next();
                        r.setDataSaida(novaDataSaida);
                        System.out.println("Data de saída na reserva alterada com sucesso!");
                        return;

                    default:
                        System.out.println("Opção inválida. Nenhuma alteração realizada.");
                }
            }
        }

        System.out.println("Reserva não encontrada. Nenhuma alteração realizada.");
    }

    // Função para listar reservas
    public static void listarReservas(List<reserva> reservas) {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
        } else {
            System.out.println("Listando Reservas:");
            for (reserva r : reservas) {
                System.out.println(r);
            }
        }
    }
}
