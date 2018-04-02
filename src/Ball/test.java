package Ball;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//第一种方法

public class test implements MouseMotionListener,MouseListener{
    Frame f=new Frame("关于鼠标的多重监听器");//窗体
    TextField tf=new TextField(30);//文本框
    public test() {//构造方法
        Label label=new Label("请按下鼠标左键并拖动");//标签的功能只是显示文本，不能动态地编辑文本。
        f.add(label,"North");
        f.add(tf,"South");
        f.setBackground(new Color(180,255,255));
        f.addMouseListener(this);//添加一个鼠标监听
        f.addMouseMotionListener(this);

        f.addWindowListener(new WindowAdapter(){//添加一个窗口监听
            public void windowClosing(WindowEvent e) {//窗口关闭事件
                System.exit(0);
            }
        });

        f.setSize(300,200);
        f.setLocation(400,250);//设置窗体位置
        f.setVisible(true);
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标点击---"+"\t");
        if(e.getClickCount()==1) {
            System.out.println("单击");
        }else if(e.getClickCount()==2) {
            System.out.println("双击");
        }else if(e.getClickCount()==3) {
            System.out.println("三连击");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        tf.setText("鼠标已经进入窗体");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tf.setText("鼠标已经移出窗体");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        String str="鼠标所在的坐标:("+e.getX()+","+e.getY()+")";
        tf.setText(str);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("鼠标移动了");
    }

}