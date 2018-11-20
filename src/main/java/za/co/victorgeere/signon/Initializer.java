package za.co.victorgeere.signon;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import za.co.victorgeere.signon.config.SessionConfig;

public class Initializer  extends AbstractHttpSessionApplicationInitializer {
	public Initializer() {
        super(SessionConfig.class);
    }
}
