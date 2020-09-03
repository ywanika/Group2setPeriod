import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Whiteboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteBoard_Ella extends Actor
{
    /**
     * Act - do whatever the Whiteboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage board;
    private boolean hidden;
    private Font defaultFont;
    private int fontSize;       // font size
    private int xLoc;           // x location of board placement
    private int yLoc;           // y location of board placement
    private int boardOffsetX;
    private int boardOffsetY;
    private int slideNumber = 1;
    public boolean finishSlide = false;
    public WhiteBoard_Ella (){
        setImage("whiteboard.jpg");
        board=this.getImage();
        hidden=true;  // hide the board at first, so that it can be placed, but unused
        hideBoard();
        fontSize=24;
        xLoc=5;
        yLoc=3;
        defaultFont=new Font("Helvetica", true,false, fontSize) ; 
        boardOffsetX=60;
        boardOffsetY=80;
        
    }
    public void act() 
    {
        // Add your action code here.
    }
    public void addText(String txt, int x, int y) {
        board.setFont(new Font("Helvetica", true,false, 18)); //default. See overloaded methods
        board.drawString(txt, x+boardOffsetX, y+boardOffsetY);
    }
    public void addImage(String imgFile, int x, int y) {
        GreenfootImage img = new GreenfootImage(imgFile);
        img.scale(7*(img.getWidth()/8), (7*img.getHeight()/8));
        board.drawImage(img, x+boardOffsetX, y+boardOffsetY);
    }
    public void eraseBoard() {
       setImage("whiteboard.jpg");
        board=this.getImage(); // required to maintain a pointer to current inmage
    }
    public void hideBoard(){
        board.setTransparency(0);
    }
    public void showBoard(){
        board.setTransparency(255);
    }
    public void previousSlide(){//function to change slide number to go back
        if (slideNumber != 1) {
             slideNumber -=1;
             addImage("Arrayslide" + slideNumber + ".jpg", 0, 0);
        }
    }
    public void nextSlide(){//function to change slide number to go forward
        slideNumber +=1;
        addImage("Arrayslide" + slideNumber + ".jpg", 0, 0);
        if (slideNumber == 8) {
             Greenfoot.delay(30);
             finishSlide= true;
        }
    }

    // Getters/Setters (or accessers/mutators)
    
    public int getXloc(){
        return xLoc;
    }
    
    public int getYloc(){
        return yLoc;
    }
    
        
}

