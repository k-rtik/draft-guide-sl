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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;

public class EndpointIT {

    @Test
    public void testHelloRedirectsToSocialLoginForm() {

        String url = "http://localhost:" + System.getProperty("http.port") + "/" + System.getProperty("context.root") + "/";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url + "hello");
        Response response = target.request().get();

        assertEquals("Incorrect response code from " + url,
                Response.Status.OK.getStatusCode(), response.getStatus());

        String message = response.readEntity(String.class);
        String expectedMessage = "Social Media Selection Form";

        assertTrue("Incorrect message in response from " + url, message.contains(expectedMessage));
        response.close();
    }
}
