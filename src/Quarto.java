public class Quarto {

    private int numeroDoQuarto;
    private String tipoDoQuarto;
    private double preco;
    private boolean disponibilidade;
    private Hospede hospede;

    public Quarto(int numeroDoQuarto, String tipoDoQuarto, double preco) {
        this.numeroDoQuarto = numeroDoQuarto;
        this.tipoDoQuarto = validaTipo(tipoDoQuarto);
        this.preco = validaPreco(preco);
        this.disponibilidade = true;
        this.hospede = null;
    }

    private String validaTipo(String tipo) {
        if (tipo == null ) {
            return "Basico";
        }
        return tipo;
    }

    private double validaPreco(double preco) {
        if (preco > 0) {
            return preco;
        }
        return 0.0;
    }

    public int getNumeroDoQuarto() { return numeroDoQuarto; }

    public String getTipoDoQuarto() { return tipoDoQuarto; }

    public double getPreco() { return preco; }

    public boolean getEstaDisponivel() { return disponibilidade; }

    public void setTipoDoQuarto(String tipoDoQuarto) {
        this.tipoDoQuarto = validaTipo(tipoDoQuarto);
    }

    public void setPreco(double preco) {
        this.preco = validaPreco(preco);
    }

    public boolean ocupar(Hospede hospede) {
        if (hospede != null && disponibilidade) {
            disponibilidade = false;
            this.hospede = hospede;
            return true;
        }
        return false;
    }

    public boolean liberar() {
        if (!disponibilidade) {
            disponibilidade = true;
            hospede = null;
            return true;
        }
        return false;
    }

    public double calcularValorEstadia(int dias) {
        return preco * dias;
    }

    public void mostrarDados() {
        String situacao = "Disponivel";
        if (!disponibilidade) {
            situacao = "Ocupado por " + hospede.getNome();
        }
        System.out.println("Quarto " + numeroDoQuarto + "| Tipo: " +tipoDoQuarto +"| Diaria:"+ preco + "| "+situacao);
    }
}
