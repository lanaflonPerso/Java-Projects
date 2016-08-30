package booklibrary.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentForm {

    private String textComment;

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }
}
