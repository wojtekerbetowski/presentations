# Setup

## Swagger

* install `brew install swagger-codegen`
* `curl https://api.apis.guru/v2/specs/getsandbox.com/v1/swagger.yaml > github.swagger.yml`
* Generate swagger app `swagger-codegen generate -i github.swagger.yml -l java -o api_client/`

Spock repository
* install asciidoc `brew install asciidoctor`
* `git clone git@github.com:spockframework/spock-example.git my_project` (for my first task and adoc)

