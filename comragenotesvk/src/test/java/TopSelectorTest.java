import listentities.RageServerEntity;
import loaders.ListLoader;
import loaders.RageMasterListLoader;
import org.junit.Test;
import parsers.JSONListParser;
import parsers.RageJSONListParser;
import selectors.RageTopSelector;
import selectors.TopSelector;

import java.io.IOException;
import java.util.List;

public class TopSelectorTest {

    @Test
    public void test() throws IOException {
        ListLoader loader = new RageMasterListLoader();
        loader.loadMasterList();
        String jsonList = loader.getMasterListJSON();

        JSONListParser<RageServerEntity> parser = new RageJSONListParser();
        List<RageServerEntity> serversList = parser.parseList(jsonList);

        TopSelector<RageServerEntity> selector = new RageTopSelector();
        List<RageServerEntity> top = selector.selectTop(serversList, RageServerEntity::compareTo, 10);

        top.forEach(
                x -> System.out.println(
                        " " + x.getFullAddress() + " " +
                                x.getEntity().getName() + " " +
                                x.getEntity().getPlayers() + "/" +
                                x.getEntity().getPeak() + " " +
                                x.getEntity().getUrl()
                )
        );
    }
}
