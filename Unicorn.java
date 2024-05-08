import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * 
 */
public class Unicorn implements Contract{

    String name;
    int PX;
    int PY;
    Number size;
    ArrayList<Integer> position = new ArrayList<Integer>(2);
    Hashtable<String, Boolean> purse;

    /**
     * 
     * @param name name of unicorn
     * @param PX // where unicorn is hortizonally
     * @param PY // where unicorn is vertically 
     * @param size // how big or small unicorn is
     */
    public Unicorn(String name, int PX, int PY, Number size){
        this.name = name;
        this.PX = PX;
        this.PY=  PY;
        this.size= size;
        this.position.add(0);
        this.position.add(0);
        this.purse = new Hashtable<String, Boolean>();

        System.out.println("/////////////////////////////");
        System.out.println("Meet your unicorn! He is the cudliest stuffed unicorn animal ever!!");
        System.out.println("/////////////////////////////\n");
        System.out.println("Your unicorns name is " + this.name + " and they're " + this.size + " inches.");
        System.out.println("They can fly " + this.PX + " inches horizontally and " + this.PY + " inches vertically at a time.");
        System.out.println("Your unicorn's postion in the air is: " + this.position + "\n");
    }

    /**
     * 
     * @param name name of unicorn
     * @param PX // where unicorn is hortizonally
     * @param PY // where unicorn is vertically 
     * @param size // how big or small unicorn is
     */

    public Unicorn (String name){
        this.name = name;
        this.PX = 10;
        this.PY=  5;
        this.size= 50;
        this.position.add(0);
        this.position.add(0);
        System.out.println("Your unicorn's name is" + this.name + "and they are" + this.size + "inches big.");
        System.out.println("Your unicron is standing at " + this.PX + "horizontally and" + this.PY+"vertically up in the air.");
    }


    /**
     * this function allows user to grab item and add it to purse
     * @param item item the user can grab
     */

    public void grab(String item){
 
        System.out.println("You have now grabbed " + item + "\n");
        this.purse.put(item, false);
    }

    /**
     * this function allows user to drop item and remove it from purse
     * @param item item the user can drop
     */
    public String drop(String item){
       
        if (purse.contains(item)) {

            purse.remove(item);
            String dropString = "You have dropped " + item + "\n";

            System.out.println(dropString);
            return dropString;

        }else {

            String noDropString = "You can't drop " + item + " because it's not in your purse!\n";

            System.out.println(noDropString);
            return noDropString;
        }
    }
    /**
     * this function allows user to examine item and note what design the item has on it 
     * @param item item the user can examine
     */
    public void examine(String item){
        System.out.println("Let's examine" + item);
        Scanner sc = new Scanner(System.in);
        System.out.println("What design is your" + item+ "?");
        String design = sc.nextLine();
        System.out.println("You have a" + design + " " + item + ", how cool!\n");

        sc.close();
    }
    
    /**
     * this function allows user to use item and adds it to purse
     * @param item item the user can use
     */
    public void use(String item){
        this.purse.replace(item, true);
        System.out.println(item + " is now in use. \n");

    }
    /**
     * 
     * @param direction the direction the unicorn is moving towards
     * @return boolean to see if the unicorn CAN walk in the direction user tells it to go
     */
    public boolean walk(String direction){

        System.out.println("Your unicorn can walk forward, backwards, to the left, and right. Which direction would you like for it to go?");

        if (direction =="forward" || direction == "left" || direction == "right" || direction == "forward" ){
        System.out.println(this.name + "is walking in " + direction + ".\n");
        return true;
        }
        else{
            System.out.println(this.name + " can't walk that direction, try another one.\n");
            return false;
        }
    }   


    /**
     * 
     * @param x how much the unicorn can fly horizontally
     * @param y how much the unicorn can fly vertically
     * @return boolean to see if the unicron was able to fly however mcuh you tell it to
     */

    public boolean fly(int x, int y){

        if (x <= this.PX && y <= this.PY){
            int ogx = this.position.get(0);
            this.position.set(0, x+ ogx);

            int ogy = this.position.get (0);
            this.position.set(0, y+ ogy);

            System.out.println(this.name + " has flown " + x + " inches horizontally and " + y + " inches vertically.");
            System.out.println("Your unicorn's position in the air is now: " + this.position + "\n");
            
            return true;}
    
        else{
            System.out.println("Oh no! That extends the defined boundaries! Try a small x and y, one that's less than " + PX + " and " + PY + ".\n");
            return false;}
    }
    /**
     * 
     * @return new size of unicorn after shrinking half it's size
     */
    public Number shrink(){
        this.size = this.size.intValue()/2;

        System.out.println(this.name + " is now " + this.size + " inches.\n");
        return this.size;
    }

    /**
     * 
     * @return new size after growing unicorn 2 times it's size
     */
    public Number grow(){
        this.size = this.size.intValue()*2;

        System.out.println(this.name + " is now " + this.size + " inches.\n");
        return this.size;
    }

    /**
     * 
     * unicorn is taking a little nap
     */
    public void rest(){
        this.position.set(1,0);

        System.out.println("ZZZZZZZ" + this.name + " is taking a quick nap. ZZZZZZZ");
        System.out.println("Your unicorn's position in the air is now " + this.position + ".\n");
       
    }

    /**
     * Resets unicorn's coordinates to [0,0]
     */
    public void undo(){
        this.position.set(0,0);
        this.position.set(1,0);

        System.out.println("You have undone all of progress" + this.name + "has made.");
        System.out.println("Their position in the air has returned back to: " + this.position + "\n");
    }


    public static void main(String[] args) {
        Unicorn myUnicorn = new Unicorn("Muenos", 10, 5, 50);
        myUnicorn.grab("hairtye");
        myUnicorn.drop("shoe");
        myUnicorn.examine("hairtye");
        myUnicorn.use("hairtye");
        myUnicorn.walk("hairtye");
        myUnicorn.fly(7,8);
        myUnicorn.fly(2, 2);
        myUnicorn.rest();
        myUnicorn.undo();
    }

}
