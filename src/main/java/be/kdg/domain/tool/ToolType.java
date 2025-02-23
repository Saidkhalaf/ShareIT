package be.kdg.domain.tool;

public class ToolType {
    private String typeDescription;
    private int guarantee;

    public ToolType(String typeDescription, int guarantee) {
        this.typeDescription = typeDescription;
        this.guarantee = guarantee;
    }

    public ToolType(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public int getGuarantee() {return guarantee;}

    public void setGuarantee(int guarantee) {this.guarantee = guarantee;}
}
