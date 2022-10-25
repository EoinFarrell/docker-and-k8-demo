FROM golang:1.18 AS go-build

WORKDIR /app

COPY go.mod go.mod
COPY go.sum go.sum
RUN go mod download

ADD . /app
RUN go build -o go-app ./main.go

FROM ruby:2.5.5 AS ruby-build

WORKDIR /app

# Application dependencies
COPY Gemfile Gemfile.lock ./
RUN bundle install

FROM ubuntu:latest
WORKDIR /app
COPY --from=go-build /app /app/go
COPY --from=ruby-build /app /app/ruby

EXPOSE 8080

CMD ./app/ruby/bundle
ENTRYPOINT [ "/app/go/go-app" ]