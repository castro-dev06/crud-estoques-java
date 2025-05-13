# 🧮 Sistema de Controle de Estoque - CRUD

## 🚀 Sobre o Projeto

Este é um mini projeto que simula um sistema de controle de estoque, com um menu simples no terminal. A ideia é permitir que o usuário possa:

- Cadastrar novos produtos  
- Ver a lista completa dos produtos  
- Atualizar informações de um produto existente  
- Remover produtos do sistema  
- Realizar vendas ou reabastecimentos de estoque  

Tudo isso de forma prática e direta, usando o terminal.

---

## 🔒 Regras do Sistema

Tem uma regra importante aqui:  
**Um produto só pode ser removido se sua quantidade em estoque for igual a zero.**  
Ou seja, se ainda tiver unidades disponíveis, o sistema não permite a exclusão.

---

## 🗂️ O que foi usado e por quê

Esse sistema foi construído aplicando alguns princípios que estou aprendendo:

- **Programação Orientada a Objetos (POO)** – para manter o código mais organizado e dividir bem as responsabilidades.  
- **Programação Funcional** – usei `stream()` e `filter()` para encontrar produtos na lista, o que ajuda a deixar o código mais enxuto.  
- **Validações básicas** – como verificar se o ID já existe, se o nome está vazio ou se o preço/quantidade são válidos.  
- **Menu interativo no terminal** – tudo acontece por lá, com mensagens claras para ajudar o usuário a navegar pelo sistema.
- Classe EstoqueService - responsável por concentrar toda a lógica de negócio do sistema, separando da classe principal (Program). Isso torna o método main mais limpo e o código, mais fácil de manter e entender.

---

## 💡 Próximos passos

Esse é só o começo. A ideia é melhorar esse sistema com o tempo e, futuramente, conectar com um banco de dados para salvar tudo de forma permanente.

---
