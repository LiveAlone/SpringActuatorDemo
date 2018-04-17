package org.yqj.actuator.demo.metrics;

import io.micrometer.core.instrument.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yaoqijun on 2018-04-17.
 */
@Controller
public class MetricWatchController {

    @Autowired
    @Qualifier(value = "configCounter")
    private Counter counter;

    @Autowired
    private LocalMeterRegistryCustomizer localMeterRegistryCustomizer;

    @RequestMapping(value = "/customer_counter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String customerPage(){
        localMeterRegistryCustomizer.incrementCounter(1.1D);
        return "counter over content";
    }

    @RequestMapping(value = "/add_counter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String indexPage(){
        counter.increment();
        return "counter over content";
    }
}
