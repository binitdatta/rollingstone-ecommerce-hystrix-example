##  Spring Cloud Hystrix Example

## Service Discovery : Microservices are supposed to be loosely coupled. In a legacy monolithic application  we call external services by using either hard coded service endpoint URL or the URL of the load balancer in front of multiple service instances. However, in this setup, if the individual service instance or the LB is down, our upstream service clients would be adversely affected. To resolve this, Netflix created the Eureka project using which services can register using a logical name (defined as the spring.application.name value in the bootstrap.properties / yml file) and submit their host IP, port and other information. Services once registered also need to send health status information periodically. Client use the same logical name of the services they want to invoke to get the multiple service instances from Eureka. With this setup, service instances can be UP or DOWN at their own convenience and the rest of the application will be able to bear that. We can simply imagine Eureka as a memory held Map with the key of the map as the logical name of the service and the value as the host ip , port information. 

## Declarative Client : We use Declarative Client Feign to let Spring Cloud place the service call instead of us placing the call using Spring RestTemplate. The advantages are manyfold as Spring Cloud uses

## 1. Spring Cloud Client Side Load Balancing Ribbon
## 2. Spring Cloud Eureka

## Circuit Breaker Hystrix : To protect our upstream services from the failure of the downstream services. If we can calling an inventory service from the AddToCart service and the inventory service is experiencing issues at the moment, keeping to call the same would waste threads and send the error up the call chain probably to the UI. Hystrix provides an excellent opportunity to protect our application from this kind of situations. Hystrix can monitor failures and can invoke an fallback method (defined by us) instead. Hystrix is one of the most complicated service utilities within Spring Cloud. While the preliminary uses is easy and simple, Hystrix has a ton of properties to configure its behavior. It is advisable to review this configurable properties before using Hystrix in production. For example, when a bad services is becoming health again, we can tell Hystrix how many successful calls it should take before calling the service on a regular basis, instead of the fallback method. A major application will have multiple Hystrix endpoints and to monitor them all through a single channel, we can use the Spring Cloud Hystrix Dashboard and the Turbine project that provides a UI dashboard.  

#rollingstone-ecommerce-hystrix-example

## 1. Develop Eureka Server. Look into rollingstone-ecommerce-hystrix-eureka-server

## 2. Develop Service API. Look into rollingstone-ecommerce-hystrix-service-api-1

## 3. Develop Service Client with Hystrix. Look into rollingstone-ecommerce-hystrix-service-client

## 4. Develop the Hystrix Dashboard Monitor Application. Look into rollingstone-ecommerce-hystrix-dashboard-monitor

## 5. Build and Run Eureka

	# A. Navigate into rollingstone-ecommerce-hystrix-eureka-server
	# B. gradle clean build
	# C. java -jar build\libs\rollingstone-ecommerce-hystrix-eureka-server-0.0.1-SNAPSHOT.jar

## 6. Build and Run Service API

	#A. Navigate into  rollingstone-ecommerce-hystrix-service-api-1
	#B. gradle clean build
	#C. java -jar build\libs\rollingstone-ecommerce-hystrix-service-api-1-0.0.1-SNAPSHOT.jar

## 7. Build and Run  Service Client

	#A. Navigate into  rollingstone-ecommerce-hystrix-service-client
	#B. gradle clean build
	#C. java -jar build\libs\rollingstone-ecommerce-hystrix-service-client-0.0.1-SNAPSHOT.jar

## 8. Build and Run the Hystrix Dashboard Monitor Application

     	#A. Navigate into  rollingstone-ecommerce-hystrix-dashboard-monitor
	#B. gradle clean build
	#C. java -jar build\libs\rollingstone-ecommerce-hystrix-dashboard-monitor-0.0.1-SNAPSHOT.jar

## 9. Try the Eureka Server

	#A.  http://localhost:8761/

## 10. Try the independent Server API

	#A. http://localhost:8081/api/rollingstone/person/1

## 11. Try  the Client

	#A. http://localhost:8091/api/rollingstone/person/client/1

## 12. Try the Client's Actuator Endpoint

	#A. http://localhost:8092/actuator

## 13. Try the Client's Hystrix Stream Actuator Endpoint

	#A. http://localhost:8092/actuator/hystrix.stream

## 14. Try the Monitor UI Dashboard 

	#A. http://localhost:8788/hystrix

## 15. Enter the Client's Hystrix Stream URL in the Text Box and Click Monitor

	#A. http://localhost:8092/actuator/hystrix.stream


