package dawid.kotarba.shared.aop

import java.lang.invoke.MethodHandles
import javax.inject.Named

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.{AfterThrowing, Aspect, Pointcut}
import org.slf4j.LoggerFactory

/**
  * Created by Dawid on 19.07.2016.
  */

@Aspect
@Named
class LogExceptionAdvice {

  val log = LoggerFactory.getLogger((MethodHandles.lookup.lookupClass()))

  @Pointcut("within(dawid.kotarba..*)")
  def loggingPointcut() {
    // intentionally left blank
  }

  @AfterThrowing(pointcut = "loggingPointcut()", throwing = "e")
  def logException(joinPoint: JoinPoint, e: Throwable) {
    log.error("Exception in {}.{}() with cause = {} and exception {}", joinPoint.getSignature.getDeclaringTypeName,
      joinPoint.getSignature.getName, e.getCause, e)
  }
}
