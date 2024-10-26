package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 템플릿 메서드 패턴
 * 상위 클래스에 알고리즘의 기본 골격(템플릿)을 정의하고, 하위 클래스에서 알고리즘의 세부 단계를 구현.
 * 즉, 공통된 로직은 상위 클래스에서 처리하고, 변화하는 부분은 하위 클래스에서 오버라이딩하여 구현
 * execute() : 공통 부분
 * call() : 구체적인 로직.
 *      protected로 외부에서의 호출을 막는 이유?
 *      execute까지 세트로 동작해야 하는 메서드인데 call 부분만 떼어내서 사용하는 일 방지.
 *      정해진 흐름대로만 작동하도록 강제.
 */
@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        call(); // 상속

        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    /*
     자식 클래스가 구체적인 로직을 작성하는 부분.
     */


    protected abstract void call();
}
