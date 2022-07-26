import spock.lang.Specification

import static Common.printInfo
import static java.lang.System.currentTimeMillis

class Simple3Spec extends Specification {
    static long startTime = currentTimeMillis()
    static volatile int execCount = 0

    def "feature-A-#count"() {
        given:
        def i = ++execCount
        printInfo(specificationContext,startTime,i)
        sleep 1000
        printInfo(specificationContext,startTime,i)

        where:
        count << (1..8)
    }

    def "feature-B-#count"() {
        given:
        def i = ++execCount
        printInfo(specificationContext,startTime,i)
        sleep 1000
        printInfo(specificationContext,startTime,i)
        where:
        count << (1..8)
    }

}