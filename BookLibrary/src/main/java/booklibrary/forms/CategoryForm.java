package booklibrary.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Hristo on 27.08.2016 г..
 */
public class CategoryForm {
    @Size(min=1, max=1000, message = "Please fill title.")
    private String name;

    @Size(min=1, max=1000, message = "Please fill title.")
    private String type;

    @Size(min=1, max=1000, message = "Please fill title.")
    private String about;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
