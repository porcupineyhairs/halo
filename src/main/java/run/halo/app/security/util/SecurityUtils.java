package run.halo.app.security.util;

import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import run.halo.app.model.entity.User;

/**
 * Security utilities.
 *
 * @author johnniang
 * @date 19-4-29
 */
public class SecurityUtils {

    /**
     * Access token cache prefix.
     */
    public final static String TOKEN_ACCESS_CACHE_PREFIX = "halo.admin.access.token.";

    /**
     * Refresh token cache prefix.
     */
    public final static String TOKEN_REFRESH_CACHE_PREFIX = "halo.admin.refresh.token.";

    public final static String ACCESS_TOKEN_CACHE_PREFIX = "halo.admin.access_token.";

    public final static String REFRESH_TOKEN_CACHE_PREFIX = "halo.admin.refresh_token.";

    public final static String TEMP_TOKEN_CACHE_PREFIX = "halo.temp.token.";


    private SecurityUtils() {
    }

    @NonNull
    public static String buildAccessTokenKey(@NonNull User user) {
        Assert.notNull(user, "User must not be null");

        return ACCESS_TOKEN_CACHE_PREFIX + user.getId();
    }

    @NonNull
    public static String buildRefreshTokenKey(@NonNull User user) {
        Assert.notNull(user, "User must not be null");

        return REFRESH_TOKEN_CACHE_PREFIX + user.getId();
    }

    @NonNull
    public static String buildTokenAccessKey(@NonNull String accessToken) {
        Assert.hasText(accessToken, "Access token must not be blank");

        return TOKEN_ACCESS_CACHE_PREFIX + accessToken;
    }

    @NonNull
    public static String buildTokenRefreshKey(@NonNull String refreshToken) {
        Assert.hasText(refreshToken, "Refresh token must not be blank");

        return TOKEN_REFRESH_CACHE_PREFIX + refreshToken;
    }

    @NonNull
    public static String buildTempTokenKey(@NonNull String tempToken) {
        Assert.hasText(tempToken, "Temporary token must not be blank");

        return TEMP_TOKEN_CACHE_PREFIX + tempToken;
    }
}
