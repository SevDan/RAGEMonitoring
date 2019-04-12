import listentities.RageServerEntity;
import loaders.ListLoader;
import loaders.RageMasterListLoader;
import org.junit.Test;
import parsers.RageJSONListParser;

import java.io.IOException;
import java.util.List;

public class RussianServersTest {

    @Test
    public void test() throws IOException {
        ListLoader loader = new RageMasterListLoader();
        loader.loadMasterList();
        RageJSONListParser parser = new RageJSONListParser();
        List<RageServerEntity> list = parser.parseList(loader.getMasterListJSON());
        list.stream()
                .filter(x -> x.getEntity().getLang().toLowerCase().contains("ru"))
                .sorted((x,y) -> Integer.compare(y.getEntity().getPeak(), x.getEntity().getPeak()))
                .forEach(
                        x -> System.err.println(
                                        x.getEntity().getPeak() + " " +
                                        x.getFullAddress() + " " +
                                        x.getEntity().getLang() + " " +
                                        x.getEntity().getName() + " " +
                                        x.getEntity().getUrl()
                        )
                );

    }
}
