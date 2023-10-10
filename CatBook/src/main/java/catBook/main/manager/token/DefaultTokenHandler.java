package catBook.main.manager.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTokenHandler extends TokenHandler {

    @Autowired
    public DefaultTokenHandler(List<TokenProcessHandler> tokenProcessHandlers) {
        tokenProcessHandlers.forEach(tokenProcessHandler ->
                getTokenProcessHandlers().put(tokenProcessHandler.getHandlerID(), tokenProcessHandler));
    }
}
