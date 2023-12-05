# apache-kafka
- what is kafka
- What is zookeeper
- apache pulsar vs kafka vs flink
- Architecture
### Let start setup
#### Step 1:
  - Download kafka server(https://kafka.apache.org/downloads)
  - unzip it and do run below commands
    - Start zookeeper server
    ```bin/zookeeper-server-start.sh config/zookeeper.properties```
    - Start kafka server
    ```bin/kafka-server-start.sh config/server.properties```
    - Run below command to listen pushing messages (optional)
    ```bin/kafka-console-consumer.sh --topic chat --from-beginning --bootstrap-server localhost:9092```
#### Step 2:
  - Start server and do call below API
    ```http://localhost:8080/message/send?message=hi```
    
#### Reference:
- https://kafka.apache.org/documentation/#quickstart
- https://www.javainuse.com/spring/spring-boot-apache-kafka-hello-world
