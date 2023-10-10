package catBook.main.manager.application;

import catBook.main.bean.locale.Locale;
import catBook.main.bean.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Helper that contains data about user that has done the request.
 *
 * @author GansaleZz
 */
@Component
@Getter
@Setter
@RequestScope
public class ApplicationSessionHelper {

    private User user;

    private Locale locale;
}
