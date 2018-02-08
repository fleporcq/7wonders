package model.bonuses;

import model.Bonus;
import model.wonderboards.WonderBoard;

import java.util.Arrays;
import java.util.List;

public class MultiScientificSymbol implements Bonus {

    private List<ScientificSymbol> scientificSymbols;

    public MultiScientificSymbol(ScientificSymbol... scientificSymbols) {
        if (scientificSymbols == null || scientificSymbols.length < 2)
            throw new IllegalArgumentException("A multi scientific symbol must be contains at least 2 symbols");
        this.scientificSymbols = Arrays.asList(scientificSymbols);
    }

    public List<ScientificSymbol> getScientificSymbols() {
        return scientificSymbols;
    }

    @Override
    public void applyInstant(WonderBoard wonderBoard) {
        wonderBoard.addMultiScientificSymbol(this);
    }
}
