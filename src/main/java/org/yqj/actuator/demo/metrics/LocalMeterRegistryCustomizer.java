package org.yqj.actuator.demo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author yaoqijun on 2018-04-17.
 */
@Component
public class LocalMeterRegistryCustomizer implements MeterRegistryCustomizer{

    private Counter counter;

    @Override
    public void customize(MeterRegistry registry) {
        counter = Counter.builder("local.meter.registry.customer").register(registry);
    }

    public void incrementCounter(double value){
        counter.increment(value);
    }
}
