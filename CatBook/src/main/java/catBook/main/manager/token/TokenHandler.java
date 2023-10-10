package catBook.main.manager.token;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class TokenHandler {

    private Map<Long, TokenProcessHandler> tokenProcessHandlers = new HashMap<>();
}
