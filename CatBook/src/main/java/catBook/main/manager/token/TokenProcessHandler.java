package catBook.main.manager.token;

public interface TokenProcessHandler {

    long getHandlerID();

    String processToken(String source);
}
