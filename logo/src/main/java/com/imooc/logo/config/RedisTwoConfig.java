package com.imooc.logo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.imooc.logo.util.redis.RedisObjectSerializer;

import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class RedisTwoConfig 
{
	@Value("${spring.redistwo.host}")
	private  String hostName;
	
	@Value("${spring.redistwo.port}")
	private  Integer port;
	
	@Value("${spring.redistwo.database}")
	private  Integer database;
	
	@Value("${spring.redistwo.timeout}")
	private  Integer timeout;
	
	@Value("${spring.redistwo.pool.max-active}")
	private  Integer maxActive;
	
	@Value("${spring.redistwo.pool.max-idle}")
	private  Integer maxIdle;
	
	@Value("${spring.redistwo.pool.min-idle}")
	private  Integer minIdle;
			
	@Value("${spring.redistwo.pool.max-wait}")
	private  Integer maxWait;
		
	@Bean
    public JedisConnectionFactory redisConnectionFactory() 
	{
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
		redisStandaloneConfiguration.setPort(port);
		redisStandaloneConfiguration.setDatabase(database);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }
	
	@Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory)
	{
        return RedisCacheManager.create(connectionFactory);
    }
	
	@Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大连接数
        jedisPoolConfig.setMaxTotal(maxActive);
        //最小空闲连接数
        jedisPoolConfig.setMinIdle(minIdle);
        //当池内没有可用连接时，最大等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        //其他属性可以自行添加
        return jedisPoolConfig;
	}
	
	
	@Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        //设置redis服务器的host或者ip地址
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPort(port);
        //获得默认的连接池构造
        //这里需要注意的是，edisConnectionFactoryJ对于Standalone模式的没有（RedisStandaloneConfiguration，JedisPoolConfig）的构造函数，对此
        //我们用JedisClientConfiguration接口的builder方法实例化一个构造器，还得类型转换
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcf = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        //修改我们的连接池配置
        jpcf.poolConfig(jedisPoolConfig);
        //通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jpcf.build();
 
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }
	
	/*
	 * @SuppressWarnings("deprecation") public RedisConnectionFactory
	 * getRedisConnectionFactory() {
	 * 
	 * RedisStandaloneConfiguration redisStandaloneConfiguration =new
	 * RedisStandaloneConfiguration();
	 * redisStandaloneConfiguration.setHostName(hostName);
	 * redisStandaloneConfiguration.setPort(port);
	 * redisStandaloneConfiguration.setDatabase(database); JedisConnectionFactory
	 * jedisFactory=new JedisConnectionFactory(redisStandaloneConfiguration);
	 * JedisPoolConfig poolConfig =new JedisPoolConfig(); //JedisClientConfiguration
	 * poolConfig=new JedisClientConfiguration(); poolConfig.setMaxTotal(maxActive);
	 * poolConfig.setMaxIdle(maxIdle); poolConfig.setMinIdle(minIdle);
	 * poolConfig.setMaxWaitMillis(maxWait); jedisFactory.setPoolConfig(poolConfig);
	 * jedisFactory.afterPropertiesSet(); return jedisFactory; }
	 */
   @Bean("redistwo")
   public RedisTemplate<String,Object> getRedisTemplate()
   {
	   RedisTemplate<String,Object> redisTemplate =new RedisTemplate<String,Object>();
	   //RedisConnectionFactory factory=this.getRedisConnectionFactory();
	   RedisConnectionFactory factory=this.redisConnectionFactory(jedisPoolConfig());
	   redisTemplate.setConnectionFactory(factory);
	   redisTemplate.setKeySerializer(new StringRedisSerializer());
	   redisTemplate.setValueSerializer(new RedisObjectSerializer());
	   return redisTemplate;
   }
}
