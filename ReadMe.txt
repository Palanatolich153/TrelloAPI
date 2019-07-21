### Description

UI tests for https://trello.com site

### Requirements

- Maven 3.5.0 and higher;

### Test running

For running test you can simply do following instructions:

1. Run test using Docker container:

1.a. Run a Docker file from a project using following commands:

sudo docker build --tag='tagname' pathToDockerFile
sudo docker run -u root --rm -d -p 8080:8080 -v jenkins-data:/var/jenkins_home/custom -v /var/run/docker.sock:/var/run/docker.sock tagname
get docker id using command: sudo docker ps
get Jenkins password using command sudo docker logs containerId

1.b. Create a Jenkins pipeline project and use a Jenkins file from a project to build a job and install TestNG Results Plugin

2. Run tests locally:

2.a. Clone the project on your local machine and run it from an IDE
2.b. Go to the https://trello.com site, login using credentials pasha1053@gmail.com/Pavel153 ad review tests running
