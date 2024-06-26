// Java-applet: JavaClock. Shows the time and the date of your system.

// Libraries needed in this applet.
import java.util.*;
import java.awt.*;
import java.applet.*;

public class Analog extends Applet implements Runnable {
    // Globals
    Thread timer = null;
    int lastxs = 0, lastys = 0, lastxm = 0, lastym = 0, lastxh = 0, lastyh = 0;
    Date dummy = new Date();
    String lastdate = dummy.toLocaleString();

    public void init() {
        int x, y;
        resize(300, 300);		// Set clock window size        
    }

	// Plotpoints allows calculation to only cover 45 degrees of the circle,
	// and then mirror
    public void plotpoints(int x0, int y0, int x, int y, Graphics g) {
        g.drawLine(x0 + x, y0 + y, x0 + x, y0 + y);
        g.drawLine(x0 + y, y0 + x, x0 + y, y0 + x);
        g.drawLine(x0 + y, y0 - x, x0 + y, y0 - x);
        g.drawLine(x0 + x, y0 - y, x0 + x, y0 - y);
        g.drawLine(x0 - x, y0 - y, x0 - x, y0 - y);
        g.drawLine(x0 - y, y0 - x, x0 - y, y0 - x);
        g.drawLine(x0 - y, y0 + x, x0 - y, y0 + x);
        g.drawLine(x0 - x, y0 + y, x0 - x, y0 + y);
    }
	// Circle is just algorithm for a scan converted circle
    public void circle(int x0, int y0, int r, Graphics g) {
        int x, y;
        float d;
        x = 0;
        y = r;
        d = 5 / 4 - r;
        plotpoints(x0, y0, x, y, g);
        while (y > x) {
            if (d < 0) {
                d = d + 2 * x + 3;
                x++;
            } else {
                d = d + 2 * (x - y) + 5;
                x++;
                y--;
            }
            plotpoints(x0, y0, x, y, g);
        }
    }
	// Paint is the main part of the program
    public void paint(Graphics g) {
        int xh, yh, xm, ym, xs, ys, s, m, h, xcenter, ycenter;
        String today;
        Date dat = new Date();
        s = dat.getSeconds();
        m = dat.getMinutes();
        h = dat.getHours();
        today = dat.toLocaleString();
        xcenter = 80;
        ycenter = 55;
        setBackground(Color.black);

	// a = s * pi / 2 - pi / 2 (to switch 0,0 from 3:00 to 12:00)
	// x = r(cos a) + xcenter, y = r(sin a) + ycenter
        xs = (int)(Math.cos(s * 3.14f / 30 - 3.14f / 2) * 45 + xcenter);
        ys = (int)(Math.sin(s * 3.14f / 30 - 3.14f / 2) * 45 + ycenter);
        xm = (int)(Math.cos(m * 3.14f / 30 - 3.14f / 2) * 40 + xcenter);
        ym = (int)(Math.sin(m * 3.14f / 30 - 3.14f / 2) * 40 + ycenter);
        xh = (int)(Math.cos((h * 30 + m / 2) * 3.14f / 180 - 3.14f / 2) * 30 + xcenter);
        yh = (int)(Math.sin((h * 30 + m / 2) * 3.14f / 180 - 3.14f / 2) * 30 + ycenter);

	// Draw the circle and numbers
        g.setFont(new Font("Helvetica", Font.PLAIN, 14));
        g.setColor(Color.blue);
        circle(xcenter, ycenter, 50, g);
        g.setColor(Color.lightGray);
        g.drawString("9", xcenter - 45, ycenter + 3);
        g.drawString("3", xcenter + 40, ycenter + 3);
        g.drawString("12", xcenter - 5, ycenter - 37);
        g.drawString("6", xcenter - 3, ycenter + 45);
	// Erase if necessary, and redraw
        g.setColor(getBackground());
        if (xs != lastxs || ys != lastys) {
            g.drawLine(xcenter, ycenter, lastxs, lastys);
            g.drawString(lastdate, 5, 125);
        }
        if (xm != lastxm || ym != lastym) {
            g.drawLine(xcenter, ycenter - 1, lastxm, lastym);
            g.drawLine(xcenter - 1, ycenter, lastxm, lastym);
        }
        if (xh != lastxh || yh != lastyh) {
            g.drawLine(xcenter, ycenter - 1, lastxh, lastyh);
            g.drawLine(xcenter - 1, ycenter, lastxh, lastyh);
        }
        g.setColor(Color.lightGray);
        g.drawString(today, 5, 125);
        g.drawLine(xcenter, ycenter, xs, ys);
        g.setColor(Color.blue);
        g.drawLine(xcenter, ycenter - 1, xm, ym);
        g.drawLine(xcenter - 1, ycenter, xm, ym);
        g.drawLine(xcenter, ycenter - 1, xh, yh);
        g.drawLine(xcenter - 1, ycenter, xh, yh);
        lastxs = xs; lastys = ys;
        lastxm = xm; lastym = ym;
        lastxh = xh; lastyh = yh;
        lastdate = today;
    }

    public void start() {
        if (timer == null) {
            timer = new Thread(this);
            timer.start();
        }
    }
    public void stop() {
        timer = null;
    }
    public void run() {
        while (timer != null) {
            try { Thread.sleep(100); }
            catch (InterruptedException e) {}
            repaint();
        }
        timer = null;
    }
    public void update(Graphics g) {
        paint(g);
    }
}
