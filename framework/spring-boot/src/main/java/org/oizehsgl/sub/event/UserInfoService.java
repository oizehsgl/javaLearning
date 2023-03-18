package org.oizehsgl.sub.event;

/**
 * userInfoService
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public interface UserInfoService {
    UserInfo create(UserInfo userInfo);
    UserInfo findOne(Long id);
}
