package updaters;

public interface Updater {
    void init(int groupId, String token);
    void update();
}
