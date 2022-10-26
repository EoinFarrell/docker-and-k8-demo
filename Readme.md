# Docker & Kubernetes Demo

Agenda:

- Quick overview of Docker
- Demo of docker cli using pre packaged images
- Overview of dockerfile and how to create images for our own services
- Overview of docker-compose and how it combines all of the above
- Outline what Kubernetes is and how it links to Docker
- Demo of kubernetes manifest files/cli/etc

![Bare metal vs VM vs Containers](https://d33wubrfki0l68.cloudfront.net/26a177ede4d7b032362289c6fccd448fc4a91174/eb693/images/docs/container_evolution.svg)

## Docker

`docker ps`

### Running an app

![Docker Architecture](https://docs.docker.com/engine/images/architecture.svg)

Give overview of App & Dockerfile

- `docker build . --tag go-app:latest`
- `docker images`
- `docker run --name go-app go-app:latest`
- `docker ps`
- `docker ps --all`
- `docker rm go-app`
- `docker run --name go-app -d -p 8080:8080 go-app:latest`
- `curl localhost:8080/ping`
- `docker stop go-app && docker rm go-app`

Change port in dockerfile to cover build caching/layers

### Tags

- `docker images go-app`
- `git checkout eoinfarrell/remove-hardcoding`
- `git rebase main`
- `git diff main..eoinfarrell/remove-hardcoding`
- `docker build . --tag go-app:remove-hardcoding`
- `docker images go-app`
- `docker run --name go-app -d -p 8080:8080 go-app:eoinfarrell-remove-hardcoding`
- `docker stop go-app`
- `docker rm go-app`

Display running both containers at the same time on different ports

- `docker run --name go-app-main -d -p 8080:8080 go-app:latest`
- `docker run --name go-app-remove-hardcoding -d -p 8081:8080 go-app:eoinfarrell-remove-hardcoding`
- `curl localhost:8080/ping`
- `curl localhost:8081/ping`

### Multi stage builds

- `docker images go-app`
- `docker build . --tag go-app:eoinfarrell-multi-stage-build`
- `docker run --name go-app -d -p 8080:8080 go-app:eoinfarrell-multi-stage-build`
- `curl localhost:8080/ping`
- `docker stop go-app && docker rm go-app`

Discuss docker push

- `docker build . --tag go-app:latest`
- `docker push go-app`

### Docker Registry

- `docker run -it --rm -d -p 8080:80 --name web nginx`
- `curl localhost:8080`
- `docker logs web`
- `docker logs -f web`
- `docker exec -it web /bin/bash`
- `docker stop web`

![Docker Volumes](https://docs.docker.com/storage/images/types-of-mounts-volume.png)

- `scp -r apps/nginx Ubnt-Horizon:/home/feoin/Code/nginx`
- `docker run -it --rm -d -p 8080:80 --name web -v /home/feoin/Code/nginx:/usr/share/nginx/html nginx`

### Docker Compose

- `docker compose up -d`
- `curl localhost:8080/ping`
- `curl localhost:8090/hello`
- `curl localhost:8091`

Mention Network/DNS

- `docker compose up java-app --force-recreate --build -d`

## Kubernetes

![Kubernetes Components](https://d33wubrfki0l68.cloudfront.net/2475489eaf20163ec0f54ddc1d92aa8d4c87c96b/e7c81/images/docs/components-of-kubernetes.svg)

![Kubernetes Nodes & Pods](https://d33wubrfki0l68.cloudfront.net/5cb72d407cbe2755e581b6de757e0d81760d5b86/a9df9/docs/tutorials/kubernetes-basics/public/images/module_03_nodes.svg)

- `kind delete cluster`

- `kind create cluster --config multi-node-cluster.yml`

Helm