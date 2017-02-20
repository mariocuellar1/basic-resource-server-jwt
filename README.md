# README

## Spring Boot OAuth Resource Server using JWT Token

The resource server is the OAuth 2.0 term for your API server. The resource server handles authenticated requests after the application has obtained an access token.

This project is a simple but functional example of OAuth2 Resource Server implemented using Spring Boot. This project is mainly use to test [Oauth2 Authorization Server](https://github.com/mariocuellar1/oauth-server-jwt).

### How to install
It's a eclipse project, just import it and run.

### Parameters & Configuration
* **aouth.cert**
  * Copy in this file public key to verify JWT Token signature. 
if you are using [oauth-server-jwt](https://github.com/mariocuellar1/oauth-server-jwt) you have to use this key:
```
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArtOebz52sI42wVZbpaDo
+UUG8Qgbhp4Ym3TkZgb7off24Ds/hMmzXm1TsiqAE6IdAl8xSJglw198en/oOHQy
10GGDV1SaINE666tEan5YDIssiLqylpT5ZVYr28VqTBKtyERFcxSIfkR/S6xbqIG
93XxNVzeauR8gbQEo6KEkK6BXhsycBvZvtSZn75jtuaDqZtX7FCKqYvc2CZVDjCG
ex6eY3sEKijUfqdjXSqGmshoBhdE+iGOHuntfn4ojuVxCiieV9oNym93mNpCK66E
45Xb/8MUa/GgPSzA1VkrnES6kdcOepuZ6MzmydXsPVerKlOeWGsTAIoxtvTpT6Lf
7QIDAQAB
-----END PUBLIC KEY-----
```

### How to test

Before you run this server you need to configure and init your own Authorization Server if you don't have one please take a look to our [Oauth2 Authorization Server](https://github.com/mariocuellar1/oauth-server-jwt)

1. Configure application (application.properties above)
2. Start Resource Server [rigth-clic, run  :) ]
3. Import postman project *JwtResourceServerTest.postman_collection.json* to postman
   * To test get my information (/user):
   ```
   Get a valid oAuth Token, you can use test "Token - password" maybe you have to adjust URI and/or authentication.
   Set a valid token using Authorization header in test "Resource get ME Data" and press "Send". 
   You'll get something that look like user information (HTTP Status 200 OK).
   ```
   * To test URI securized by ROLE (User Authority)
   ```
   Get a valid oAuth Token, you can use test "Token - password" maybe you have to adjust URI and/or authentication.
   Set a valid token using Authorization header in test "Resource get private Admin info" and press "Send". 
   You'll get an HTTP Status 200 OK and some text data.
   ```
   * To test URI securized by oauth scope 
   ```
   Get a valid oAuth Token, you can use test "Token - password". Token must contains "write" scope.
   Set a valid token using Authorization header in test "Resource get write scope info" and press "Send". 
   You'll get an HTTP Status 200 OK and some text data.
   ```

To be sure about signature verification, change the public key and run test again, Response has to be 401 "Invalid token".
   
   
And you Done !!!!

Notes:
- I use postman to test 'cause it's what I usually do :) , if you want, modify this readme adding other ways, CURL, junit, simple java ó whatever.
- Please feel free to add/modify/correct/update any part of this content as necessary

Other Projects:
- [oAuth Server using JWT Token](https://github.com/mariocuellar1/oauth-server-jwt)
- [oAuth Server using oauth and opaque token](https://github.com/mariocuellar1/oauth-server-opaque)
- [Basic Resource Server using oauth and opaque token](https://github.com/mariocuellar1/basic-resource-server-opaque)
