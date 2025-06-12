# ArvoreAvlTrabalho

Este projeto implementa uma Árvore AVL em Java para análise de desempenho, conforme solicitado na disciplina de Programação Orientada a Objetos.

## Descrição

O objetivo deste trabalho é implementar uma Árvore AVL para armazenar e manipular dados, analisando o tempo gasto nas operações de inserção, remoção e busca. O projeto também compara o desempenho da Árvore AVL com o `java.util.TreeMap` (árvore rubro-negra) do Java Collections Framework.

## Autores

- Ian Carvalho Santos Conceiçãos
- Guilherme Oliveira Pereira
- Jonathas Sampaio Mascarenhas Almeida
  
## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

-   `Show.java`: Representa um filme ou série (entidade de dados).
-   `NoAVL.java`: Representa um nó da Árvore AVL.
-   `ArvoreAVL.java`: Implementa a Árvore AVL com os métodos de inserção, remoção, busca e balanceamento.
-   `Main.java`: Classe principal que lê os dados do CSV, realiza os testes de desempenho e gera o arquivo de log.

## Pré-requisitos

-   Java Development Kit (JDK) 8 ou superior
-   IntelliJ IDEA (ou outra IDE de sua preferência)

## Como Rodar

Siga os passos abaixo para executar o projeto:

1.  **Clone o repositório:**

    ```bash
    git clone [URL do seu repositório]
    cd ArvoreAvlTrabalho
    ```

2.  **Abra o projeto no IntelliJ IDEA:**

    -   Clique em "File" -> "Open" e selecione a pasta do projeto.

3.  **Verifique a estrutura do projeto:**

    -   Certifique-se de que a estrutura do projeto está correta, com as classes Java na pasta `src`.

4.  **Adicione o arquivo CSV:**

    -   Coloque o arquivo `netflix_data.csv` na pasta `src` do projeto.

5.  **Compile e execute o projeto:**

    -   No IntelliJ IDEA, clique com o botão direito no arquivo `Main.java` e selecione "Run 'Main.main()'".

6.  **Analise os resultados:**

    -   Após a execução, um arquivo chamado `log.txt` será gerado na pasta raiz do projeto. Este arquivo contém os tempos de inserção, busca e remoção para a Árvore AVL e o TreeMap.

## Configuração Adicional (Opcional)

-   **Aumentar o número de testes:**
    -   No arquivo `Main.java`, você pode alterar o número de buscas e remoções para obter resultados mais precisos. Altere as variáveis `numBuscas` e o número de iterações nos laços de remoção.

## Observações

-   Este projeto utiliza um parser CSV simples implementado manualmente para lidar com campos entre aspas.
-   Os tempos de execução podem variar dependendo do hardware e da quantidade de dados no arquivo CSV.

## Licença

[Tipo de Licença]
