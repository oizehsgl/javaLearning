package org.oizehsgl.sub.jpa;

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
