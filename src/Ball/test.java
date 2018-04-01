import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author bzwm
 *
 */
class MyMouseTest extends JFrame{
    public MyMouseTest()
    {
        this.add(new MousePanel());
        this.setVisible(true);
        this.setSize(300, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        new MyMouseTest();
    }
}

class MousePanel extends JPanel implements java.awt.event.MouseMotionListener
{
    public MousePanel()
    {
        this.addMouseMotionListener(this);
    }
    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getX()+"\t"+e.getY());
    }
}