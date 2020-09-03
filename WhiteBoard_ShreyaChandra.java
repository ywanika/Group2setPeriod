import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * WThis is the class to create the whiteboard for the lesson.
 * 
 * @Shreya Chandra 
 * @2.0 August 7, 2020
 */
public class WhiteBoard_ShreyaChandra extends Actor
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
    private int slideNumber = 1; //starts the slides at slide 1
    public boolean finishSlide = false; //checks to see if slides are completed
    public WhiteBoard_ShreyaChandra (){
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
        //showBoard();
    }
    
    public void addText(String txt, int x, int y) {
        board.setFont(new Font("Helvetica", true,false, 18)); //default. See overloaded methods
        board.drawString(txt, x+boardOffsetX, y+boardOffsetY);
    }
    public void addImage(String imgFile, int x, int y) {
        GreenfootImage img = new GreenfootImage(imgFile);
        img.scale((7*img.getWidth()/8), (7*img.getHeight()/8));
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
    public void slides(){
        //checks to see if slides are completed or not       
        if (slideNumber < 8){         
            if(Greenfoot.mouseClicked(this)){            
                slideNumber +=1;      
            }
            addImage("Arrayslide" + slideNumber + ".jpg", 0, 0);
        }
        if (slideNumber == 8) {
            finishSlide = true;    
        }
    }
    public void previousSlide(){
        //returns previous slide when clicked
        if (slideNumber != 1) {
             slideNumber -=1;
             addImage("Arrayslide" + slideNumber + ".jpg", 0, 0);
        }
    }
    public void nextSlide(){
        //moves to next slide when clicked
        slideNumber +=1;
        addImage("Arrayslide" + slideNumber + ".jpg", 0, 0);
        
        if (slideNumber == 8) {
             finishSlide = true;
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
