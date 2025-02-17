package com.mukit.springbootscheduler.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.mukit.springbootscheduler.repository")
public class DynamoDBConfig {

//    @Bean
//    public DynamoDbClient dynamoDbClient() {
//        AwsBasicCredentials awsCreds = AwsBasicCredentials.create("non_empty_key", "non_empty_key");
//        return DynamoDbClient.builder()
//                .region(Region.AP_SOUTHEAST_1)
//                .endpointOverride(URI.create("http://localstack-for-scheduler:4566"))
//                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
//                .build();
//    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder
                        .EndpointConfiguration("http://localstack-for-scheduler:4566", "ap-southeast-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("non_empty_key", "non_empty_key")))
                .build();
    }

}
