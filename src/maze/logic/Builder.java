package maze.logic;

import java.io.Serializable;

public interface Builder extends Serializable {

	public void makePath(int n);

	public void makeExit(int n);

	public void removeBorders(int n);
}
