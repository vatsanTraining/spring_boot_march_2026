Invoke the command below from Context Path where compose.yml is present 

1) docker compose build
2) docker compose up
3) If application run successfully invoke http://localhost:6060/api/v1/customers
4) Invoker docker compose down
5) Invoke kompose convert -f compose.yml -o output.yml
6) On Successful execution invoke  kubectl apply -f output.yml
7) Invoke kubectl get pods , check pods are running 
8) Invoke kubectl get services checks services are running and customer-service has LoadBalancer
9) Open the Browser and invoke http://localhost:6060/api/v1/customers
10) View the logs using kubectl logs <pod-name>

