# Simple Cache2k application with Spring

Sample Spring application using Cache2k caching.

This example simulates a slow repository. Caching is used at the service level. That way, we can make sure that only the **first request** will be slow. All the following requests will be executed quickly until the cache expires.


# API

You can check the caching work by running the application and going to: **http://localhost:8080/autos/list?category=TRUCK**

## Tests

See service tests: **AutoServiceImplIT**.class
