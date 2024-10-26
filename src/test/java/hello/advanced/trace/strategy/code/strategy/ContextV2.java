package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 템플릿 콜백 패턴
 * 전략을 파라미터로 전달받아 사용.
 * 전략을 필드에 주입 받아 사용할 때와 달리, 동일한 Context 인스턴스를 사용하면서
 * execute(Strategy strategy)에 전략은 인자로 전달 받음.
 * 즉 실행 시점에 동적으로 전략을 결정할 수 있음.
 * callback?
 * 콜백은 특정 시점에 실행할 코드를 미리 넘겨두고(call), 나중에 필요할 때(back) 그 코드를 호출하는 방식.
 * 특정 인터페이스의 구현체를 (익명 클래스나 람다식)인스턴스화해서 콜백으로 넘긴다
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
