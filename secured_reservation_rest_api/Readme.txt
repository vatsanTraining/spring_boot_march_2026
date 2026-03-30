=======================

Add Dockerfile
update the compose yml and and build/run 

=================
services:
  postgres:
    image: 'postgres:latest'
    container_name: postgres-db
    environment:
      POSTGRES_DB: customer_db
      POSTGRES_USER: user
      POSTGRES_PASSWORD: secret
    ports:
      - '5432:5432'
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U user -d customer_db"]
      interval: 10s
      timeout: 5s
      retries: 6
    volumes:
      - postgres-data:/var/lib/postgresql

  customer-app:
    image: 'vatsank/reservation-service:1.0'
    build:
      context: ./
    ports:
      - '8080:8080'
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/customer_db
      SPRING_DATASOURCE_USERNAME: user
      SPRING_DATASOURCE_PASSWORD: secret
    depends_on:
      postgres:
        condition: service_healthy 

volumes:
  postgres-data:

====================
Execute the following command to convert the docker-compose.yml to kubernetes yaml files

kompose -f docker-compose.yml -o output.yml convert  


This will create the output.yml file with the necessary Kubernetes deployment and service definitions
 for both the postgres and customer-app services. 
 
Update the spec section in the output.yml 
spec:
  type: LoadBalancer
  ports:

Invoke the command 
kubectl apply -f output.yml

kubectl get pods
kubectl get services 
Test the application using postman
  
