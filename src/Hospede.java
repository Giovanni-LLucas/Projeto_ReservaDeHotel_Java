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
            System.out.println("Erro: nome invalido. O nome nao pode ficar vazio.");
            return "NAO INFORMADO";
        }
        return nome;
    }

    private String validaCpf(String cpf) {
        if (cpf != null && cpf.length() == 11 && soTemNumeros(cpf)) {
            return cpf;
        }
        System.out.println("Erro: CPF invalido. Digite exatamente 11 numeros, sem pontos nem tracos.");
        return "NAO INFORMADO";
    }

    private String validaTelefone(String telefone) {
        if (telefone != null
                && telefone.length() == 11 && soTemNumeros(telefone)) {
            return telefone;
        }
        System.out.println("Erro: telefone invalido. Digite 11 numeros com DDD, sem espacos, parenteses nem tracos.");
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

    public boolean nomeValido() {
        return !nome.equals("NAO INFORMADO");
    }

    public boolean cpfValido() {
        return !cpf.equals("NAO INFORMADO");
    }

    public boolean telefoneValido() {
        return !telefone.equals("NAO INFORMADO");
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
