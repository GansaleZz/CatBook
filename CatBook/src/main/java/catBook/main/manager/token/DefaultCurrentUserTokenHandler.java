package catBook.main.manager.token;

import catBook.main.manager.application.ApplicationSessionHelper;
import genesis.util.constant.GenesisConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCurrentUserTokenHandler implements TokenProcessHandler {

    @Autowired
    private ApplicationSessionHelper applicationSessionHelper;

    @Override
    public long getHandlerID() {
        return GenesisConstants.CURRENT_USER_TOKEN_HANDLER_ID;
    }

    @Override
    public String processToken(String source) {
        return applicationSessionHelper.getUser().getDisplayName();
    }
}
