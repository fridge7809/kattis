
public class Party implements Comparable<Party> {
    private int id;
    private int votesCount;
    private int seatsAllocated;

    public Party(int votesCount, int id) {
        this.id = id;
        this.votesCount = votesCount;
    }

    @Override
    public int compareTo(Party o) {
        return (int) Double.compare(quotient(), o.quotient());
    }

    public double quotient() {
        return (double) votesCount / (double) (seatsAllocated + 1);
    }

    public void allocateSeat() {
        seatsAllocated++;
    }

    public int getVotesCount() {
        return votesCount;
    }

    public int getSeatsAllocated() {
        return seatsAllocated;
    }

    public int getId() {
        return id;
    }

}
