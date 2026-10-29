public class Hotel {

    Quarto[] quartos;
    Reserva[] reservas;

    public Hotel (){
        quartos = new Quarto[10];
        reservas = new Reserva[10];

        inicializarQuartos();
    }

    private void inicializarQuartos(){
        for(int i = 0; i < quartos.length; i++){
            int numeroQuarto  = i + 1;

            String tipo;
            double preco;

            if(numeroQuarto <= 4){
                tipo = "Basico";
                preco = 100.0;
            }else if(numeroQuarto <= 7){
                tipo = "Duplo";
                preco = 200.0;
            }else{
                tipo = "Luxo";
                preco = 300.0;
            }

            quartos[i] = new Quarto(numeroQuarto, tipo, preco);
        }
    }

    public void listarQuartos(){
        for(int i = 0; i < quartos.length; i++){
            System.out.println(quartos[i].mostrarDados;);
        }
    }

    public Quarto buscarQuartoDisponivel(){
        for(int i = 0; i < quartos.length; i++){
            if(quartos[i].getEstaDisponivel()){
                return quartos[i];
            }
        }
        return null;
    }

    public Reserva reservarQuarto(Hospede hospede, Quarto quarto, int dias){
        for(int i = 0; i < quartos.length; i++){
            if(!quartos[i].registrarCheckIn){
                System.out.println("O quarto já esta ocupado.");
                return null;
            }
        }
        return estaAtiva();
    }

    public void cancelarReserva(int codigo){
        for(int  i = 0; i < quartos.length; i++){
            if(quartos[i].registrarCheckOut){
                quartos[i].cancelar();
            }
        }
        return null;
    }

    public Reserva buscarReservaPorCpf(String cpf){
        for(int i = 0; i < quartos.length; i++){
            if(quartos[i].equals.getHospede()){
                return quartos[i].getHospede();
            }
        }
        return null
    }

    public void exibirReservas(){
        for(int i = 0; i < quartos.length; i++){
            System.out.println();
        }
    }

}
