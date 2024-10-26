package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 전략을 파라미터로 전달받아 사용.
 * 전략을 필드에 주입 받아 사용할 때와 달리, 컨텍스트 객체는 하나만 만들고
 * execute(Strategy strategy)에 전략은 인자로 전달 받음.
 * 즉 실행 시점에 전략을 결정할 수 있음.
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        strategy.call(); //

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
