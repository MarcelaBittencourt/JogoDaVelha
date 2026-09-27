# JogoDaVelha
Código na linguagem java que simula o clássico "jogo da velha" .

JOGO DA VELHA (TIC-TAC-TOE) - JAVA
===================================

DESCRICAO
---------
Implementacao do classico Jogo da Velha em Java, jogado via console (terminal).
O programa utiliza tipos heterogeneos para representar o tabuleiro e os
jogadores, conforme descrito abaixo.

ESTRUTURAS DE DADOS
--------------------
- Tabuleiro: matriz String[3][3], onde cada posicao vazia e representada
  pelo caractere "-". As jogadas sao marcadas com "X" ou "O".

- Jogadores: vetor heterogeneo Object[][] jogadores, onde cada linha guarda:
      posicao 0 -> nome do jogador (String)
      posicao 1 -> pontuacao (Integer)

  Jogadores fixos:
      jogadores[0] = { "JogadorX", 0 }
      jogadores[1] = { "JogadorO", 0 }

COMO EXECUTAR
--------------
Este codigo usa o formato simplificado de programa Java (metodo main sem
modificadores, disponivel a partir do JDK 21 como preview / JDK 25 como
recurso padrao). 

COMO JOGAR
-----------
1. O jogo pede a linha e a coluna (valores de 1 a 3) para cada jogada.
2. Os jogadores se alternam automaticamente a cada rodada valida.
3. Se a posicao escolhida ja estiver ocupada, o jogo avisa e pede uma
   nova jogada, sem trocar a vez.
4. O jogo verifica automaticamente:
     - Vitoria por linha
     - Vitoria por coluna
     - Vitoria por diagonal
     - Empate (tabuleiro cheio sem vencedor)
5. Ao final de cada partida:
     - O tabuleiro final e exibido.
     - O placar (pontuacao acumulada) e exibido.
     - O vencedor da partida recebe 1 ponto.
6. O programa pergunta se os jogadores desejam jogar novamente (S/N).
   Os pontos sao mantidos entre as partidas ate o programa ser encerrado.

REGRAS RESUMIDAS
------------------
- Vencer uma partida: 1 ponto.
- Empate: nenhum ponto para ninguem.
- Posicoes ja ocupadas nao podem ser escolhidas novamente.
- O jogo so termina (por partida) com vitoria ou empate.

ESTRUTURA DO CODIGO (METODOS)
-------------------------------
- main                  -> controla o loop de partidas e exibe o placar final
- inicializarTabuleiro  -> preenche o tabuleiro com "-"
- exibirTabuleiro       -> imprime o tabuleiro formatado
- exibirPontuacao       -> imprime nome e pontos de cada jogador
- jogarPartida          -> controla uma partida completa (turnos, jogadas)
- lerPosicao            -> le e valida a entrada de linha/coluna do usuario
- posicaoOcupada        -> verifica se uma posicao do tabuleiro ja foi usada
- verificarVitoria      -> verifica vitoria por linha, coluna ou diagonal
- verificarEmpate       -> verifica se o tabuleiro esta cheio sem vencedor

OBSERVACOES
------------
- Nomes dos jogadores sao fixos ("JogadorX" e "JogadorO").

