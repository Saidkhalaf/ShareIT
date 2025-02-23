package be.kdg.domain.tool;

public class Tool {
    private String name;
    private ToolType type;
    private int purchasePrice;
    private String description;
    private String status;
    private boolean availability;
    private ToolSet partOfSet;
    private int guarantee;

    public Tool(String name, ToolType type, int purchasePrice, String description, String status, boolean availability, ToolSet partOfSet, int guarantee) {
        this.name = name;
        this.type = type;
        this.purchasePrice = purchasePrice;
        this.description = description;
        this.status = status;
        this.availability = availability;
        this.partOfSet = partOfSet;
        this.guarantee = guarantee;
    }

    // Getters en Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public ToolSet getPartOfSet() {
        return partOfSet;
    }

    public void setPartOfSet(ToolSet partOfSet) {
        this.partOfSet = partOfSet;
    }

    public ToolType getToolType() {
        return type;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }
}
