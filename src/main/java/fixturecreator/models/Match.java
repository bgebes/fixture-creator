package fixturecreator.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Match {
    public Team home;
    public Team away;

    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    @Override
    public String toString() {
        return String.format("%s vs %s", home.getName(), away.getName());
    }
}

