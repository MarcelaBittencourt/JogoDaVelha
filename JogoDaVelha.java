import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in);

    String[][] tabuleiro = new String[3][3];

    Object[][] jogadores = {
                    { "JogadorX", 0 },
                    { "JogadorO", 0 }
    };

    boolean continuarJogando = true;

    while (continuarJogando) {
                inicializarTabuleiro(tabuleiro);
                jogarPartida(tabuleiro, jogadores, scanner);

                System.out.println("\n=== Tabuleiro final ===");
                exibirTabuleiro(tabuleiro);
                exibirPontuacao(jogadores);

                System.out.print("\nDeseja jogar outra partida? (S/N): ");
                String resposta = scanner.nextLine().trim();
                continuarJogando = resposta.equalsIgnoreCase("S");
    }

    System.out.println("\nObrigado por jogar! Placar final:");
    exibirPontuacao(jogadores);

    scanner.close();
}

    private static void inicializarTabuleiro(String[][] tabuleiro) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tabuleiro[i][j] = "-";
                }
            }
        }

        private static void exibirTabuleiro(String[][] tabuleiro) {
            System.out.println();
            for (int i = 0; i < 3; i++) {
                StringBuilder linha = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    linha.append(" ").append(tabuleiro[i][j]).append(" ");
                    if (j < 2) linha.append("|");
                }
                System.out.println(linha);
                if (i < 2) System.out.println("-----------");
            }
            System.out.println();
        }

        private static void exibirPontuacao(Object[][] jogadores) {
            System.out.println("=== Placar ===");
            for (Object[] jogador : jogadores) {
                String nome = (String) jogador[0];
                int pontos = (Integer) jogador[1];
                System.out.println(nome + ": " + pontos + " ponto(s)");
            }
        }

        private static void jogarPartida(String[][] tabuleiro, Object[][] jogadores, Scanner scanner) {
            String[] marcas = { "X", "O" };
            int indiceJogadorAtual = 0;
            boolean fimDeJogo = false;

            while (!fimDeJogo) {
                String nomeAtual = (String) jogadores[indiceJogadorAtual][0];
                String marcaAtual = marcas[indiceJogadorAtual];

                exibirTabuleiro(tabuleiro);
                System.out.println("Vez de " + nomeAtual + " (" + marcaAtual + ")");

                int linha = lerPosicao(scanner, "linha");
                int coluna = lerPosicao(scanner, "coluna");

                if (posicaoOcupada(tabuleiro, linha, coluna)) {
                    System.out.println(">> Posição já ocupada! Tente novamente.");
                    continue;
                }

                tabuleiro[linha][coluna] = marcaAtual;

                if (verificarVitoria(tabuleiro, marcaAtual)) {
                    exibirTabuleiro(tabuleiro);
                    System.out.println(">>> " + nomeAtual + " venceu a partida! <<<");
                    int pontosAtuais = (Integer) jogadores[indiceJogadorAtual][1];
                    jogadores[indiceJogadorAtual][1] = pontosAtuais + 1;
                    fimDeJogo = true;
                } else if (verificarEmpate(tabuleiro)) {
                    exibirTabuleiro(tabuleiro);
                    System.out.println(">>> Empate! Ninguém pontua. <<<");
                    fimDeJogo = true;
                } else {
                    indiceJogadorAtual = 1 - indiceJogadorAtual;
                }
            }
        }

        private static int lerPosicao(Scanner scanner, String tipo) {
            int valor;
            while (true) {
                System.out.print("Digite a " + tipo + " (1 a 3): ");
                String entrada = scanner.nextLine().trim();
                try {
                    valor = Integer.parseInt(entrada);
                    if (valor >= 1 && valor <= 3) {
                        return valor - 1;
                    }
                    System.out.println(">> Valor fora do intervalo. Digite entre 1 e 3.");
                } catch (NumberFormatException e) {
                    System.out.println(">> Entrada inválida. Digite um número entre 1 e 3.");
                }
            }
        }

        private static boolean posicaoOcupada(String[][] tabuleiro, int linha, int coluna) {
            return !tabuleiro[linha][coluna].equals("-");
        }

        private static boolean verificarVitoria(String[][] tabuleiro, String marca) {
            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][0].equals(marca) && tabuleiro[i][1].equals(marca) && tabuleiro[i][2].equals(marca)) {
                    return true;
                }
                if (tabuleiro[0][i].equals(marca) && tabuleiro[1][i].equals(marca) && tabuleiro[2][i].equals(marca)) {
                    return true;
                }
            }
            if (tabuleiro[0][0].equals(marca) && tabuleiro[1][1].equals(marca) && tabuleiro[2][2].equals(marca)) {
                return true;
            }
            if (tabuleiro[0][2].equals(marca) && tabuleiro[1][1].equals(marca) && tabuleiro[2][0].equals(marca)) {
                return true;
            }
            return false;
        }

        private static boolean verificarEmpate(String[][] tabuleiro) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j].equals("-")) {
                        return false;
                    }
                }
            }
            return true;
        }
