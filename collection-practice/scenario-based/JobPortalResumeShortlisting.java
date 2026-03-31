import java.util.*;

class InvalidResumeException extends Exception {
    public InvalidResumeException(String message) {
        super(message);
    }
}

class Resume {
    String name;
    Set<String> skills;

    public Resume(String name, Set<String> skills) throws InvalidResumeException {
        if (skills == null || skills.isEmpty()) {
            throw new InvalidResumeException("Resume must have at least one skill");
        }
        this.name = name;
        this.skills = skills;
    }

    public int getMatchingSkillCount(Set<String> requiredSkills) {
        int count = 0;
        for (String skill : skills) {
            if (requiredSkills.contains(skill)) {
                count++;
            }
        }
        return count;
    }
}

public class JobPortalResumeShortlisting {

    public static void main(String[] args) {

        try {
            Set<String> requiredSkills = new HashSet<>();
            requiredSkills.add("Java");
            requiredSkills.add("Spring");
            requiredSkills.add("SQL");

            List<Resume> resumes = new ArrayList<>();

            resumes.add(new Resume("Steve", Set.of("Java", "Spring", "SQL")));
            resumes.add(new Resume("Natasha", Set.of("Java", "HTML")));
            resumes.add(new Resume("Bruce", Set.of("Python", "Django")));

            resumes.sort(new Comparator<Resume>() {
                @Override
                public int compare(Resume r1, Resume r2) {
                    return r2.getMatchingSkillCount(requiredSkills)
                            - r1.getMatchingSkillCount(requiredSkills);
                }
            });

            for (Resume r : resumes) {
                int score = r.getMatchingSkillCount(requiredSkills);
                if (score > 0) {
                    System.out.println(r.name + " -> Matching Skills: " + score);
                }
            }

        } catch (InvalidResumeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
