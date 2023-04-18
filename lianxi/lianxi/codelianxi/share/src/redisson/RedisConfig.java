package com.welab.account.redisson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.MasterSlaveServersConfig;
import org.redisson.config.ReplicatedServersConfig;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("redis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisConfig {
  private SentinelServersConfig sentinelServersConfig;

  private MasterSlaveServersConfig masterSlaveServersConfig;

  private SingleServerConfig singleServerConfig;

  private ClusterServersConfig clusterServersConfig;

  private ReplicatedServersConfig replicatedServersConfig;
}

