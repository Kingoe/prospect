package com.kingoe.service;

import com.kingoe.common.anno.DistributionLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author jinwu
 */
@Slf4j
@Service
public class DistributionLockService {

    public static int count = 20;

    @DistributionLock(value = "incrementLock", waitTime = 1000)
    public boolean increment() {
        if (count > 0) {
            count--;
            return true;
        }
        return false;
    }

    public int getCount() {
        return count;
    }

}
