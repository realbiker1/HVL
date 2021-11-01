package opg1;

public class TextObj {

    private String string;
    private boolean isQuit = true;

    public TextObj(String string){
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        if (string.equalsIgnoreCase("quit")){
            this.string = string;
            isQuit = false;
        } else {
            this.string = string;
        }

    }

    public boolean isQuit() {
        return isQuit;
    }

    public void setQuit(boolean quit) {
        isQuit = quit;
    }

    public boolean checkQuit(){
        return !this.string.equalsIgnoreCase("quit");
    }

}
