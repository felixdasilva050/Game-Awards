package domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    private Long id;
    private String name;
    private String description;
    private String cover;
    private long vote;

}
