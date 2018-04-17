package org.yqj.actuator.demo.info;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author yaoqijun on 2018-04-17.
 */
@Component
public class LocalInfoContributor implements InfoContributor {
    @Override
    public void contribute(Builder builder) {
        builder.withDetail("myKeyIsWhat", "keyContentValueIs");
    }
}
