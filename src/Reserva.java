public class Reserva {

    private int codigo;
    private Hospede hospede;
    private Quarto quarto;
    private int dias;
    private double totalHospedagem;
    private String status;

    public Reserva(int codigo, Hospede hospede, Quarto quarto, int dias) {
        this.codigo = codigo;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dias = validaDias(dias);
        this.totalHospedagem = quarto.calcularValorEstadia(this.dias);
        this.status = "STATUS RESERVADA";
        quarto.ocupar(hospede);
        hospede.incrementarReservas();
    }

    private int validaDias(int dias) {
        if (dias >= 1) {
            return dias;
        }
        return 1;
    }

    public int getCodigo() { return codigo; }

    public Hospede getHospede() { return hospede; }

    public Quarto getQuarto() { return quarto; }

    public int getDias() { return dias; }

    public double getTotalHospedagem() { return totalHospedagem; }

    public String getStatus() { return status; }

    public boolean estaAtiva() {
        return status.equals("STATUS RESERVADA") || status.equals("STATUS HOSPEDADO");
    }

    public boolean registrarCheckIn() {
        if (status.equals("STATUS RESERVADA")) {
            status = "STATUS HOSPEDADO";
            return true;
        }
        return false;
    }

    public boolean registrarCheckOut() {
        if (status.equals("STATUS HOSPEDADO")) {
            status = "STATUS FINALIZADA";
            quarto.liberar();
            hospede.decrementarReservas();
            return true;
        }
        return false;
    }

    public boolean cancelar() {
        if (status.equals("STATUS RESERVADA")) {
            status = "STATUS CANCELADA";
            quarto.liberar();
            hospede.decrementarReservas();
            return true;
        }
        return false;
    }

    public String mostrarDados() {
        return String.format("Reserva: %-5d | Hospede: %-20s | Quarto: %-2d - Tipo do Quarto: %-10s | Quantidade de dias: %-2d | Total Hospedagem: R$ %-7.2f | Status: %s", 
        codigo, hospede.getNome(), quarto.getNumeroDoQuarto(), quarto.getTipoDoQuarto(), dias, totalHospedagem, status);
    }
}
