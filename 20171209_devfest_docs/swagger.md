Load Swagger.yml

`curl https://api.apis.guru/v2/specs/getsandbox.com/v1/swagger.yaml > github.swagger.yml`

generate sources

`swagger-codegen generate -i github.swagger.yml -l java -o api_client/`

