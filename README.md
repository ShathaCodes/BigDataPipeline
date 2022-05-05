# Temperature and Humidity Monitoring through a Big Data Pipeline using Lambda Architecture

### Architecture

We used **Lambda architecture** which is a data-processing architecture designed to handle massive quantities of data by taking advantage of both batch and stream-processing methods.

![architecture](https://raw.githubusercontent.com/ShathaCodes/BigData/main/architecture.PNG)

### Execution

All component parts are dynamically managed using Docker, which means you don't need to worry about setting up your local environment, the only thing you need is to have Docker installed.

Just run 

```
docker-compose up
```

You must also run to create the database schema in Cassandra

```
docker exec -it cassandra-iot 
```
```
cqlsh --username cassandra --password cassandra -f /schema.cql
```
