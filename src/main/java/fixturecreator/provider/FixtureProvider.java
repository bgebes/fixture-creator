package fixturecreator.provider;

import fixturecreator.models.Match;
import fixturecreator.models.Team;

import java.util.*;

public class FixtureProvider {
    public static LinkedHashSet<Team> readTeams() {
        LinkedHashSet<Team> teams = new LinkedHashSet<>();

        Scanner input = new Scanner(System.in);
        System.out.println("------------ Teams ------------");

        while (true) {
            String team = input.nextLine().trim();
            if (team.isEmpty()) {
                break;
            }

            if (teams.stream().filter(t -> Objects.equals(t.getName(), team)).findFirst().isEmpty()) {
                teams.add(new Team(team));
            }
        }

        Team.count = teams.size();

        if (Team.count % 2 != 0) {
            teams.add(new Team("Bay"));
        }

        return teams;
    }

    public static LinkedHashSet<Match> shuffleFixture(Set<Match> fixture) {
        List<Match> shuffleMe = new ArrayList<>(fixture);
        Collections.shuffle(shuffleMe);
        return new LinkedHashSet<>(shuffleMe);
    }

    public static void printFixtureByRounds(Set<Match> fixture) {
        int matchCountPerRound = Team.count / 2;
        int roundLength = fixture.size() / matchCountPerRound;

        Match[] fixtureArray = fixture.toArray(new Match[0]);

        for (int i = 0; i < roundLength; i++) {
            System.out.printf("Round %d\n", i + 1);

            // 27, 28, 29

            for (int j = i * matchCountPerRound; j < matchCountPerRound * (i + 1); j++) {
                System.out.println(fixtureArray[j]);
            }
        }
    }


}
