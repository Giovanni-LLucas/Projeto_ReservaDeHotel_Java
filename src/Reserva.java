public class Reserva {

    private int codigo;
    private Hospede hospede;
    private Quarto quarto;
    private int dias;
    private double totalHospedagem;
    private String status;

    private final String STATUS_RESERVADA = "Reservada";
    private final String STATUS_HOSPEDADO = "Hospedado";
    private final String STATUS_FINALIZADA = "Finalizada";
    private final String STATUS_CANCELADA = "Cancelada";

    public Reserva(int codigo, Hospede hospede, Quarto quarto, int dias) {
        this.codigo = codigo;
        this.hospede = hospede;
        this.quarto = quarto;
        this.dias = validaDias(dias);
        this.totalHospedagem = quarto.calcularValorEstadia(this.dias);
        this.status = STATUS_RESERVADA;
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
        return status.equals(STATUS_RESERVADA) || status.equals(STATUS_HOSPEDADO);
    }

    public boolean registrarCheckIn() {
        if (status.equals(STATUS_RESERVADA)) {
            status = STATUS_HOSPEDADO;
            return true;
        }
        return false;
    }

    public boolean registrarCheckOut() {
        if (status.equals(STATUS_HOSPEDADO)) {
            status = STATUS_FINALIZADA;
            quarto.liberar();
            hospede.decrementarReservas();
            return true;
        }
        return false;
    }

    public boolean cancelar() {
        if (status.equals(STATUS_RESERVADA)) {
            status = STATUS_CANCELADA;
            quarto.liberar();
            hospede.decrementarReservas();
            return true;
        }
        return false;
    }

    public void mostrarDados() {
        System.out.printf("Reserva #%d | Hospede: %s | Quarto %d (%s) | %d dia(s) | Total: R$ %.2f | %s%n",
                codigo, hospede.getNome(), quarto.getNumeroDoQuarto(), quarto.getTipoDoQuarto(),
                dias, totalHospedagem, status);
    }
}
