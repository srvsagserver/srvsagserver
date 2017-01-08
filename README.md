### Service aggregator project
Please, make a fork of this repo to start work with

#### Dev notes
When the project is running from IDE, after making some changes 
no need to restart whole app. It's good enough just rebuild
the project (in Idea -> Ctrl+F9).

#### Additional info
http://docs.spring.io/autorepo/docs/spring-boot/current/reference/htmlsingle/

## UI
### Start
To start UI navigate to 'client' folder and run: <br>

- npm install - to install all dependencies as node 
- npm run build-js - to build js modules (NODE_ENV=production webpack, to make it min)
- npm start - to start the project locally on http://localhost:8080/