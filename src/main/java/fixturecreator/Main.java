package fixturecreator;

import fixturecreator.models.Match;
import fixturecreator.models.Team;
import fixturecreator.provider.FixtureProvider;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        HashSet<Match> fixture = new HashSet<>();

        LinkedHashSet<Team> teams = FixtureProvider.readTeams();

        for (Team t1 : teams) {
            for (Team t2 : teams) {
                if (Objects.equals(t1, t2)) continue;

                Match match = new Match(t1, t2);
                fixture.add(match);
            }
        }

        LinkedHashSet<Match> shuffledFixture = FixtureProvider.shuffleFixture(fixture);
        FixtureProvider.printFixtureByRounds(shuffledFixture);
    }
}