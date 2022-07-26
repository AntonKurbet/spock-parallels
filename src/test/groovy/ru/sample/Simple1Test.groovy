package ru.sample

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

import static java.lang.System.currentTimeMillis
import static ru.sample.common.Tools.printInfo

class Simple1Test {
    long startTime = currentTimeMillis()

    private TestInfo testInfo

    @BeforeEach
    void init(TestInfo testInfo) {
        this.testInfo = testInfo
    }

    @Tag("fast")
    @Test
    void "feature-0-#count"() {
        //given:
        printInfo(testInfo, startTime, 0)
        sleep 1000
        printInfo(testInfo, startTime, 0)
    }

    @ParameterizedTest(name = "A givenNumbers {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8])
    void "feature-A-#count"(int count) {
        //given:
        printInfo(testInfo, startTime, count)
        sleep 1000
        printInfo(testInfo, startTime, count)
    }

    @ParameterizedTest(name = "B givenNumbers {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8])
    void "feature-B-#count"(int count) {
        //given:
        printInfo(testInfo, startTime, count)
        sleep 1000
        printInfo(testInfo, startTime, count)
    }

    @Tag('slow')
    @ParameterizedTest(name = "C givenNumbers {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8])
    void "feature-C-#count"(int count) {
        //given:
        printInfo(testInfo, startTime, count)
        sleep 1000
        printInfo(testInfo, startTime, count)
    }

}