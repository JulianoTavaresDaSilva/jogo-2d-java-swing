# 🎮 Jogo 2D em Java com Swing

Projeto de um jogo 2D desenvolvido em Java utilizando a biblioteca Swing, com foco no aprendizado de Programação Orientada a Objetos, lógica de combate, renderização gráfica e controle de estados dos personagens.

## Visão Geral

O jogo simula personagens em um ambiente 2D onde é possível movimentar unidades, realizar ataques em área e gerenciar atributos como vida, ataque e alcance. Cada personagem possui comportamentos e características próprias.

## ⚙️ Funcionalidades Implementadas

- Renderização gráfica utilizando Java Swing
- Sistema de personagens com herança e polimorfismo
- Tipos de personagens:
  - **Aldeão** (alcance curto)
  - **Arqueiro** (alcance longo)
  - **Cavaleiro** (alcance médio)
- Ataque em área baseado em distância
- Alcance de ataque individual por personagem
- Dano aplicado com base no atributo de ataque
- Prevenção de auto-ataque
- Detecção automática de morte (vida ≤ 0)
- Efeito visual de desaparecimento (fade-out)
- Remoção de personagens mortos das coleções
- Exibição visual do alcance do ataque durante a ação

## ⚙️ Sistema de Configuração (Config)

O projeto utiliza um arquivo `.properties` para centralizar configurações do jogo, evitando valores fixos no código.

A classe `Config` carrega automaticamente o arquivo `joe.properties` a partir do classpath e disponibiliza métodos estáticos para acessar os valores de forma tipada (`int`, `double` e `String`). Caso o arquivo ou alguma chave não exista, uma exceção é lançada.

Esse modelo facilita ajustes e manutenção do projeto.

## 🛠️ Tecnologias Utilizadas

- Java
- Java Swing / AWT
- Gradle
- Programação Orientada a Objetos (POO)

## ▶️ Como Executar o Projeto

1. Certifique-se de que o Java esteja instalado.
2. No terminal, acesse a pasta raiz do projeto.
3. Execute o comando:
./gradlew run

👨‍💻 **Desenvolvido por Juliano Tavares e Erik Bueno**
