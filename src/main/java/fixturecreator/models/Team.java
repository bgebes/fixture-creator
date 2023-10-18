package fixturecreator.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Team {
    private int id;
    private String name;

    public static int lastID = -1;
    public static int count = 0;

    public Team(String name) {
        this.id = ++lastID;
        this.name = name;

        count++;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Team) {
            return Objects.equals(this.name, ((Team) obj).getName());
        }

        return super.equals(obj);
    }
}