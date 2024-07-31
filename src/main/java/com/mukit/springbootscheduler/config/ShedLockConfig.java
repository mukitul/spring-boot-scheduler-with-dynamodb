package com.mukit.springbootscheduler.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtLeastFor = "PT5M", defaultLockAtMostFor = "PT14M")
public class ShedLockConfig {
    /*
     * we added defaultLockAtLeastFor so that we can put some distance between method invocations.
     * Using “PT5M” means that this method will hold the lock for five minutes, at a minimum.
     * In other words, that means that this method can be run by ShedLock no more often than every five minutes.
     *
     * ----------------
     *
     * we added lockAtMostFor to specify how long the lock should be kept in case the executing node dies.
     * Using “PT14M” means that it will be locked for no longer than 14 minutes.
     *
     * */

//    @Bean
//    public LockProvider lockProvider(DynamoDbClient dynamodbClient) {
//        return new DynamoDBLockProvider(dynamodbClient, "shedlock");
//    }

    @Bean
    public LockProvider lockProvider(RedisConnectionFactory connectionFactory) {
        return new RedisLockProvider(connectionFactory, "");
    }

}
