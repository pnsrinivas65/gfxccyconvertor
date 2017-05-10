# Spring Boot / Micro services

Spring MVC Server


## Overview
Global foreign exchange (GFX) is project developed for One of Major Bank. It uses One of online REST API to pull latest conversion rates.
Whatever user requested irrespective of combination of currencies all requests are logged in Audit. 
Currency Table holds the information for Of Currency, decimal places
Daily Currency Table holds the key information of conversion & Inversion rate used as per latest FX rates

## Usage
java -jar ccycon-1.0.jar

## Pre-requiste
1.) Java 7 or 8 <br/>
2.) MYSQL </br>
3.) following properties in the file has to change db-config.properties <br/>
	a.) spring.datasource.url = MYSQL server IP address, port and schema <br/>
	b.) spring.datasource.username <br/>
	c.) spring.datasource.password <br/>
4.) Maven <br/>
## compile
mvn clean install