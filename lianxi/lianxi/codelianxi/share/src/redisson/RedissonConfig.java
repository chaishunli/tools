package com.welab.account.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RedissonConfig {

  @Value("${spring.redis.cluster.address:123}")
  private String address;

  /**
   * 密码
   */
  @Value("${spring.redis.cluster.password:123}")
  private String password;

  /**
   * 同任何节点创建链接时的等待超时。时间单位是毫秒。
   */
  @Value("${spring.redis.cluster.connectTimeout:123}")
  private int connectTimeout = 10000;

  @Value("${spring.redis.cluster.timeout:123}")
  private int timeout = 5000;

  /**
   * 命令失败重试次数
   */
  @Value("${spring.redis.cluster.retryAttempts:123}")
  private int retryAttempts = 3;

  /**
   * 命令重试发送时间间隔
   */
  @Value("${spring.redis.cluster.retryInterval:123}")
  private int retryInterval = 1000;

  //@Bean("redisClient")
  RedissonClient redissonCluster() {
    Config config = new Config();
    config.setCodec(new org.redisson.client.codec.StringCodec());
    ClusterServersConfig clusterServerConfig = config.useClusterServers();
    String[] addHost = address.split(",");
    if (addHost != null && addHost.length > 0) {
      for (String host : addHost) {
        clusterServerConfig.addNodeAddress("redis://" + host);
      }
    }
    clusterServerConfig.setCheckSlotsCoverage(true)
        .setConnectTimeout(connectTimeout)
        .setRetryAttempts(retryAttempts)
        .setRetryInterval(retryInterval)
        .setTimeout(timeout);
    clusterServerConfig.setPassword(password);
    return Redisson.create(config);
  }

}