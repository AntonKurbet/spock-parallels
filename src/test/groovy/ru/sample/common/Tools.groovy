package ru.sample.common

import static java.lang.System.currentTimeMillis
import static java.lang.Thread.currentThread

class Tools {
    public static INFO_SAMPLE = '%5d %2d [%s] >> %s (%s)%n'

    static printInfo(def specificationContext, long startTime, int i) {
        printf "$INFO_SAMPLE", currentTimeMillis() - startTime, i, currentThread().name,
                specificationContext.currentIteration.displayName, specificationContext.getCurrentSpec().getName()
    }
}
