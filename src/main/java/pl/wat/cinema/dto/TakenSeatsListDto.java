package pl.wat.cinema.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonDeserialize(builder = SeatsDto.SeatsDtoBuilder.class)
public class TakenSeatsListDto {
    private Integer rowId;
    private List<SeatsDto> seats;


    @JsonPOJOBuilder(withPrefix = "")
    public static class SeatsDtoBuilder {
    }

    public TakenSeatsListDto(Integer rowId, List<SeatsDto> listOfSeats){

    }
}
