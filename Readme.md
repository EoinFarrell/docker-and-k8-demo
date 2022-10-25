# Docker & Kubernetes Demo

Agenda:

- Quick overview of Docker
- Demo of docker cli using pre packaged images
- Overview of dockerfile and how to create images for our own services
- Overview of docker-compose and how it combines all of the above
- Outline what Kubernetes is and how it links to Docker
- Demo of kubernetes manifest files/cli/etc

## Docker

`docker ps`

### Running an app

`docker run --name go-app go-app:latest`
`docker ps`
`docker ps --all`
`docker rm go-app`
`docker run --name go-app -d -p 8080:8080 go-app:latest`
`docker stop go-app && docker rm go-app`

`docker build . --tag go-app:latest`

### Docker Registry

`docker run -it --rm -d -p 8080:80 --name web nginx`
`curl localhost:8080`
`docker logs web`
`docker logs -f web`
`docker exec -it web /bin/bash`
`docker stop web`

https://docs.docker.com/storage/images/types-of-mounts-volume.png

`scp -r apps/nginx Ubnt-Horizon:/home/feoin/Code/nginx`
`docker run -it --rm -d -p 8080:80 --name web -v /home/feoin/Code/nginx:/usr/share/nginx/html nginx`

### Docker Compose

## Kubernetes

`kind delete cluster`

`kind create cluster --config multi-node-cluster.yml`
