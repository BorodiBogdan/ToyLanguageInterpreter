package Repository;

import model.Structures.PrgState;

public class ProgramRepository implements IRepository{
    private final PrgState curentState;

    public ProgramRepository(PrgState cs) {
        curentState = cs;
    }

    @Override
    public PrgState getCurentState() {
        return curentState;
    }
}
