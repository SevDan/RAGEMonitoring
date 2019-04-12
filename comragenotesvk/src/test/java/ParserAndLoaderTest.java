import listentities.RageServerEntity;
import loaders.ListLoader;
import loaders.RageMasterListLoader;
import org.junit.Test;
import parsers.RageJSONListParser;

import java.io.IOException;
import java.util.List;

public class ParserAndLoaderTest {

    @Test
    public void test() throws IOException {
        ListLoader loader = new RageMasterListLoader();
        loader.loadMasterList();
        RageJSONListParser parser = new RageJSONListParser();
        List<RageServerEntity> list = parser.parseList(loader.getMasterListJSON());
        list.sort(RageServerEntity::compareTo);
        for(int i = 0; i < 10; ++i) {
            RageServerEntity entity = list.get(i);
            System.err.println("ParserAndLoaderTest: " +
                    "IP = " + entity.getFullAddress() + "  " +
                    "Name = " + entity.getEntity().getName() + "   " +
                    "Online = " + entity.getEntity().getPlayers() + "/" +
                    entity.getEntity().getMaxplayers() + "   " +
                    "Peak = " + entity.getEntity().getPeak()
            );
        }
    }
}
