# GSPAssembler
This repository is created for mastek's sample public code for GST integration

	Create directory to check-out the project code.  Run following command from that directory from command line.

		git clone https://github.com/suraj13392/GSPAssembler.git


	Go to the checked out directory GSPAssembler  and run below command to get latest code
		git pull

	Install Postgres on your machine and try to keep usrename and password as postgres\postgres .
		Create Database with name MastekGSP and create schema with name party .

	To build run below command from command line in folder GSPAssembler
		mvn clean install -Denv=local
	
	To run application, go to boot project and run below command
		mvn spring-boot:run -Dspring.profiles.active=local

