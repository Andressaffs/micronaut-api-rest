CREATE KEYSPACE Todo
WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 3}
AND durable_writes = true;

use todo;

CREATE TABLE product(
    id uuid,
    date text,
    description decimal,
    done boolean,
    PRIMARY KEY (id)
);