package hello.advanced.trace.callback;

/**
 * 제네릭 타입 <T>로 정의된 클래스나 인터페이스에서 T를 사용하는 경우,
 * 구현 시점에 구체적인 타입을 지정하면 <T> 자리에 설정한 타입으로 전부 대체
 */
public interface TraceCallback<T> {

    T call();
}
