import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Random;

import javax.swing.Icon;

/*
	This fancy theme implements BoardTheme.
	Author: Hai Tan Nguyen
*/

public class FancyTheme implements BoardTheme
{
	@Override
	public Color getBoardColor() 
	{
		return Color.BLACK;	
	}

	@Override
	public Color getPitColor() 
	{
		return Color.GREEN;
	}

	@Override
	public Object myShape() 
	{
		return new Rectangle2D.Float(0,0,99,99);
	}

	@Override
	public Color getMancalaColor()
	{
		return Color.RED;
	}





}
