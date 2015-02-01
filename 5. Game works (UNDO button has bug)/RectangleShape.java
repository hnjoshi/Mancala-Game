/**
 *      Name: Hardik Joshi
 *     Class: CS 151
 * Professor: Dr. Kim
 *   Section: 9:00am to 10:15am
 *       HW2: Button
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.Icon;


public class RectangleShape implements Icon
{
	private int size;
	int x,y;
	private int height;
	private int width;
	Color color = Color.YELLOW;
	private int startingStones;
	
	private int radius=100;
	
	// Constructor
	public RectangleShape()
	{
		size = 0;
		width = 0;
		height = 0;
		startingStones = 0;
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
		Rectangle2D.Double e = new Rectangle2D.Double(x,y,width,height);
		g2.setColor(this.color);
		g2.fill(e);
		
		
		
		Graphics2D draw = (Graphics2D) g;
      Ellipse2D.Double circle = new Ellipse2D.Double (x,y,radius,radius);
		
		int random = -30 + (int)(Math.random() * ((20 - (-30)) + 1));
      Random randoming = new Random(); 
              
      for(int i=0; i<startingStones; i++)
      {
      
         int red = randoming.nextInt(255); 
         int green = randoming.nextInt(255); 
         int blue = randoming.nextInt(255); 
         
         Color randomColor = new Color(red, green, blue); 
         Ellipse2D.Double tempCircle = new Ellipse2D.Double 
                 (circle.getCenterX()+random,circle.getCenterY()+random,radius/6,radius/6);
         if(randomColor.equals(Color.YELLOW))
         {
            randomColor = Color.RED;
         }
         draw.setColor(randomColor);
         draw.fill(tempCircle);
         random = -30 + (int)(Math.random() * ((20 - (-30)) + 1));
      }
		
		
		
		
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
	
	public int getStones()
   {
   	return startingStones;
   }
	
	public void setStones(int x)
   {
   	startingStones = x;
   }
}
