package Ball;

import java.io.IOException;

import javax.swing.JFrame;

/**
*Create by NiGHTMARE
*2018-03-20
 */

public class BallGame {
    public static void main(String[] args) throws IOException {
        BallFrame ballFrame = new BallFrame();
        ballFrame.Mose_info();
        ballFrame.pack();
        ballFrame.setVisible(true);
        ballFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
