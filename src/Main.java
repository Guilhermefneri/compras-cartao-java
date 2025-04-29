import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe o limite do cartão:");
        double limite = leitor.nextDouble();
        leitor.nextLine();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0){
            System.out.println("Digite o nome do produto que deseja comprar:");
            String descricao = leitor.nextLine();

            System.out.println("Digite o valor da compra:");
            double valor = leitor.nextDouble();
            leitor.nextLine();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancarCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para fazer uma nova compra.");
                sair = leitor.nextInt();
                leitor.nextLine();
            }else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("********************************");
        System.out.println("COMPRAS REALIZADAS:\n");

        // ordena compras por valor (menor para maior)
        Collections.sort(cartao.getCompras());

        for (Compra c : cartao.getCompras()){
            System.out.println(c.getDescricao() + " - " + "R$" + c.getValor());
        }
        System.out.println("\n********************************");
        System.out.println("\nTotal de compras realizadas: " + cartao.getCompras().size());
        System.out.println("Saldo do cartão: " + cartao.getSaldo());
    }
}