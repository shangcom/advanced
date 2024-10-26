package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략 보관
 * 사용 시, 전략을 주입 받은 Context 객체를 만들고(선조립)
 * 그 객체를 통해 execute() (후 실행)
 * 전략이 달라지면 Context 객체도 다시 만들어야 한다.
 */
@Slf4j
public class ContextV1 {

    // 전략 객체를 주입받아 사용하므로 상속 대신 위임(Delegation)을 사용하여 코드의 유연성 높아진다.

    public final Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        // 비즈니스 로직 실행
        strategy.call(); //

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
