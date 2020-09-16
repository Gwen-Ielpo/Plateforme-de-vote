package multimif.grpc.model;

public abstract class Result {

    protected TurnOption option;

    public Result(TurnOption option) {
        this.option = option;
    }

    public TurnOption getOption() {
        return option;
    }

}
