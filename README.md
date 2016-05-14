# Isentia_project
Code challenge solution for Isentia_project

Software used:

Operating system - Ubuntu 64-bit 14.04.2

java version "1.7.0_101"

Web Crawler – Apache Nutch(Java Based web Crawler)

Database Mongodb – Compose.io


Steps followed:

Downloaded and installed Apache Nutch 2.3.1

Created asap-mongodb database in Compose.io

Configured compose Mongodb as storage for output of Nutch using connection string in nutch-2.3.1/conf/gora.properties file and nutch-2.3.1/conf/nutch-site.xml file

mongodb://<username>:<password>@aws-us-east-1-portal.17.dblayer.com:10227,aws-us-east-1-portal.18.dblayer.com:10227/admin 

Created a search API for MongoDB using java 

