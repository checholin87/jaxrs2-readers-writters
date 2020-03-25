package me.secosme.jaxrs2readerswritters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JaxRSParamDataHolderDTO {
    @QueryParam("date")
    private LocalDate date;
    @QueryParam("time")
    private LocalTime time;
    @QueryParam("timestamp")
    private LocalDateTime timestamp;
}
