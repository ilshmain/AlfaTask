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
- `/api`  
Возвращает гифку в зависимости от курса валюты (USD)    
**_Пример:gi_**   
`http://localhost:8080/api`
***