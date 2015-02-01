
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.Icon;
public class CircleShape implements Icon
{
   private int radius;
   private int height;
   private int width; 
   private int startingStones;
   
   public CircleShape(int r)
   {
      radius = r; 
   }
   public CircleShape(int r, int h, int w, int c )
   {
      radius = r; 
      height = h; 
      width  = w; 
      startingStones = c; 
   }
   @Override
   public void paintIcon(Component c, Graphics g, int x, int y) 
   {
      Graphics2D draw = (Graphics2D) g;
      Ellipse2D.Double circle = new Ellipse2D.Double (x,y,radius,radius);
      draw.setColor(Color.yellow);
      draw.fill(circle);
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
