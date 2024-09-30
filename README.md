# Lead Sample Webapp

CRUD application with Struts and MySQL created by Javachap and upgraded by me.

## Environment

- JDK
```
java version "11.0.9" 2020-10-20 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.9+7-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.9+7-LTS, mixed mode)
```

- Database
```
mysql  Ver 8.4.2 for Linux on x86_64 (MySQL Community Server - GPL)
```

## For usage
- Database backup
```
mysqldump -u travis lead -r database/lead_schema.sql
```

- Database container
```
docker run --name mysql-v8 -p 3310:3306 --restart on-failure -e MYSQL_DATABASE=lead -e MYSQL_ROOT_PASSWORD=rootroot -e TZ='America/Lima' -d mysql:8.4.2
```

- Unicode list:
[UTF-8 C1 Controls and Latin1 Supplement](https://www.w3schools.com/charsets/ref_utf_latin1_supplement.asp)
