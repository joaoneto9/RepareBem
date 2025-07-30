# SIMULADO DE LP2 2025.1 - UFCG - 🧵 RepareBem 

## 📋 Descrição

O sistema **RepareBem** foi desenvolvido para informatizar os serviços de uma startup de ajustes em roupas, incentivando o consumo consciente e sustentável. Ele permite o controle completo de reparos realizados em peças de roupas por meio de **ordens de serviço (OS)** e mantém um registro detalhado de clientes, status e valores.

---

## ⚙️ Funcionalidades Implementadas

A classe principal `RepareBem` disponibiliza as seguintes funcionalidades:

### 🔧 Reparo
- `cadastrarReparo(id: String, descricao: String, preco: double)`: cadastra um novo reparo, evitando duplicações por ID.
- `reajustarPrecoReparo(idReparo: String, percentual: double)`: reajusta o preço de um reparo existente com base em um percentual.

### 🧾 Ordem de Serviço
- `cadastrarOrdemDeServico(cliente: String, telefone: String, roupa: String): int`: cadastra uma nova ordem de serviço, retornando seu ID sequencial.
- `exibirOrdemDeServico(idOS: int): String`: exibe a representação textual de uma ordem de serviço.
- `incluirReparoOrdemDeServico(idOS: int, idReparo: String): void`: associa um reparo existente a uma ordem de serviço.
- `mudarStatusOrdemDeServico(idOS: int, status: String): void`: atualiza o status da ordem de serviço. Status válidos: `"Não iniciada"`, `"Em andamento"`, `"Concluída"`.
- `obterValorOrdemServico(idOS: int): double`: retorna o valor total da OS, somando os valores dos reparos associados.

### 📊 Listagens
- `listarOrdemDeServico(status: String): String`: lista todas as ordens de serviço com um status específico.
- `listarOrdensDeServico(): String`: lista **todas** as ordens de serviço cadastradas, independentemente do status.

---

## ✅ Regras e Restrições

- 📌 Máximo de **100 tipos de reparos** no sistema.
- 📌 Máximo de **500 ordens de serviço**.
- 📌 Cada ordem de serviço pode conter até **10 reparos**.
- 📌 O identificador textual do reparo deve ser único.
- 📌 As ordens de serviço recebem um ID sequencial começando em 1.
- ⚠️ Caso seja fornecido um ID de reparo ou OS inexistente em alguma operação, o sistema lançará uma exceção `IllegalArgumentException`.

---

## 🧪 Testes de Unidade

Testes automatizados foram implementados para garantir o comportamento correto de métodos críticos:

### ✅ Classe `Reparo`
- **Método testado:** `reajustarPreco`
- Garante que o valor é reajustado corretamente com base no percentual informado.

### ✅ Classe `OrdemDeServico`
- **Método testado:** `setStatus`
- Garante que o status é atualizado corretamente.

🔎 *As demais funcionalidades foram projetadas para serem invocadas pela classe `RepareBem` e não precisam ser testadas diretamente.*

---

## 📎 Exemplo de Saída

```
Ordens de Serviço - Concluída
#1; cliente: Maria Helena; roupa: calça; reparos: 1; total: R$20,00
#4; cliente: Gabriel; roupa: bermuda; reparos: 2; total: R$40,00

---

## 🚫 Exceções

A classe `RepareBem` lança exceções do tipo `IllegalArgumentException` em situações como:

- Quando um ID de **reparo** fornecido não existe no sistema.
- Quando uma **ordem de serviço** informada não foi cadastrada.
- Essas validações garantem a integridade do sistema ao evitar operações inválidas.

---

## 💡 Observação

> A classe `Main`, responsável por interações com o usuário (como entrada via terminal ou interface gráfica), **não é parte obrigatória** deste projeto.

Toda a **lógica de negócio** está encapsulada na classe `RepareBem`, permitindo que o sistema seja facilmente testado com **testes unitários**.

---
