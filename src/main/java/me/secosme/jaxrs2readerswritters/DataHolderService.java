package me.secosme.jaxrs2readerswritters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("dataholder")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataHolderService {

    // http://localhost:9080/jaxrs2-readers-writters/service/dataholder/jaxb
    @GET
    @Path("/jaxb")
    public JaxbDataHolderDTO jaxb() {
        return JaxbDataHolderDTO.builder()
            .date(LocalDate.now())
            .time(LocalTime.now())
            .timestamp(LocalDateTime.now())
            .build();
    }

    // http://localhost:9080/jaxrs2-readers-writters/service/dataholder/jaxb-list
    @GET
    @Path("/jaxb-list")
    public List<JaxbDataHolderDTO> jaxbl() {
        return Arrays.asList(
            JaxbDataHolderDTO.builder()
                .date(LocalDate.now())
                .time(LocalTime.now())
                .timestamp(LocalDateTime.now())
                .build());
    }

    // http://localhost:9080/jaxrs2-readers-writters/service/dataholder/converter-bean?date=2019-02-21&time=15:30:45&timestamp=2019-02-21%2015:30:45
    @GET
    @BeanParam
    @Path("/converter-bean")
    public JaxRSParamDataHolderDTO converter(@BeanParam JaxRSParamDataHolderDTO holder) {
        System.out.println(
            String.format("%s - %s - %s",
                holder.getDate(),
                holder.getTime(),
                holder.getTimestamp()));
        return holder;
    }

    // http://localhost:9080/jaxrs2-readers-writters/service/dataholder/converter-query?date=2019-02-21&time=15:30:45&timestamp=2019-02-21%2015:30:45
    @GET
    @BeanParam
    @ApplyConverter
    @Path("/converter-query")
    public JaxRSParamDataHolderDTO converter(
        @QueryParam("date") LocalDate date,
        @QueryParam("time") LocalTime time,
        @QueryParam("timestamp") LocalDateTime timestamp) {
        System.out.println(
            String.format("%s - %s - %s",
                date,
                time,
                timestamp));
        return JaxRSParamDataHolderDTO.builder()
            .date(date)
            .time(time)
            .timestamp(timestamp)
            .build();
    }

    // http://localhost:9080/jaxrs2-readers-writters/service/dataholder/converter-query-list?date=2019-02-21&time=15:30:45&timestamp=2019-02-21%2015:30:45
    @GET
    @BeanParam
    @ApplyConverter
    @Path("/converter-query-list")
    public List<JaxRSParamDataHolderDTO> converterl(
        @QueryParam("date") LocalDate date,
        @QueryParam("time") LocalTime time,
        @QueryParam("timestamp") LocalDateTime timestamp) {
        System.out.println(
            String.format("%s - %s - %s",
                date,
                time,
                timestamp));
        return Arrays.asList(
            JaxRSParamDataHolderDTO.builder()
                .date(date)
                .time(time)
                .timestamp(timestamp)
                .build());
    }

}
