/**
 * packageName    : com.dongnae.jjabpang.aop
 * fileName       : SelectLogAspect
 * author         : ipeac
 * date           : 2022-10-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-10-07        ipeac       최초 생성
 */
package com.dongnae.jjabpang.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;

/**
 * packageName    : com.dongnae.jjabpang.aop
 * fileName       : SelectLogAspect
 * author         : ipeac
 * date           : 2022-10-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-10-07        ipeac       최초 생성
 */
@Slf4j
@Aspect
public class SelectLogAspect {
    
    
    public Object outputCrudServiceLogging(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        
        try {
            Signature signature = proceedingJoinPoint.getSignature();
            
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            
            log.info("------------ SelectLogAspect Request Service Method: {}", signature.toShortString());
            log.info("------------ SelectLogAspect Request Service Method Execution Time: {}", (end - start));
        } catch (Throwable throwable) {
            if (log.isErrorEnabled()) {
                log.error("------------ SelectLogAspect outputCrudServiceLogging(Aspect) ERROR !! {}", throwable.getMessage());
            }
        }
        
        return result;
    }
    
}
