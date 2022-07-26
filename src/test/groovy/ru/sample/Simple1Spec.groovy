package ru.sample

import spock.lang.Execution
import spock.lang.Ignore
import spock.lang.Specification

import static java.lang.System.currentTimeMillis
import static ru.sample.common.Tools.printInfo

import static org.spockframework.runtime.model.parallel.ExecutionMode.CONCURRENT

class Simple1Spec extends Specification {
    static long startTime = currentTimeMillis()
    static volatile int execCount = 0

    @Ignore
    def "feature-A-#count"() {
        given:
        def i = ++execCount
        printInfo(specificationContext, startTime, i)
        sleep 1000
        printInfo(specificationContext, startTime, i)

        where:
        count << (1..8)
    }

    @Execution(CONCURRENT)
    def "feature-B-#count"() {
        given:
        def i = ++execCount
        printInfo(specificationContext, startTime, i)
        sleep 1000
        printInfo(specificationContext, startTime, i)
        where:
        count << (1..8)
    }

    @Execution(CONCURRENT)
    def "feature-C-#count"() {
        given:
        def i = ++execCount
        printInfo(specificationContext, startTime, i)
        sleep 1000
        printInfo(specificationContext, startTime, i)
        where:
        count << (1..8)
    }

}