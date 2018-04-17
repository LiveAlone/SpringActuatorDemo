package org.yqj.actuator.demo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yaoqijun on 2018-04-17.
 */
@Configuration
public class LocalMetricsConfiguration {

    @Autowired
    private MeterRegistry meterRegistry;

    @Bean
    public Counter configCounter(){
        Counter counter = Counter.builder("local.configuration.random.value")
                .register(meterRegistry);
        return counter;
    }

    @Bean
    public LocalGaugeByBinder localGaugeByBinder(){
        LocalGaugeByBinder localGaugeByBinder = new LocalGaugeByBinder();
        localGaugeByBinder.setCounter(configCounter());
        return localGaugeByBinder;
    }
}
