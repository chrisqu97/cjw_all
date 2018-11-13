package com.cjw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author qucl
 * @date 2018/11/13 16:45
 */
@Configuration
public class ThreadPoolConfig {
    /**
     * 核心线程池大小
     */
    @Value("${thread.pool.corePoolSize}")
    private Integer corePoolSize;
    /**
     * 最大线程数
     */
    @Value("${thread.pool.maxPoolSize}")
    private Integer maxPoolSize;
    /**
     * 活跃时间
     */
    @Value("${thread.pool.keepAliveSeconds}")
    private Integer keepAliveSeconds;
    /**
     * 队列容量
     */
    @Value("${thread.pool.queueCapacity}")
    private Integer queueCapacity;

    @Bean
    public Executor myThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池大小
        executor.setCorePoolSize(this.corePoolSize);
        //最大线程数
        executor.setMaxPoolSize(this.maxPoolSize);
        //队列容量
        executor.setQueueCapacity(this.queueCapacity);
        //活跃时间
        executor.setKeepAliveSeconds(this.keepAliveSeconds);
        //线程名字前缀
        executor.setThreadNamePrefix("MyExecutor-");

        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
