## Описание задания
Создать сервис, который обращается к сервису курсов валют, и отображает gif:  
если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную [отсюда](https://giphy.com/search/rich)   
если ниже - [отсюда](https://giphy.com/search/broke)   

**Ссылки**  
[REST API курсов валют](https://docs.openexchangerates.org/)   
[REST API гифок](https://developers.giphy.com/docs/api#quick-start-guide)
***
## Запуск
- Склонируйте репозиторий, выполнив команду:   
`git clone https://github.com/ilshmain/AlfaTask.git`   
- В папке проекта выполните команду:     
`gradle build`   
- Соберите докер-образ выполнив команду:    
`docker build -t alfa .`   
- Запустить контейнер с образом:   
`docker run -p 8080:8080 -t alfa`   
***
## Endpoints
- `/api/gif`  
Возвращает гифку в зависимости от курса валют  
**_Пример:_**   
`http://localhost:8080/api/gif?base=AED`
------
- `/api/gif`  
Возвращает гифку в зависимости от курса валюты (USD)    
**_Пример:_**   
`http://localhost:8080/api/gif`
