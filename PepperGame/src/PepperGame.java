import org.newdawn.slick.*;
public class PepperGame extends BasicGame {
 
    static int width = 640;
    static int height = 480;
    static boolean fullscreen = false;
    static boolean showFPS = true;
    static String title = "#1 Game NA";
    static int fpslimit = 60;
    private Image basicImage;
    private int mouseX, mouseY;
    private int posX, posY;
    private String osName;
    public PepperGame(String title) {
        super(title);
    }
 
    @Override
    public void init(GameContainer gc) throws SlickException {
    	//Load image depending on Operating System
    	osName = System.getProperty("os.name");
    	if(osName.contains("Windows"))
    	{
    		basicImage = new Image("data\\image.jpg");
    	}
    	else
    	{
    	basicImage = new Image("data/image.jpg");
    	}
    	//Set initial position of image
    	posX = 200;
    	posY = 200;
    	
       
    }
    
    public void input(GameContainer gc, int delta) throws SlickException
    {
    	Input input = gc.getInput();
    	mouseX = input.getAbsoluteMouseX();
    	mouseY = input.getAbsoluteMouseY();
    	//Movement
    	if(input.isKeyDown(input.KEY_W) || input.isKeyDown(input.KEY_UP))
    	{
    		posY -= 10;
    	}
    	if(input.isKeyDown(input.KEY_S) || input.isKeyDown(input.KEY_DOWN))
    	{
    		posY += 10;
    	}
    	if(input.isKeyDown(input.KEY_D) || input.isKeyDown(input.KEY_RIGHT))
    	{
    		posX += 10;
    	}
    	if(input.isKeyDown(input.KEY_A) || input.isKeyDown(input.KEY_LEFT))
    	{
    		posX -= 10;
    	}
    	//Boundaries
    	if(posX <= basicImage.getWidth()/2)
    	{
    		posX = basicImage.getWidth()/2;
    	}
    	if(posX >= 640 - basicImage.getWidth()/2)
    	{
    		posX = 640 - basicImage.getWidth()/2;
    	}
    	if(posY <= basicImage.getHeight()/2)
    	{
    		posY = basicImage.getHeight()/2;
    	}
    	if(posY >= 480 - basicImage.getHeight()/2)
    	{
    		posY = 480 - basicImage.getHeight()/2;
    	}
    }
 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
    	input(gc, delta);
       
    }
 
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
    	
    	basicImage.draw(posX-(basicImage.getWidth()/2), posY-(basicImage.getHeight()/2));
    }
   
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new PepperGame(title));
        app.setDisplayMode(width, height, fullscreen);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(fpslimit);
        app.setShowFPS(showFPS);
        app.setVSync(true);
        app.start();
    }
   
}

