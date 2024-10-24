package hello.advanced.trace;

/**
 * 로그를 시작할 때의 상태 정보.
 * 로그 종료 시 사용
 */
public class TraceStatus {

    private TraceId traceId; // tran
    private Long startTimeMs; // 시작 시간. 소요시간은 종료 시간 - 시작 시간 하면 됨.
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }
}
