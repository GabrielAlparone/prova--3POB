import java.util.Scanner;
import java.util.List;

public class cama {
    private int id;
    private String codigoCama;
    private boolean ehBeliche;
    private String posicao;
    private String descricao;

    public cama(String codigoCama, boolean ehBeliche, String posicao, String descricao) {
        this.codigoCama = codigoCama;
        this.ehBeliche = ehBeliche;
        this.posicao = posicao;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoCama() {
        return codigoCama;
    }

    public void setCodigoCama(String codigoCama) {
        this.codigoCama = codigoCama;
    }

    public boolean isEhBeliche() {
        return ehBeliche;
    }

    public void setEhBeliche(boolean ehBeliche) {
        this.ehBeliche = ehBeliche;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Cama [id=" + id + ", codigoCama=" + codigoCama + ", ehBeliche=" + ehBeliche + ", posicao=" + posicao
                + ", descricao=" + descricao + "]";
    }

    // Adicione o scanner como parâmetro na função
    public static void incluirCama(List<cama> camas, Scanner scanner) {
        System.out.println("Incluindo Cama");
        System.out.print("Informe o código da cama: ");
        String codigoCama = scanner.next();
        System.out.print("A cama é beliche? (true/false): ");
        boolean ehBeliche = scanner.nextBoolean();
        System.out.print("Informe a posição da cama: ");
        String posicao = scanner.next();
        System.out.print("Descrição da cama: ");
        String descricao = scanner.next();

        // Criar o objeto Cama e adicionar à lista
        cama novaCama = new cama(codigoCama, ehBeliche, posicao, descricao);
        camas.add(novaCama);

        System.out.println("Cama incluída com sucesso!");
    }
    public static void excluirCama(List<cama> camas, Scanner scanner) {
        System.out.println("Excluindo Cama");
        System.out.print("Informe o código da cama a ser excluída: ");
        String codigoCamaExcluir = scanner.next();

        int indexCamaExcluir = -1;  // Inicializa o índice como -1, indicando que a cama não foi encontrada

        for (int i = 0; i < camas.size(); i++) {
            if (camas.get(i).getCodigoCama().equals(codigoCamaExcluir)) {
                indexCamaExcluir = i;
                break;  // Encontrou a cama, podemos sair do loop
            }
        }

        if (indexCamaExcluir != -1) {
            camas.remove(indexCamaExcluir);
            System.out.println("Cama excluída com sucesso!");
        } else {
            System.out.println("Cama não encontrada. Nenhuma cama foi excluída.");
        }
    }


    public static void alterarCama(List<cama> camas, Scanner scanner) {
        System.out.println("Alterando Cama");
        System.out.print("Informe o código da cama a ser alterada: ");
        String codigoCamaAlterar = scanner.next();

        for (cama c : camas) {
            if (c.getCodigoCama().equals(codigoCamaAlterar)) {
                // Opções de alteração, por exemplo, descrição ou outras propriedades
                System.out.println("Opções de alteração:");
                System.out.println("1. Alterar descrição");
                System.out.println("2. Outra opção de alteração");

                int opcaoAlteracao = scanner.nextInt();
                switch (opcaoAlteracao) {
                    case 1:
                        System.out.print("Nova descrição da cama: ");
                        String novaDescricao = scanner.next();
                        c.setDescricao(novaDescricao);
                        System.out.println("Descrição da cama alterada com sucesso!");
                        return;
                    case 2:
                        // Outra opção de alteração
                        break;
                    default:
                        System.out.println("Opção inválida. Nenhuma alteração realizada.");
                }
            }
        }

        System.out.println("Cama não encontrada. Nenhuma alteração realizada.");
    }

    public static void listarCamas(List<cama> camas) {
        if (camas.isEmpty()) {
            System.out.println("Nenhuma cama cadastrada.");
        } else {
            System.out.println("Listando Camas:");
            for (cama c : camas) {
                System.out.println(c);
            }
        }
    }
    
}