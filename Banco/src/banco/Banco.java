package banco;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class Banco {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Conta corrente Slay
        ContaCorrente contaCorrenteSlay = new ContaCorrente();
        contaCorrenteSlay.setSaldo(1000);
        contaCorrenteSlay.setLimiteDeSaque(5000);
        contaCorrenteSlay.setTaxaDeJuros(10);

        // Conta Poupança Slay
        ContaPoupanca contaPoupancaSlay = new ContaPoupanca();
        contaPoupancaSlay.setSaldo(200);
        contaPoupancaSlay.setLimiteDeSaque(10000);
        contaPoupancaSlay.setTaxaDeJuros(20);

        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Levantar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Conta Poupanca");
        System.out.println("-------------------");

        System.out.print("Digite aqui: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                contaCorrenteSlay.mostrarDetalhes();
                break;
            case 2:
                limparConsole();
                System.out.print("Digite o valor: ");
                double quantiaLevantamento = scanner.nextDouble();
                limparConsole();
                contaCorrenteSlay.fazerSaque(quantiaLevantamento);
                break;
            case 3:
                limparConsole();
                System.out.print("Digite o valor: ");
                double quantiaDeposito = scanner.nextDouble();
                limparConsole();
                contaCorrenteSlay.fazerDeposito(quantiaDeposito);
                break;
            case 4:
                limparConsole();
                System.out.println("1 - Para Conta Poupanca");
                System.out.println("2 - Para Conta Investimento");
                System.out.println("3 - De conta Poupanca para Corrente");
                System.out.println("4 - De conta Investimento para corrente");

                System.out.print("Digite aqui: ");
                int opcaoTransferencia = scanner.nextInt();

                switch (opcaoTransferencia) {
                    case 1:
                        limparConsole();
                        System.out.print("Digite o valor: ");
                        double quantiaTransferenciaPara = scanner.nextDouble();
                        limparConsole();
                        contaCorrenteSlay.fazerTransferencia(quantiaTransferenciaPara, "Conta Corrente");
                        contaPoupancaSlay.receberTransferencia(quantiaTransferenciaPara, "Conta Poupanca");
                        break;
                    case 3:
                        limparConsole();
                        System.out.print("Digite o valor: ");
                        double quantiaTransferenciaDe = scanner.nextDouble();
                        limparConsole();
                        contaPoupancaSlay.fazerTransferencia(quantiaTransferenciaDe, "Conta Poupanca");
                        contaCorrenteSlay.receberTransferencia(quantiaTransferenciaDe, "Conta Corrente");
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }

                break;
            case 5:
                limparConsole();
                contaPoupancaSlay.mostrarDetalhes();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    // Usar este método para limpar console do netbeans
    public final static void limparConsole() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(60);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
            System.out.println(ex);
        }
    }
}
