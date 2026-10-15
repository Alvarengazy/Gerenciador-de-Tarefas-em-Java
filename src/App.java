import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> tarefas = new ArrayList<>();
    private static final ArrayList<Double> horas = new ArrayList<>();

    private static String leitura(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(leitura(mensagem));
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("===BEM VINDO===");
        String name = leitura("Digite seu nome: ");
        menu(name);
    }

    public static void menu(String name) {
        int selecionar;

        do {
            System.out.println("\n === Olá, " + name + " ===");
            System.out.println("1. Cadastrar Tarefas ");
            System.out.println("2. Verificar Tarefas ");
            System.out.println("3. Remover Tarefas ");
            System.out.println("0. Finalizar");

            selecionar = lerInteiro("\nEscolha uma opção: ");

            switch (selecionar) {
                case 1 -> cadastro();
                case 2 -> verificar();
                case 3 -> remover();
                case 0 -> System.out.println("Sistema Encerrado");
                default -> System.out.println("Opção inválida!!!");
            }
        } while (selecionar != 0);
    }

    private static void cadastro() {
        int selecionar;
        do {
            System.out.println("\n === CADASTRO ===");
            System.out.println("1. Adicionar");
            System.out.println("0. Voltar");
            selecionar = lerInteiro("\nSelecione uma opção: ");

            switch (selecionar) {
                case 1 -> adicionar();
                case 0 -> System.out.println("\nVoltando");
                default -> System.out.println("Opção inválida!!!");
            }
        } while (selecionar != 0);
    }

    private static void adicionar() {
        String tarefa;
        do {
            tarefa = leitura("Digite o nome de sua Tarefa: ");
            if (tarefa.isBlank()) {
                System.out.println("O campo não pode ficar vazio");
            }
        } while (tarefa.isBlank());

        double hora;

        while (true) {
            try {
                hora = Double.parseDouble(leitura("Digite o Horário que deseja (0 a 24): ").replace(",", "."));

                
                if (hora < 0 || hora > 24) {
                    System.out.println("O horário deve ficar entre 0 e 24!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite um horário válido!");
            }
        }

        tarefas.add(tarefa);
        horas.add(hora);

        System.out.println("Nome: " + tarefa + " Horário: " + hora + "H");
    }

    private static void verificar() {
        if (tarefas.isEmpty()) {
            System.out.println("Está vazia sua lista!!!");
            return;
        }

        System.out.println("===TAREFAS REGISTRADAS==");

        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + "- " + tarefas.get(i) + " | Horário: " + horas.get(i));
        }
    }

    private static void remover() {
        if (tarefas.isEmpty()) {
            System.out.println("Não existem Tarefas!!");
            return;
        }

        System.out.println("===REMOÇÃO===");

        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + " - Tarefa: " + tarefas.get(i) + " | Horário: " + horas.get(i));
        }

        int escolha = lerInteiro("Qual tarefa deseja remover? ");
        int indice = escolha - 1;

       
        if (indice < 0 || indice >= tarefas.size()) {
            System.out.println("Tarefa inexistente!");
            return;
        }

        tarefas.remove(indice);
        horas.remove(indice);

        System.out.println("Tarefa removida!");
    }
}