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
package io.openliberty.guides.rest;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("hello")
@RolesAllowed({"users"})
public class HelloService {

    @Context
    HttpServletRequest request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
        String remoteUser = request.getRemoteUser();
        String principalName = request.getUserPrincipal() == null ? null : request.getUserPrincipal().getName();

        String response = "Hello, " + (principalName == null ? "friend" : principalName + "!\n");
        response += "Your remote user is: " + remoteUser + "\n";

        return response;
    }

}
