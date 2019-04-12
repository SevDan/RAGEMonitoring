package updaters.widgetcodegenerator;

import listentities.RageServerEntity;
import loaders.ListLoader;
import parsers.JSONListParser;
import selectors.TopSelector;

public interface CodeGenerator {
    void init(ListLoader loader, JSONListParser<RageServerEntity> parser, TopSelector<RageServerEntity> selector);
    void update();
    String getCode();
}
