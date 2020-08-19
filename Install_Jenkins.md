# Install jenkins


## Docker

```
mkdir $HOME/jenkins_home
chown 1000 $HOME/jenkins_home
docker run -d -p 49001:8080 -v $HOME/jenkins_home:/var/jenkins_home --name jenkins jenkins/jenkins:2.150.3
# or
docker run -d -p 49001:8080 -v $HOME/jenkins_home:/var/jenkins_home --name jenkins jenkins/jenkins:lts

docker logs jenkins -f
http://localhost:49001
```




## Native

```
sudo su # this prevents us from having to issue sudo each time.  
yum install -y wget  
wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat/jenkins.repo  
rpm --import https://pkg.jenkins.io/redhat/jenkins.io.key  
yum install jenkins  java-1.8.0-openjdk-devel git -y  
systemctl enable jenkins && systemctl restart jenkins  
```

http://<IP>:8080
