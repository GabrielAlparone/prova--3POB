import java.util.List;
import java.util.Scanner;

public class quarto {
    private static int idCounter = 1;
    private int id;
    private String nomeQuarto;
    private int qtdeCamas;
    private boolean temBanheiro;
    private String descricao;

    // Construtor
    public quarto(String nomeQuarto, int qtdeCamas, boolean temBanheiro, String descricao) {
        this.id = idCounter++;
        this.nomeQuarto = nomeQuarto;
        this.qtdeCamas = qtdeCamas;
        this.temBanheiro = temBanheiro;
        this.descricao = descricao;
    }

    // Métodos getter e setter para os atributos

    public int getId() {
        return id;
    }

    public String getNomeQuarto() {
        return nomeQuarto;
    }

    public void setNomeQuarto(String nomeQuarto) {
        this.nomeQuarto = nomeQuarto;
    }

    public int getQtdeCamas() {
        return qtdeCamas;
    }

    public void setQtdeCamas(int qtdeCamas) {
        this.qtdeCamas = qtdeCamas;
    }

    public boolean isTemBanheiro() {
        return temBanheiro;
    }

    public void setTemBanheiro(boolean temBanheiro) {
        this.temBanheiro = temBanheiro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Quarto [id=" + id + ", nomeQuarto=" + nomeQuarto + ", qtdeCamas=" + qtdeCamas
                + ", temBanheiro=" + temBanheiro + ", descricao=" + descricao + "]";
    }

    // Função para incluir quarto
    public static void incluirQuarto(List<quarto> quartos, Scanner scanner) {
        System.out.println("Incluindo Quarto");

        System.out.print("Nome do Quarto: ");
        String nomeQuarto = scanner.next();
        System.out.print("Quantidade de Camas: ");
        int qtdeCamas = scanner.nextInt();
        System.out.print("Tem Banheiro? (true/false): ");
        boolean temBanheiro = scanner.nextBoolean();
        System.out.print("Descrição: ");
        String descricao = scanner.next();

        // Criar o objeto Quarto e adicionar à lista
        quarto novoQuarto = new quarto(nomeQuarto, qtdeCamas, temBanheiro, descricao);
        quartos.add(novoQuarto);

        System.out.println("Quarto incluído com sucesso!");
    }

    // Função para excluir quarto
    public static void excluirQuarto(List<quarto> quartos, Scanner scanner) {
        System.out.println("Excluindo Quarto");

        System.out.print("Informe o ID do quarto a ser excluído: ");
        int idQuartoExcluir = scanner.nextInt();

        for (int i = 0; i < quartos.size(); i++) {
            if (quartos.get(i).getId() == idQuartoExcluir) {
                quartos.remove(i);
                System.out.println("Quarto excluído com sucesso!");
                return;
            }
        }

        System.out.println("Quarto não encontrado. Nenhum quarto foi excluído.");
    }

    // Função para alterar quarto
    public static void alterarQuarto(List<quarto> quartos, Scanner scanner) {
        System.out.println("Alterando Quarto");

        System.out.print("Informe o ID do quarto a ser alterado: ");
        int idQuartoAlterar = scanner.nextInt();

        for (quarto q : quartos) {
            if (q.getId() == idQuartoAlterar) {
                // Opções de alteração
                System.out.println("Opções de alteração:");
                System.out.println("1. Alterar nome do quarto");
                System.out.println("2. Alterar quantidade de camas");
                System.out.println("3. Alterar a presença de banheiro");
                System.out.println("4. Alterar descrição");
                // Adicione mais opções conforme necessário

                int opcaoAlteracao = scanner.nextInt();
                switch (opcaoAlteracao) {
                    case 1:
                        System.out.print("Novo nome do quarto: ");
                        String novoNomeQuarto = scanner.next();
                        q.setNomeQuarto(novoNomeQuarto);
                        System.out.println("Nome do quarto alterado com sucesso!");
                        return;
                    case 2:
                        System.out.print("Nova quantidade de camas: ");
                        int novaQtdeCamas = scanner.nextInt();
                        q.setQtdeCamas(novaQtdeCamas);
                        System.out.println("Quantidade de camas do quarto alterada com sucesso!");
                        return;
                    case 3:
                        System.out.print("O quarto tem banheiro? (true/false): ");
                        boolean novoTemBanheiro = scanner.nextBoolean();
                        q.setTemBanheiro(novoTemBanheiro);
                        System.out.println("Presença de banheiro no quarto alterada com sucesso!");
                        return;
                    case 4:
                        System.out.print("Nova descrição do quarto: ");
                        String novaDescricao = scanner.next();
                        q.setDescricao(novaDescricao);
                        System.out.println("Descrição do quarto alterada com sucesso!");
                        return;

                    default:
                        System.out.println("Opção inválida. Nenhuma alteração realizada.");
                }
            }
        }

        System.out.println("Quarto não encontrado. Nenhuma alteração realizada.");
    }

    // Função para listar quartos
    public static void listarQuartos(List<quarto> quartos) {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
        } else {
            System.out.println("Listando Quartos:");
            for (quarto q : quartos) {
                System.out.println(q);
            }
        }
    }
}
