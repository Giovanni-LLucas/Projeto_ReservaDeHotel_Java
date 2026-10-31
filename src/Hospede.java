public class Hospede {

    private String nome;
    private String cpf;
    private String telefone;
    private int reservasAtivas;

    public Hospede(String nome, String cpf, String telefone) {
        this.nome = validaNome(nome);
        this.cpf = validaCpf(cpf);
        this.telefone = validaTelefone(telefone);
        this.reservasAtivas = 0;
    }

    private String validaNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return "NAO INFORMADO";
        }
        return nome;
    }

    private String validaCpf(String cpf) {
        if (cpf != null && cpf.length() == 11 && soTemNumeros(cpf)) {
            return cpf;
        }
        return "NAO INFORMADO";
    }

    private String validaTelefone(String telefone) {
        if (telefone != null
                && telefone.length() == 11 && soTemNumeros(telefone)) {
            return telefone;
        }
        return "NAO INFORMADO";
    }

    private boolean soTemNumeros(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean dadosValidos() {
        return !nome.equals("NAO INFORMADO") && !cpf.equals("NAO INFORMADO") && !telefone.equals("NAO INFORMADO");
    }

    public String getNome() { return nome; }

    public String getCpf() { return cpf; }

    public String getTelefone() { return telefone; }

    public int getReservasAtivas() { return reservasAtivas; }

    public void incrementarReservas() {
        reservasAtivas++;
    }

    public void decrementarReservas() {
        if (reservasAtivas > 0) {
            reservasAtivas--;
        }
    }

    public void mostrarDados() {
        System.out.println("Hospede: " + nome + " | CPF: " + cpf + " | Telefone: " + telefone + " | Reservas ativas: " + reservasAtivas);
    }
}
