import static org.spockframework.runtime.model.parallel.ExecutionMode.CONCURRENT
import static org.spockframework.runtime.model.parallel.ExecutionMode.SAME_THREAD

runner {
    parallel {
        enabled true
        // These values are the default already, specifying them is redundant
        // defaultSpecificationExecutionMode = CONCURRENT
        // defaultExecutionMode = CONCURRENT
        defaultSpecificationExecutionMode SAME_THREAD
        defaultExecutionMode SAME_THREAD
        fixed Runtime.runtime.availableProcessors()
    }
}

println("Threads:${Runtime.runtime.availableProcessors()}")
println("Classes:${runner.parallel.defaultSpecificationExecutionMode}")
println("Methods:${runner.parallel.defaultExecutionMode}")
