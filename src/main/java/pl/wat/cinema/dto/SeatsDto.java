package pl.wat.cinema.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonDeserialize(builder = SeatsDto.SeatsDtoBuilder.class)
public class SeatsDto implements Comparable<SeatsDto> {

    private Integer idSeat;
    private int row;
    private int place;
    private boolean taken;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SeatsDtoBuilder {
    }

    @Builder
    public SeatsDto(Integer idSeat, int place, int row, boolean taken) {
        this.idSeat = idSeat;
        this.row = row;
        this.place = place;
        this.taken = taken;
    }


    @Override
    public int compareTo(SeatsDto o) {
        return this.getPlace() - o.getPlace();
    }


}
