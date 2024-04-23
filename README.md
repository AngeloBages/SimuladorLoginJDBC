# Simulador de Login

Este projeto consiste em um simulador de login desenvolvido em Java. Ele permite cadastrar usuários, realizar login e atualizar senhas. Abaixo estão descritas as principais classes e funcionalidades do projeto:

## Classes

### ConnectionFactory

Esta classe é responsável por fornecer uma conexão com o banco de dados MySQL. Ela utiliza um arquivo de propriedades para configurar os parâmetros de conexão, como URL do banco de dados, usuário e senha.

### Usuario

Representa um usuário do sistema, com atributos de email e senha.

### Dao

Uma interface genérica para operações de acesso a dados, como inserção, consulta, atualização e exclusão.

### UsuarioDaoImpl

Implementação da interface `Dao` para a entidade `Usuario`, fornecendo métodos para manipulação de dados no banco de dados relacionados aos usuários.

### GerenciadorUsuarios

Esta classe contém a lógica de negócios para interação com os usuários, incluindo cadastro, login e atualização de senhas.

### ValidadorDeUsuarios

Fornece métodos estáticos para validar emails e senhas, garantindo que atendam a critérios específicos, como formato de email e complexidade de senha.

### LoginTeste

Uma classe de teste que inicia a aplicação e permite interagir com as funcionalidades do simulador de login por meio de um menu de opções.

## Utilização

Para utilizar o simulador de login, execute a classe `LoginTeste`, que apresentará um menu com as opções de cadastrar um novo usuário, realizar login, atualizar senha ou sair do programa.

Certifique-se de configurar corretamente o banco de dados MySQL com as seguintes informações:

- URL: jdbc:mysql://localhost:3306/fj21?useSSL=false
- Usuário: root
- Senha: root
