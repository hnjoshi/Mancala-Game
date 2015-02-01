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
import javax.swing.Icon;
public class CircleShape implements Icon
{
   private int radius;
   private int height;
   private int width; 
   
   public CircleShape(int r)
   {
      radius = r; 
   }
   public CircleShape(int r, int h, int w)
   {
      radius = r; 
      height = h; 
      width  = w; 
   }
   @Override
   public void paintIcon(Component c, Graphics g, int x, int y) 
   {
      Graphics2D draw = (Graphics2D) g;
      Ellipse2D.Double circle = new Ellipse2D.Double (x,y,radius,radius);
      draw.setColor(Color.yellow);
      draw.fill(circle);
   }

   @Override
   public int getIconWidth() 
   {
      return radius;
   }

   @Override
   public int getIconHeight() 
   {
      return radius; 
   }
   
}
