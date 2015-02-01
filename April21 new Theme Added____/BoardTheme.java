import java.awt.Color;
import java.awt.Shape;

import javax.swing.Icon;


public interface BoardTheme 
{
	public Color getBoardColor();
	public Color getPitColor();
	public Color getMancalaColor();
	public Object myShape(); 
	//public void setPitShape(Icon s);
}
