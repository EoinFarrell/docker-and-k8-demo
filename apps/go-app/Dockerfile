FROM golang:1.18 AS build

WORKDIR /app

COPY go.mod go.mod
COPY go.sum go.sum
RUN go mod download

ADD . /app

RUN go build -o go-app ./main.go
# RUN go build --ldflags '-linkmode external -extldflags "-static"' -o go-app ./main.go

# FROM alpine:latest
# COPY --from=build /app/go-app .

# EXPOSE 8080

# ENTRYPOINT [ "./go-app" ]