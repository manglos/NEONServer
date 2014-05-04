package youcanthide;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER")
public class Player implements Serializable{

    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    
    @Id 
    @Column(name="id")
    private long id;
    
    private String customMessage;
    
    
    private boolean online=false;
    private Color myColor, onlineColor, offlineColor;
    private int loginCount, numTagged, numBeenTagged;
    private Role myRole=null;
    private ArrayList<Mesh> myMeshes;
    private ArrayList<Sequence> mySequences;
    private ArrayList<Playlist> myPlaylists;
    private HashMap<String, String> seqStringMap;
    private ArrayList<String> seqNames;

    public Player(String fn, String ln, String un, String pw, boolean on){
        firstName=fn; lastName=ln; username=un; password=pw;
        offlineColor = new Color(0xFF0000);
        onlineColor = new Color(0x23D400);
        myColor=offlineColor;
        setOnline(on);
        loginCount=0;
        numTagged=0;
        numBeenTagged=0;
        myMeshes = new ArrayList<Mesh>();
        mySequences = new ArrayList<Sequence>();
        myPlaylists = new ArrayList<Playlist>();
        seqStringMap = new HashMap<String, String>();
        seqNames = new ArrayList<String>();
    }
    public Player(String fn, String ln, String un, String pw, boolean on, Role r){
        firstName=fn; lastName=ln; username=un; password=pw;
        offlineColor = new Color(0xFF0000);
        onlineColor = new Color(0x23D400);
        myColor=offlineColor;
        setOnline(on);
        myRole=r;
        loginCount=0;
        numTagged=0;
        numBeenTagged=0;
        myMeshes = new ArrayList<Mesh>();
        mySequences = new ArrayList<Sequence>();
        myPlaylists = new ArrayList<Playlist>();
        seqStringMap = new HashMap<String, String>();
        seqNames = new ArrayList<String>();
    }
    public Player(String fn, String ln, String un, String pw, boolean on, String r){
        firstName=fn; lastName=ln; username=un; password=pw; 
        offlineColor = new Color(0xFF0000);
        onlineColor = new Color(0x23D400);
        myColor=offlineColor;
        setOnline(on);
        loginCount=0;
        numTagged=0;
        numBeenTagged=0;
        setRole(r);
        myMeshes = new ArrayList<Mesh>();
        mySequences = new ArrayList<Sequence>();
        myPlaylists = new ArrayList<Playlist>();
        seqStringMap = new HashMap<String, String>();
        seqNames = new ArrayList<String>();
    }
    
    public Player(){}
    
    public ArrayList getSequenceNames(){
        return seqNames;
    }
    
    public void addSequenceString(String name, String seq){
        seqStringMap.put(name, seq);
        seqNames.add(name);
    }
    
    public String getSequenceString(String name){
        return seqStringMap.get(name);
    }
    
    public String getInfo(){
        return firstName + "," + lastName + "," + username + "," + getMeshCount();
    }
    
    public void setMessage(String message){
        customMessage = message;
    }
    
    public String getMessage(){
        return customMessage;
    }
    
    public int getMeshCount(){
        return myMeshes.size();
    }
    
    public int getSequenceCount(){
        return mySequences.size();
    }
    
    public int getPlaylistCount(){
        return myPlaylists.size();
    }
    
    public ArrayList<Mesh> getMeshes(){
        return myMeshes;
    }
    
    public ArrayList<Sequence> getSequences(){
        return mySequences;
    }
    
    public ArrayList<Playlist> getPlaylists(){
        return myPlaylists;
    }
    
    public boolean addSequence(Sequence s){
        mySequences.add(s);
        return true;
    }
    
    public boolean addPlaylist(Playlist p){
        myPlaylists.add(p);
        return true;
    }
    
    public boolean addMesh(Mesh m){
        m.setID(myMeshes.size());
        m.setUser(username);
        myMeshes.add(m);
        return true;
    }
    
    public void setID(int i){
        id=i;
    }

    public void setName(String fn, String ln){
        firstName=fn; lastName=ln;
    }
    public void setUsername(String un){
        username=un;
    }
    public void setRole(Role r){
		myRole=r;
    }
    public void setRole(String r){
            if(r==null)
                    return;

            if(r.equalsIgnoreCase("IT"))
                    myRole=new It();
            else if(r.equalsIgnoreCase("Runner"))
                    myRole=new Runner();
            else if(r.equalsIgnoreCase("Spectator"))
                    myRole=new Spectator();

    }
    public Role getRole(){	
            return myRole;
    }
    
    public String getName(){
        return firstName + " " + lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    
    public int getLoginCount(){
        return loginCount;
    }
    public void addLogin(){
        loginCount++;
    }
    public boolean isOnline(){
        return online;
    }
    public void setOnline(boolean o){
        if(o==true){
            myColor=onlineColor;
        }
        else{
            myColor=offlineColor;
        }

        online=o;
    }
    public void editInfo(String fn, String ln, String un, String pw){
        username=un;
        firstName=fn;
        lastName=ln;
        password=pw;
    }
    public String getColor(){
        String s = Integer.toHexString( myColor.getRGB() & 0xffffff );

        if ( s.length() < 6 ){
           s = "000000".substring( 0, 6 - s.length() ) + s;
        }

        return s;
    }
    @Override
    public String toString(){
        return username + "'s info:\nName: " + getName() + "\nOwns " + myMeshes.size() + " Meshes.";
    }
	
}

