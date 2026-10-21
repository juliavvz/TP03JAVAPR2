# CBTLPR2 TP 03

Solução em Java Swing para o trabalho prático da disciplina **CBTLPR2 (Java)**, do IFSP Campus Cubatão.

## Funcionalidades

- Calculadora com adição, subtração, multiplicação e divisão.
- Botão `C` para limpar os campos e o resultado.
- Tratamento de erros com `try`, `catch` e `finally`.
- Classe `Pessoa` com `kp` estático para contar pessoas distintas cadastradas.
- Formulário de pessoa com campos `Número`, `Nome`, `Sexo` e `Idade`.
- Versão de seleção de sexo usando `JComboBox`.
- Versão de seleção de sexo usando `JRadioButton`.
- Validação dos campos obrigatórios e da idade.

## Link do vídeo 

- https://youtu.be/EflJaBbhquI

## Requisitos

- Java JDK 17 ou superior.
- Maven 3.8 ou superior.

## Como executar

Na raiz do projeto, execute:

```bash
mvn clean compile exec:java
```

Também é possível abrir o projeto em uma IDE como IntelliJ IDEA, Eclipse ou NetBeans e executar a classe:

```text
br.edu.ifsp.cbtlpr2.Main
```

## Executar sem Maven

### Linux ou macOS

```bash
mkdir -p classes

javac -encoding UTF-8 -d classes src/main/java/br/edu/ifsp/cbtlpr2/*.java

java -cp classes br.edu.ifsp.cbtlpr2.Main
```

### Windows PowerShell

```powershell
mkdir classes

javac -encoding UTF-8 -d classes src\main\java\br\edu\ifsp\cbtlpr2\*.java

java -cp classes br.edu.ifsp.cbtlpr2.Main
```

## Estrutura do projeto

```text
src/main/java/br/edu/ifsp/cbtlpr2/
├── CalculadoraFrame.java
├── Main.java
├── Pessoa.java
└── PessoaFrame.java
```
