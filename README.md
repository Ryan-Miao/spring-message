## spring-message

## How to Run
Just run `com.test.Application.main`

## 1. How to set a message bundle
```
new -> Resource Bundle
```
Make sure the message bundle sits on classpath.

## 2. How to escape single quote
Add a single quote to escape. @see `com.test.Application.messageSource`

## 3. How spring message work with the same key in different bundles
Just take the first meet. @see `com.test.controller.I18NController.keyConflict`

## More detail
http://www.cnblogs.com/woshimrf/p/5942815.html

