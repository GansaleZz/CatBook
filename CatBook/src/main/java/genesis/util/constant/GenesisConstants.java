package genesis.util.constant;

import java.time.LocalDateTime;

/**
 * Application constants.
 *
 * @author GansaleZz
 */
public final class GenesisConstants {

    public static int EMPTY_INT = Integer.MIN_VALUE;
    public static long EMPTY_LONG = EMPTY_INT;
    public static int INTEGER_MAX = Integer.MAX_VALUE;
    public static LocalDateTime EMPTY_DATE = LocalDateTime.MAX;

    public static long SYSTEM_USER_ID = -1;

    // Handler ID
    public static long CURRENT_USER_TOKEN_HANDLER_ID = 1;

    // Locale ID
    public static long LOCALE_ENGLISH_ID = 1;
    public static long LOCALE_RUSSIAN_ID = 2;

    // User Role ID
    public static long USER_ADMIN_ROLE_ID = 1;
    public static long USER_CONFIG_ROLE_ID = 2;
    public static long USER_CLIENT_ROLE_ID = 3;

    // Validation
    //TODO: Localisation of messages
    public static String VALIDATION_EMPTY_FIELD = "Field '%s' shouldn't be empty.";
    public static String VALIDATION_INVALID_ID = "ID defined on '%s' with value '%d' is incorrect.";
    public static String VALIDATION_USER_WITH_USERNAME_EXISTS = "User with username '%s' already exists";
    public static String VALIDATION_STRING_TOO_LONG = "Length of field '%s' shouldn't be greater than %d chars.";
}
