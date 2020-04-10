# Drools

## Table of Content
- [Overview](#overview)
- [Installation](#installation)
- [Modules](#modules)
- [Appendix](#appendix)

## Overview

---
## Installation
- **Docker Based Installation**
  - Create a Oracle Linux 7 environment.
  - Execute below commands to run Drools Workbench
  ```shell
  # Creating base folders
  cd /scratch
  mkdir -m777 docker_storage
  mkdir -m777 wb_git
  
  # Adding Proxy Server Details
  vi ~/.bash_profile
    export http_proxy="http://<server>:<port>"
    export https_proxy="http://<server>:<port>"
    export no_proxy="localhost,127.0.0.1,.<orgextension>.com"
  
  # Setting up docker
  sudo su
    chmod 777 /var/run/docker.sock
    systemctl  stop docker
    /usr/sbin/usermod -a -G docker <login user>
    /usr/sbin/sysctl net.ipv4.conf.all.forwarding=1
    vi /etc/docker/daemon.json
        {
            "data-root":"/scratch/docker_storage"
        }
    systemctl  start docker
    exit
  
  # Checking Docker
  docker run hello-world

  # Executing Drool Workbench
  docker run -p 8080:8080 -p 8001:8001 -e JAVA_OPTS="-server -Xms1024m -Xmx1024m -Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8" -v /scratch/wb_git:/opt/jboss/wildfly/bin/.niogit:Z -d --name drools-workbench jboss/drools-workbench-showcase:latest

  # Checking error in executions
  docker ps
  docker logs <container_id>

  ```
  - After successful execution of above script, drool workbench will be available [here](http://localhost:8080/business-central/kie-wb.jsp#) with user/pwd as `admin/admin`.
  - To install KIE Execution server using Docker, run below command. This will automatically make kie server enabled in drool workbench.
  ```shell
  docker run -p 8180:8080 -d --name kie-server --link drools-workbench:kie-wb jboss/kie-server-showcase:latest
  ``` 
  ![](./02-Images/01-Installation.png)
---
## Modules

---
## Appendix
- References
  - [Kia Workbench - Medium](https://medium.com/@hasnat.saeed/setup-jboss-drools-workbench-and-kie-execution-server-on-wildfly-14-on-ubuntu-18-04-using-docker-e87b10f301ad)