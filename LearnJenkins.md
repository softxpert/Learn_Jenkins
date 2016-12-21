## Learn Jenkins

### Links
https://jenkins.io/doc/book/getting-started/installing/

### Installation CentOs

```
yum install -y wget
sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo
sudo rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
sudo yum update
sudo yum install jenkins java-1.8.0-openjdk
systemctl enable jenkins
systemctl start jenkins
#Running on port 8080
systemctl status jenkins
sudo yum install telnet
ps aux | grep jenkins
telnet localhost 8080
#Install nginx for proxy configuration. Port 8080 could be restricted on the server.
sudo yum install nginx
cd /etc/nginx
vi nginx.conf
>listen 80 default_server;
>location / {
>proxy_pass http://127.0.0.1:8080;
>}
systemctl enable nginx
systemctl start nginx
systemctl status nginx
sudo yum install elinks
elinks http://localhost:8080
```

```
getenforce
setenforce 0 
getenforce
systemctl restart nginx jenkins
```

Now you can test in the browser with
```
http://<jenkins_server_name.com>
```

```
sudo yum install setroubleshoot-server selinux-policy-devel
#Shows wich port are allowed
sepolicy network -t http_port_t
semanage port -a -t http_port_t -p tcp 8080
sepolicy network -t http_port_t
setenforce 1
getenforce
systemctl restart nginx jenkins
```

Now you can test in the browser with
```
http://<jenkins_server_name.com>
```

Check Time: 20:50 in LinuxAcademy Install in Jenkins Quick Start  


### Installation Ubuntu

```
sudo wget -q -O - https://pkg.jenkins.io/debian/jenkins.io.key | sudo apt-key add -
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
sudo apt-get update
sudo apt-get install jenkins
#This package installation will:
#Setup Jenkins as a daemon launched on start. See /etc/init.d/jenkins for more details.
#Create a jenkins user to run this service.
#Direct console log output to the file /var/log/jenkins/jenkins.log. Check this file if you are troubleshooting Jenkins.
#Populate /etc/default/jenkins with configuration parameters for the launch, e.g JENKINS_HOME
#Set Jenkins to listen on port 8080. Access this port with your browser to start configuration.
#If your /etc/init.d/jenkins file fails to start Jenkins, edit the /etc/default/jenkins to replace the line ----#HTTP_PORT=8080---- with ----HTTP_PORT=8081---- Here, "8081" was chosen but you can put another port available.
```

Check if the jenkins user has a shell defined: /bin/bash
```
vi /etc/passwd
>jenkins:x:119:128:Jenkins,,,:/var/lib/jenkins:/bin/bash
passwd jenkins
su - jenkins
ssh-keygen
ssh-copy-id jenkins@localhost
visudo
>jenkins ALL=(ALL) NOPASSWD: ALL
```

On the Clients
```
adduser jenkins
passwd jenkins
visudo
>jenkins ALL=(ALL) NOPASSWD: ALL
#From the Jenkins server
ssh-copy-id jenkins@<client-name>
```

#If there are problems with TTY error messages in a build  
#visudo  
#>Defaults !requiretty  

### Plugins

* SSH plugin
* Schedule Build Plugin

### Setting Up a Build Slave
```
ssh jenkins@<slave_name>
sudo apt-get install git
cd /home/jenkins
mkdir jenkins_slave
```
