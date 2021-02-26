public class PastoralPlay extends Play{
    public PastoralPlay(String name) {
        super(name);
    }

    @Override
    public int getAmount(Performance perf) {
        throw new Error("unknown type: ${play.type}");
    }
}
