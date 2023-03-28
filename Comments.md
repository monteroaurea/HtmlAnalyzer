        // CLASSE HTMLFETCHER
        // Contém o método getHtml, que recebe uma URL como entrada, 
        // retornando seu conteúdo HTML em forma de string.
        // O método pode lançar uma exceção IOException se ocorrer algum erro ao tentar conectar-se ou ler o conteúdo da URL.

        // Main Program
        // O programa inicializa recebendo a URL via argumento (adicionada na linha de comando) e 
        // faz uma tentativa de conexão para receber o conteúdo HTML (usando o getHtml).
        // Se ocorrer algum erro retorna uma mensagem de erro "URL connection error".
        // Caso o contrário, o conteúdo vai ser manipulado através do conceito de pilhas:



        // A pilha, ou stack, serve para empilhar os dados necessários durante a execução de blocos de código.
        // Ela é manipulada através de um laço de repetição que fará a iteração sobre cada linha do conteúdo.
        // Toda vez que encontra uma tag de fechamento, verifica se a tag de abertura correspondente está no topo
        // da pilha. Se houver "match", a tag de abertura? é removida. Se houver uma tag quebrada,
        // o programa exibe uma mensagem de erro e sai do loop.
        // A cada iteração, o programa verifica se o tamanho da pilha é maior do que o registrado anteriormente e 
        // atualiza a variável 'deepestLevel' com a tag mais profunda .
        // Por fim, o programa exibe o conteúdo do trecho HTML mais profundo encontrado. 