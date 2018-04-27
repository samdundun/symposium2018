package rpg;

public interface IState {

    public void onEnter();
    public void onExit();
	public Tile getTile(int x, int y);
}
