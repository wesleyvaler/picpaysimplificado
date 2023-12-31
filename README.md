 🚀 Picpay Simplificado

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![H2 Database](https://img.shields.io/badge/h2-database-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Junit](https://img.shields.io/badge/Junit-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Mockito](https://img.shields.io/badge/Mockito-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)




O sistema "PicPay Simplificado" é uma aplicação financeira voltada para a transferência de recursos financeiros entre usuários e lojistas. A aplicação realiza transações de forma segura, garantindo a integridade dos dados sensíveis, realizando verificação de CPF, validação de e-mail e a confirmação do saldo do usuário antes de realizar cada transação. Caso haja algum problema, a aplicação permite reverter a operação . A aplicação também possui integração com serviços externos, garantindo autorizações e notificações em tempo real. Mesmo em momentos de indisponibilidade desses serviços externos, os usuários são mantidos atualizados por meio de notificações.

O processo de desenvolvimento dessa aplicação foi uma verdadeiro desafio! Encarei alguns bugs com o Lombok e a injeção de dependências, e confesso que, no início, entender o StackTrace foi um pouco complicado. Mas com o tempo, fui pegando o jeito e me acostumando a lidar com os bugs. A tarefa de ajustar versões e alinhar dependências no pom.xml também foi processo complexo, mas aprendi bastante durante o proceso. Esses bugs não só me mostraram a importância da consistência nas dependências, mas também lapidou minhas habilidades de debugging. 

No desenvolvimento da aplicação utilizei JUnit e Mockito para realizar testes nas classes fundamentais: "UserService" e "UserRepository". Esses testes foram essenciais para garantir a integridade das operações e assegurar a correta persistência dos dados no banco. Essa prática não só contribuiu para a qualidade do código, mas também fortaleceu a segurança do sistema, identificando e corrigindo possíveis problemas antes da implementação em produção.

Utilizei o Swagger para gerar a documentação que serve como um guia para aplicação, simplificando o entendimento da API e otimizando o tempo de desenvolvimento, oferecendo um mapa claro para manutenções e expansões futuras da aplicação.

