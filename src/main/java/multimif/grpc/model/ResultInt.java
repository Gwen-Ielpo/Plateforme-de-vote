package multimif.grpc.model;

public class ResultInt extends Result {

    private int score;

    public ResultInt(TurnOption option, int score) {
        super(option);
        this.score = score;
    }

    int getScore ()
    {
        return score;
    }

    void setScore (int score)
    {
        this.score = score;
    }

}
