import java.util.List;
import java.util.Scanner;

public class cliente {
    private static int idCounter = 1; // Contador para gerar IDs únicos
    private int id;
    private String nome;
    private String endereco;
    private String postalCode;
    private String pais;
    private String cpf;
    private String passaporte;
    private String email;
    private String dataNascimento;

    // Construtor
    public cliente(String nome, String endereco, String postalCode, String pais, String cpf,
                   String passaporte, String email, String dataNascimento) {
        this.id = idCounter++;
        this.nome = nome;
        this.endereco = endereco;
        this.postalCode = postalCode;
        this.pais = pais;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    // Métodos getter e setter para os atributos

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }



    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco
                + ", postalCode=" + postalCode + ", pais=" + pais + ", cpf=" + cpf
                + ", passaporte=" + passaporte + ", email=" + email + ", dataNascimento=" + dataNascimento + "]";
    }

    // Função para incluir cliente
    public static void incluirCliente(List<cliente> clientes, Scanner scanner) {
        System.out.println("Incluindo Cliente");

        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Endereço: ");
        String endereco = scanner.next();
        System.out.print("Código Postal: ");
        String postalCode = scanner.next();
        System.out.print("País: ");
        String pais = scanner.next();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.print("Passaporte: ");
        String passaporte = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.next();

        // Criar o objeto Cliente e adicionar à lista
        cliente novoCliente = new cliente(nome, endereco, postalCode, pais, cpf, passaporte, email, dataNascimento);
        clientes.add(novoCliente);

        System.out.println("Cliente incluído com sucesso!");
    }

    // Função para excluir cliente
    public static void excluirCliente(List<cliente> clientes, Scanner scanner) {
        System.out.println("Excluindo Cliente");

        System.out.print("Informe o ID do cliente a ser excluído: ");
        int idClienteExcluir = scanner.nextInt();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == idClienteExcluir) {
                clientes.remove(i);
                System.out.println("Cliente excluído com sucesso!");
                return;
            }
        }

        System.out.println("Cliente não encontrado. Nenhum cliente foi excluído.");
    }

    // Função para alterar cliente
    public static void alterarCliente(List<cliente> clientes, Scanner scanner) {
        System.out.println("Alterando Cliente");

        System.out.print("Informe o ID do cliente a ser alterado: ");
        int idClienteAlterar = scanner.nextInt();

        for (cliente c : clientes) {
            if (c.getId() == idClienteAlterar) {
                // Opções de alteração
                System.out.println("Opções de alteração:");
                System.out.println("1. Alterar nome");
                System.out.println("2. Alterar endereço");
                // Adicione mais opções conforme necessário

                int opcaoAlteracao = scanner.nextInt();
                switch (opcaoAlteracao) {
                    case 1:
                        System.out.print("Novo nome do cliente: ");
                        String novoNome = scanner.next();
                        c.setNome(novoNome);
                        System.out.println("Nome do cliente alterado com sucesso!");
                        return;
                    case 2:
                        System.out.print("Novo endereço do cliente: ");
                        String novoEndereco = scanner.next();
                        c.setEndereco(novoEndereco);
                        System.out.println("Endereço do cliente alterado com sucesso!");
                        return;

                    default:
                        System.out.println("Opção inválida. Nenhuma alteração realizada.");
                }
            }
        }

        System.out.println("Cliente não encontrado. Nenhuma alteração realizada.");
    }

    // Função para listar clientes
    public static void listarClientes(List<cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Listando Clientes:");
            for (cliente c : clientes) {
                System.out.println(c);
            }
        }
    }
}
