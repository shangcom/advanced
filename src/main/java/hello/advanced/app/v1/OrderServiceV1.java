package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepositoryV1;
    private final HelloTraceV1 trace;

    // 주문 시 아이템 Id 저장만 하는 간단한 로직.
    public void orderItem(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");

            // 저장 로직
            orderRepositoryV1.save(itemId);

            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외 던져야함.
        }
    }

}
