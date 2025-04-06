# 💳 Criador de Conta Bancária

Projeto Java com foco em Programação Orientada a Objetos (POO), que simula a criação e gerenciamento de contas bancárias para diferentes bancos e tipos de conta (Corrente e Poupança). Permite cadastrar clientes, abrir contas, fazer saques, depósitos, transferências e consultar extratos.

---

## 🧠 Funcionalidades

- ✅ Cadastro de clientes com validações de CPF e e-mail  
- ✅ Escolha do banco entre: Itaú, Bradesco, Santander, Nubank e Inter  
- ✅ Criação de conta corrente ou poupança  
- ✅ Impressão de extrato bancário  
- ✅ Busca de contas por número  
- ✅ Aplicação de taxa em conta corrente  
- ✅ Aplicação de juros em conta poupança  

---

## 📁 Estrutura do Projeto

```
src/
├── app/
│   └── App.java
├── model/
│   ├── Banco.java
│   ├── Cliente.java
│   ├── Conta.java (abstract)
│   ├── ContaCorrente.java
│   ├── ContaPoupanca.java
│   └── enums/
│       ├── BancoEnum.java
│       └── TipoConta.java
├── interfaces/
│   └── IConta.java
└── validador/
    └── Validador.java
```

---

## ⚙️ Tecnologias

- Java 17+ (compatível com JDK 23)
- Lombok (para gerar getters, setters e construtores automaticamente)
- Maven (recomendado para gerenciamento de dependências)

---

## 🚀 Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/VitorReis44/projeto-banco-dio.me.git
   cd Criador-Conta
   ```

2. **Abra o projeto no Eclipse:**
   - Vá em **File > Open Projects from File System**
   - Clique em Directory... e selecione a pasta dio-banco-inicial

3. **Execute o programa:**
   - Navegue até `src/app/App.java`
   - Clique com o botão direito > **Run As > Java Application**

---

## 🧾 Licença

Este projeto é open-source e está licenciado sob a licença MIT.
