import java.util.Scanner;

public class GioNat_Palace {

    private Scanner leitor;
    private Hotel hotel;

    public GioNat_Palace(){
        this.leitor = new Scanner (System.in);
        this.hotel = new Hotel();
    }

    public static void main (String[] args) {
        
        GioNat_Palace main = new GioNat_Palace();

        System.out.println("============== SEJAM BEM VINDOS AO GIONAT PALACE ==============");
        System.out.println("");

        int opcao;



        
        do{ 
            main.menu();
            opcao = main.leitor.nextInt();

            switch (opcao) {

                case 1:
                    main.listandoQuartos();
                    break;

                case 2:
                    main.fazerReserva();
                    break;

                case 3:
                    main.buscandoReservaPorCpf();
                    break;

                case 4:
                    main.cancelarReserva();
                    break;

                case 5:
                    main.exibindoReservas();
                    break;
                
                case 0:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

        }while(opcao != 0);

    }
    
    public void menu(){
        System.out.println("");
        System.out.println("1 - Listar Quartos");
        System.out.println("2 - Reservar Quarto");
        System.out.println("3 - Buscar reserva por CPF");
        System.out.println("4 - Cancelar Reserva");
        System.out.println("5 - Exibir reservas");
        System.out.println("0 - Encerrar programa");
        System.out.println("");
        System.out.print("O que deseja fazer: ");
    }

    public void listandoQuartos(){
        System.out.println("");
        hotel.listarQuartos();
    }

    public void fazerReserva(){
        leitor.nextLine();
        System.out.print("Insira seu nome: ");
        String nome = leitor.nextLine();
        System.out.print("Insira seu CPF (APENAS NUMEROS): ");
        String cpf = leitor.nextLine();
        System.out.print("Insira o seu telefone (APENAS NUMEROS): ");
        String telefone = leitor.nextLine();

        Hospede novoHospede = new Hospede(nome, cpf, telefone);

        listandoQuartos();

        System.out.println("");
        System.out.print("Qual o quarto deseja (Escolha pelo numero): ");
        int numeroQuarto = leitor.nextInt();

        Quarto quartoEscolhido = hotel.buscarQuartoPorNumero(numeroQuarto);

        if(quartoEscolhido != null && quartoEscolhido.getEstaDisponivel()){
            System.out.print("Quantos dias deseja ficar no hotel: ");
            int dias = leitor.nextInt();
            System.out.println("");
            hotel.reservarQuarto(novoHospede, quartoEscolhido, dias);
        }else{
            System.out.println("O quarto nao existe ou esta ocupado.");
        }

        //hotel.exibirReservas();
        System.out.println("");
    }

    public void buscandoReservaPorCpf(){
        leitor.nextLine();
        System.out.print("Insira seu CPF (SOMENTE NUMEROS): ");
        String cpf = leitor.nextLine();

        Reserva reservaEncotrada = hotel.buscarReservaPorCpf(cpf);

        if(reservaEncotrada != null){
            System.out.println("Reserva encontrada.");
            System.out.println(reservaEncotrada.mostrarDados());
        }else{
            System.out.println("Nenhuma reserva encotrada.");
        }
        System.out.println("");
    }

    public void cancelarReserva(){
        System.out.println("Insira o numero do quarto da sua reserva: ");
        int numero = leitor.nextInt();

        hotel.cancelarReserva(numero);
    }

    public void exibindoReservas(){
        hotel.exibirReservas();
    }
}