package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame
{
    Splash()
    {
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/splash/Splash.jpg"));
        Image imageone=imageIcon.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon imageicon2=new ImageIcon(imageone);
        JLabel imagelabel=new JLabel(imageicon2);//Inorder to show the image we have to use JLabel
        add(imagelabel);



        setSize(600,400);
        setLocation(500,200);
        setVisible(true);

        try
        {
            Thread.sleep(3000);//Here our screen will upto 3 seconds.
            setVisible(false); //After 3 seconds frame will be closed automatically.

            new Login(); //After 3sec it will open login frame
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new Splash();
    }
}
