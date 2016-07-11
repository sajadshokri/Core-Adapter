package ir.coderz.coreadaptersample;

/**
 * Created by sajad on 6/30/16.
 */
public class AnotherModel {
    String text;
    String message;

    public AnotherModel(String text, String message) {
        this.text = text;
        this.message = message;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
