## Hands-on Lab: Configure a Jenkins Pipeline

#Adding the docker repo
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
 yum clean all
 
 yum install -y --setopt=obsoletes=0 docker-ce-17.03.1.ce-1.el7.centos docker-ce-selinux-17.03.1.ce-1.el7.centos

