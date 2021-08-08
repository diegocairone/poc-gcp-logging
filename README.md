
# poc-gcp-logging
Sending log messeges to Google cloud logging

[Setting Up Cloud Logging for Java](https://cloud.google.com/logging/docs/setup/java?hl=en)

Resume

Enable the Cloud Logging API.
Installing the dependency:

    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-logging-logback</artifactId>
      <version>0.121.5-alpha</version>
    </dependency>

Add *logback-spring.xml* in classpath (resources folder)

Create or update a service account (in GCP, IAM & Admin, Service accounts) and download the key in a JSON key file. [See Setup authentication](https://cloud.google.com/logging/docs/reference/libraries#setting_up_authentication)

Provide authentication credentials to your application code by setting the environment variable GOOGLE_APPLICATION_CREDENTIALS

The value of the variable must point to the path of the JSON file.
