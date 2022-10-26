FROM golang:1.18

WORKDIR /app

COPY go.mod go.mod
COPY go.sum go.sum
RUN go mod download

ADD . /app

RUN go build -o go-app ./main.go

EXPOSE 8080

ENTRYPOINT [ "/app/go-app" ]