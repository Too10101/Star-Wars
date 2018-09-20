/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.wars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 629469
 */
public class Space extends JPanel{
    
    final int marginX;
    final int marginY;
    private Hero hero;
    private Enemy enemy;
    private Collectables collectables;
    private Timer timer;
    
    public Space() {
        super();
        marginX = 10;
        marginY = 10;
        hero = new Hero(100, 100, Color.MAGENTA, 40, "Hero");
        enemy = new Enemy(1000, 650, Color.RED, 40, "Enemy");
        collectables = new Collectables(1100, 700, 20, Color.BLUE, "collectables");
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 150, 1000/60);
    }
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        //drawStars(g);
        
        hero.draw(g);
        enemy.draw(g);
        collectables.draw(g);
        
        g.dispose();
        }
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            wallCollisions(hero);
            wallCollisions(enemy);
            hero.update();
            enemy.update();
            heroVsEnemy(enemy);
            heroVsCollectables();
            repaint();
        }
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDX(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDX(-2);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDY(-2);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDY(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_T) {
            hero.teleport();
        }
        if (e.getKeyCode() == KeyEvent.VK_Y) {
            hero.teleport2();
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D)
            hero.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_A)
            hero.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_W)
            hero.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_S)
            hero.setDY(0);
    }
    
    private void wallCollisions(Character c) {
        if (c.getX() <= 0) {
            c.reverseX();
        }
        if (c.getX() + 40 >= this.getWidth()) {
            c.reverseX2();
        }
        if (c.getY() <= 0) {
            c.reverseY();
        }
        if (c.getY() + 40 >= this.getHeight()) {
            c.reverseY2();
        }
    }
    
    private void heroVsEnemy(Character c) {
        if (hero.getX()+ 40 >= enemy.getX() && hero.getY() + 40 >= enemy.getY()) {
            if (hero.getX() <= enemy.getX() + 40 && hero.getY() <= enemy.getY() + 40) {
                c.kill(c);
                enemy.setX(-2000);
            }
        }
    }
    private void heroVsCollectables() {
        if (hero.getX() + 40 >= collectables.getX() && hero.getY() + 40 >= collectables.getY()) {
            if (hero.getX() <= collectables.getX() + 20 && hero.getY() <= collectables.getY() + 20) {
                collectables.setSize(0);
                collectables.setX(2000);
                    if (collectables.getX() == 2000) {
                        
                    }
            }
        }
    }
}