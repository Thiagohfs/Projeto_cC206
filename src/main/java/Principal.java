import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int op = 1;
        boolean flag = true;
        Jogo f = new Jogo();
        ClienteDAO c2 = new ClienteDAO();
        AlugadoDAO a2 = new AlugadoDAO();
        ArrayList<Jogo> j2 = new ArrayList<>();
        JogoDAO j3 = new JogoDAO();


        while (flag) {
            System.out.println(" Bem vindo a nossa locadora de jogos ");
            System.out.println("1 - Cadastro Cliente");
            System.out.println("2 - Locação Jogo");
            System.out.println("3 - Devolução Jogo");
            System.out.println("4 - Jogos Diponiveis");
            System.out.println("5 - Sair");

            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Digite seu Nome:");
                    String nome = scan.nextLine();
                    System.out.println("Digite seu CPF:");
                    String Cpf = scan.nextLine();
                    System.out.println("Seu endereçoEndereço:");
                    String endereco = scan.nextLine();
                    Cliente c = new Cliente(nome, Cpf, endereco);
                    c2.inserirCliente(c);

                    break;

                case 2:
                    System.out.println("Data Locação:");
                    String dataAlugado = scan.nextLine();
                    System.out.println("Data Devolução:");
                    String dataDeVolucao = scan.nextLine();
                    boolean disponivel = false;
                    boolean alugado = true;
                    System.out.println("Código Jogo:");
                    int codigo_jogo = scan.nextInt();
                    j2 = j3.buscaJogos();
                    for (int i = 0; i < j2.size(); i++) {
                        if (j2.get(i).getCodigo() == codigo_jogo) {
                            System.out.println("Este filme está alugado!");
                            alugado = false;
                        }
                    }
                        if (alugado == true) {
                            Alugado a = new Alugado(dataAlugado, dataDeVolucao, codigo_jogo);
                            a2.inserirAlugado(a);
                        }
                        break;

                        case 3:
                            System.out.println("Codigo Jogo:");
                            int codigo = scan.nextInt();
                            a2.deletarAlugado(codigo);
                            System.out.println("Jogo Devolvido!");
                            break;
                        case 4:
                            j2 = j3.buscaJogos();
                            for (int i = 0; i < j2.size(); i++) {
                                if (j2.get(i).isDisponivel() != true) {
                                    System.out.println(j2.get(i).getNome());
                                    System.out.println(j2.get(i).getGenero());
                                    System.out.println(j2.get(i).getCodigo());
                                }
                            }
                        case 5:
                            flag = false;


                    }

            }
        }
    }




