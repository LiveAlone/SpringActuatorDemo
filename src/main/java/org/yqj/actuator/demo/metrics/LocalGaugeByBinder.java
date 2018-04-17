package org.yqj.actuator.demo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

/**
 * @author yaoqijun on 2018-04-17.
 */
@Component
public class LocalGaugeByBinder implements MeterBinder{

    private Counter counter;

    @Override
    public void bindTo(MeterRegistry registry) {
        Gauge.builder("local.binder.gauge", counter, Counter::count).register(registry);
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
}
