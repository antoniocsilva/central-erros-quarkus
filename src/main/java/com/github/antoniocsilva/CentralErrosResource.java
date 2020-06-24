package com.github.antoniocsilva;

import com.github.antoniocsilva.entity.LogError;
import com.github.antoniocsilva.enums.Level;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Path("/errors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CentralErrosResource {

    @GET
    public Map<Level, Long> allLogErrorLevel(){

        Stream<LogError> logErrorStream = LogError.streamAll();

        return logErrorStream.collect(Collectors.groupingBy(LogError::getLevel, Collectors.counting()));

    }
}