footer: twitter: @erbetowski
Welcome!

I am Wojtek Erbetowski. You pronounce my first name like "Voytech". And this talk is about Serverless computing.

I you want to mention me, I am:
* @erbetowski on Twitter
* wojtek.erbetowski pretty much everywhere else

---

# Who am I?

Generalist.
 #java #machinelearning #scala #groovy #android
 #python #microservices #django #spring #gradle
 #docker #ecmascript #reactjs

Passionate about the people, then the process.

MSc in mathematics.

---

# What is Serverless?

---

# What is Serverless?

1. Abstract from the runtime (server)
1. Stateless
1. Event driven
1. Ephemeral

---
^ this name gives better understanding of the thing
as we actually sure servers, even more

another name is **FaaS** or **Function as a Service**

---
^ TODO: nice comparison against BaaS

# What Serverless is not?

1. BaaS
1. parallel computing engine

---

Current options are

1. Amazon AWS Lambda
1. Google Cloud Functions
1. Microsoft Azure Functions
1. IBM OpenWhisk
1. OpenStack Picasso
1. minor frameworks

---

# AWS Lambda

---

# Event driven

1. S3
1. DynamoDB
1. Simple Notification Service
1. CloudWatch
1. API Gateway
1. and many more

---

# Supports variety of languages

-> Node.js – v4.3.2 and 6.10.2
-> Java – Java 8
-> Python – Python 3.6 and 2.7
-> .NET Core – .NET Core 1.0.1 (C#)
-> (extra) language of your choice

---

# Vendor lock-in

1. APIs differ between cloud providers
2. API is pretty minimal though

---

# Pricing

Lambdas are priced per:
1. number of requests
1. 100s of milliseconds (depends on declared memory)

Free tier is very generous.

---

# Pricing

$0.20 per 1 million requests.

1024 MB: 1$ -> 600k units -> 16 hours
128 MBs: 1$ -> 5M units -> 133 hours

---

# Free tier

First 1 million requests per month.

512 MB app can run for 800,000s (~200 hours).

---

# Serverless frameworks
## Raising the API level

1. Serverless.com
1. Apex
1. Chalice
1. Kappa
1. Sparta
1. Zappa

---

# Serverless framework

1. Deployments
1. Declarative (YAML)
1. Resource management (S3, DynamoDB, VPC)
1. Logs
1. Triggers, APIs
1. Local execution

---

hello serverless framework!

---

set up

```yaml
service: my-service

provider:
  name: aws
  runtime: nodejs6.10

functions:
  hello:
    handler: handler.hello
    events:
      - http:
          path: hello
          method: get
```

---

handle

```javascript
module.exports.hello = (event, context, callback) => {
  const response = {
    statusCode: 200,
    body: JSON.stringify({
      message: 'Hello Polyconf!',
      input: event,
    }),
  };

  callback(null, response);
};
```

---

deploy

```
$ serverless deploy
Serverless: Packaging service...
Serverless: Uploading CloudFormation file to S3...
Serverless: Uploading artifacts...
Serverless: Uploading service .zip file to S3 (307 B)...
Serverless: Validating template...
Serverless: Updating Stack...
Serverless: Checking Stack update progress...
..............
Serverless: Stack update finished...
Service Information
service: my-service
stage: dev
region: us-east-1
api keys:
  None
endpoints:
  GET - https://.../dev/hello
functions:
  hello: my-service-dev-hello
```

---

partial deploy

```
$ serverless deploy function -f hello
```

---

Use

```
$ serverless invoke -f hello

$ curl "https://.../dev/hello"
```

---
^ note - time savings go to AWS pocket

how to async?

```

```

---
how to async?

```

```

---

working with S3

```javascript
fetch('image URL')
  .then(res => {
    return s3.putObject({Bucket, Key, Body: res.body}).promise();
  }).then(res => {
    callback(null, res);
  }).catch(err => {
    callback(err, null);
  });
```

---

scheduling tasks

```yaml
functions:
  cron:
    handler: handler.run
    events:
      # Invoke Lambda function every minute
      - schedule: rate(1 minute)
  secondCron:
    handler: handler.run
    events:
      # Invoke Lambda function every 2nd minute from Mon-Fri
      - schedule: cron(0/2 * ? * MON-FRI *)
```

---

Perfect use cases
* S3 images processing
* Chatbots
* Websites
* Inconsistent traffic
* Log analysis on the fly
* Event Sourcing

Easy tools take over the world
* Greek and Romans?
* Lack of operations and system administration
* Lambda is to computing what S3 is to storage
* Two students re-done the service

Limitations
* Disk space
* Deployment package size
* Memory
* Time

Pain points
* Monitor usage
* Debugging
* Wall of requests hit AWS (doesn’t scale that well)
* Cost management

Biggest wins
* Scalability
* Pricing
* NoOps

Extras
* Serverlessify regular app (WSGI)
* Golem

---
^
Is it new? GAE
sample recursion: https://github.com/serverless/examples/blob/master/aws-node-recursive-function/handler.js
