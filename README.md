Poc de mensageria com RabbitMQ, Spring Cloud Stream, Binder Rabbit.

Possui duas aplicações, um consumer e um producer, ambas construidas de forma mais abstraida com Spring Cloud.

O Rabbit possui três filas:
* fila normal
* fila de retentativas
* fila de DLQ

Ao lançar uma exceção no cosumo da fila normal, a mensagem é enviada para a fila de retentativas, após 3 tentivas de validar a mensagem no consumer, ela é encaminhada para a fila de DLQ.
Toda arquitetura foi desenvolvida abstraindo ao maximo o codigo para o contexto de gerenciamento do Spring.
