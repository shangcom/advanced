package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderRepositoryV0 orderRepositoryV0;

    // 주문 시 아이템 Id 저장만 하는 간단한 로직.
    public void orderItem(String itemId) {
        orderRepositoryV0.save(itemId);
    }

}
