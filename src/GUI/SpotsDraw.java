package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class SpotsDraw {
    private JFrame form;
    public SpotsDraw(JFrame form){
        this.form = form;
    }
    public void DrawRec(String name,int y,int x,boolean state){
        JPanel pnl = new JPanel(){
          @Override
          public void paintComponent(Graphics g){
              Graphics2D g2 = (Graphics2D)g;
              if(state == true){
                  g2.setColor(Color.green);
              }else if (state == false){
                  g2.setColor(Color.red);
              }
              g2.fillRect(x+20, y+20, 50, 100);
              g2.setColor(Color.white);
              g2.drawString(name, x+20+50/2, y+20+100/2);
          }
        };
        form.add(pnl);
        pnl.setBounds(0, 0, form.getWidth(), form.getHeight());
    }
}
