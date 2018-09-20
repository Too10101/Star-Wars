/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.wars;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 629469
 */
public class Collectables {
    int x;
    int y;
    private Color color;
    private int size;
    private String name;
    
    public Collectables() {
        x = 0;
        y = 0;
        color = Color.BLUE;
        size = 20;
        name  = "collectables";
    }
    
    public Collectables(int x, int y, int size, Color color, String name) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
        this.name  = name;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Color getColor() {
        return color;
    }
    public int getSize() {
        return size;
    }
    public String getName() {
        return name;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setName(String name) {
        this.name = name;
    }
}