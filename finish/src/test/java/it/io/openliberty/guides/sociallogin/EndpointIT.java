// tag::comment[]
/*******************************************************************************
 * Copyright (c) 2017, 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
// end::comment[]
package it.io.openliberty.guides.sociallogin;

import org.junit.jupiter.api.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EndpointIT {

    @Test
    void testHelloRedirectsToSocialLoginForm() {

        // Construct URL for protected service
        String url = "http://localhost:" + System.getProperty("http.port") + "/" + System.getProperty("context.root") + "/hello";

        // Get response from service
        Response response = ClientBuilder.newClient()
                .target(url)
                .request()
                .get();

        // Service must get 200
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(), "Incorrect response code from " + url);

        // The response must be the selection form for social media login provider
        String message = response.readEntity(String.class);
        String expectedMessage = "Social Media Selection Form";
        assertTrue(message.contains(expectedMessage), "Incorrect response from " + url + ". Did not redirect to social login form");

        response.close();
    }
}
