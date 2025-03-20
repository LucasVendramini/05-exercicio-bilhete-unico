import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    private BilheteUnico[] bilhete = new BilheteUnico[2];
    private int index = 0;

    public void menuPrincipal() {

        int opcao = 0;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";

        do {
            opcao = parseInt(showInputDialog(menu));

            if (opcao == 1) {
                menuAdmin();
            }

        } while (opcao != 3);
    }

    private void menuAdmin() {
        int opcao;
        String menu = "MENU ADMINISTRADOR\n";
        menu += "1. Emitir Bilhete\n";
        menu += "2. Listar Bilhete\n";
        menu += "3. Excluir Bilhete\n";
        menu += "4. Sair\n";

        do {

            opcao = parseInt(showInputDialog(menu));

            switch (opcao) {
                case 1:
                    emitirBilhete();
                    break;
                case 2:
                    listarBilhete();
                    break;
            }

        } while (opcao != 4);

    }

    private void emitirBilhete() {
        String nome, perfil;
        long cpf;

        if (index < bilhete.length) {
            nome = showInputDialog("Nome do Usuário: ");
            cpf = parseLong(showInputDialog("CPF: "));
            perfil = showInputDialog("Estudante ou Professor ou Comum: ");
            bilhete[index] = new BilheteUnico(cpf, nome, perfil);
            index++;
        } else {
            showMessageDialog(null, "Procure um Posto de Atendimento");
        }

    }

    private void listarBilhete() {

        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";
        for (int i = 0; i < index; i++){
            aux += "Número do Bilhete: " + bilhete[i].numero + "\n";
            aux += "Saldo do Bilhete: R$" + df.format(bilhete[i].saldo) + "\n";
            aux += "Usuário: " + bilhete[i].usuario.nome + "\n";
            aux += "Perfil do Usuário: " + bilhete[i].usuario.perfil + "\n";
            aux += "CPF: " + bilhete[i].usuario.cpf + "\n\n";
        }

        showMessageDialog(null, aux);

    }


}