package updaters.widgetcodegenerator;

import listentities.RageServerEntity;
import loaders.ListLoader;
import parsers.JSONListParser;
import selectors.TopSelector;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.List;

public class WidgetCodeGenerator implements CodeGenerator {

    private final static int TOP_COUNT = 10;

    private ListLoader loader;
    private JSONListParser<RageServerEntity> parser;
    private TopSelector<RageServerEntity> selector;

    private List<RageServerEntity> content;

    @Override
    public String getCode() {
        throw new NotImplementedException();
    }

    @Override
    public void init(ListLoader loader, JSONListParser<RageServerEntity> parser, TopSelector<RageServerEntity> selector) {
        this.loader = loader;
        this.parser = parser;
        this.selector = selector;
        update();
    }

    @Override
    public void update() {
        try {
            loader.loadMasterList();
            String jsonList = loader.getMasterListJSON();

            List<RageServerEntity> list = parser.parseList(jsonList);
            content = selector.selectTop(list, (x, y) -> x.compareTo(y), TOP_COUNT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
