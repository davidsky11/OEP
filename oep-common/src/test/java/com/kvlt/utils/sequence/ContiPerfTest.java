package com.kvlt.utils.sequence;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * ContiPerfTest
 * 性能测试
 * @author KVLT
 * @date 2017-09-17.
 */
public class ContiPerfTest {

    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    Sequence sequence = new Sequence(0, 0);

    @Test
    @PerfTest(invocations = 200000000, threads = 16)
    public void test1() throws Exception {
        sequence.nextId();
    }
}
