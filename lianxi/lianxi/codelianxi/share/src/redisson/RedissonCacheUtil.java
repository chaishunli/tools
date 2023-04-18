package com.welab.account.redisson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMapCache;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedissonCacheUtil {

  /**
   * redisson client object
   */
  @Autowired
  private RedissonClient redissonClient;

  /**
   * read cache
   *
   * @param key cache key
   * @param <T> T
   * @return cache return value
   */
  public <T> T get(String key) {
    RBucket<T> bucket = redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key);
    if (null == bucket) {
      return null;
    }
    return bucket.get();
  }

  /**
   * read cache as string
   *
   * @param key cache key
   * @return cache return value
   */
  public String getString(String key) {
    RBucket<String> bucket = redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key,
        StringCodec.INSTANCE);

    if (null == bucket) {
      return null;
    }
    return bucket.get();
  }

  /**
   * Set the cache (Note: redisson will automatically select the serialization and deserialization
   * method)
   *
   * @param key   cache key
   * @param value cache value
   * @param <T>   T
   */
  public <T> void put(String key, T value) {
    RBucket<T> bucket = redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key);
    bucket.set(value, RedissonProperties.DEFAULT_EXPIRED, TimeUnit.SECONDS);
  }

  /**
   * set cache
   *
   * @param key     cache key
   * @param value   cache value
   * @param expired cache expiration time
   * @param <T>     type
   */
  public <T> void put(String key, T value, long expired) {
    RBucket<T> bucket = redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key);
    bucket.set(value, expired <= 0 ? RedissonProperties.DEFAULT_EXPIRED : expired,
        TimeUnit.SECONDS);
  }

  /**
   * Set the cache as a string
   *
   * @param key   KEY
   * @param value VALUE
   */
  public void putString(String key, String value) {
    RBucket<String> bucket = redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key,
        StringCodec.INSTANCE);
    bucket.set(value, RedissonProperties.DEFAULT_EXPIRED, TimeUnit.SECONDS);
  }



  /**
   * Save the cache as a string (you need to use this function when sharing redis with other
   * applications)
   *
   * @param key     cache key
   * @param value   cache value
   * @param expired cache expiration time
   */
  public void putString(String key, String value, long expired) {
    RBucket<String> bucket = redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key,
        StringCodec.INSTANCE);
    bucket.set(value, expired <= 0 ? RedissonProperties.DEFAULT_EXPIRED : expired,
        TimeUnit.SECONDS);
  }

  /**
   * If it does not exist, write to the cache (string mode, without format information of redisson)
   * (without expiration time, permanently saved)
   *
   * @param key   cache key
   * @param value cache value
   */
  public boolean putStringIfAbsent(String key, String value) {
    RBucket<String> bucket = redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key,
        StringCodec.INSTANCE);
    return bucket.trySet(value);
  }

  /**
   * If it does not exist, write to the cache (string mode, without redisson format information)
   *
   * @param key     cache key
   * @param value   cache value
   * @param expired cache expiration time
   */
  public boolean putStringIfAbsent(String key, String value, long expired) {
    RBucket<String> bucket = redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key,
        StringCodec.INSTANCE);
    return bucket.trySet(value, expired <= 0 ? RedissonProperties.DEFAULT_EXPIRED : expired,
        TimeUnit.SECONDS);
  }





  /**
   * remove cache
   *
   * @param key key
   */
  public void remove(String key) {
    redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key).delete();
  }

  /**
   * check if the cache exists
   *
   * @param key key
   * @return  boolean
   */
  public boolean exists(String key) {
    return redissonClient.getBucket(RedissonProperties.REDIS_KEY_PREFIX + key).isExists();
  }


  /**
   * List object exposing redisson
   *
   * @param key key
   * @return result
   */
  public <T> RList<T> getRedisList(String key) {
    return redissonClient.getList(RedissonProperties.REDIS_KEY_PREFIX + key);
  }

  /**
   * batch get
   *
   * @param key key
   * @return list
   */
  public List<String> getBatchRedisList(String key) {
    Iterable<String> keysByPattern = redissonClient.getKeys()
        .getKeysByPattern(RedissonProperties.REDIS_KEY_PREFIX + key + "*");
    List<String> result = new ArrayList<>();
    Iterator<String> iterator = keysByPattern.iterator();
    while (iterator.hasNext()) {
      RBucket<Object> bucket = redissonClient.getBucket(iterator.next());
      if (null != bucket) {
        result.add(bucket.get().toString());
      }
    }
    return result;
  }

  /**
   * Map Cache object exposing redisson
   *
   * @param key key
   * @return value
   */
  public <K, V> RMapCache<K, V> getRedisMap(String key) {
    return redissonClient.getMapCache(RedissonProperties.REDIS_KEY_PREFIX + key);
  }

  /**
   * Expose the RSET object of redisson
   *
   * @param key key
   * @return result
   */
  public <T> RSet<T> getRedisSet(String key) {
    return redissonClient.getSet(RedissonProperties.REDIS_KEY_PREFIX + key);
  }


  /**
   * Expose redisson's RScoredSortedSet object
   *
   * @param key key
   * @param <T> value
   * @return result
   */
  public <T> RScoredSortedSet<T> getRedisScoredSortedSet(String key) {
    return redissonClient.getScoredSortedSet(RedissonProperties.REDIS_KEY_PREFIX + key);
  }


  /*============================================lock=========================================*/

  /**
   * lock
   *
   * @param lockKey key
   * @return result
   */
  public RLock lock(String lockKey) {
    RLock lock = redissonClient.getLock(lockKey);
    return lock;
  }

  /**
   * lock
   *
   * @param key key
   * @param supplier supplier
   * @return result
   */
  public <T> T lock(String key, Supplier<T> supplier) {
    RLock lock = lock(key);
    try {
      lock.lock();
      return supplier.get();
    } finally {
      if (lock != null && lock.isLocked()) {
        lock.unlock();
      }
    }
  }

  /**
   * lock with timeout
   *
   * @param lockKey key
   * @param timeout Timeout time unit: second
   * @return value
   */
  public RLock lock(String lockKey, int timeout) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.lock(timeout, TimeUnit.SECONDS);
    return lock;
  }

  /**
   * lock with timeout
   *
   * @param lockKey lockKey
   * @param unit    time unit
   * @param timeout overtime time
   */
  public RLock lock(String lockKey, TimeUnit unit, int timeout) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.lock(timeout, unit);
    return lock;
  }



  /**
   * fair lock
   *
   * @param key key
   * @return result
   */
  public RLock fairLock(String key) {
    return redissonClient.getFairLock(key);
  }


  /**
   * Read-write lock
   *
   * @param key key
   * @return value
   */
  public RReadWriteLock readWriteLock(String key) {
    return redissonClient.getReadWriteLock(key);
  }






  /**
   * try to acquire lock
   *
   * @param lockKey lockKey
   * @param waitTime  waiting time
   * @param leaseTime Auto release lock time
   * @return  boolean
   */
  public boolean tryLock(String lockKey, int waitTime, int leaseTime) {
    RLock lock = redissonClient.getLock(lockKey);
    try {
      return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      return false;
    }
  }

  /**
   * try to acquire lock
   *
   * @param lockKey lockKey
   * @param unit      time unit
   * @param waitTime  waiting time
   * @param leaseTime Auto release lock time
   * @return boolean
   */
  public boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
    RLock lock = redissonClient.getLock(lockKey);
    try {
      return lock.tryLock(waitTime, leaseTime, unit);
    } catch (InterruptedException e) {
      return false;
    }
  }

  /**
   * release lock
   *
   * @param lockKey lockKey
   */
  public void unlock(String lockKey) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.unlock();
  }


  /**
   * release lock
   *
   * @param lock lock
   */
  public void unlock(RLock lock) {
    lock.unlock();
  }

  //getKeysByPattern
  public List<String> getKeysByPattern(String key) {
    List<String> list = new ArrayList<>();
    Iterable<String> keysByPattern = redissonClient.getKeys()
            .getKeysByPattern(RedissonProperties.REDIS_KEY_PREFIX + key + "*");
    Iterator<String> iterator = keysByPattern.iterator();
    while (iterator.hasNext()) {
      list.add(iterator.next());
    }
    return list;
  }

  //removeNoPrefix,use for  reading from redis ,aleady having prefix info
  public void removeNoPrefix(String key) {
    redissonClient.getBucket(key).delete();
  }
}