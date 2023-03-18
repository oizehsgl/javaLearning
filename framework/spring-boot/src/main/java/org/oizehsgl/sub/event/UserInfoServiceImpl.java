package org.oizehsgl.sub.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * userInfoServiceImpl
 *
 * @author oizehsgl
 * @since 3/18/23
 */
@Slf4j
@Service("userService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRespository userInfoRespository;
    private final EmailDetailRepository emailDetailRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfo create(UserInfo userInfo) {
        Long begin = System.currentTimeMillis();
        userInfoRespository.save(userInfo);
        applicationEventPublisher.publishEvent(new SendEmailEvent(this, userInfo.getId()));
        Long end = System.currentTimeMillis();
        return userInfo;
    }

    @Override
    public UserInfo findOne(Long id) {
        Optional<UserInfo> optionalUserInfo = userInfoRespository.findById(id);
        return optionalUserInfo.orElse(new UserInfo());
    }
}
