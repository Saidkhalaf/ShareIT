package be.kdg.domain.tool;

public class ApprovalStatus {
    private String status;
    private int warrantyInSharepoints;

    public ApprovalStatus(String status, int warrantyInSharepoints) {
        this.status = status;
        this.warrantyInSharepoints = warrantyInSharepoints;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWarrantyInSharepoints() {
        return warrantyInSharepoints;
    }

    public void setWarrantyInSharepoints(int warrantyInSharepoints) {
        this.warrantyInSharepoints = warrantyInSharepoints;
    }
}
