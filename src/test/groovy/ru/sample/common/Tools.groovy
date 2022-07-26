package ru.sample.common

import org.junit.jupiter.api.TestInfo

import static java.lang.System.currentTimeMillis
import static java.lang.Thread.currentThread

class Tools {
    public static INFO_SAMPLE = '%5d %2d [%s] >> %s%n'

    static printInfo(TestInfo testInfo, long startTime, int i) {
        printf "$INFO_SAMPLE", currentTimeMillis() - startTime, i, currentThread().name,
                testInfo.getDisplayName()
    }
}
