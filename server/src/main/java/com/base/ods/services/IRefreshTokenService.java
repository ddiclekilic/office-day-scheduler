package com.base.ods.services;

import com.base.ods.domain.RefreshToken;
import com.base.ods.domain.User;

public interface IRefreshTokenService {
    String createRefreshToken(User user);

    boolean isRefreshExpired(RefreshToken token);

    RefreshToken getByUser(Long userId);
}
