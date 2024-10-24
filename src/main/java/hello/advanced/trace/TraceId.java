package hello.advanced.trace;

import java.util.UUID;

/*
트랜잭션ID와 깊이를 가지고 있는 클래스.
 */
public class TraceId {

    private String id; // 트랜잭션 Id. UUID로 만든다.
    private int level; // 로그 깊이.

    public TraceId() {
        this.id = creatdId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String creatdId() {
        // UUID 앞 8자리 잘라서 사용함.
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // 다음 TraceId 반환. traceId는 유지, level만 1 증가
    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    // 이전 TraceId 반환. traceId는 유지, level만 1 감소
    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    // TraceId의 레벨이 1레벨이면 true 반환.
    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
