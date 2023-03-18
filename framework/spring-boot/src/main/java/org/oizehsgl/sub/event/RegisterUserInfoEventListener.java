package org.oizehsgl.sub.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * registerUserInfoEventListener
 *
 * @author oizehsgl
 * @since 3/18/23
 */
@Slf4j
@Component
public class RegisterUserInfoEventListener {
    @Autowired
    private UserInfoRespository userInfoRespository;
    @Autowired
    private EmailDetailRepository emailDetailRepository;

    @EventListener
    @Async
    public void sendEmail(SendEmailEvent sendEmailEvent) {
        Optional<UserInfo> optionalUserInfo = userInfoRespository.findById(sendEmailEvent.getId());
        if (optionalUserInfo.isPresent()) {
            UserInfo userInfo = optionalUserInfo.get();
            log.info("userInfo<{}>", userInfo);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error(e.getLocalizedMessage());
            }
            emailDetailRepository.save(EmailDetail.builder()
                    .id(1L)
                    .userId(userInfo.getId())
                    .email(userInfo.getEmail())
                    .sendTime(new Date())
                    .build());
            log.info("email send over");
        }
    }
}
