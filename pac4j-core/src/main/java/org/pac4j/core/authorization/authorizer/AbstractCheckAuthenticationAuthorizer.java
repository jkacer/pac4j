package org.pac4j.core.authorization.authorizer;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.profile.CommonProfile;

/**
 * Check the authentication of the user.
 *
 * @author Jerome Leleu
 * @since 1.9.0
 */
public abstract class AbstractCheckAuthenticationAuthorizer<U extends CommonProfile> extends ProfileAuthorizer<U> {

    private String redirectionUrl;

    public AbstractCheckAuthenticationAuthorizer() {}

    public AbstractCheckAuthenticationAuthorizer(final String redirectionUrl) {
        this.redirectionUrl = redirectionUrl;
    }

    @Override
    protected boolean handleError(final WebContext context) {
        if (this.redirectionUrl != null) {
            throw HttpAction.redirect(context, this.redirectionUrl);
        } else {
            return false;
        }
    }

    public String getRedirectionUrl() {
        return redirectionUrl;
    }

    public void setRedirectionUrl(final String redirectionUrl) {
        this.redirectionUrl = redirectionUrl;
    }
}
