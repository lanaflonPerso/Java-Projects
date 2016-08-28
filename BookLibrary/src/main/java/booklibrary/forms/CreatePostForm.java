package booklibrary.forms;

import booklibrary.models.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Hristo on 05.08.2016 г..
 */
public class CreatePostForm {

    private String title;

    private String body;

    private Category category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
