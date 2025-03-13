import java.util.Random;

public class BilheteUnico {

    double saldo;
    long numero;
    Usuario usuario;
   static final double TARIFA = 5.20;

   public BilheteUnico(long cpf, String nome, String perfil) {
       Random random = new Random();
       numero = random.nextLong(1000, 10000);
       usuario = new Usuario(cpf, nome, perfil);
   }

   //Método para cerregar o bilhete
    public double carregar(double valor) {
       saldo += valor;
       return saldo;
    }

    //Método para consultar o saldo do bilhete
    public double consultarSaldo() {
       return saldo;
    }

    //Método para passar na catraca
    public String passarCatraca() {
       double debito = TARIFA / 2;
       if(usuario.perfil.equalsIgnoreCase("comum")) {
           debito = TARIFA;
       }
       if(saldo >= debito) {
           saldo -= debito;
           return "Catraca liberada";
       }
       return "Saldo insuficiente";
   }

}
