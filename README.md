# Learn Jenkins

## Docker

```
docker network create jenkins
```


```
docker container run --name jenkins-docker \
  --detach --restart unless-stopped \
  --network jenkins --network-alias docker \
  --volume /var/run/docker.sock:/var/run/docker.sock \
  --publish 2375:2375 \
  alpine/socat \
  tcp-listen:2375,fork,reuseaddr unix-connect:/var/run/docker.sock
```


```
docker container run --name jenkins-blueocean \
  --detach --restart unless-stopped \
  --network jenkins \
  --env DOCKER_HOST="tcp://docker:2375" \
  --env DOCKER_TLS_VERIFY="" \
  --volume jenkins-data:/var/jenkins_home \
  --publish 8080:8080 --publish 50000:50000 \
  jenkinsci/blueocean
```


```
http://localhost:8080
```


