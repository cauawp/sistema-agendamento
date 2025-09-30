import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// Classe que representa um Cliente
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

// Classe que representa um Serviço
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

// Classe que representa um Agendamento
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

// Classe que gerencia a lista de agendamentos
class Agenda {
  private List<Agendamento> agendamentos = new ArrayList<>();

  public void marcar(Agendamento ag) {
    agendamentos.add(ag);
  }

  // Método para cancelar um agendamento (caso seja necessário)
  public void cancelar(Agendamento ag) {
    agendamentos.remove(ag);
  }

  // Método para listar todos os agendamentos cadastrados
  public void listar() {
    System.out.println("\nAgendamentos:");
    for (Agendamento a : agendamentos) {
      System.out.println(
          a.getCliente().getNome() + " - " +
              a.getServico().getDescricao() + " - " +
              a.getDataHora());
    }
  }
}

public class Main {
  public static void main(String[] args) {
    // Cria o scanner para ler entrada do usuário
    Scanner sc = new Scanner(System.in);
    // Cria uma nova agenda (lista de agendamentos)
    Agenda agenda = new Agenda();

    boolean continuar = true;

    // Loop que permite registrar vários agendamentos
    while (continuar) {
      System.out.println("\n--- NOVO AGENDAMENTO ---");

      System.out.print("Nome do cliente: ");
      String nome = sc.nextLine();

      System.out.print("Telefone: ");
      String telefone = sc.nextLine();

      // Cria o objeto cliente
      Cliente cliente = new Cliente(nome, telefone);

      System.out.print("Descrição do serviço: ");
      String desc = sc.nextLine();

      System.out.print("Preço do serviço: R$");
      Double preco = sc.nextDouble();
      sc.nextLine(); // Consome a quebra de linha após nextDouble()

      Servico servico = new Servico(desc, preco);

      System.out.print("Data e hora do agendamento (ex: 29/09 20:00): ");
      String dataHora = sc.nextLine();

      Agendamento ag = new Agendamento(cliente, servico, dataHora);

      agenda.marcar(ag);

      System.out.println("Seu agendamento foi cadastrado com sucesso!");

      System.out.print("\nDeseja cadastrar outro agendamento? (s/n): ");
      String resposta = sc.nextLine().trim().toLowerCase();

      // Se a resposta for diferente de "s", encerra o loop
      if (!resposta.equals("s")) {
        continuar = false;
      }
    }

    agenda.listar();

    sc.close();
  }
}