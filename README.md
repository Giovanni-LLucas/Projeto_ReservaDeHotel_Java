# Projeto_ReservaDeHotel_Java

# GioNat Palace — Sistema de Reservas de Hotel (Java)

Projeto acadêmico que simula o cadastro de reservas de um hotel, feito em **Java**, com interação por **terminal** (sem interface gráfica).

**Autores:** Giovanni Lucas e Natanel Nunes


## Sobre o projeto

O **GioNat Palace** é um hotel fictício com 10 quartos. Pelo menu do terminal é possível listar os quartos, fazer reservas informando os dados do hóspede, buscar reservas por CPF, cancelar reservas e consultar todas as reservas ativas.

Os dados ficam "armazenados" num vetor. Ao encerrar o programa, tudo é reiniciado.

## Funcionalidades (menu)

| Opção | Função | O que faz |
|:---:|---|---|
| 1 | Listar quartos | Mostra número, tipo, diária e se está disponível ou ocupado (e por quem) |
| 2 | Reservar quarto | Pede nome, CPF, telefone, quarto e quantidade de dias; calcula o total da estadia |
| 3 | Buscar reserva por CPF | Mostra todas as reservas ativas daquele CPF |
| 4 | Cancelar reserva | Cancela a reserva pelo número do quarto e libera o quarto |
| 5 | Exibir reservas | Lista todas as reservas ativas |
| 0 | Encerrar programa | Sai do sistema |

## Quartos do hotel

| Quartos | Tipo | Diária |
|:---:|---|---:|
| 1 a 4 | Básico | R$ 100,00 |
| 5 a 7 | Duplo | R$ 200,00 |
| 8 a 10 | Luxo | R$ 300,00 |


### Responsabilidade de cada classe

- **GioNat_Palace** — exibe o menu, lê o que o usuário digita e chama o `Hotel`.
- **Hotel** — guarda os 10 quartos e as reservas em vetores; faz reservar, cancelar, buscar e listar.
- **Quarto** — número, tipo, preço, disponibilidade e hóspede atual, além de calcular o valor da estadia.
- **Reserva** — código, hóspede, quarto, dias, total e status (`RESERVADA`, `HOSPEDADO`, `FINALIZADA`, `CANCELADA`).
- **Hospede** — nome, CPF e telefone, com validação dos dados.


## Exemplo

```
============== SEJAM BEM VINDOS AO GIONAT PALACE ==============

1 - Listar Quartos
2 - Reservar Quarto
3 - Buscar reserva por CPF
4 - Cancelar Reserva
5 - Exibir reservas
0 - Encerrar programa

O que deseja fazer: 2
Insira seu nome: Giovanni Lucas
Insira seu CPF (APENAS NUMEROS): 12345678901
Insira o seu telefone (APENAS NUMEROS): 83999998888
...
Qual o quarto deseja (Escolha pelo numero): 8
Quantos dias deseja ficar no hotel: 3

Reserva realizada com sucesso!
Reserva: 1  | Hospede: Maria Silva | Quarto: 8 - Tipo do Quarto: Luxo | Quantidade de dias: 3 | Total Hospedagem: R$ 900,00 | Status: RESERVADA
```

## Escopo do projeto

- Os dados não são salvos em arquivo ou banco de dados.
- O hotel comporta no máximo 10 reservas ativas ao mesmo tempo (uma por quarto).
- O CPF é validado apenas pelo formato (11 dígitos), sem cálculo dos dígitos verificadores.

## Tecnologias

- Linguagem: **Java**
- IDE: **VS Code**
- Versionamento: **Git**