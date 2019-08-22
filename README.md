SPRING INTEGRATION:

               Spring Integration is an open source framework for enterprise application integration.It is a lightweight framework that builds upon the core 
Spring framework. It is designed to enable the development of integration solutions typical of event-driven architectures
and messaging-centric architectures.


What SpringCsvToJson Application do?

               Read a csv file records in csv format using spring integration , transform it into a JSON.


The STS(Spring Tool Suite) Configuration


        The Spring Tool Suite is an Eclipse-based development environment that is customized for developing 
Spring applications. It provides a ready-to-use environment
to implement, debug, run, and deploy your Spring applications, including integrations 
for Pivotal tc Server, Pivotal Cloud Foundry, Git, Maven, AspectJ, and
comes on top of the latest Eclipse releases. 


Installation



             1.
Download  https://gitlab.com/capgemini-digital-cloud-platform/springcsvtojson.git
             2.Extract the zip to directory.
             3.Import the code in STS Tool.



             4.The code is imported and we can see it.



Troubleshoot:


When you download the project from GitLab and then import and run  it into your local you may get a build failure error to resolve this 
follow the steps below:

1)If there is JDK Not Found Error -then Right click on the project->Goto Build Path ->Configure Build Path->Java Build Path-> 
select the Library tab->Add Library

2)Right click on the project->Go to Run As->click on Maven Clean(wait till the process ends)

3)Again right click on 
the project->Go to Run As->click on Maven build->Goals:(write) package install->click on apply->Run(instead on maven build you can also choose 
maven install, both works in similar way)

4)Again Right click on the project/main class->Go to Run As->click on Spring Boot App
(Your project will start 
working fine).


Testing the Service:

1. Once the Service starts running, it will start reading data from CSV File and write data in json format.
2. We can see the data in the destination folder.


Process:

  Step 1 :- Create a input.csv file and insert records in csv format.
  Step 2 :- Use Spring Integration Consumer end point to read this CSV file.
  Step 3 :- Using processor/transformer transform csv file into the xml/JSON file.


Eclipse shortcuts:
               
              Alt+shift+j to generate javadocs

Maven dependency :- Before adding any jar dependency in maven, please check it in the  Spring boot release list first. Most of the dependency is the 
                     part of Spring boot jar, if we are adding dependency in pom file then it creates problem. 

                    e.g. 

                        <dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-csv</artifactId>
			</dependency>   

        - In Spring boot 2.0.1.RELEASE, default having jackson-dataformat-csv.2.9.5 version. if you are   

           adding downgraded dependency then it will create problems.Better not mentioning the versioning tag



Built With : Spring-Boot, JDK 1.8, STS Tool


Author : Lakshmi Priya