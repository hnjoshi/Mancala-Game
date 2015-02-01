import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.Icon;


public class DefaultTheme implements BoardTheme
{

	public Color getBoardColor() 
	{
		return Color.GRAY;
	}

	@Override
	public Color getPitColor() 
	{
		return Color.blue;
	}

	@Override
	public Object myShape() 
	{
		return new Ellipse2D.Float(0, 0, 99, 99);
	}

	@Override
	public Color getMancalaColor() 
	{
		return Color.ORANGE;
	}


}


