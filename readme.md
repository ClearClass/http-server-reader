## О проекте

Приложение представляет собой простейший http-сервер, который принимает http-запрос и отображает его в окне консоли. Позволяет проанализировать запросы таких клиентов, как `curl`, `Jsoup`, `HttpUrlConnection` и т.д. После считывания стартовой строки, заголовков и тела сообщения, клиенту возвращается тестовая html-страница `index.html` с кодом ответа 200, и соединение закрывается. После этого программа вновь переходит к ожиданию подключения.

По умолчанию, сообщение принимается в кодировке UTF-8, которая может быть переопределена путем задания соответвующего аргумента командной строки.

Примеры чтения http-запросов некоторых клиентов с настройками по умолчанию:

**HttpURLConnection**

```sh
GET / HTTP/1.1
User-Agent: Java/1.8.0_91
Host: localhost:8080
Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2
Connection: keep-alive

```

**Jsoup 1.12.2**

```sh
GET / HTTP/1.1
Accept-Encoding: gzip
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36
Host: localhost:8080
Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2
Connection: keep-alive

```

**curl**

```sh
$ curl -XGET http://localhost:8080
```

```sh
GET / HTTP/1.1
Host: localhost:8080
User-Agent: curl/7.64.0
Accept: */*

```

```sh
$ curl -XPUT -H "Content-type: text/xml" --data "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><album>Звезда в шоке!</album>" http://localhost:8080/webapp
```

```sh
PUT /webapp HTTP/1.1
Host: localhost:8080
User-Agent: curl/7.64.0
Accept: */*
Content-type: text/xml
Content-Length: 95

<?xml version="1.0" encoding="UTF-8" standalone="yes"?><album>Звезда в шоке!</album>
```

**REST-клиент на основе Jersey**

```sh
GET /webapp HTTP/1.1
Content-Type: text/xml
User-Agent: Java/1.8.0_91
Host: localhost:8080
Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2
Connection: keep-alive

```

