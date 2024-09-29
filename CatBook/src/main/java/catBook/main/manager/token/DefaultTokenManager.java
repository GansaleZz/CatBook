package catBook.main.manager.token;

import catBook.main.bean.token.Token;
import catBook.main.hibernate.DAO.token.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DefaultTokenManager extends TokenManager {

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private TokenDAO tokenDAO;

    @Override
    public String processToken(String source) {
        Pattern p = Pattern.compile("\\[\\[(.*?)\\]\\]");
        Matcher m = p.matcher(source);

        while(m.find())
        {
            String tokenName = "[[" + m.group(1) + "]]";
            Token token = findByTokenValue(tokenName);
            TokenProcessHandler tokenProcessHandler = tokenHandler.getTokenProcessHandlers()
                    .get(token.getHandler().getID());
            String processedToken = tokenProcessHandler.processToken(tokenName);
            source = source.replace(tokenName, processedToken);
        }

        return source;
    }

    @Override
    public Token findByTokenValue(String tokenValue) {
        return tokenDAO.findByTokenValue(tokenValue);
    }
}
