# Springboot-microservices-online-shopping
Springboot microservices online shopping 


# To setup Zipkin
https://zipkin.io/pages/quickstart

C:\Users\rajesh> docker run -d -p 9411:9411 openzipkin/zipkin --> To download and run zipkin
C:\Users\rajesh> docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin  --> To give name to container

C:\Users\rajesh> docker ps  --> To see running containers
CONTAINER ID   IMAGE               COMMAND          CREATED          STATUS                   PORTS                              NAMES
55793af3637f   openzipkin/zipkin   "start-zipkin"   10 seconds ago   Up 9 seconds (healthy)   9410/tcp, 0.0.0.0:9411->9411/tcp   zipkin

C:\Users\rajesh> docker kill 55793af3637f --> To kill container using containerId

# To open zipkin UI in browser:
http://localhost:9411/zipkin/

# To run the docker-compose file
C:\Users\rajesh> docker-compose up -d  -->To start docker-compose file

C:\Users\rajesh> docker-compose down  -->To stop docker-compose file
