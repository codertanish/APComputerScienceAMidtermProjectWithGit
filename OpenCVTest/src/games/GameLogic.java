package games;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface GameLogic {
public default void endCondition() {}

public default void startGame() {}

public default void endGame() {}

public default boolean getStatus() {
	return false;
}
public default void init() {
	
}

}
