package objectsClasses_Exe.teamworkProjects_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ChaosFire on 12.10.2017 г.
 */
public class TeamworkProjects {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        Map<String, Team> teamsByName = new HashMap<>();
        Map<String, Team> teamsByCreator = new HashMap<>(count);
        Map<String, Team> teamsByNameInvalid = new TreeMap<>();
        StringBuilder output = new StringBuilder(1_000_000);
        for (int i = 0; i < count; i++) {
            Team team = parseTeam(reader.readLine().split("-"));
            if (teamsByName.containsKey(team.getTeamName())) {
                output.append(String.format("Team %s was already created!", team.getTeamName())).append(System.lineSeparator());
            } else {
                if (teamsByCreator.containsKey(team.getCreator())) {
                    output.append(String.format("%s cannot create another team!", team.getCreator())).append(System.lineSeparator());
                } else {
                    output.append(String.format("Team %s has been created by %s!", team.getTeamName(), team.getCreator()))
                            .append(System.lineSeparator());
                    teamsByName.put(team.getTeamName(), team);
                    teamsByNameInvalid.put(team.getTeamName(), team);
                    teamsByCreator.put(team.getCreator(), team);
                }
            }
        }

        Map<String, Team> teamsByNameValid = new TreeMap<>();
        String input = reader.readLine();
        while (!input.equals("end of assignment")) {
            String[] data = input.split("->");
            String user = data[0];
            String teamName = data[1];
            if (!teamsByName.containsKey(teamName)) {
                output.append(String.format("Team %s does not exist!", teamName)).append(System.lineSeparator());
            } else {
                if (userHasTeam(user, teamsByCreator.values())) {
                    output.append(String.format("Member %s cannot join team %s!", user, teamName)).append(System.lineSeparator());
                } else {
                    Team team = teamsByName.get(teamName);
                    if (team.getMembers().size() == 0) {
                        teamsByNameValid.put(teamName, teamsByNameInvalid.remove(teamName));
                    }
                    team.getMembers().add(user);

                }
            }

            input = reader.readLine();
        }
        reader.close();

        teamsByNameValid.values()
                .stream()
                .sorted((team1, team2) -> Integer.compare(team2.getMembers().size(), team1.getMembers().size()))
                .forEach(team -> {
                    output.append(team.getTeamName()).append(System.lineSeparator());
                    output.append("- ").append(team.getCreator()).append(System.lineSeparator());
                    Set<String> members = team.getMembers();
                    for (String member : members) {
                        output.append("-- ").append(member).append(System.lineSeparator());
                    }
                });
        output.append("Teams to disband:");
        Collection<Team> teamsToDisband = teamsByNameInvalid.values();
        for (Team team : teamsToDisband) {
            output.append(System.lineSeparator()).append(team.getTeamName());
        }
        System.out.print(output);
    }

    private static boolean userHasTeam(String user, Collection<Team> teams) {
        for (Team team : teams) {
            if (team.getMembers().contains(user) || team.getCreator().equals(user)) {
                return true;
            }
        }
        return false;
    }

    private static Team parseTeam(String[] data) {
        return new Team(data[1], data[0]);
    }
}

class Team {

    private String teamName;
    private String creator;
    private Set<String> members;

    Team(String teamName, String creator) {
        this.setTeamName(teamName);
        this.setCreator(creator);
        this.setMembers(new TreeSet<>());
    }

    String getTeamName() {
        return this.teamName;
    }

    private void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    String getCreator() {
        return this.creator;
    }

    private void setCreator(String creator) {
        this.creator = creator;
    }

    Set<String> getMembers() {
        return this.members;
    }

    private void setMembers(Set<String> members) {
        this.members = members;
    }
}