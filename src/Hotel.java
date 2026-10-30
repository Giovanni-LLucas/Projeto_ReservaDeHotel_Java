public class Hotel {

    Quarto[] quartos;
    Reserva[] reservas;
    private int proximoCodigo = 1;

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
            quartos[i].mostrarDados();
        }
    }

    public Quarto buscarQuartoPorNumero(int numero){
        for(int i = 0; i < quartos.length; i++){
            if(quartos[i].getNumeroDoQuarto() == numero){
                return quartos[i];
            }
        }
        return null;
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
       if(!quarto.getEstaDisponivel()){
            System.out.println("O quarto já está ocupado.");
            return null;
       }

       for(int i = 0; i < reservas.length; i++){
            if(reservas[i] == null){
                Reserva novaReserva = new Reserva(proximoCodigo, hospede, quarto, dias);
                reservas[i] = novaReserva;
                proximoCodigo++;

                quarto.ocupar(hospede);
                return novaReserva;
            }
       }
       System.out.println("Reserva não encontrada ou já cancelada.");
       return null;
    }

    public void cancelarReserva(int numero){
        for(int  i = 0; i < reservas.length; i++){
            if(reservas[i] != null){

                if(reservas[i].getQuarto().getNumeroDoQuarto() == numero){

                    if(reservas[i].estaAtiva()){

                        reservas[i].cancelar();
                        reservas[i].getQuarto().liberar();

                        System.out.println("Reserva do quarto " + numero + " cancelada.");
                        System.out.println("");
                        return;
                    }

                }

            }
        }
        System.out.println("Nenhuma reserva no quarto " + numero + " encontrada.");
        System.out.println("");
    }

    public Reserva buscarReservaPorCpf(String cpf){
        for(int i = 0; i < reservas.length; i++){

            if(reservas[i] != null){

                if(reservas[i].getHospede().getCpf().equals(cpf) && reservas[i].estaAtiva()){
                    return reservas[i];
                }
            }
        }
        return null;
    }

    public void exibirReservas(){
        boolean encontrarReserva = false;
        for(int i = 0; i < reservas.length; i++){

            if(reservas[i] != null && reservas[i].estaAtiva()){
                System.out.println(reservas[i].mostrarDados());
                encontrarReserva = true;
            }
        }
        if(!encontrarReserva){
            System.out.println("Nenhuma reserva cadastrada.");
        }   
    }
    
}
