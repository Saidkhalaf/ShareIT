package be.kdg.domain.tool;

import be.kdg.domain.user.User;

import java.util.List;

public class ToolSet extends Tool {
    private int id;
    private String description;
    private ToolType type;
    private User owner;
    private List<Tool> tools;

    public ToolSet(int id, String description, ToolType type, User owner, List<Tool> tools) {
        super(description, type, 0, description, "available", true, null, 0);
        this.id = id;
        this.description = description;
        this.type = type;
        this.owner = owner;
        this.tools = tools;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
