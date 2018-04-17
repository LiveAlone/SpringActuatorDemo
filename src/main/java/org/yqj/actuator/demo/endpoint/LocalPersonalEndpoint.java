package org.yqj.actuator.demo.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.info.Info;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yaoqijun on 2018-04-17.
 */
@Component
@Endpoint(id = "business")
public class LocalPersonalEndpoint {

    @ReadOperation
    public Map<String, Object> info() {
        Info.Builder builder = new Info.Builder();
        builder.withDetail("localBusiness", "this is local business");
        Info build = builder.build();
        return build.getDetails();
    }
}
