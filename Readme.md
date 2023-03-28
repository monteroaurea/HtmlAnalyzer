# HtmlAnalyzer

O `HtmlAnalyzer` é um programa Java que recebe uma URL como entrada e retorna o conteúdo HTML em forma de String. Em seguida, analisa o conteúdo e retorna o trecho de texto mais profundo na estrutura HTML.

## Requisitos

Para utilizar o `HtmlAnalyzer`, é necessário ter o [Java](https://www.java.com/en/) instalado em sua máquina.


## Utilização 
*No Command Line Interface, diretório onde está o arquivo java:*

1. **Compilar:**
Para Compilar, usar o seguinte comando:
- javac HtmlAnalyzer.java

2. **Obter trecho HTML mais profundo da URL:**
Para utilizar, usar o comando abaixo seguido pela URL de preferencia como argumento:
- java HtmlAnalyzer inserir-url-aqui


## Como funciona

O `HtmlAnalyzer` funciona analisando o conteúdo HTML da URL especificada. Ele utiliza uma pilha para acompanhar as tags HTML enquanto analisa o conteúdo. Quando encontra uma tag de abertura, adiciona-a à pilha. Quando encontra uma tag de fechamento, remove o elemento do topo da pilha e verifica se ele corresponde à tag de fechamento.

VERIFICAR: Se as tags correspondem, o programa continua a análise. Caso contrário, ele lança um erro.

O programa mantém o controle do nível mais profundo de tags aninhadas encontradas e o elemento HTML correspondente a esse nível. Depois de analisar todo o conteúdo HTML, ele retorna o elemento HTML mais profundo ao usuário.

*O programa irá recuperar o conteúdo HTML da URL inserida na Linha de Comando e analisar seu conteúdo para encontrar o trecho de texto mais profundo da estrutura HTML, e por fim, imprimi-lo no console.*