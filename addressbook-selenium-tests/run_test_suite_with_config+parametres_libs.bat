@echo off

set XStream=D:\Traning\Programming_for_Testers\Soft\xstream-distribution-1.4.6-bin\xstream-1.4.6\lib\xstream-1.4.6.jar;D:\Traning\Programming_for_Testers\Soft\xstream-distribution-1.4.6-bin\xstream-1.4.6\lib\xstream\xpp3_min-1.1.4c.jar;D:\Traning\Programming_for_Testers\Soft\xstream-distribution-1.4.6-bin\xstream-1.4.6\lib\xstream\xmlpull-1.1.3.1.jar
set Selenium=D:\Traning\Programming_for_Testers\Soft\selenium-server-standalone-2.38.0.jar

java -cp bin;%XStream%;%Selenium% -DconfigFile=firefox.properties org.testng.TestNG testng-customsuite.xml

@echo on