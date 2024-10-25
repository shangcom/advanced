package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    /**
     *     FieldService의 String 싱글톤 객체를 ThreadLocal으로 교체.
     *     ThreadLocal을 사용해 쓰레드마다 독립적인 저장소를 제공
     */
    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("저장 name= {} -> nameStore= {}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("조회 nameStore = {}", nameStore.get());
        return nameStore.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
