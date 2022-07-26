import ru.sample.annotations.MajorTests
import ru.sample.annotations.MinorTests

import static org.spockframework.runtime.model.parallel.ExecutionMode.CONCURRENT

runner {
//    include {
//        annotation MajorTests
//    }
    exclude {
        annotation MinorTests
//        baseClass Specification
    }
    parallel {
        enabled true
        // defaultSpecificationExecutionMode SAME_THREAD
        defaultSpecificationExecutionMode CONCURRENT
        defaultExecutionMode CONCURRENT
        fixed Runtime.runtime.availableProcessors()
    }
}

println("Threads:${Runtime.runtime.availableProcessors()}")
println("Classes:${runner.parallel.defaultSpecificationExecutionMode}")
println("Methods:${runner.parallel.defaultExecutionMode}")