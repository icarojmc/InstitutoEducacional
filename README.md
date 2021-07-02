<h4>Sistema desenvolvido para estudos, sem aplicação real</h4>

Trata-se de um sistema de gestão de uma associação com intuito educacional. O sistema foi criado como uma forma de estudo dos princípios de REST, utilizando como base o Spring Web e o Spring Data JPA.
Para a camada de permanência foi implementado o MySQL, com baixo acoplamento pelo uso do Hibernate e do Spring data.

Para a arquitetura se utilizou uma adaptação do modelo MVC, seguindo a documentação do Spring Boot e algumas técnicas de refatoração.

A divisão de usuários é feita por meio de herança, utilizando single table como estratégia de permanência.
Já a divisão de eventos foi feita utilizando composição e vinculação por meio de foreing keys, possibilitando a criação de cursos presenciais, virtuais e modulares, além de palestras presenciais e virtuais.

A matrícula em eventos foi feita utilizando uma classe intermediária que inclui em uma tabela de junção a foreing key do inscrito e do evento, além da situação e data da inscrição.
O usuário professor e o usuário administrador possuem acessos específicos, com vinculação própria do professor aos eventos e autorização própria para edição de materiais e conteúdos.
Os eventos são configuráveis automaticamente com o currículo do professor, local de realização e valores, os quais podem ser diferenciados entre os diversos tipos de usuários.

Não foi implantado o frontend, sendo o sistema responsável pela organização e permanência dos dados.

Não foram implantados testes unitários e de integração, sendo uma implementação a ser realizada futuramente.

Também será refatorado o código para melhorar a legibilidade e manutenibilidade, considerando que algumas das funções possuem elevado acoplamento.
