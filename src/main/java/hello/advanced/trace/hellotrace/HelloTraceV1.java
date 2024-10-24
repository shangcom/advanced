package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloTraceV1 {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    /**
     * 로그 시작
     * @param message 로그 메시지
     * @return 현재 로그 상태 'TraceStatus'
     */
    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    /**
     * 로그 정상 종료 - 정상 흐름에서 호출.
     * @param status 이용해서 실행 시간 계산 및 종료 시에도 시작과 동일한 traceId와 메시지 출력 가능함.
     */
    public void end(TraceStatus status) {
        complete(status, null);
    }

    /**
     * 로그를 예외 상호아으로 종료 - 예외 발생시 호출.
     * status, e 정보로 실행시간, 예외 정보 등 가져와서 출력.
     */
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    /**
     * end(), exception() 처리.
     * 실생 시간 측정, 로그 출력, (예외 있을 시) 예외 정보 출력.
     */
    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(),
                    addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs, e.toString());
        }
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append( (i == level - 1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }
}
