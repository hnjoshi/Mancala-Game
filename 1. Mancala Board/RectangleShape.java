/**
 *
 * @author Jagrut
 * @author Hardik Joshi
 * @author Hai Nguyen
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;


public class RectangleShape implements Icon
{
	private int size;
	int x,y;
	private int height;
	private int width;
	Color color = Color.YELLOW;
	
	// Constructor
	public RectangleShape()
	{
		size = 0;
		width = 0;
		height = 0;
	}
	
	/**
	 * Sets radius, width and height Constructor.
	 * 
	 * @param radii
	 * @param x
	 * @param y
	 */
	public RectangleShape(int x, int y, int height, int width)
	{
		this.x = x; 
		this.y = y;
		this.height = height; 
		this.width =  width; 
	}
	
	/**
	 * Sets color.
	 * 
	 * @param m
	 */
	public void changeTheColorTo(Color m)
	{
		this.color = m;
	}
	
	/**
	 * Gets size.
	 * 
	 * @return size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * PaintIcon method
	 * 
	 * @param c
	 * @param g
	 * @param w
	 * @param h
	 */
	public void paintIcon(Component c, Graphics g, int w, int h)
	{
		Graphics2D g2 = (Graphics2D) g;
		//Ellipse2D.Double e = new Ellipse2D.Double(w,h,this.size,this.size);
		Rectangle2D.Double e = new Rectangle2D.Double(x,y,width,height);
		g2.setColor(this.color);
		g2.fill(e);
	}
	
	@Override
	/**
	 * Gets Icon Height.
	 * 
	 * @return height
	 */
	public int getIconHeight()
	{
		// TODO Auto-generated method stub
		return height;
	}
	
	@Override
	/**
	 * Gets Icon Width.
	 * 
	 * @return width
	 */
	public int getIconWidth()
	{
		// TODO Auto-generated method stub
		return width;
	}
}
