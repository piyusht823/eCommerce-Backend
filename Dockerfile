FROM java:17
EXPOSE 8080
ADD target/eCommerce-Backend.jar eCommerce-Backend.jar
ENTRYPOINT ["java","-jar","/eCommerce-Backend.jar"]