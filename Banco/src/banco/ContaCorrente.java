package banco;

public class ContaCorrente extends SuperClass {
    public void fazerSaque(double quantia) {
        double quantiaTaxaSaque = quantia + this.getTaxaDeJuros();
        if (quantiaTaxaSaque > this.getSaldo()) {
            System.out.println("Não tens saldo suficiente para realizar a transação");
        } else {
            double novoSaldo = this.getSaldo() - quantiaTaxaSaque;
            this.setSaldo(novoSaldo);
            System.out.println("Saque efetuado com sucesso!");
            System.out.println("O teu novo saldo é: " + this.getSaldo());
        }
    }
    
    public void fazerDeposito(double quantia) {
        if (quantia <= 0) {
            System.out.println("A quatia mínima de depósito é 1");
        } else {
            double novoSaldo = this.getSaldo() + quantia;
            this.setSaldo(novoSaldo);
            System.out.println("Depósito efetuado com sucesso!");
            System.out.println("O teu novo saldo é: " + this.getSaldo());
        }
    }
}
