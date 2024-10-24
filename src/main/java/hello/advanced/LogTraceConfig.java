package hello.advanced;

import hello.advanced.trace.logtrace.FieldLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 싱글톤 객체임.
 * 만약 여러 군데에서 동시에 사용하면, FieldLogTrace에 들어있는 traceIdHolder의 동기화 동시성 이슈 발생
 */
@Configuration
public class LogTraceConfig {

    @Bean
    public FieldLogTrace fieldLogTrace() {
        return new FieldLogTrace();
    }
}
