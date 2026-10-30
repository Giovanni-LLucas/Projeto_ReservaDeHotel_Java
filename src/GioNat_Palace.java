import java.util.Scanner;

public class GioNat_Palace {

    private Scanner leitor;

    public GioNat_Palace(){
        this.leitor = new Scanner (System.in);
    }

    public static void main (String[] args) {
        
        GioNat_Palace read = new GioNat_Palace();

        System.out.println("============== SEJAM BEM VINDOS AO GIONAT PALACE ==============");
        System.out.println("");
        System.out.println("");

        read.iniciar();

    }

    public void iniciar(){

    }

    public void menu(){
        System.out.println("1 - Listar Quartos | Disponibilidade");
        System.out.println("2 - Reservar Quarto");
        System.out.println("3 - Buscar reserva por CPF");
        System.out.println("4 - Cancelar Reserva");
        System.out.println("5 - Exibir reservas");
        System.out.println("0 - Encerrar programa");
        System.out.println("");
        System.out.print("O que deseja fazer: ");
    }
}