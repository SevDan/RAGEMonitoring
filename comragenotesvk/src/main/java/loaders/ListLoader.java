package loaders;

import java.io.IOException;

public interface ListLoader {
    void loadMasterList() throws IOException;
    String getMasterListJSON();
}
