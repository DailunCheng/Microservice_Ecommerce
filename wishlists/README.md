[![Build Status](https://travis-ci.org/microservices-demo/wishlists.svg?branch=master)](https://travis-ci.org/microservices-demo/wishlists) [![Coverage Status](https://coveralls.io/repos/github/microservices-demo/wishlists/badge.svg?branch=master)](https://coveralls.io/github/microservices-demo/wishlists?branch=master)
[![](https://images.microbadger.com/badges/image/weaveworksdemos/wishlist.svg)](http://microbadger.com/images/weaveworksdemos/wishlist "Get your own image badge on microbadger.com")
# wishlist
A microservices-demo service that provides shopping wishlists for users.

This build is built, tested and released by travis.

# API Spec

Checkout the API Spec [here](http://microservices-demo.github.io/api/index?url=https://raw.githubusercontent.com/microservices-demo/wishlists/master/api-spec/wishlist.json)

# Build

## Java

`mvn -DskipTests package`

## Docker

`GROUP=weaveworksdemos COMMIT=test ./scripts/build.sh`

# Test

`./test/test.sh < python testing file >`. For example: `./test/test.sh unit.py`

# Run

`mvn spring-boot:run`

# Check

`curl http://localhost:8081/health`

# Use

`curl http://localhost:8081`

# Push

`GROUP=weaveworksdemos COMMIT=test ./scripts/push.sh`
