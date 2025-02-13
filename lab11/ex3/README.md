1) Problema

Numa aplicação que permite conversas privadas entre utilizadores, os users podem enviar mensagens uns aos outros, em diferentes salas de chat.
Tratar da entrega de mensagens entre usuários pode tornar-se num processo complicado e demorado, se não for projetada uma solução inteligente.
A solução para este problema passa pelo uso do padrão de design Mediator.


2) Solução

O Mediator será responsável pela criação de um objeto que vai separar as interações entre os utilizadores, proibindo que estes se refiram uns aos outros diretamente, no entanto, através do Mediator, podem interagir entre si, com as salas de chat.
O Mediator vai gerenciar as mensagens entre os utilizadores e as salas de chat.
Esta solução permite um baixo acoplamento.



