package cn.three.module.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/12/5 0005.
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TraceApplication {
    private Logger logger = LoggerFactory.getLogger(TraceApplication.class);

    @RequestMapping(value = "/trace-2",method = RequestMethod.GET)
    public String trace(HttpServletRequest request){

        StringBuilder infotrace = new StringBuilder();
        infotrace.append("=====call trace-2,traceId={} , SpanId ={}>=======");
        infotrace.append(request.getHeader("X-B3-TraceId"));
        infotrace.append(request.getHeader("X-B3-SpanId"));
        logger.info("=====call trace-2=======",request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
        return "Trace";
    }
    public static void main(String[] args){
        SpringApplication.run(TraceApplication.class,args);
    }
}
