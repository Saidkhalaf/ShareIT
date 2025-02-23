package be.kdg.domain.tool;

public class Expert {

    private String name;
    private String areaOfExpertise;

    public Expert(String name, String areaOfExpertise) {
        this.name = name;
        this.areaOfExpertise = areaOfExpertise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }
}

