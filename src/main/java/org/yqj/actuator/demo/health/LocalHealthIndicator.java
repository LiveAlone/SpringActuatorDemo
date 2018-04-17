package org.yqj.actuator.demo.health;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yaoqijun on 2018-04-17.
 */
//@Component
@Slf4j
public class LocalHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Long randomValue = ThreadLocalRandom.current().nextLong(100);
        if (randomValue % 2 == 0){
            return Health.up().build();
        }else {
            return Health.outOfService().withDetail("value is", randomValue).build();
        }
    }
}
