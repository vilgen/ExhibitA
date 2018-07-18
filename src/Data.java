import java.util.Date;

public class Data {

    private String playId;
    private int songId;
    private int clientId;
    private Date time;

    //**Constructor definition**
    public Data(){}

    //**Setter methods**
    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    //**Getter methods**
    public String getPlayId() {
        return playId;
    }

    public int getSongId() {
        return songId;
    }

    public int getClientId() {
        return clientId;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return getPlayId() + " " + getSongId() + " " + getClientId() + " " + getTime();
    }

}