import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}

class Servico {
    private String descricao;
    private double preco;

    public Servico(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
}

class Agendamento {
    private Cliente cliente;
    private Servico servico;
    private String dataHora;

    public Agendamento(Cliente cliente, Servico servico, String dataHora) {
        this.cliente = cliente;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public String getDataHora() {
        return dataHora;
    }
}

class Agenda {
    private List<Agendamento> agendamentos = new ArrayList<>();

    public void marcar(Agendamento ag) {
        agendamentos.add(ag);
    }

    public void cancelar(Agendamento ag) {
        agendamentos.remove(ag);
    }

    public void listar() {
        System.out.println("\n📅 Agendamentos:");
        for (Agendamento a : agendamentos) {
            System.out.println(
                a.getCliente().getNome() + " - " +
                a.getServico().getDescricao() + " - " +
                a.getDataHora()
            );
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

        System.out.print("Quantos agendamentos deseja cadastrar? ");
        int qtd = sc.nextInt();
        sc.nextLine(); // consumir quebra de linha

        for (int i = 0; i < qtd; i++) {
            System.out.println("\n--- Novo Agendamento ---");

            System.out.print("Nome do cliente: ");
            String nome = sc.nextLine();

            System.out.print("Telefone: ");
            String telefone = sc.nextLine();

            Cliente cliente = new Cliente(nome, telefone);

            System.out.print("Descrição do serviço: ");
            String desc = sc.nextLine();

            System.out.print("Preço do serviço: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            Servico servico = new Servico(desc, preco);

            System.out.print("Data e hora do agendamento (ex: 2025-08-27 14:00): ");
            String dataHora = sc.nextLine();

            Agendamento ag = new Agendamento(cliente, servico, dataHora);
            agenda.marcar(ag);

            System.out.println("✅ Agendamento cadastrado com sucesso!");
        }

        agenda.listar();

        sc.close();
    }
}
