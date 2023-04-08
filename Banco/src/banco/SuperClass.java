package banco;

public class SuperClass {

    private double saldo;
    private double taxaDeJuros;
    private double limiteDeSaque;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void setTaxaDeJuros(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    public double getLimiteDeSaque() {
        return limiteDeSaque;
    }

    public void setLimiteDeSaque(double limiteDeSaque) {
        this.limiteDeSaque = limiteDeSaque;
    }

    public void mostrarDetalhes() {
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Taxa de Juros: " + this.getTaxaDeJuros());
        System.out.println("Limite de saque: " + this.getLimiteDeSaque());
    }

    public void fazerTransferencia(double quantia, String conta) {
        double quantiaTaxaTransferencia = quantia + this.taxaDeJuros;
        if (quantiaTaxaTransferencia <= 0 || quantiaTaxaTransferencia > this.saldo) {
            System.out.println("Saldo insuficiente para efutuar a transferência");
        } else {
            double novoSaldo = this.saldo - quantiaTaxaTransferencia;
            this.saldo = novoSaldo;
            System.out.println("Transferencia efutuada com sucesso!");
            System.out.println("-----------------------------------");
            System.out.println(conta);
            this.mostrarDetalhes();
            System.out.println("-----------------------------------");
        }
    }

    public void receberTransferencia(double quantia, String conta) {
        if (quantia <= 0) {
            System.out.println("Quantia mínima de transferencia é 1");
        } else {
            double novoSaldo = this.saldo + quantia;
            this.saldo = novoSaldo;
            System.out.println(conta);
            this.mostrarDetalhes();
        }
    }
}
