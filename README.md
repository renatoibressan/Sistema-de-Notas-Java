# 📚 Sistema de Notas em Java

Sistema de gerenciamento de alunos desenvolvido em Java, com suporte a cadastro, registro de notas e persistência em arquivos.

O projeto foi criado com foco no aprendizado prático de Programação Orientada a Objetos (POO), manipulação de arquivos e tratamento de exceções.

---

## 🚀 Funcionalidades

* Cadastro de alunos com matrícula única
* Registro de múltiplas notas por aluno
* Validação de notas (0 a 10)
* Cálculo de média
* Busca de alunos por matrícula
* Persistência de dados em arquivo `.txt`
* Carregamento de dados ao iniciar o programa
* Opção de salvar dados ao encerrar

---

## 🧠 Conceitos aplicados

* Programação Orientada a Objetos (POO)
* Encapsulamento e separação de responsabilidades
* Estruturas de dados (`Map`, `List`)
* Exceções customizadas
* Manipulação de arquivos com buffer (`BufferedReader`, `BufferedWriter`)
* Parsing de dados

---

## 📂 Estrutura do projeto

```bash
.
├── Aluno.java
├── GerenciadorAlunos.java
├── ArquivoAlunos.java
├── PersistenciaAlunos.java
└── Main.java
```

---

## 💾 Formato do arquivo

Os dados são armazenados em um arquivo `.txt` no seguinte formato:

```
matricula | nome | nota1; nota2; nota3
```

### Exemplo:

```
1 | João Silva | 8.5; 7.0; 9.2
```

---

## ▶️ Como executar

### 1. Clonar o repositório

```bash
git clone https://github.com/renatoibressan/Sistema-de-Notas-Java.git
cd Sistema-de-Notas-Java
```

### 2. Compilar

```bash
javac *.java
```

### 3. Executar

```bash
java Main
```

---

## ⚙️ Decisões de projeto

* Uso de `Map<Integer, Aluno>` para garantir unicidade de matrícula
* Interface de persistência (`PersistenciaAlunos`) para desacoplamento
* Separação entre lógica de negócio e persistência
* Uso de buffer para melhor desempenho em leitura/escrita de arquivos

---

## 🔧 Melhorias futuras

* Interface gráfica (GUI)
* Validação mais robusta de entrada de dados
* Ordenação de alunos
* Persistência com banco de dados (JDBC)
* Auto-save automático
* Melhor encapsulamento das coleções

---

## 📌 Observações

Este projeto representa uma evolução além de exercícios básicos, incluindo persistência de dados e tratamento estruturado de erros.

---

## 👨‍💻 Autor

Renato Bressan
Graduando em Ciência da Computação
