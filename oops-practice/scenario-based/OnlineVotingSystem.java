import java.util.*;

class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String message) {
        super(message);
    }
}

class Voter {
    int voterId;
    boolean hasVoted;

    Voter(int voterId) {
        this.voterId = voterId;
        this.hasVoted = false;
    }
}

class Candidate {
    int candidateId;
    String name;
    int votes;

    Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.votes = 0;
    }
}

class Vote {
    int voterId;
    int candidateId;

    Vote(int voterId, int candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }
}

abstract class ElectionService {
    abstract void registerVoter(Voter voter);
    abstract void addCandidate(Candidate candidate);
    abstract void castVote(int voterId, int candidateId) throws DuplicateVoteException;
    abstract void declareResult();
}

class ElectionServiceImpl extends ElectionService {

    private Map<Integer, Voter> voters = new HashMap<>();
    private Map<Integer, Candidate> candidates = new HashMap<>();
    private List<Vote> votes = new ArrayList<>();

    @Override
    void registerVoter(Voter voter) {
        voters.put(voter.voterId, voter);
    }

    @Override
    void addCandidate(Candidate candidate) {
        candidates.put(candidate.candidateId, candidate);
    }

    @Override
    void castVote(int voterId, int candidateId) throws DuplicateVoteException {
        Voter voter = voters.get(voterId);

        if (voter.hasVoted) {
            throw new DuplicateVoteException("Duplicate vote detected for voter: " + voterId);
        }

        voter.hasVoted = true;
        candidates.get(candidateId).votes++;
        votes.add(new Vote(voterId, candidateId));
    }

    @Override
    void declareResult() {
        System.out.println("Election Results:");
        for (Candidate c : candidates.values()) {
            System.out.println(c.name + " -> " + c.votes + " votes");
        }
    }
}

public class OnlineVotingSystem {
    public static void main(String[] args) {

        ElectionService election = new ElectionServiceImpl();

        election.registerVoter(new Voter(1));
        election.registerVoter(new Voter(2));

        election.addCandidate(new Candidate(101, "Jhon"));
        election.addCandidate(new Candidate(102, "Bruce"));

        try {
            election.castVote(1, 101);
            election.castVote(2, 102);
        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        election.declareResult();
    }
}
