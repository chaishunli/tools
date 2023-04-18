package com.welab.account.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.MasterSlaveServersConfig;
import org.redisson.config.ReplicatedServersConfig;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(RedissonClient.class)
@EnableConfigurationProperties({RedisConfig.class})
public class RedissonClientConfig {

  @Autowired private RedisConfig redisConfig;

  @Bean("redisClient")
  public RedissonClient redissonClient() {
    Config config = new Config();
    if (redisConfig.getReplicatedServersConfig() != null) {
      ReplicatedServersConfig replicatedServersConfig = config.useReplicatedServers();
      BeanUtils.copyProperties(redisConfig.getReplicatedServersConfig(), replicatedServersConfig);
    } else if (redisConfig.getMasterSlaveServersConfig() != null) {
      MasterSlaveServersConfig masterSlaveServersConfig = config.useMasterSlaveServers();
      BeanUtils.copyProperties(redisConfig.getMasterSlaveServersConfig(), masterSlaveServersConfig);
      // 哨兵模式
    } else if (redisConfig.getSentinelServersConfig() != null) { // sentinel
      SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
      BeanUtils.copyProperties(redisConfig.getSentinelServersConfig(), sentinelServersConfig);

      // 集群模式
    } else if (redisConfig.getClusterServersConfig() != null) { // cluster
      ClusterServersConfig clusterServersConfig = config.useClusterServers();
      //set password
      BeanUtils.copyProperties(redisConfig.getClusterServersConfig(), clusterServersConfig);
      // 普通模式
    } else { // single server
      SingleServerConfig singleServerConfig = config.useSingleServer();
      BeanUtils.copyProperties(redisConfig.getSingleServerConfig(), singleServerConfig);
    }
    config.setCodec(new org.redisson.client.codec.StringCodec());
    RedissonClient client = Redisson.create(config);

    return client;
  }
}

