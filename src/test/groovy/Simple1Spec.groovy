import spock.lang.Execution
import spock.lang.Specification

import static java.lang.System.currentTimeMillis
import static Common.printInfo

import static org.spockframework.runtime.model.parallel.ExecutionMode.CONCURRENT
import static org.spockframework.runtime.model.parallel.ExecutionMode.SAME_THREAD

class Simple1Spec extends Specification {
    static long startTime = currentTimeMillis()
    static volatile int execCount = 0

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