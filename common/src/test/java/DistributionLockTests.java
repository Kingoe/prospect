import com.kingoe.service.DistributionLockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {com.kingoe.Cm.class})
public class DistributionLockTests {

    @Autowired
    private DistributionLockService distributionLockService;

    /**
     * 多线程并行处理500个请求，扣库存
     */
    @Test
    public void testDistributionLock() {
        long successCount = IntStream.range(0, 200).parallel().filter(j -> distributionLockService.increment()).count();
        log.info("成功数:{}", successCount);
        log.info("剩余库存:{}", distributionLockService.getCount());
    }

}
