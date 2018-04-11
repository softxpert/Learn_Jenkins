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
rpm -Uvh jdk-8u161-linux-x64.rpm
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
or newer
yum install -y jenkins-2.107.2
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



### Adding a Jenkins Slave

```
#On the master create an ssh key
su jenkins -s /bin/bash
ssh-keygen
exit

cat /var/lib/jenkins/.ssh/id_rsa

#On the slave 
useradd -d /var/lib/jenkins jenkins  # -d sets the home dir
mkdir /var/lib/jenkins/.ssh
vi /var/lib/jenkins/.ssh/authorized_keys
>Past in the key from the master

#Install java on the slave

#In the Jenkins Gui "Manage Jenkins" => "Manage Nodes" => "New Node" / Node Name=Slave 1 / OK 
Number of executors = 2
Remote root directory = /var/lib/jenkins
Usage = Use this Node as much as possible
Launch Method = Launch slave agents via ssh
Host = your slave hostname
Add credential = jenkins
   Kind = SSH username with private key
   Username = jenkins
   Private key = From the jenkins master home ssh
   Credentials = jenkins
   Host key verification strategy = Manualy trusted key verification
   Availbility = Keep the agent online as much as possible
   SAVE
#Test it
Create a new job freestyle project
  Restrict where the job can be run = "Slave 1"
  Build => Execute shell => echo "I ran!"
  SAVE
Test the job and have a look at the output
```

### Setting Up GitHub

```
# Get the public key from your jenkins master
cat /var/lib/jenkins/.ssh/id_rsa.pub
#In the Jenkins Gui go to your user => settings => SSH and GPG Keys => New key => Past the key => Add SSH key

#Add new project in Github: jenkins_test
Initialize with README
Create Repository

#Copy the ssh Git clone link
You can now clone the repo
```


### Plugin Manager

```
Install ThinBackup
Download now and install after restart

#Get an old version
wget https://updates.jenkins.io/download/plugins/thinBackup/1.8/thinBackup.hpi

Click advanded tab in the plugin manager in Jenkins => Browse
```

### Source Code Management and the Git Plugin

```
#Install Git on the master and nodes
yum install -y git

```

### Git Hooks and Other Build Triggers

```
In Github in the Settings of a project => Integrations and services => Add Services => Jenkins Git Plugin 
Jenkins URL = Url from Jenkins Master http://fantomi1.mylabserver.com:8080/
```
