## Certified Jenkins Engineer (CJE) - 2017

```
#Is Java installed?
which java

#Is Tomcat already using the default port 8080?
netstat -tulpn | grep 8080

yum list java*

#Install java
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Download dk-8u161-linux-x64.rpm
scp dk-8u161-linux-x64.rpm user@your-server:/home/user
rpm -Uvh dk-8u161-linux-x64.rpm
which java
alternatives --install /usr/bin/java java /usr/java/latest/bin/java 200000
alternatives --install /usr/bin/javac javac /usr/java/latest/bin/javac 200000
alternatives --install /usr/bin/jar jar /usr/java/latest/bin/jar 200000
vi /etc/rc.local
>export JAVA_HOME="/usr/java/latest"

or install openjdk

```

Install Jenkins
```
wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
cat /etc/yum.repos.d/jenkins.repo
rpm --import http://pkg.jenkins.io/redhat-stable/jenkins.io.key
yum install -y jenkins-2.19.4-1.1
#Disable the repo after installation (So it cant be updated accidently)
yum-config-manager --disable jenkins
#Check if the port is open
netstat -tulpn | grep 8080
systemctl start jenkins
watch n=1 "netstat -tulpn | grep 8080"
systemctl enable jenkins
#In the browser
http://hostname:8080
```

