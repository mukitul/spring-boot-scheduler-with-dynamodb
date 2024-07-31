# Spring Scheduler Distributed Shedlock


## Build Project
Build project first
```jsunicoderegexp
mvn clean install -Dmaven.test.skip=true
```


## Docker Run
Scaling out Scheduler container
```jsunicoderegexp
docker compose up --scale scheduler-1=3
```
