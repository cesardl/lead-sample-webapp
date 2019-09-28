# Lead Sample Webapp [![Build Status](https://travis-ci.org/cesardl/lead-sample-webapp.svg?branch=master)](https://travis-ci.org/cesardl/lead-sample-webapp) [![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.javachap.lead-sample-webapp&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.javachap.lead-sample-webapp) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.javachap.lead-sample-webapp&metric=coverage)](https://sonarcloud.io/component_measures?id=com.javachap.lead-sample-webapp&metric=coverage)

CRUD application with Struts and MySQL created by Javachap and upgraded by me.

## Environment

- JDK
```
java version "1.8.0_92"
Java(TM) SE Runtime Environment (build 1.8.0_92-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.92-b14, mixed mode)
```

- Database
```
mysql  Ver 14.14 Distrib 5.7.13, for Win32 (AMD64)
```

## For usage
- Database backup
```
mysqldump -u travis lead -r database/lead_schema.sql
```

- Database container
```
docker run --name lead -e MYSQL_ROOT_PASSWORD=lead -p 3306:3306 -d mysql:5.6.33
```

- Unicode list:
[UTF-8 C1 Controls and Latin1 Supplement](https://www.w3schools.com/charsets/ref_utf_latin1_supplement.asp)
