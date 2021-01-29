package design_patterns.behaviour_design_pattern;

/**
 * A pattern in which an object's behavior is determined by its state. An object transition from one state to another 
 * ( something needs to trigger a transition. ).
 * In case of strategy we don't decide on the basis of state which functionality should called
 * */

// this is Context
//The AudioPlayer class acts as a context. It also maintains a
//reference to an instance of one of the state classes that
//represents the current state of the audio player.
 class AudioPlayer  {
	 // reference to the current state
    public State state;
    public boolean playing;

    public void changeState(State state){
        this.state = state;
    }
    public void clickLock(){
        this.state.clickLock();
    }
    public void clickPlay(){
        this.state.clickPlay();
    }

    public void nextSong(){
        System.out.println("Playing next song!!!");
    }
    public void previousSong(){
        System.out.println("Playing previous song !!!");
    }
}

// this is state
//The base state class declares methods that all concrete
//states should implement and also provides a backreference to
//the context object associated with the state. States can use
//the backreference to transition the context to another state.
abstract class State{
	// context reference
  protected AudioPlayer player;

  State(){
      //System.out.println("State Class Initialized!!!");
  }

  State( AudioPlayer player ){
      this.player = player;
  }
  public abstract  void clickLock();
  public abstract void clickPlay();

}

 class ReadyState extends State{

    ReadyState(AudioPlayer player){
        super.player = player;
    }
    @Override
    public void clickLock() {
        System.out.println("Player in Ready State Lock!!!");
        super.player.changeState(new LockedState(super.player));
    }

    @Override
    public void clickPlay() {
        System.out.println("Player in Ready State Play!!!");
        super.player.changeState(new PlayingState(player));
    }
}

class PlayingState extends State{

    PlayingState(AudioPlayer player){
        super.player = player;
    }
    @Override
    public void clickLock() {
        System.out.println("Player in Playing State Lock!!!");
        player.changeState(new LockedState(player));
    }

    @Override
    public void clickPlay() {
        System.out.println("Player in Playing State Play!!!");
        player.changeState(new ReadyState(player));
    }
}

class LockedState extends  State{

    LockedState(AudioPlayer player){
        super.player = player;
    }

    @Override
    public void clickLock() {
        System.out.println("Player in Locked State Lock!!!");
        if(player.playing){
            player.changeState(new PlayingState((player)));
        }else{
            player.changeState(new ReadyState(player));
        }

    }

    @Override
    public void clickPlay() {
        System.out.println("Player in Locked State PLay!!!");
        System.out.println("Locked State cant playing !!!");
    }
}

public class StateDesignPattern {

    public static void main(String[] args){

        AudioPlayer player = new AudioPlayer();
        State playerState = new ReadyState(player);
        player.changeState(playerState);

        System.out.println("Player in Ready State!!!");
        player.clickLock();
        player.clickPlay();
        System.out.println("Execute 1 !!!");
        player.clickLock();
        player.clickPlay();
        System.out.println("Execute 2 !!!");
        player.clickLock();
        player.clickPlay();
        System.out.println("Execute 3 !!!");
    }

}

