package fixture;

import com.godeltech.l3pt1.annotation.InjectRandomValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InjectRandomValueFixture {
    @InjectRandomValue
    private String name;
    @InjectRandomValue
    private Boolean isMarried;
    @InjectRandomValue
    private Integer age;

}
