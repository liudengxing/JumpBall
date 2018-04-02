package Ball;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.security.Key;
import java.util.TimerTask;

/**
 * 游戏界面
 */

public class BallFrame extends JFrame {
    // 定义JPanel的宽度
    private final int BALLPANEL_WIDTH = 307;
    // 定义JPanel的高度
    private final int BALLPANEL_HEIGHT = 400;
    // 定义画板
    private BallPanel ballPanel = null;
    // 定义档板
    // private Image stick = null;
    // 设置档板x坐标
    private int stickX = -1;
    // 创建一个BallService实例
    private BallService service = null;
    // 定义一个timer
    Timer timer = null;
    int value_x ;

    public void Mouse_info() {
        try {
            int x;
            BallFrame info_frame = new BallFrame();
            java.util.Timer timer = new java.util.Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
                    System.out.println(point.x);
                    value_x = (point.x);
                }
            }, 100, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 默认构造器
     */
    public BallFrame() throws IOException {
        super();
        // 初始化
        initialize();
    }

    /**
     * 初始化界面
     *
     * @return void
     */
    public void initialize() throws IOException {
        // 设置窗口的标题
        this.setTitle("JumpBall");
        // 设置为不可改变大小
        this.setResizable(false);
        // 设置背景为黑色
        this.setBackground(Color.BLACK);
        // 获取画板
        ballPanel = getBallPanel();
        // 创建BallService实例
        service = new BallService(this, BALLPANEL_WIDTH, BALLPANEL_HEIGHT);

        // 定义每0.1秒执行一次监听器
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 开始改变位置
                service.run();
                // 刷新画板
                ballPanel.repaint();
            }
        };
        // 如果timer不为空
        if (timer != null) {
            // 重新开始timer
            timer.restart();
        } else {
            // 新建一个timer
            timer = new Timer(100, task);
            // 开始timer
            timer.start();
        }

        service.SetStickPoseMouse(value_x);

        this.add(ballPanel);

        KeyListener[] klarr = this.getKeyListeners();
        if (klarr.length == 0) {

            KeyListener keyAdapter = new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {

                   // service.setStickPos(value_x);
                }
            };
            this.addKeyListener(keyAdapter);
        }
    }    /**
     * 获取画板
     *
     * @return BallPanel 返回BallPanle
     */
    public BallPanel getBallPanel() {

        if (ballPanel == null) {
            // 新建一个画板
            ballPanel = new BallPanel();
            // 设置画板的大小
            ballPanel.setPreferredSize(new Dimension(BALLPANEL_WIDTH,
                    BALLPANEL_HEIGHT));
        }
        return ballPanel;
    }

    // 定义一个JPanel内部类来完成画图功能
    public class BallPanel extends JPanel {
        /**
         * 重写void paint( Graphics g )方法
         *
         * @param g
         *            Graphics
         * @return void
         */
        public void paint(Graphics g) {
            // 画图
            service.draw(g);
        }
    }

}
