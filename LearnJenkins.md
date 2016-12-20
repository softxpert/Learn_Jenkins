## Learn Jenkins

### Links

### Installation
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
