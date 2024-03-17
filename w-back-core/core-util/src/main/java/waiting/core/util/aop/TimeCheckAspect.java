package waiting.core.util.aop;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TimeCheckAspect {

    @Around("@annotation(waiting.core.util.annotation.TimeCheck)")
    public Object DurationTimeCheck(ProceedingJoinPoint pjp) throws Throwable {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = null;

        Boolean isException = false;

        UUID requestTimeCheckId = UUID.randomUUID();
        log.info("[{}] : TimeCheck Calling Method >>> {}.{}", requestTimeCheckId, pjp.getSignature().getDeclaringTypeName(),
            pjp.getSignature().getName());

        try {
            Object obj = pjp.proceed();
            endTime = LocalDateTime.now();
            isException = false;
            return obj;
        }
        catch (Exception e) {
            endTime = LocalDateTime.now();
            log.error("[{}] : TimeCheck Exception Occurred >>> {}", requestTimeCheckId, e.getMessage(), e);
            isException = true;
            throw e;
        }
        finally {
            Duration duration = Duration.between(startTime, endTime);

            if(isException)
                log.error("[{}] : Duration >>> {}ms, StartTime >>> {}, EndTime >>> {}, Exception Occurred", requestTimeCheckId,
                    duration.toMillis(), startTime, endTime);
            else {
                log.info("[{}] : Duration >>> {}ms, StartTime >>> {}, EndTime >>> {}", requestTimeCheckId,
                    duration.toMillis(), startTime, endTime);
            }
        }
    }

}
