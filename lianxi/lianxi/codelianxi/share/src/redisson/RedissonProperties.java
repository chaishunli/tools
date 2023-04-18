package com.welab.account.redisson;

public class RedissonProperties {

  /**
   * default cache time
   */
  public static final Long DEFAULT_EXPIRED = 5 * 60L;
  /**
   * redis key prefix
   */
  public static final String REDIS_KEY_PREFIX = "account:";


  public static final String CATALOG_INTERVAL_SYMBOL = ":";

  public static final String CREATE_DUMMY_ACCOUNT = REDIS_KEY_PREFIX + "dummy:";

  public static final String SEND_OTP = "otp:";

  public static final String LOGIN = "login:";

  public static final String REFID = "refid:";

  public static final int LOGIN_EXPIRED = 5 * 60;

  public static final String LOGIN_PIN = "loginpin:";

  public static final int LOGIN_PIN_EXPIRED = 5 * 60;

  public static final String VERIFY_PASSWORD  = "verifypassword:";

  public static final long ONE_DAY_SECONDS = 86400;



}
