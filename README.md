# RegistrationService
[![Build Status](https://travis-ci.org/dawidkotarba/RegistrationService.svg?branch=master)](https://travis-ci.org/dawidkotarba/RegistrationService)
[![Coverage Status](https://coveralls.io/repos/github/dawidkotarba/RegistrationService/badge.svg?branch=master)](https://coveralls.io/github/dawidkotarba/RegistrationService?branch=master)

#### Gradle tasks:
- gradle build - build all modules
- gradle test itest - run unit and integration tests
- gradle run --parrarel - run all modules parallely

#### Links:
- http://localhost:8080/ - Eureka main page
- http://localhost:xxxx/db - H2 DB (for modules with H2 db)
- http://localhost:xxxx/swagger-ui.html (for modules with swagger [currently buggy])

#### Getting OAuth2 token:
```
URL: http://localhost:8082/oauth/token
Method: POST
Content-Type: application/x-www-form-urlencoded
Authorization: Basic bW9kdWxlOnJlZ2lzdHJhdGlvblN2
Raw payload: username=XXXX&password=XXXX&grant_type=password, where XXXX are username/pwd params
```

In new request use generated token:
```
Authorization: Bearer generated_token
```