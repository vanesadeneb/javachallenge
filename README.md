Java Challenge: URL Shortener

For this challenge I used spring framework.

In this challenge I builded the AliasGenerator Class wich goal is generate an alias depending in a url received.

The API respond to two endpoints: 
- Creation that use the POST verb and use a payload like {"url":"https://google.com"}
- Retrieval that use a GET request to /<alias> and redirect to the given url.
Both located in UrlShortenerController Class. 

Files path: javachallenge/complete/src/main/java/com/urlshortener/restservice

How to run the project:
- Open a command line (or terminal) and navigate to the folder /**javachallenge/complete** and execute the follow commands:
MacOS/Linux: **./mvnw spring-boot:run**

I used the follow commad to obtain the alias from a url:
**- curl -X POST localhost:8080/ -H 'Content-type:application/json' -d '{"url": "https://espanol.yahoo.com/"}'**

Then you can see the follow response:
**{"alias":foyiUs4}**

Finaly test this alias in your browser:
http://localhost:8080/foyiUs4
The result can be to redirect to the url or a 404 error if alias is not found.
