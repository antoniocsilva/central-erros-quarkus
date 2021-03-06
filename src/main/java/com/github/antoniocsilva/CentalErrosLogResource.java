package com.github.antoniocsilva;


import com.github.antoniocsilva.dto.LogDTO;
import com.github.antoniocsilva.entity.LogError;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;


@Path("/logs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Log Error")
@SecurityScheme(securitySchemeName = "central-oauth", type = SecuritySchemeType.OAUTH2, flows =
@OAuthFlows(password = @OAuthFlow(tokenUrl = "http://localhost:8180/auth/realms/central/protocol/openid-connect/token")))
@SecurityRequirement(name = "central-oauth")
public class CentalErrosLogResource {

    @GET
    public List<LogError> allLog(){
        return LogError.listAll();
    }

    @POST
    @Transactional
    public void adicionar(LogDTO dto){
        LogError logError = new LogError();
        logError.setLevel(dto.level);
        logError.setDescription(dto.description);
        logError.setEventLog(dto.eventLog);
        logError.setOrigin(dto.origin);
        logError.setQuantity(dto.quantity);
        logError.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void atualizar(@PathParam("id") long id, LogDTO dto){
        Optional<LogError> logErrorOptional = LogError.findByIdOptional(id);

        if(logErrorOptional.isPresent()) {

            LogError logError = logErrorOptional.get();
            logError.setLevel(dto.level);
            logError.setDescription(dto.description);
            logError.setEventLog(dto.eventLog);
            logError.setOrigin(dto.origin);
            logError.setQuantity(dto.quantity);
            logError.persist();

        }else{
            throw new NotFoundException();
        }

    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletar(@PathParam("id") long id){
        Optional<LogError> logErrorOptional = LogError.findByIdOptional(id);

        logErrorOptional.ifPresentOrElse(LogError::delete, () -> {
            throw new NotFoundException();
        });

    }
}
