package com.tendril.cleanweb.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.tendril.cleanweb.domain.tendril.TendrilLocation;
import com.tendril.cleanweb.domain.tendril.TendrilUser;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.core.MediaType;

/**
 */
public class TendrilClient {

    private Provider<Client> clientProvider;

    @Inject
    public TendrilClient(Provider<Client> clientProvider) {
        this.clientProvider = clientProvider;
    }

    public TendrilUser getUser(String username, String password) throws Exception {
        Client c = clientProvider.get();
        c.addFilter(new HTTPBasicAuthFilter(username, password));
        WebResource webResource = c.resource("https://dev-program.tendrildemo.com/api/rest/user/current-user");
        TendrilUser user = webResource.type(MediaType.APPLICATION_JSON_TYPE).get(TendrilUser.class);

        return user;
    }

    public TendrilLocation getLocation(String username, String password) {
        Client c = clientProvider.get();
        c.addFilter(new HTTPBasicAuthFilter(username, password));
        WebResource webResource = c.resource("https://dev-program.tendrildemo.com/api/rest/user/current-user/account/default-account/location/default-location");

        TendrilLocation location = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(TendrilLocation.class);

        return location;
    }

}