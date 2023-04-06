package org.oizehsgl.sub.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * userInfoServiceImpl
 *
 * @author oizehsgl
 * @since 3/18/23
 */
@Slf4j
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final EmailDetailRepository emailDetailRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfo create(UserInfo userInfo) {
        Long begin = System.currentTimeMillis();
        userInfoRepository.save(userInfo);
        //applicationEventPublisher.publishEvent(new SendEmailEvent(this, userInfo.getId()));
        Long end = System.currentTimeMillis();
        return userInfo;
    }

    @Override
    public UserInfo findOne(Long id) {
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(id);
        List<UserInfo> userInfos= userInfoRepository.findAll();
        return optionalUserInfo.orElse(new UserInfo());
    }
}
