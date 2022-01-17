package disney.challenge.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterFilterDTO {

    private String name;
    private Integer age;
    private Set<Long> movies;
    private String order;

    public boolean isASC() {
        return order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC() {
        return order.compareToIgnoreCase("DESC") == 0;
    }
}
