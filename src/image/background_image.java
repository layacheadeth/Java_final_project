package image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author madushanka
 */

//Creating extended class of JComponent class

class backImage extends JComponent {

    Image i;

    //Creating Constructer
    public backImage(Image i) {
        this.i = i;

    }

    //Overriding the paintComponent method
    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(i, 0, 0, null);  // Drawing image using drawImage method

    }
}

//Creating JFrame
public class background_image extends JFrame {

    public background_image() throws IOException {


// i have set size of JFrame to size of my image there for image will cover all the area of JFrame

        this.setSize(1024, 683);

        this.setTitle("JFrame with Background image");

// read image file in my HardDisk using imageIO and assign it to buffered image reference

        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

// adding created component to the JFrame using my backImage class


        this.setContentPane(new backImage(bf));

//adding other component

        JButton b = new JButton("Click");
        JTextField tf=new JTextField();


        b.setBounds(318, 143, 98, 27);
        tf.setBounds(235, 104, 180, 27);

        this.add(b);
        this.add(tf);
    }

    public static void main(String[] args) throws IOException {

        background_image f = new background_image();

        f.setVisible(true);
    }

}